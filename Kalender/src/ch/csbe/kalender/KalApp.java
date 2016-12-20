package ch.csbe.kalender;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class KalApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("kalender.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Kalender");
		primaryStage.getIcons().add(new Image("file:icon.png"));
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
