package GameEntity.Enemy;

import Debugger.Log;
import GameEntity.GameObject;
import Program.Player;
import Map.*;
import Program.Position;

public abstract class Enemy extends GameObject {
    /**
     *  TODO:
     *   - Firstly, call init(Player, Map) to load static data( player and map )
     *   - Call Enemy() to create a new Enemy, its location set automatic in startPoint
     */
    private double health;
    private double armor;
    private double speed;

    private int reward;

    private int currentIndex;//current index in Map.data.road

    private int[] direction;

    private boolean destroy;

    // all Enemy use the same player and map
    private static Player player;
    private static Map map;

    public Enemy(){
    }

    public Enemy(double health, double armor,
                 int speed, double width,
                 double height, int reward) {
        super(width, height);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.position = map.startPoint.getCenter().clone();
        this.currentIndex = 0;
        this.direction = new int[2];
        updateDirection();
        destroy = false;
    }

    public static boolean init(Map _map, Player _player){
        /**
         * TODO: Load static data
         *   - map
         *   - player
         *   - [image]
         */
        boolean success = true;
        map = _map;
        player = _player;
        try{
            if (map == null) throw new Exception("Map is null");
            map = _map;
        }
        catch (Exception e){
            success = false;
            Log.log(e);
        }
        try{
            if (player == null) throw new Exception("Player is null");
            player = _player;
        }
        catch (Exception e){
            success = false;
            Log.log(e);
        }
        return success;
    };

    public void updateDirection(){
        int inCol = Data.line[currentIndex + 1][0] - Data.line[currentIndex][0];
        if (inCol > 0){
            direction = Data.direction[0];
        }
        else if (inCol < 0){
            direction = Data.direction[1];
        }
        else {
            int inRow = Data.line[currentIndex + 1][1] - Data.line[currentIndex][1];
            if (inRow > 0){
                direction = Data.direction[2];
            }
            else direction = Data.direction[3];
        }
    }

    public void update(){

        /**
         * TODO:
         *  - Check if this enemy's health is over
         *  - Check if this enemy go to turf
         *  - DO NOT check if this enemy be shoot -> it's from Bullet
         */
        /**
         * TODO:
         *  -
         */
        if (health <= 0){
            /**
             * TODO:
             *  - Do destroy
             */
            doDestroy();
        }
        else if (position.over(map.map[Data.line[currentIndex + 1][0]][Data.line[currentIndex + 1][1]].getCenter(), direction)){
            Position target = map.map[Data.line[currentIndex + 1][0]][Data.line[currentIndex + 1][1]].getCenter();
            position.setX(target.getX());
            position.setY(target.getY());
            currentIndex++;
            if (currentIndex >= Data.size - 1){
                /**
                 * TODO:
                 *  -do damage
                 *  -do destroy
                 */
                doDamage();
                doDestroy();
            }
            else {
                updateDirection();
                move();
            }
        }
        else move();
    }

    public void move(){
        setLocation(this.position.getX() + (int)speed*direction[0], this.position.getY() + (int)speed * direction[1]);
    }

    public void setLocation(int x, int y){
        /**
         * TODO:
         *  -reload new location
         */
        this.position.setX(x);
        this.position.setY(y);
    };

    public void doDestroy(){
        /**
         * TODO:
         *  - Call EnemyManager to delete this enemy
         */
        destroy = true;
    }

    public void doDamage(){
        player.beAttacked();
    }

    public void beAttacked(final double damage){
        this.health -= damage;
        if (this.health <= 0){
            doDestroy();
            player.earnMoney(this.reward);
        }
    }

    public boolean isDestroy() {
        return destroy;
    }
}