package StoreManager;

import WidgetOrder.CreateFixtures;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StoreManager.fxml"));
        primaryStage.setTitle("Store Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(640);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(640);
        primaryStage.show();
    }


    public static void main(String[] args) {
        new CreateFixtures().run();

        launch(args);
    }
}
