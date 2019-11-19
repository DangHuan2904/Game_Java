package GameEntity.Enemy;

import javafx.scene.paint.Color;

public class SmallerEnemy extends Enemy{
    public SmallerEnemy() {
        super(EnemyConfig.SMALLER_ENEMY_HEALTH, EnemyConfig.SMALLER_ENEMY_ARMOR,
                EnemyConfig.SMALLER_ENEMY_SPEED, EnemyConfig.SMALLER_ENEMY_WIDTH,
                EnemyConfig.SMALLER_ENEMY_HEIGHT, EnemyConfig.SMALLER_ENEMY_REWARD);
        color = Color.YELLOW;
    }
}
