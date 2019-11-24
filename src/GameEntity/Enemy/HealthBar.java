package GameEntity.Enemy;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class HealthBar extends Pane {
    protected double hp_max = 50;
    protected double hp_0 = 50;

    Rectangle outerHealthRect;
    Rectangle innerHealthRect;



    public HealthBar() {
        int x = 0, y = 0;
        outerHealthRect = new Rectangle( x, y, hp_max, 10);
        outerHealthRect.setStroke(Color.BLACK);
        outerHealthRect.setStrokeWidth(2);
        outerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        outerHealthRect.setFill(Color.RED);

        innerHealthRect = new Rectangle( x, y, hp_0, 10);
        innerHealthRect.setStrokeType( StrokeType.OUTSIDE);
        innerHealthRect.setFill(Color.LIMEGREEN);

        getChildren().addAll( outerHealthRect, innerHealthRect);
    }

    public void setValue( double value) {
        innerHealthRect.setWidth( value * 50);
    }


}
