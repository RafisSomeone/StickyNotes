package Kernel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AddHandler implements EventHandler<ActionEvent> {

    private NoteAdder noteAdder;

    public AddHandler(NoteAdder noteAdder) {
        this.noteAdder = noteAdder;

    }

    @Override
    public void handle(ActionEvent event) {


        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();


        scrollPane.setContent(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene scene = new Scene(scrollPane, 200, 400);

        Button button = new Button();

        button.setOnAction(new AddHandler(noteAdder));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Note note = null;
        try {
            note = noteAdder.noteAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (PreNote preNote : noteAdder.getPreNotes()) {
            root.getChildren().add(preNote.getGroup());
        }
        PreNote last = noteAdder.getPreNotes().getLast();

        last.refreshPrenote(note);
        root.getChildren().add(button);

        button.setStyle("-fx-graphic: url('http://icons.iconarchive.com/icons/hopstarter/button/16/Button-Add-icon.png')");


        stage.setScene(scene);

        stage.setResizable(false);
        last.setDeleteAction(noteAdder, last, stage, note);
        stage.show();
        note.newDisplay();


        //  menu.display(stage);
        // note.newDisplay();


    }
}
