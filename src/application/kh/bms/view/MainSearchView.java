package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.kh.bms.controller.BookSearchController;
import application.kh.bms.controller.RentalController;
import application.kh.bms.controller.UserDeleteController;
import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.BookModel;
import application.kh.bms.model.vo.BookTable;
import application.kh.bms.model.vo.SelectedBook;
import application.kh.bms.model.vo.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainSearchView implements Initializable {



	@FXML private Button btnSelect;   //��ȸ
	@FXML private Button btnAll;   //��ü����
	@FXML private Button lookDetailBtn; //�󼼺���
	@FXML private Button rentalListBtn;//�뿩���
	@FXML private Button btnGoUserSearch;   //ȸ��������ư
	@FXML private Button btnGoAdminMain;   //����������ư
	@FXML private Button btnUserDelete;
	@FXML private Button btnLogin;   //�ڷΰ���
	@FXML private Button btnNowRental;   //�ٷδ뿩��ư

	@FXML private TextField tfWord;
	@FXML private Label lblNullCheck;

	@FXML private ComboBox<String> comboBox;	//���м���

	@FXML private TableView<BookTable> tableView;
	@FXML private TableColumn<BookTable, String> codeCol;	//��ȣ
	@FXML private TableColumn<BookTable, String> nameCol;	//������
	@FXML private TableColumn<BookTable, String> authorCol;	//����
	@FXML private TableColumn<BookTable, String> pubCol;	//���ǻ�
	@FXML private TableColumn<BookTable, String> cateCol;	//�帣
	@FXML private TableColumn<BookTable, Boolean> rentalCol;//�뿩����

	private RentalController rentalController = new RentalController();
	
	static BookTable model = new BookTable();
	private DetailPageView detailPageView = new DetailPageView();

	private BookSearchController bookSearchController = new BookSearchController();
	private ArrayList<BookTable> books = new ArrayList<BookTable>();


	//���̺�����
	public int row=-1;

	//�޺��ڽ� list
	private ObservableList<String> comboList = FXCollections.observableArrayList("������","����","���ǻ�","�帣");

	private String tfsel="";	//�ؽ�Ʈ�ʵ� �����
	private String combosel="";	//�޺��ڽ� �����

	private LoadSave dao = LoadSave.getDao();
	private ArrayList<BookModel> temp = dao.loadBook();
	private ArrayList<User> temp2 = dao.loadUser();

	//��ü��ȸ ���̺��
	public ObservableList<BookTable> bookList = FXCollections.observableArrayList();

	private String userId = dao.getNowUser();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnGoUserSearch.setVisible(false);
		btnGoAdminMain.setVisible(false);
		//���������� Ȯ��
		for(int i = 0; i < temp2.size(); i++) {
			if(temp2.get(i).getId().equals(userId)) {
				if(temp2.get(i).isAdminCheck()==true) {
					//������
					btnGoUserSearch.setVisible(true);
					btnGoAdminMain.setVisible(true);

				}
			}
		}

		codeCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("code"));
		nameCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("bookName"));
		authorCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("author"));
		pubCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("publishingHouse"));
		cateCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("category"));
		rentalCol.setCellValueFactory(new PropertyValueFactory<BookTable, Boolean>("rental"));

		books = bookSearchController.bookTableLoad();

		for(int i = 0; i < books.size(); i++) {
			BookTable temp = books.get(i);
			bookList.add(books.get(i));
		}
		tableView.setItems(bookList);

		//		lookDetailBtn.setDisable(true);

		comboBox.setItems(comboList);

		lookDetailBtn.setDisable(true);


		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTable>()
		{
			public void changed(ObservableValue<? extends BookTable> observable, BookTable oldValue, BookTable newValue)
			{
				lookDetailBtn.setDisable(false);
				model = tableView.getSelectionModel().getSelectedItem();

				//				System.out.println("���õ� Item�� Index" +  tableView.getSelectionModel().getSelectedIndex());
				//				System.out.println("���õ� ���� �����ڵ� : " + model.getCode());
			}
		});


	}

	//��ü���� ��ư Ŭ�� �׼� �޼ҵ�
	public void viewAll() {

		bookList.clear();
		for (int i = 0; i < books.size(); i++) {
			bookList.add(books.get(i));
		}
		tableView.setItems(bookList);

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTable>()
		{
			public void changed(ObservableValue<? extends BookTable> observable, BookTable oldValue, BookTable newValue)
			{
				lookDetailBtn.setDisable(false);
				model = tableView.getSelectionModel().getSelectedItem();

				System.out.println("���õ� Item�� Index" +  tableView.getSelectionModel().getSelectedIndex());
				System.out.println("���õ� ���� �����ڵ� : " + model.getCode());
			}
		});

	}

	//��ȸ��ư Ŭ�� �޼ҵ�
	public void selectSearch() {
		ArrayList<BookTable> tempBooks = new ArrayList<BookTable>();
		tfsel = tfWord.getText();
		combosel = comboBox.getValue();

		if(tfsel.isEmpty() || combosel==null) {
			lblNullCheck.setText("�˻������� �Է����ּ���");
		} else {

			int j = 0;
			switch(combosel) {
			case "������" : 
				for(j = 0; j < books.size(); j++) {
					if (books.get(j).getBookName().contains(tfsel)) {
						tempBooks.add(books.get(j));
					}
				}
				break;
			case "����" :
				for(j = 0; j < books.size(); j++) {
					if (books.get(j).getAuthor().contains(tfsel)) {;
					tempBooks.add(books.get(j));
					}
				}
				break;
			case "���ǻ�" : 
				for(j = 0; j < books.size(); j++) {
					if (books.get(j).getPublishingHouse().contains(tfsel)) {
						tempBooks.add(books.get(j));
					}

				}
				break;
			case "�帣" : 
				for(j = 0; j < books.size(); j++) {
					if (books.get(j).getCategory().contains(tfsel)) {
						tempBooks.add(books.get(j));
					}
				}
				break;
			}
			bookList.clear();
			for (int i = 0; i < tempBooks.size(); i++) {
				bookList.add(tempBooks.get(i));
			}
			tableView.setItems(bookList);
		}
	}




	//�뿩��� Ŭ�� �޼ҵ�
	@FXML
	public void changeToRentalList() {
		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/RentalList.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("�뿩���");
			newStage.show();

			Stage primaryStage = (Stage) rentalListBtn.getScene().getWindow();
			primaryStage.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//�󼼺��� ��ư Ŭ�� �޼ҵ�
	@FXML
	public void changeToDetailPage() {

		try { 
			System.out.println("�޾ƿԴ�? : " + model.getCode());
			//detailPageView.loadSelectedRow(model);
			SelectedBook.selBook.setBookName(model.getBookName());
			SelectedBook.selBook.setAuthor(model.getAuthor());
			SelectedBook.selBook.setPublishingHouse(model.getPublishingHouse());
			SelectedBook.selBook.setCategory(model.getCategory());
			SelectedBook.selBook.setRental(model.getRental().get());
			SelectedBook.selBook.setCode(model.getCode());
			System.out.println("����? : " + SelectedBook.selBook.getCode());

			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/DetailPage.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("�����󼼺���");
			newStage.show();

			Stage primaryStage = (Stage) lookDetailBtn.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//ȸ������ ��ư Ŭ�� �޼ҵ�
	//	btnGoUserSearch
	@FXML
	public void GoUserSearch() {

		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/userSearch.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("ȸ������");
			newStage.show();

			Stage primaryStage = (Stage) btnGoUserSearch.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//�������� ��ư Ŭ�� �޼ҵ�
	@FXML
	public void GoAdminMain() {

		try { 
			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/AdminSearch.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("��������");
			newStage.show();

			Stage primaryStage = (Stage) btnGoAdminMain.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//ȸ��Ż�� ��ư Ŭ�� �޼ҵ�
	@FXML
	public void UserDelete() {
		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/UserDelete.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("ȸ������");
			newStage.show();

			Stage primaryStage = (Stage) btnUserDelete.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//�ڷΰ��� ��ư Ŭ�� �޼ҵ�
	@FXML
	public void GoLogin() {

		try { 
			Stage newStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/kh/bms/view/Login.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("�α���");
			newStage.show();

			Stage primaryStage = (Stage) btnLogin.getScene().getWindow();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void nowRental() {
		System.out.println("�ٷδ뿩�ǳ�?");
		System.out.println(model.getCode());
//		// ---------------------------------------------
		rentalController.addRetalBook(model.getCode());

//		btnNowRental.setDisable(true);

		temp = dao.loadBook();
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getCode().equals(model.getCode())) {
				temp.get(i).setRental(true);
			}
		}
		dao.saveBook(temp);
		
		bookList.clear();
		books = bookSearchController.bookTableLoad();
		for(int i = 0; i < books.size(); i++) {
			bookList.add(books.get(i));
		}
		tableView.setItems(bookList);
//		// ---------------------------------------------
//		

	}

}




