package Kernel;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Note {
    private int  NoteID ;
    private Stage stage;
    private Scene scene ;
    private StackPane stackPane ;
    private TextArea textArea ;




    public Note() throws IOException {
        NodeID id = new NodeID();
        id.increaseID();
        this.NoteID=id.getID();
        stage = new Stage();
        stackPane = new StackPane();
        textArea = new TextArea();
        stackPane.getChildren().add(textArea);
        scene = new Scene(stackPane,300,300);
        stage.setScene(scene);

    }
    public int getNodeID()
    {
        return this.NoteID;
    }


    public void newDisplay() {

        stage.setResizable(false);
        this.stage.show();
        textArea.setWrapText(true);
        textArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");


        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override

            public void handle(WindowEvent event) {
                String string = textArea.getText();

                File file = new File(new File(System.getProperty("user.home")) + File.separator + "StickyNotes" + File.separator +NoteID+".txt");
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(string);
                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println(string);
            }
        });


    }





}
