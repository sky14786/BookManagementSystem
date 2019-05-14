package application.kh.bms.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class View {
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPw;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnEnd;

	@FXML
	public void login() {

	}

	@FXML
	public void end() {

	}

	@FXML
	public void signUp() {

		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/signUp.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
