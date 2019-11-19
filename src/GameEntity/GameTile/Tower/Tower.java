package GameEntity.GameTile.Tower;

import GameEntity.Bullet.BulletManager;

import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManager;
import GameEntity.GameObject;
import Map.Grid;
import Program.Position;

public abstract class Tower extends GameObject{
    protected int range;
    protected Enemy target;

    protected int attackRate;//attackRate time giữa 2 lần bắn
    protected int lastAttacked;//time kể từ lần bắn trc

    protected Grid positionInMap;

    protected boolean destroy;

    public int getRange(){
        return this.range;
    }

    public Tower(int height, int width, Grid pos, int range, int attackRate){
        this.height = height;
        this.width = width;
        this.positionInMap = pos;
        this.position = pos.getCenter();
        this.range = range;
        this.attackRate = attackRate;
        this.lastAttacked = 0;
        destroy = false;
    }

    public int getAttackRate() {
        return attackRate;
    }

    public void checkRange() {
        if (target != null) {
            if (target.isDestroy()) target = null;
            else{
                double distance = target.getLocation().distance(this.position);
                if (distance > range) target = null;
            }
        }
        if (target == null) {
            for (Enemy enemy: EnemyManager.listEnemy) {
                double distance = position.distance(enemy.getLocation());
                if (distance <= range) {
                    target = enemy;
                    break;
                }
            }
        }
    }

    public void doDestroy() {
        destroy = true;
    }

    //update lastAttacked, update target and fire a bullet
    public void update(){
        //update lastAttacked
        if (target != null)  lastAttacked ++;
        else lastAttacked = 0;

        //update target
        checkRange();

        //fire a bullet
        if(lastAttacked > attackRate && target != null){
            lastAttacked = 0;
            if(this instanceof NormalTower){
                BulletManager.addBullet("NormalBullet", target, this);
            }
            if(this instanceof SmallerTower){
                BulletManager.addBullet("MachineGunBullet", target, this);
            }
            if(this instanceof SniperTower){
                BulletManager.addBullet("SniperBullet", target, this);
            }
        }
    }

    @Override
    public String toString() {
        return "Tower{" +
                "range=" + range +
                ", attackRate=" + attackRate +
                ", target=" + target +
                ", lastAttacked=" + lastAttacked +
                '}';
    }
}