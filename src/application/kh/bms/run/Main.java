package application.kh.bms.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application/kh/bms/view/userUpdate.fxml"));
//			Parent root = FXMLLoader
//					.load(getClass().getClassLoader().getResource("application/kh/bms/view/userSearch.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("Book Management System - User Update");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
