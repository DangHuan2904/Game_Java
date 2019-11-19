package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.GameTile.Tower.Tower;

import java.util.HashSet;
import java.util.Set;

public class BulletManager {
    public static Set<Bullet> bulletList;

    public BulletManager() {
    }

    public static boolean init(){
        bulletList = new HashSet<Bullet>();
        return true;
    }

    public static void addBullet(String bulletType, Enemy target, Tower tower){
        if(bulletType.equals("NormalBullet")) {
            Bullet newBullet = new NormalBullet(target, tower);
            bulletList.add(newBullet);
        }
        else if(bulletType.equals("MachineGunBullet")) {
            Bullet newBullet = new MachineGunBullet(target, tower);
            bulletList.add(newBullet);
        }
        else if(bulletType.equals("SniperBullet")) {
            Bullet newBullet = new Sniper(target, tower);
            bulletList.add(newBullet);
        }
    }

    public static void deleteBullet(Bullet bullet){
        bulletList.remove(bullet);
    }

    public static void update(){
        if(!bulletList.isEmpty()){
            for(Bullet bullet: bulletList) bullet.update();
            bulletList.removeIf(Bullet::isDestroy);
        }
    }

    public static void reset(){
        bulletList.clear();
    }
}
