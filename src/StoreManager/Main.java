package StoreManager;
/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */ 
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
