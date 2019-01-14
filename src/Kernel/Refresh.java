package Kernel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Refresh {

    public void refresh(Stage stage, NoteAdder noteAdder) {
        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(root);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        Scene scene = new Scene(scrollPane, 200, 400);

        Button button = new Button();
        button.setStyle("-fx-graphic: url('http://icons.iconarchive.com/icons/hopstarter/button/16/Button-Add-icon.png')");
        button.setOnAction(new AddHandler(noteAdder));
        for (PreNote preNote : noteAdder.getPreNotes()) {
            for (Note note : noteAdder.getNotes()) {
                if (note.getNodeID() == preNote.getNodeID()) {
                    preNote.refreshPrenote(note);
                }
            }

            root.getChildren().add(preNote.getGroup());


        }


        root.getChildren().add(button);
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();


    }
}
