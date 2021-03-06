package Kernel;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EditWindow {
    private Stage stage;

    public EditWindow() {


        this.stage = new Stage();

    }

    public void displayEdit(NoteSettings noteSettings, Note note) {
        this.stage.setResizable(false);
        StackPane stackPane = new StackPane();
        Label fontSelect = new Label();
        Label fontColorSelect = new Label();
        Label fontBackSelect = new Label();
        Label fontSizeSelect = new Label("Select font size:");

        fontSelect.setText("Select font:");
        fontColorSelect.setText("Select font color:");
        fontBackSelect.setText("Select background color:");
        ComboBox fontSizeBox = new ComboBox();
        Label small = new Label("Small");
        Label medium = new Label("Medium");
        Label large = new Label("Large");
        Label huge = new Label("Huge");
        Label giant = new Label("Giant");

        fontSizeBox.getItems().addAll(small, medium, large,huge,giant);
       // String first = noteSettings.getFontsize().trim().substring(0, 1).toUpperCase();
       // String prompt = first + noteSettings.getFontsize().trim().substring(1);

        //fontSizeBox.setPromptText(prompt);
        fontSizeBox.setPromptText(getSizeName(noteSettings.getFontsize()));
        List<String> fonts = getFonts();
        ComboBox fontBox = new ComboBox();
        ComboBox backgroundBox = new ComboBox();
        for (String color : getColors()) {
            Label colorLable = new Label("             ");
            colorLable.setStyle("-fx-background-color: " + color + ";");
            backgroundBox.getItems().add(colorLable);
        }

        backgroundBox.setPromptText(getColorName(noteSettings.getBackgroundColor().trim()));
        for (String font : fonts) {
            Label fontLabel = new Label(font);
            fontLabel.setStyle("-fx-font-family: " + font + ";");
            fontBox.getItems().add(fontLabel);
        }


        fontBox.setPromptText(noteSettings.getFont());
        ComboBox fontColorBox = new ComboBox();
        fontColorBox.setPrefWidth(150);
        backgroundBox.setPrefWidth(96);
        fontBox.setPrefWidth(180);
        fontSizeBox.setPrefWidth(150);


        fontSelect.setTranslateX(-97);
        fontSelect.setTranslateY(-60);
        fontColorSelect.setTranslateX(-78);
        fontColorSelect.setTranslateY(-30);
        fontBackSelect.setTranslateX(-51);
        fontBackSelect.setTranslateY(0);
        fontSizeSelect.setTranslateX(-80);
        fontSizeSelect.setTranslateY(30);

        fontBox.setTranslateX(40);
        fontBox.setTranslateY(-60);
        fontColorBox.setTranslateX(56);
        fontColorBox.setTranslateY(-30);
        backgroundBox.setTranslateX(83);
        backgroundBox.setTranslateY(0);
        fontSizeBox.setTranslateX(57);
        fontSizeBox.setTranslateY(30);


        for (String color : getColors()) {
            Label colorLabel = new Label("                         ");
            colorLabel.setStyle("-fx-background-color: " + color + ";");
            fontColorBox.getItems().add(colorLabel);
        }
        fontColorBox.setPromptText(getColorName(noteSettings.getFontColor().trim()));


        fontSizeBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label fontsize = (Label) fontSizeBox.getSelectionModel().getSelectedItem();
              //  String sizeString = fontsize.getText().toLowerCase();
               // note.changeFontSize(sizeString);
                note.changeFontSize(getFontSize(fontsize.getText()));
                displayEdit(noteSettings, note);
                note.newDisplay();

            }
        });

        backgroundBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Label backgroundColor = (Label) backgroundBox.getSelectionModel().getSelectedItem();

                String background = backgroundColor.getStyle();
                background = background.substring(background.lastIndexOf(" "), background.lastIndexOf(';'));
                note.changeBackGroundColor(background);
                note.newDisplay();
                displayEdit(noteSettings, note);
            }
        });

        fontBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String wantedFont = fontBox.getSelectionModel().getSelectedItem().toString();
                wantedFont = wantedFont.substring(wantedFont.lastIndexOf(']') + 2, wantedFont.length() - 1);
                note.changeFont(wantedFont);
                note.newDisplay();
                displayEdit(noteSettings, note);
            }
        });

        fontColorBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Object wantedColor = fontColorBox.getSelectionModel().getSelectedItem();
                Label label2 = (Label) wantedColor;
                String fontColor = label2.getStyle();
                fontColor = fontColor.substring(fontColor.lastIndexOf(" "), fontColor.lastIndexOf(';'));
                note.changeFontColor(fontColor);
                note.newDisplay();
                displayEdit(noteSettings, note);
            }
        });

        Scene scene = new Scene(stackPane, 300, 150);
        stackPane.getChildren().addAll(fontBox, fontColorBox, backgroundBox, fontSelect, fontBackSelect, fontColorSelect, fontSizeBox, fontSizeSelect);
        this.stage.setScene(scene);


        this.stage.show();

    }


    public void closeEdit() {
        this.stage.close();
    }

    public List<String> getFonts() {
        List<String> fonts = Font.getFamilies();// Arrays.asList(toString().split())

        return fonts;
    }


    public List<String> getColors() {
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
        colors.add("#008080");
        colors.add("#0000FF");
        colors.add("#000080");
        colors.add("#FF00FF");
        colors.add("#800080");
        return colors;
    }

    public String getFontSize(String size) {

        switch (size) {
            case "Small":
                return "13px";
            case "Medium":
                return "16px";
            case "Large":
                return "18px";
            case "Huge":
                return "24px";
            case "Giant":
                return "32px";

            default:
                return "16Fpx";
        }
    }


    public String getSizeName(String size) {

        switch (size) {
            case " 13px":
                return "Small";
            case " 16px":
                return "Medium";
            case " 18px":
                return "Large";
            case " 24px":
                return "Huge";
            case " 32px":
                return "Giant";
            default:
                return "Medium";
        }
    }
    public String getColorName(String color) {

        switch (color) {
            case "#FFFFFF":
                return "WHITE";
            case "#C0C0C0":
                return "SILVER";
            case "#808080":
                return "GREY";
            case "#000000":
                return "BLACK";
            case "#FF0000":
                return "RED";
            case "#800000":
                return "MAROON";
            case "#FFFF00":
                return "SUN";
            case "#808000":
                return "OLIVE";
            case "#00FF00":
                return "LIME";
            case "#008000":
                return "GREEN";
            case "#00FFFF":
                return "AQUA";

            case "#008080":
                return "TEAL";
            case "#0000FF":
                return "BLUE";
            case "#000080":
                return "NAVY";
            case "#800080":
                return "PURPLE";
            case "#FF00FF":
                return "FUCHSIA";
            default:
                return "NONE";
        }

    }
}