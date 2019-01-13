package Kernel;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
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
    private Pane pane;
    private VBox vbox;
    private Button edit;

    public Note() throws IOException {
        NodeID id = new NodeID();
        id.increaseID();
        this.NoteID=id.getID();
        this.edit = new Button();
        this.vbox = new VBox();
        this.pane = new Pane();
        this.pane.getChildren().add(edit);
        this.edit.setPrefSize(300,10);
        this.stage = new Stage();
        this.stackPane = new StackPane();
        this.textArea = new TextArea();
        this.vbox.getChildren().add(this.pane);
        this.vbox.getChildren().add(this.stackPane);
        this.stackPane.getChildren().add(this.textArea);
        this.scene = new Scene(this.vbox,300,300);
        this.stage.setScene(this.scene);
        this.pane.setPrefSize(300,10);
        this.textArea.setPrefSize(300,290);

    }
    public void setNoteID(int id)
    {
        this.NoteID=id;
    }

    public void closeStage()
    {
        this.stage.close();
    }

    public Stage getStage()
    {
        return this.stage;
    }

    public int getNodeID()
    {
        return this.NoteID;
    }


    public void newDisplay() {

        this.stage.setResizable(false);
        this.stage.show();
        this.textArea.setWrapText(true);
        this.textArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");


        this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
