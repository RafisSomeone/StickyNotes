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


        //  Image image = new Image("https://gfx.chillizet.pl/var/zetchilli/storage/images/news/ludzie/3-rzeczy-ktore-najbardziej-podobaja-sie-mezczyznom-w-twarzy-kobiet-9734/577664-1-pol-PL/Te-3-rzeczy-w-twarzy-kobiet-najbardziej-podobaja-sie-mezczyznom_article.jpg");
        //  ImageView pic = new ImageView(image);
        //   Image image2 = new Image("https://gfx.chillizet.pl/var/zetchilli/storage/images/news/ludzie/3-rzeczy-ktore-najbardziej-podobaja-sie-mezczyznom-w-twarzy-kobiet-9734/577664-1-pol-PL/Te-3-rzeczy-w-twarzy-kobiet-najbardziej-podobaja-sie-mezczyznom_article.jpg");
        //   ImageView pic2 = new ImageView(image);
        Data data = new Data();
        data.run();
        Menu menu = new Menu();
        menu.display(stage);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
