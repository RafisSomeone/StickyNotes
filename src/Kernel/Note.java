package Kernel;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;


public class Note {
    long  NoteID ;
    private Stage stage;
    private Scene scene ;
    private StackPane stackPane ;
    private TextArea textArea ;




    public Note() {
       // this.NoteID=IDNode;
        stage = new Stage();
        stackPane = new StackPane();
        textArea = new TextArea();
        stackPane.getChildren().add(textArea);
        scene = new Scene(stackPane,300,300);
        stage.setScene(scene);

    }

    public void dispaly() {

        stage.setResizable(false);
        this.stage.show();
        textArea.setWrapText(true);


        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override

            public void handle(WindowEvent event) {
                String string = textArea.getText();

                File file = new File(new File(System.getProperty("user.home")) + File.separator + "StickyNotes" + File.separator + "plik.txt");
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(string);

                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println(string);
            }
        });


    }

}