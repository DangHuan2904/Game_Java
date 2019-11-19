package GameEntity.Enemy;

import javafx.scene.paint.Color;

public class BossEnemy extends Enemy{
    public BossEnemy() {
        super(EnemyConfig.BOSS_ENEMY_HEALTH, EnemyConfig.BOSS_ENEMY_ARMOR,
                EnemyConfig.BOSS_ENEMY_SPEED, EnemyConfig.BOSS_ENEMY_WIDTH,
                EnemyConfig.BOSS_ENEMY_HEIGHT, EnemyConfig.BOSS_ENEMY_REWARD);
        color = Color.VIOLET;
    }
}
