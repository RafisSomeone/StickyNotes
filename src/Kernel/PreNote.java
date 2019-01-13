package Kernel;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class PreNote  {
    StackPane stackPane = new StackPane();
    Label title = new Label("Title");
    Button delete = new Button();
    int NoteID;
    Button open = new Button();

    public PreNote(int id){
        this.NoteID =id;
        this.stackPane.setPrefSize(182,50);

        this.stackPane.getChildren().add(this.title);
        this.stackPane.setStyle("-fx-background-color: yellow");
        this.delete.setTranslateX(60);
        this.delete.setTranslateY(0);

        this.open.setPrefSize(182,50);
        this.stackPane.getChildren().add(this.open);
        this.open.setStyle("-fx-background-color: transparent;");
        this.stackPane.getChildren().add(this.delete);


    }



    public void setDeleteAction(NoteAdder noteAdder, PreNote preNote, Stage stage)
    {
        this.delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            noteAdder.deleteNote(preNote);
            new Refresh().Refresh(stage,noteAdder);
            }
        });

    }
    public int getNodeID()
    {
        return this.NoteID;
    }

    public void setOpenAction(Note note)
    {
        this.open.setOnDragDetected((EventHandler<Event>) event -> note.newDisplay());
        //this.open.setOnAction((EventHandler<ActionEvent>) event -> note.newDisplay());
    }

    public Group getGroup() {
        return new Group(this.stackPane);
    }
    public void setNoteID(int id){this.NoteID =id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreNote preNote = (PreNote) o;
        return NoteID == preNote.NoteID;
    }


    }

