package application.kh.bms.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.UserUpdateController;
import application.kh.bms.model.User;
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
import javafx.scene.text.Text;

public class UserUpdateView implements Initializable {
	UserUpdateController userUpdateController = new UserUpdateController();
	@FXML
	private Button btnUpdate, btnBack, btnTest;
	@FXML
	private ComboBox comGender;
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfName, tfAddr, tfPhone;
	@FXML
	private PasswordField tfPw;
	@FXML
	private Label lDuText;
	@FXML
	private Text tID;

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
	public void testLoad(ActionEvent ev) {
		User user = userUpdateController.loadData();
		tID.setText(user.getId());
		tfPw.setText(user.getPw());
		tfName.setText(user.getName());
		tfAddr.setText(user.getAddr());
		comGender.setPromptText(user.getGender());
		tfPhone.setText(user.getPhone());
	}

	@FXML
	private void update() {
		userUpdateController.updateUser(tfPw.getText(), tfName.getText(), tfAddr.getText(), comGender.getPromptText(),
				tfPhone.getText());
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
