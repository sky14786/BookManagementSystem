package application.kh.bms.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.SignUpController;
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

public class SignUpView implements Initializable {
	SignUpController signUpController = new SignUpController();
	@FXML
	private Button btnCreate, btnBack, btnDuplicateCheck;
	@FXML
	private ComboBox comGender;
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfId, tfName, tfAddr;
	@FXML
	private PasswordField tfPw;
	@FXML
	private Label lDuText;

	private ObservableList<String> list = FXCollections.observableArrayList("남자", "여자");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comGender.setItems(list);
	}

	@FXML
	private void create() {
		signUpController.createUser(tfId.getText(), tfPw.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getPromptText());
	}

	@FXML
	private void duplicateCheck() {
		if (signUpController.duplicateCheck(tfId.getText())) {
			lDuText.setText("사용가능");
		} else {
			lDuText.setText("사용불가");
		}
	}

	@FXML
	private void comboChanged(ActionEvent e) {

	}

}
