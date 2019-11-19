package GameEntity.GameTile.Tower;

import Map.*;
import Program.*;

import java.util.HashSet;
import java.util.Set;

public class TowerManager implements TowerProperty{
    public static Set<Tower> towerList;
    private static Player player;

    public static boolean init(Player _player){
        player = _player;
        towerList = new HashSet<Tower>();
        return true;
    }

    public static void addTower(Tower tower){
        towerList.add(tower);
    }

    public static void createTower(String towerType, Grid grid){
        boolean ableToSetTower = true;

        //is this place a Mountain?
        if(!(grid instanceof Mountain)) ableToSetTower = false;

        //Does this place have a tower yet?
        if (grid.isFilled()) ableToSetTower = false;

        if(ableToSetTower){
            Tower tower;
            if(towerType.equals("NormalTower")){
                if(player.getGold() >= NORMAL_TOWER_COST){
                    tower = new NormalTower(grid);
                    towerList.add(tower);
                    grid.setContain(tower);

                    player.setGold(player.getGold() - NORMAL_TOWER_COST);
                }
            }
            else if(towerType.equals("SmallerTower")){
                if(player.getGold() >= SMALLER_TOWER_COST){
                    tower = new SmallerTower(grid);
                    towerList.add(tower);
                    grid.setContain(tower);

                    player.setGold(player.getGold() - SMALLER_TOWER_COST);
                }
            }
            else {
                if(player.getGold() >= SNIPER_TOWER_COST){
                    tower = new SniperTower(grid);
                    towerList.add(tower);
                    grid.setContain(tower);

                    player.setGold(player.getGold() - SNIPER_TOWER_COST);
                }
            }
        }
    }

    public static void removeTower(Tower tower){
        towerList.remove(tower);
    }

    public static void reset() {
        towerList.clear();
    }

    public static void update(){
        for (Tower tower : towerList){
            tower.update();
        }
    }
}