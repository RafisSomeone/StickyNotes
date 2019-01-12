package Kernel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RefreshHandle implements EventHandler<ActionEvent> {

 private NoteAdder noteAdder;

public RefreshHandle(NoteAdder noteAdder){
this.noteAdder=noteAdder;

}
    @Override
    public void handle(ActionEvent event) {

        Note note = new Note();
        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        root.setStyle("-fx-background-color: blue");

        scrollPane.setContent(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene scene = new Scene(scrollPane,200,400);

       Button button = new Button();
       button.setOnAction(new RefreshHandle(noteAdder));

       noteAdder.noteAdd();

        for(PreNote preNote : noteAdder.getPreNotes())
        {
            root.getChildren().add(preNote.getGroup());
        }
        root.getChildren().add(button);


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();
        note.dispaly();



        //  menu.display(stage);
    // note.dispaly();


    }
}
