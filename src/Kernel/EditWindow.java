package Kernel;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EditWindow {
    private Stage stage;
    private StackPane stackPane;
    private Scene scene;

    public EditWindow(){

        this.stage= new Stage();

    }

    public void displayEdit(NoteSettings noteSettings)
    {
        this.stackPane = new StackPane();
        List<String> fonts= getFonts();
        ComboBox fontBox = new ComboBox();

        for(String font: fonts)
        {
            Label fontLabel= new Label(font);
            fontLabel.setStyle("-fx-font-family: "+font+";");
            fontBox.getItems().add(fontLabel);
        }
       fontBox.setPromptText(noteSettings.getFont());
        ComboBox fontColorBox = new ComboBox();

        fontColorBox.setTranslateX(0);
        fontColorBox.setTranslateY(100);

        for(String color : getColors())
        {
            Label colorLabel = new Label("                         ");
            colorLabel.setStyle("-fx-background-color: "+color+";");
            fontColorBox.getItems().add(colorLabel);
        }
        fontColorBox.setPromptText(noteSettings.getFontColor());

        fontBox.setOnAction(new EventHandler<ActionEvent> );

        this.scene= new Scene(this.stackPane,200,300);
        stackPane.getChildren().addAll(fontBox, fontColorBox);
        this.stage.setScene(scene);



        this.stage.show();

    }



    public void closeEdit()
    {
        this.stage.close();
    }

    public List<String> getFonts()
    {
        List<String> fonts =  Font.getFamilies();// Arrays.asList(toString().split())

        System.out.println(fonts);
      return  fonts;
    }
    public List<String> getColors()
    {
        List<String> colors = new LinkedList<>();
        colors.add("#FFFFFF");
        colors.add("#C0C0C0");
        colors.add("#808080");
        colors.add("#000000");
        colors.add("#FF0000");
        colors.add("#800000");
        colors.add("#FFFF00");
        colors.add("#808000");
        colors.add("#00FF00");
        colors.add("#008000");
        colors.add("#00FFFF");
        colors.add("#0000FF");
        colors.add("#000080");
        colors.add("#FF00FF");
        colors.add("#800080");
         return colors;
    }

}
