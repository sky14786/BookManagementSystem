package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.UserUpdateController;
import application.kh.bms.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserUpdateView implements Initializable {
	UserUpdateController userUpdateController = new UserUpdateController();
	@FXML
	private Button btnUpdate, btnBack, btnTest, btnAgree;
	@FXML
	private ComboBox comGender;
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfName, tfAddr, tfPhone, tfID;
	@FXML
	private PasswordField tfPw;
	@FXML
	private Text tID, tCheck;

	// �׽�Ʈ�� ����
	private int userNo = 0;

	private ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");

	User user = null;

	// �׽�Ʈ�� ����
	public void test() {
		userUpdateController.enrollTest(userNo++, tfID.getText(), tfPw.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getValue().toString(), tfPhone.getText());
		resetTextfield();
	}

	// �׽�Ʈ�� ����
	public void resetTextfield() {
		tfID.setText("");
		tfPw.setText("");
		tfName.setText("");
		tfAddr.setText("");
		tfPhone.setText("");
		comGender.setPromptText("Gender");
	}

	// Combox�� �ʱⰪ�� list�� ����, ȸ�� ���� ����â �ε�ÿ� Data�� �ҷ�����
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comGender.setItems(list);
		user = userUpdateController.loadData(0);
		userInformationLoad();
		tCheck.setText("");
	}

	// �ڷΰ��� ��ư ������ �ش� �÷��� ����
	@FXML
	public void backMove() {
		javafx.application.Platform.exit();
	}

	// ȸ�� ���� ������ User�� ������ Controller�κ��� Load��
	@FXML
	public void userInformationLoad() {
		userNo = user.getUserNo();
		tID.setText(user.getId());
		tfPw.setText(user.getPw());
		tfName.setText(user.getName());
		tfAddr.setText(user.getAddr());
		comGender.setPromptText(user.getGender());
		tfPhone.setText(user.getPhone());
	}

	// ȸ�� ���� ������ ������ PW���� 8~12�� üũ ���� ������ True �� ���� ���� ������Ʈ
	// False �Ͻ� �н����� ���� ���� ���
	@FXML
	private void updateUser() {
		if (userUpdateController.pwCheck(tfPw.getText())) {
			userUpdateController.updateUser(userNo, tID.getText(), tfPw.getText(), tfName.getText(), tfAddr.getText(),
					comGender.getValue().toString(), tfPhone.getText());
			new UpdateSuccessView().showUpdateSuccess();
		} else {
			tCheck.setText("PW's Length : 8 ~ 12 ");
		}
	}

	@FXML
	private void agreeUpdate() {

	}

	@FXML
	private void comboChanged(ActionEvent e) {
	}

}
