package application.kh.bms.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.kh.bms.controller.UserSearchController;
import application.kh.bms.model.UserTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserSearchView implements Initializable {
	@FXML
	private TableView<UserTable> table;
	@FXML
	private TableColumn<UserTable, Integer> userNo;
	@FXML
	private TableColumn<UserTable, String> id;
	@FXML
	private TableColumn<UserTable, String> name;
	@FXML
	private TableColumn<UserTable, String> addr;
	@FXML
	private TableColumn<UserTable, String> gender;
	@FXML
	private TableColumn<UserTable, String> phone;
	@FXML
	private ComboBox comboBox;
	@FXML
	private Button btnSearch;

	UserSearchController userSearchController = new UserSearchController();
	ArrayList<UserTable> users = new ArrayList<UserTable>();

	private ObservableList<String> comboList = FXCollections.observableArrayList("userNo", "ID", "name", "addr",
			"gender", "phone");

	public ObservableList<UserTable> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userNo.setCellValueFactory(new PropertyValueFactory<UserTable, Integer>("userNo"));
		id.setCellValueFactory(new PropertyValueFactory<UserTable, String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<UserTable, String>("name"));
		addr.setCellValueFactory(new PropertyValueFactory<UserTable, String>("addr"));
		gender.setCellValueFactory(new PropertyValueFactory<UserTable, String>("gender"));
		phone.setCellValueFactory(new PropertyValueFactory<UserTable, String>("phone"));
//		UserTable ss = new UserTable(4, "admin", "test", "test", "test", "test");
//		list.add(ss);
		users = userSearchController.userTableLoad();
		for (int i = 0; i < users.size(); i++) {
			list.add(users.get(i));
		}

		table.setItems(list);
		comboBox.setItems(comboList);

	}
}
