package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameObject;
import GameEntity.GameTile.Tower.Tower;

public class Sniper extends Bullet implements BulletProperty {
	public Sniper(Enemy target, Tower tower){
		super(SNIPER_BULLET_WIDTH, SNIPER_BULLET_HEIGHT,
				SNIPER_BULLET_SPEED, SNIPER_BULLET_DAMAGE,
				SNIPER_BULLET_RANGE, target, tower);
	}
}