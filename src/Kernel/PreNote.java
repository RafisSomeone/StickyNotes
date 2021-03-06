package Kernel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PreNote {
    StackPane stackPane = new StackPane();
    Label title = new Label("Title");
    Button delete = new Button();

    int NoteID;
    Button open = new Button();

    public PreNote(int id) {
        this.NoteID = id;
        this.stackPane.setPrefSize(182, 50);

        this.stackPane.getChildren().add(this.title);
        this.delete.setTranslateX(60);
        this.delete.setTranslateY(0);
        this.title.setTranslateX(-20);

        this.open.setPrefSize(182, 50);
        this.stackPane.getChildren().add(this.open);
        this.open.setStyle("-fx-background-color: transparent;");
        this.stackPane.getChildren().add(this.delete);
        this.delete.setStyle("-fx-graphic: url('http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-8/16/Trash-can-icon.png')");


    }

    public void refreshPrenote(Note note) {
        NoteSettings noteSettings = note.getNoteSettings();
        this.stackPane.setStyle("-fx-background-color: " + noteSettings.getBackgroundColor() + ";");
        String text = note.getText();
        int ilosc;
        switch (noteSettings.getFontsize()) {
            case " 13px":
                ilosc = 15;
                break;
            case " 16px":
                ilosc = 12;
                break;
            case " 18px":
                ilosc = 10;
                break;

            case " 24px":
                ilosc = 7;
                break;
            case " 32px":
                ilosc = 5;
                break;



            default:
                ilosc = 14;
                break;
        }

        if (text.length() > ilosc) text = text.substring(0, ilosc) + "...";
        this.title.setText(text);
        this.title.setStyle(noteSettings.getSettings());


    }


    public void setDeleteAction(NoteAdder noteAdder, PreNote preNote, Stage stage, Note note) {
        this.delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                note.getEditWindow().closeEdit();
                note.closeStage();
                noteAdder.deleteNote(preNote);
                new Refresh().refresh(stage, noteAdder);

            }
        });

    }

    public int getNodeID() {
        return this.NoteID;
    }

    public void setOpenAction(Note note) {
        // this.open.setOnDragDetected((EventHandler<Event>) event -> note.newDisplay());
        this.open.setOnAction((EventHandler<ActionEvent>) event -> note.newDisplay());
    }

    public Group getGroup() {
        return new Group(this.stackPane);
    }

    public void setNoteID(int id) {
        this.NoteID = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreNote preNote = (PreNote) o;
        return NoteID == preNote.NoteID;
    }


}

