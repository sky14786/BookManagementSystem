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
import javafx.scene.control.TextField;
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
	private ComboBox searchType;
	@FXML
	private Button btnSearch;
	@FXML
	private TextField tfKeyword;

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
		gender.setCellValueFactory(new PropertyValueFactory<UserTable, String>(".gender"));
		phone.setCellValueFactory(new PropertyValueFactory<UserTable, String>("phone"));
//		UserTable ss = new UserTable(4, "admin", "test", "test", "test", "test");
//		list.add(ss);
		users = userSearchController.userTableLoad();
		for (int i = 0; i < users.size(); i++) {
			list.add(users.get(i));
		}

		table.setItems(list);
		searchType.setItems(comboList);

	}

	@FXML
	public void search() {
		ArrayList<UserTable> tempUsers = new ArrayList<UserTable>();
		switch (searchType.getValue().toString()) {
		case "userNo":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUserNo() == Integer.parseInt(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
					break;
				}
			}
			break;
		case "id":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
					break;
				}
			}
			break;
		case "name":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getName().equals(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
				}
			}
			break;
		case "addr":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getAddr().contains(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
				}
			}
			break;
		case "gender":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getGender().equals(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
				}
			}
			break;
		case "phone":
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getPhone().contains(tfKeyword.getText())) {
					tempUsers.add(users.get(i));
				}
			}
			break;

		}
		list.clear();
		for (int i = 0; i < tempUsers.size(); i++) {
			list.add(tempUsers.get(i));
		}
		table.setItems(list);
	}

	@FXML
	public void refresh() {
		list.clear();
		for (int i = 0; i < users.size(); i++) {
			list.add(users.get(i));
		}
		table.setItems(list);
	}
}
