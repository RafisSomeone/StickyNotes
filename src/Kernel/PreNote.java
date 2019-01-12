package Kernel;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PreNote  {
    StackPane stackPane = new StackPane();
    Label title = new Label("Title");
    Button delete = new Button();

    public PreNote(){

        this.stackPane.setPrefSize(182,50);
        this.stackPane.getChildren().add(this.title);
        this.stackPane.setStyle("-fx-background-color: yellow");
        this.delete.setTranslateX(60);
        this.delete.setTranslateY(0);
        this.stackPane.getChildren().add(this.delete);

    }

    public Group getGroup() {
        return new Group(stackPane);
    }
}
