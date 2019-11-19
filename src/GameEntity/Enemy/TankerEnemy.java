package GameEntity.Enemy;

import javafx.scene.paint.Color;

public class TankerEnemy extends Enemy{
    public TankerEnemy() {
        super(EnemyConfig.TANKER_ENEMY_HEALTH, EnemyConfig.TANKER_ENEMY_ARMOR,
                EnemyConfig.TANKER_ENEMY_SPEED, EnemyConfig.TANKER_ENEMY_WIDTH,
                EnemyConfig.TANKER_ENEMY_HEIGHT, EnemyConfig.TANKER_ENEMY_REWARD);
        color = Color.GREEN;
    }
}
