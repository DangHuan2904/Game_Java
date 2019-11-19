package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameObject;
import GameEntity.GameTile.Tower.Tower;

public class MachineGunBullet extends Bullet implements BulletProperty {

	public MachineGunBullet(Enemy target, Tower tower) {
		super(MACHINEGUN_BULLET_WIDTH,MACHINEGUN_BULLET_HEIGHT,
				MACHINEGUN_BULLET_SPEED, MACHINEGUN_BULLET_DAMAGE,
				MACHINEGUN_BULLET_RANGE, target, tower);
	}
}
