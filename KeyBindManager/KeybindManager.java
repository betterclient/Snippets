import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class KeybindManager {
	private static ArrayList<KeyMapping> maps = new ArrayList<>();
	private static Map<String, Integer> categories = new HashMap<>();
	
	public static ArrayList<KeyMapping> getKeyMappings(){
		return maps;
	}
	
	public static Map<String, Integer> getCategories(){
		return categories;
	}
	
	public static void addKeyMapping(KeyMapping a) {
		maps.add(a);
	}
	
	public static void removeKeyMapping(KeyMapping a) {
		maps.remove(a);
	}
	
	public static void addCategory(String key , Integer value) {
		categories.put(key, value);
	}
	
	public static void removeCategory(String key , Integer value) {
		categories.remove(key, value);
	}

	public static void processInputs() {
		for(KeyMapping map : Minecraft.getInstance().options.keyMappings) {
			for(Entry<String, Integer> key : categories.entrySet()) {
				map.CATEGORY_SORT_ORDER.put(key.getKey(), key.getValue());
			}
		}
		for(KeyMapping map : maps) {
			Minecraft.getInstance().options.keyMappings = ArrayUtils.add(Minecraft.getInstance().options.keyMappings, map);
			fixKeyConflicts(Minecraft.getInstance().options.keyMappings, new KeyMapping[] {map});
		}
	}
	
	public static void fixKeyConflicts(KeyMapping[] keys, KeyMapping[] keysPrio)
    	{
        	Set<String> set = new HashSet<>();
        	for (int i = 0; i < keysPrio.length; ++i)
        	{
        		KeyMapping keymapping = keysPrio[i];
       	 		set.add(getId(keymapping));
       		 }
	
       		 Set<KeyMapping> set1 = new HashSet<>(Arrays.asList(keys));
       		 set1.removeAll(Arrays.asList(keysPrio));

       		 for (KeyMapping keymapping1 : set1)
       		 {
       	 	    String s = getId(keymapping1);
	
       	  	   if (set.contains(s))
       	    	   {
       	    	     keymapping1.setKey(InputConstants.bv);
       	     	    }
       		 }
      	}
	
	
}
