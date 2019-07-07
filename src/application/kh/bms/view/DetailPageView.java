package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.kh.bms.controller.RentalController;
import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.BookModel;
import application.kh.bms.model.vo.SelectedBook;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetailPageView implements Initializable {

	@FXML
	private Label bookCodeLab; // �����ڵ� ��¶�
	@FXML
	private Label bookNameLab; // ������ ��¶�
	@FXML
	private Label authorLab; // ���� ��¶�
	@FXML
	private Label pubLab; // ���ǻ� ��¶�
	@FXML
	private Label categoryLab; // �帣 ��¶�
	@FXML
	private Label rentalLab; // �뿩���� ��¶�

	@FXML
	private Button backBtn; // �ڷΰ��� ��ư
	@FXML
	private Button rentalBtn; // �뿩�ϱ� ��ư

	private RentalController rentalController = new RentalController();

	private ArrayList<BookModel> books = new ArrayList<BookModel>();
	private LoadSave dao = LoadSave.getDao();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		bookCodeLab.setText(SelectedBook.selBook.getCode());
		bookNameLab.setText(SelectedBook.selBook.getBookName());
		authorLab.setText(SelectedBook.selBook.getAuthor());
		pubLab.setText(SelectedBook.selBook.getPublishingHouse());
		categoryLab.setText(SelectedBook.selBook.getCategory());

		System.out.println("�Ѱܹ��� �����ڵ� : " + SelectedBook.selBook.getCode());

		if (SelectedBook.selBook.isRental() == false) {
			rentalLab.setText("�뿩 ����");
			rentalBtn.setDisable(false);
		} else {
			rentalLab.setText("�뿩��");
			rentalBtn.setDisable(true);
		}

	}

	// �ڷΰ��� ��ư �޼ҵ�
	@FXML
	public void backToSearchView() {
		try {
			Stage newStage = new Stage();
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application/kh/bms/view/MainSearch.fxml"));
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.setTitle("�����˻�");
			newStage.show();

			Stage primaryStage = (Stage) backBtn.getScene().getWindow();
			primaryStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �뿩�ϱ� ��ư �޼ҵ�
	@FXML
	public void decideRental() {
		rentalController.addRetalBook(SelectedBook.selBook.getCode());

		rentalLab.setText("�뿩��");
		rentalBtn.setDisable(true);

		books = dao.loadBook();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getCode().equals(SelectedBook.selBook.getCode())) {
				books.get(i).setRental(true);
			}
		}
		dao.saveBook(books);
		// ---------------------------------------------
		backToSearchView();
		// ---------------------------------------------
	}

}
