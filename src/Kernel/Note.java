package Kernel;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Note  {

    private int NoteID;
    private Stage stage;
    private Scene scene;
    private StackPane stackPane;
    private TextArea textArea;
    private Pane pane;
    private VBox vbox;
    private Button edit;
    private EditWindow editWindow;
    private NoteSettings noteSettings;
    private NoteAdder noteAdder;

    public Note(NoteAdder noteAdder) throws IOException {
        this.noteAdder=noteAdder;
        noteAdder.add(this);
        NodeID id = new NodeID();
        id.increaseID();
        this.NoteID = id.getID();
        this.edit = new Button();
        this.vbox = new VBox();
        this.pane = new Pane();
        this.pane.getChildren().add(edit);
        this.edit.setPrefSize(300, 10);
        this.stage = new Stage();
        this.stackPane = new StackPane();
        this.textArea = new TextArea();
        this.vbox.getChildren().add(this.pane);
        this.vbox.getChildren().add(this.stackPane);
        this.stackPane.getChildren().add(this.textArea);
        this.scene = new Scene(this.vbox, 300, 300);
        this.stage.setScene(this.scene);
        this.pane.setPrefSize(300, 10);
        this.textArea.setPrefSize(300, 290);
        this.editWindow = new EditWindow();
        this.noteSettings = new NoteSettings();
        this.edit.setOnAction(e -> editWindow.displayEdit(this.noteSettings,this));


    }

    public Note(TextArea textArea,NoteAdder noteAdder) throws IOException {
        this.noteAdder=noteAdder;
        NodeID id = new NodeID();
        id.increaseID();
        this.NoteID = id.getID();
        this.edit = new Button();
        this.vbox = new VBox();
        this.pane = new Pane();
        this.pane.getChildren().add(edit);
        this.edit.setPrefSize(300, 10);
        this.stage = new Stage();
        this.stackPane = new StackPane();
        this.textArea = textArea;
        this.vbox.getChildren().add(this.pane);
        this.vbox.getChildren().add(this.stackPane);
        this.stackPane.getChildren().add(this.textArea);
        this.scene = new Scene(this.vbox, 300, 300);
        this.stage.setScene(this.scene);
        this.pane.setPrefSize(300, 10);
        this.textArea.setPrefSize(300, 290);
        this.editWindow = new EditWindow();
        this.noteSettings = new NoteSettings();
        this.edit.setOnAction(e -> editWindow.displayEdit(this.noteSettings,this));


    }

    public String getText()
    {
        return this.textArea.getText();
    }
    public void setNoteSettings(NoteSettings noteSettings)
    {
        this.noteSettings=noteSettings;
    }
    public void changeFont(String font)
    {
        this.noteSettings.setFont(font);

    }
    public void changeFontColor(String color)
    {
        this.noteSettings.setFontColor(color);
    }

    public void changeBackGroundColor(String color)
    {
        this.noteSettings.setBackgroundColor(color);
    }

    public NoteSettings getNoteSettings() {
        return this.noteSettings;
    }

    public void setNoteID(int id) {
        this.NoteID = id;
    }

    public void closeStage() {
        this.stage.close();
    }

    public Stage getStage() {
        return this.stage;
    }

    public int getNodeID() {
        return this.NoteID;
    }

    public EditWindow getEditWindow() {
        return this.editWindow;
    }


    public void newDisplay() {


        this.stage.setResizable(false);
        this.stage.show();
        this.textArea.setWrapText(true);
        this.textArea.setStyle(this.noteSettings.getSettings());

        this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override

            public void handle(WindowEvent event) {

                String outPut = noteSettings.getFont().trim()+"\n"+noteSettings.getFontColor().trim()+"\n"+noteSettings.getBackgroundColor().trim()+"\n";
                outPut=outPut+textArea.getText();
                editWindow.closeEdit();




                File file = new File(new File(System.getProperty("user.home")) + File.separator + "StickyNotes" + File.separator + NoteID + ".txt");
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(outPut);
                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }



                new Refresh().refresh(noteAdder.getMain(), noteAdder);


            }
        });


    }


}
