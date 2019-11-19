package GameEntity.GameTile.Tower;

import Map.Grid;

public class SmallerTower extends Tower implements TowerProperty{
    public SmallerTower(Grid pos) {
        super( SMALLER_TOWER_HEIGHT, SMALLER_TOWER_WIDTH, pos, SMALLER_TOWER_RANGE, SMALLER_TOWER_ATTACKRATE);
    }
}
