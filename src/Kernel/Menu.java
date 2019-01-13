package Kernel;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

import java.util.LinkedList;
import java.util.List;

public class Menu {

    private VBox root;
    private List<PreNote> preNotes = new LinkedList<>();

    // private Stage stage;

    public Menu() {
        root = new VBox();
    }



    public void display(Stage stage,NoteAdder noteAdder) {

        root.setStyle("-fx-background-color: blue");

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(root);




        Scene scene = new Scene(scrollPane,200,400);



for(PreNote preNote : noteAdder.getPreNotes())
{
    root.getChildren().add(preNote.getGroup());

}



        Button button = new Button();
        button.setOnAction(new AddHandler(noteAdder));
        root.getChildren().addAll(button);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        stage.setTitle("StickyNotes");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("sdafasdsad");
            }
        });


    }



}
