import client.event.Event;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;

//This event gets called whenever mc.theplayer hits an entity

public class EventEntityHit extends Event {
	public LocalPlayer hitter;
	public LivingEntity hittenEntity;
	public double distance;
	
	public EventEntityHit(LocalPlayer player , LivingEntity hitEntity) {
		this.hittenEntity = hitEntity;
		this.hitter = player;
		this.distance = hitter.position().distanceToSqr(hittenEntity.position());
	}
}
