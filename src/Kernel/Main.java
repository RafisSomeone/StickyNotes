package Kernel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        NoteAdder noteAdder = new NoteAdder();
        Data data = new Data();
        data.run(noteAdder, stage);
        Menu menu = new Menu();
        menu.display(stage, noteAdder);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
