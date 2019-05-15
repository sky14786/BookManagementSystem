package application.kh.bms.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.SignUpController;

public class SignUpView implements Initializable {
	SignUpController signUpController = new SignUpController();
	@FXML
	private Button btnCreate;
	@FXML
	private ComboBox comGender;
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfId, tfName, tfAddr;
	@FXML
	private PasswordField tfPw;

	private ObservableList<String> list = FXCollections.observableArrayList("남자", "여자");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comGender.setItems(list);
	}

	@FXML
	private void create() {
		signUpController.createUser(tfId.getText(), tfPw.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getId());
	}

	@FXML
	private void duplicateCheck() {

	}

	@FXML
	private void comboChanged(ActionEvent e) {

	}

}
