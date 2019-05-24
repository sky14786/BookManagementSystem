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

	// 테스트용 변수
	private int userNo = 0;

	private ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");

	User user = null;

	// 테스트용 로직
	public void test() {
		userUpdateController.enrollTest(userNo++, tfID.getText(), tfPw.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getValue().toString(), tfPhone.getText());
		resetTextfield();
	}

	// 테스트용 로직
	public void resetTextfield() {
		tfID.setText("");
		tfPw.setText("");
		tfName.setText("");
		tfAddr.setText("");
		tfPhone.setText("");
		comGender.setPromptText("Gender");
	}

	// Combox의 초기값을 list로 설정, 회원 정보 수정창 로드시에 Data를 불러들임
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comGender.setItems(list);
		user = userUpdateController.loadData(0);
		userInformationLoad();
		tCheck.setText("");
	}

	// 뒤로가기 버튼 누를시 해당 플랫폼 종료
	@FXML
	public void backMove() {
		javafx.application.Platform.exit();
	}

	// 회원 정보 수정할 User의 정보를 Controller로부터 Load함
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

	// 회원 정보 수정시 설정된 PW길이 8~12자 체크 로직 수행후 True 면 유저 정보 업데이트
	// False 일시 패스워드 길이 에러 출력
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
