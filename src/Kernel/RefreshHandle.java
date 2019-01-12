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

public class RefreshHandle implements EventHandler<ActionEvent> {

 private NoteAdder noteAdder;

public RefreshHandle(NoteAdder noteAdder){
this.noteAdder=noteAdder;

}
    @Override
    public void handle(ActionEvent event) {


        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        root.setStyle("-fx-background-color: blue");

        scrollPane.setContent(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene scene = new Scene(scrollPane,200,400);

       Button button = new Button();
       button.setOnAction(new RefreshHandle(noteAdder));

        Note note = null;
        try {
            note = noteAdder.noteAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(PreNote preNote : noteAdder.getPreNotes())
        {
            root.getChildren().add(preNote.getGroup());
        }
        root.getChildren().add(button);


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();
        note.newDisplay();



        //  menu.display(stage);
    // note.newDisplay();


    }
}
