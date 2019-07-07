package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.UserEnrollController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserEnrollView implements Initializable {
	private UserEnrollController ec = new UserEnrollController();

	private ObservableList<String> list = FXCollections.observableArrayList("����", "����");

	@FXML
	private TextField id, pw, name, addr, phone, adCheck;

	// �޺��ڽ�

	@FXML
	private ComboBox<String> comGender;

	@FXML
	private Label checkIdLabel, checkPwLabel, checkNullLabel;
//
	@FXML
	private Button enrollBtn, backBtn;

	// �߰���ư
	@FXML
	private void enroll() {
		String memId = id.getText();
		String memPw = pw.getText();
		String memName = name.getText();
		String memGender = comGender.getValue().toString();
		String memAddr = addr.getText();
		String memPhone = phone.getText();
		String memAdCheck = adCheck.getText();
		boolean memAdChk = ec.adminCheck(memAdCheck);

		checkIdLabel.setText("");
		checkPwLabel.setText("");
		checkNullLabel.setText("");

		if (ec.checkedId(memId) == false) {
			checkIdLabel.setText("�ߺ��Ǵ� ���̵��Դϴ�.");
		} else if (ec.checkPw(memPw) == false) {
			checkPwLabel.setText("8~12�� ���̷� �Է����ּ���.");
		} else if (ec.checkNull(memId, memPw, memName, memGender, memPhone, memAddr) == false) {
			checkNullLabel.setText("  ��ĭ���� �Է����ּ���.  ");
		} else {
			checkNullLabel.setText(" ȸ���� �����ƽ��ϴ�. ");
			ec.addUser(memId, memPw, memName, memGender, memAddr, memPhone, memAdChk);
			try {
				Stage newStage = new Stage();
				Parent root = FXMLLoader
						.load(getClass().getClassLoader().getResource("application/kh/bms/view/UserSearch.fxml"));
				Scene scene = new Scene(root);
				newStage.setScene(scene);
				newStage.setTitle("ȸ����������");
				newStage.show();

				Stage primaryStage = (Stage) enrollBtn.getScene().getWindow();
				primaryStage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@FXML
	public void back() {
		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application/kh/bms/view/UserSearch.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("ȸ����������");
			newStage.show();

			Stage primaryStage = (Stage) backBtn.getScene().getWindow();
			primaryStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private void comboChanged(ActionEvent e) {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comGender.setItems(list);
		// --------------------------------------------------
		comGender.setPromptText("����");
		// --------------------------------------------------

	}

}
