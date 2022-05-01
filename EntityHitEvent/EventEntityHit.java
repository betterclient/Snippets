import client.event.Event;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

//This event gets called whenever mc.theplayer hits an entity

public class EventEntityHit extends Event {
	public Player hitter;
	public Entity hittenEntity;
	public double distance;
	
	public EventEntityHit(Player pPlayer , Entity pTargetEntity) {
		this.hittenEntity = pTargetEntity;
		this.hitter = pPlayer;
		this.distance = hitter.position().distanceToSqr(hittenEntity.position());
	}
}
