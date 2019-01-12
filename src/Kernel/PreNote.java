package Kernel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.StackPane;

public class PreNote  {
    StackPane stackPane = new StackPane();
    Label title = new Label("Title");
    Button delete = new Button();
    int NoteID;
    Button open = new Button();

    public PreNote(int id){
        this.NoteID =id;
        this.stackPane.setPrefSize(182,50);
        this.stackPane.getChildren().add(this.open);
        this.stackPane.getChildren().add(this.title);
        this.stackPane.setStyle("-fx-background-color: yellow");
        this.delete.setTranslateX(60);
        this.delete.setTranslateY(0);
        this.stackPane.getChildren().add(this.delete);
        this.open.setPrefSize(182,50);


    }
    public void setOpenAction(Note note)
    {
        this.open.setOnMouse(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                note.newDisplay();
            }


        });
    }

    public Group getGroup() {
        return new Group(this.stackPane);
    }
    public void setNoteID(int id){this.NoteID =id;}
}
