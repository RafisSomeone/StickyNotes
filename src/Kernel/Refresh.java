package Kernel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Refresh {

    public void Refresh(Stage stage,NoteAdder noteAdder)
    {
        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();


        scrollPane.setContent(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene scene = new Scene(scrollPane,200,400);

        Button button = new Button();
        button.setOnAction(new AddHandler(noteAdder));
        for(PreNote preNote : noteAdder.getPreNotes())
        {

            root.getChildren().add(preNote.getGroup());
        }
            root.getChildren().add(button);
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();


    }
}
