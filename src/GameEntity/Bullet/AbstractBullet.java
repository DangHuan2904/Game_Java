package GameEntity.Bullet;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public abstract class AbstractBullet {
    protected int speed = 0;

    protected ImageView imageBulletView;

    protected PathTransition bulletMove;
    private boolean shot = false;

    public AbstractBullet() {

    }

    public void move(double sourceX, double sourceY, double desX, double desY) {
        MoveTo spawn = new MoveTo(sourceX, sourceY);
        LineTo target = new LineTo(desX, desY);
        Path path = new Path();
        path.getElements().addAll(spawn, target);
        bulletMove = new PathTransition(Duration.millis(1000), path, this.imageBulletView);
        bulletMove.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        bulletMove.play();
        bulletMove.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                shot = true;
            }
        });
    }

    public ImageView getImageView() {
        return imageBulletView;
    }

    public boolean isShot() {
        return shot;
    }
}
