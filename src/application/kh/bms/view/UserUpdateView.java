package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.kh.bms.controller.UserUpdateController;
import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.User;
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
	private UserUpdateController userUpdateController = new UserUpdateController();
	@FXML
	private Button btnUpdate = new Button(), btnBack, btnTest, btnAgree;
	@FXML
	private ComboBox comGender = new ComboBox<>();
	@FXML
	private CheckBox checkAgree;
	@FXML
	private TextField tfName = new TextField();
	@FXML
	private TextField tfAddr = new TextField();
	@FXML
	private TextField tfPhone = new TextField();
	@FXML
	private TextField tfID = new TextField();
	@FXML
	private PasswordField tfPw = new PasswordField();
	@FXML
	private Text tID = new Text(), tCheck;
	@FXML
	private Label lID;
	private ObservableList<String> list = FXCollections.observableArrayList("����", "����");

	private LoadSave dao = LoadSave.getDao();

	private User user = UserSearchView.getSelectUser();

	private void resetTextfield() {
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
		lID.setText(user.getId());
		tfPw.setText(user.getPw());
		tfPw.setEditable(false);
		tfName.setText(user.getId());
		tfAddr.setText(user.getAddr());
		tfPhone.setText(user.getPhone());
		comGender.setItems(list);
		comGender.setValue(user.getGender());
		tCheck.setText("");
	}

	// �ڷΰ��� ��ư ������ �ش� �÷��� ����
	@FXML
	private void backMove() {
		try {
            Stage newStage = new Stage();
            Parent root = FXMLLoader
                  .load(getClass().getClassLoader().getResource("application/kh/bms/view/userSearch.fxml"));
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.setTitle("���θ޴�");
            newStage.show();

            Stage primaryStage = (Stage) btnBack.getScene().getWindow();
             primaryStage.close();
         }
         catch (IOException e) {
            e.printStackTrace();
         }
	}

	// ȸ�� ���� ������ User�� ������ Controller�κ��� Load��
//	@FXML
//	public void userInformationLoad(User selUser) {
////		user = userUpdateController.loadData(id);
//		this.user=selUser;
//		System.out.println(user.getId());
//		System.out.println(user.getPw());
//		System.out.println(user.toString());
////		tfPw.setText(user.getPw());
//		tfName.setText(user.getName());
////		tfAddr.setText(user.getAddr());
////		comGender.setPromptText(user.getGender());0
////		tfPhone.setText(user.getPhone());
//	}

	// ȸ�� ���� ������ ������ PW���� 8~12�� üũ ���� ������ True �� ���� ���� ������Ʈ
	// False �Ͻ� �н����� ���� ���� ���
	@FXML
	private void updateUser() {
		System.out.println(comGender.getValue().toString());
		userUpdateController.updateUser(tID.getText(), tfName.getText(), tfAddr.getText(),
				comGender.getValue().toString(), tfPhone.getText());

//		new UpdateSuccessView().showUpdateSuccess();

	}

	@FXML
	private void comboChanged(ActionEvent e) {
	}

}
