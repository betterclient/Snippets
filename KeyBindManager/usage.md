1.Go to net.minecraft.client.option.java and change keymapping variable to non final.

![image](https://user-images.githubusercontent.com/103489620/166139178-06c2b936-ad07-44a5-89d4-a69abc783b12.png)

2.Go to net.minecraft.client.keymapping.java and make CATEGORY_SORT_ORDER public.

![image](https://user-images.githubusercontent.com/103489620/166139475-0b831f05-2973-4afc-803c-5cbade98a561.png)

3.Use addKeyMapping(KeyMapping) and addCategory(String , Integer) to create keybinds and categories.

![image](https://user-images.githubusercontent.com/103489620/166139239-00d4e84c-63a5-4127-a430-685ff8abae72.png)

4.Call KeybindManager.processInputs() to add keybinds and categories to the game.

![image](https://user-images.githubusercontent.com/103489620/166139261-76c933f4-75b8-4375-bd08-fcfa6e465999.png)

5.Congrats! Now you have keybinds and categories

![image](https://user-images.githubusercontent.com/103489620/166139602-5b8f225b-88ee-4b8c-9a67-a8835688b7b1.png)
