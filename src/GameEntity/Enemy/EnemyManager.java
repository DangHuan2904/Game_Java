package GameEntity.Enemy;

import Debugger.Log;
import Map.Map;
import Program.Player;

import java.util.ArrayList;

public class EnemyManager {
    /**
     * TODO:
     *  -Call init method first
     */
    public static ArrayList<Enemy> listEnemy;
    private static Map map;
    private static Player player;
    private static int counter = 0;
    private static int currentWave;
    private static int currentEnemyInWave;

    public static boolean init(Player _player, Map _map){
        /**
         * TODO:
         *  - initialise Enemy (load static data for all enemy)
         *  - load this static data (player and map)
         *  - declare listEnemy
         */
        boolean success = true;
        player = _player;
        map = _map;

        Enemy.init(map, player);

        try{
            if (player == null) throw new Exception("EnemyManager.init() error: Player is null");
            player = _player;
        }catch (Exception e){
            success = false;
            Log.log(e);
        }
        try{
            if (map == null) throw  new Exception("EnemyManager.init() error: Map is null");
            map = _map;
        }catch (Exception e){
            success = false;
            System.out.println(e.getMessage());
        }
        listEnemy = new ArrayList<>();
        currentWave = 0;
        currentEnemyInWave = 0;
        return success;
    }

    private static void addEnemy(Enemy enemy){
        listEnemy.add(enemy);
    }

    public static void createNormalEnemy(){
        Enemy newEnemy = new NormalEnemy();
        addEnemy(newEnemy);
    }

    public static void createSmallerEnemy(){
        Enemy newEnemy = new SmallerEnemy();
        addEnemy(newEnemy);
    }

    public static void createBossEnemy(){
        Enemy newEnemy = new BossEnemy();
        addEnemy(newEnemy);
    }

    public static void createTankerEnemy(){
        Enemy newEnemy = new TankerEnemy();
        addEnemy(newEnemy);
    }

    public static void update(){
        /**
         * TODO:
         *  - Create new Enemy
         *  - Update all Enemy
         */
        counter++;
        if (!listEnemy.isEmpty()){
            for (Enemy enemy: listEnemy) enemy.update();
            listEnemy.removeIf(Enemy::isDestroy);
        }
        if (counter >= EnemyConfig.defaultCounter){
            if (currentEnemyInWave < EnemyData.wave[currentWave].length){
                switch (EnemyData.wave[currentWave][currentEnemyInWave]){
                    case 1:
                        createNormalEnemy();
                        break;
                    case 2:
                        createSmallerEnemy();
                        break;
                    case 3:
                        createTankerEnemy();
                        break;
                    case 4:
                        createBossEnemy();
                        break;
                }
                currentEnemyInWave++;
                counter = 0;
            }
            else {
                currentWave++;
                if (currentWave >= EnemyData.wave.length){
                    currentWave = 0;
                    currentEnemyInWave = 0;
                    counter = EnemyConfig.defaultCounter - EnemyConfig.waveCounter;
                }
                else {
                    currentEnemyInWave = 0;
                    counter = EnemyConfig.defaultCounter - EnemyConfig.waveCounter;
                }
            }
        }
    }
}
