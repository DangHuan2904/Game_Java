package GameEntity.Enemy;

import javafx.scene.paint.Color;

public class NormalEnemy extends Enemy{

    public NormalEnemy() {
        super(EnemyConfig.NORMAL_ENEMY_HEALTH, EnemyConfig.NORMAL_ENEMY_ARMOR,
                EnemyConfig.NORMAL_ENEMY_SPEED, EnemyConfig.NORMAL_ENEMY_WIDTH,
                EnemyConfig.NORMAL_ENEMY_HEIGHT, EnemyConfig.NORMAL_ENEMY_REWARD);
        color = Color.BLUE;
    }
}
