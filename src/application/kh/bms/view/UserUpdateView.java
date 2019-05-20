package application.kh.bms.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.media.jfxmediaimpl.platform.Platform;

import application.kh.bms.controller.UserUpdateController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserUpdateView implements Initializable {
	UserUpdateController userUpdateController = new UserUpdateController();
	@FXML
	private Button btnUpdate, btnBack;
	@FXML
	private ComboBox comGender;
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfName, tfAddr;
	@FXML
	private PasswordField tfPw;
	@FXML
	private Label lDuText, lID;

	private ObservableList<String> list = FXCollections.observableArrayList("남자", "여자");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comGender.setItems(list);
	}

	@FXML
	public void backMove() {
		javafx.application.Platform.exit();
	}

	@FXML
	private void loadUser(String id, String name, String addr, String gender) {

	}

	@FXML
	private void update() {
		userUpdateController.updateUser(tfPw.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getTypeSelector());
	}

//	@FXML
//	private void duplicateCheck() {
//		if (signUpController.duplicateCheck(tfId.getText())) {
//			lDuText.setText("사용가능");
//		} else {
//			lDuText.setText("사용불가");
//		}
//	}

	@FXML
	private void comboChanged(ActionEvent e) {

	}

}
