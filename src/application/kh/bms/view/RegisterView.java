package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.RegisterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterView implements Initializable {
	@FXML
	private TextField id;
	@FXML
	private Button idCheck;
	@FXML
	private PasswordField pw;
	@FXML
	private PasswordField pw2;
	@FXML
	private TextField name;
	@FXML
	private TextField addr;
	@FXML
	private TextField phone;
	@FXML
	private TextField adminNum;
	@FXML
	private ComboBox<String> gender;
	@FXML
	private Button register;
	@FXML
	private Button cancel;
	@FXML
	private Label rMessage;
	@FXML
	private Label idLabel;

	ObservableList<String> list = FXCollections.observableArrayList("����", "����");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gender.setItems(list);
		// --------------------------------------------------------
		gender.setPromptText("����");
		// --------------------------------------------------------
	}

	@FXML
	public void checkedId() {
		String regId = id.getText();
		RegisterController rc = new RegisterController();
		// --------------------------------------------------------
		if (rc.idEnglishCheck(regId)) {
			// --------------------------------------------------------
			boolean idCheck = rc.checkedId(regId);
			if (idCheck == false) {
				idLabel.setStyle("-fx-text-fill: red");
				idLabel.setText("�̹� �����ϴ� ���̵��Դϴ�.");
			} else {
				idLabel.setStyle("-fx-text-fill: green");
				idLabel.setText("��밡���� ���̵��Դϴ�.");
			}
			// --------------------------------------------------------
		} else {
			idLabel.setStyle("-fx-text-fill: red");
			idLabel.setText("���̵�� ���� ��ҹ��ڸ� �����մϴ�.");
		}
		// --------------------------------------------------------

	}

	@FXML
	public void register() {
		String regId = id.getText();
		String regPw = pw.getText();
		String regPw2 = pw2.getText();
		String regName = name.getText();
		String regGender = gender.getValue();
		String regAddr = addr.getText();
//		String regEmail = 
		String regphone = phone.getText();
		String regAdmin = adminNum.getText();

		RegisterController rc = new RegisterController();
		boolean idCheck = rc.checkedId(regId);
		boolean psChk = rc.checkedPw(regPw, regPw2);
		boolean nullChk = rc.nullCheck(regId, regPw, regPw2, regName, regGender, regAddr, regphone);
		boolean adChk = rc.adminCheck(regAdmin);

		if (idCheck == false) {
			rMessage.setStyle("-fx-text-fill: red");
			rMessage.setText("��ȿ���� ���� ���̵��Դϴ�.");
		} else if (psChk == false) {
			rMessage.setStyle("-fx-text-fill: red");
			rMessage.setText("��й�ȣ�� ��Ȯ�� �Է����ּ���.");
		} else if (nullChk == false) {
			rMessage.setStyle("-fx-text-fill: red");
			rMessage.setText("�� ĭ ���� ä���ּ���.");
		} else {
			rMessage.setStyle("-fx-text-fill: green");
			rMessage.setText("ȸ������ �Ϸ�.");
			rc.addUser(regId, regPw, regName, regGender, regAddr, regphone, adChk);
			// --------------------------------------------------------
			cancel();
			// --------------------------------------------------------
		}
	}

	@FXML
	public void cancel() {
		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application/kh/bms/view/Login.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("�α���");
			newStage.show();

			Stage primaryStage = (Stage) cancel.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
