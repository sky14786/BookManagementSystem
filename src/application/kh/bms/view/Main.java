package application.kh.bms.view;

import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.BookModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//	private LoadSave dao = LoadSave.getDao();
//	ArrayList<BookModel> books = dao.loadBook();
	@Override
	public void start(Stage primaryStage) {
//		books.add(new BookModel("B909","����", "�ʹ�", "�´�", "������"));
//		books.add(new BookModel("B809","�����", "����", "�װھ�", "�θǽ�"));
//		books.add(new BookModel("P001","�ؿ���", "��𰬴�", "�����شٸ�", "���˼��繰"));
//		books.add(new BookModel("P002","������", "ȯ����", "����Ա���", "�θǽ��Ҽ�"));
//		books.add(new BookModel("P003","�����", "����", "�����Ŵ�", "��Ÿ���Ҽ�"));
//		books.add(new BookModel("P004","������", "�Ŷ�", "������;�", "�߸��Ҽ�"));
//		books.add(new BookModel("P005","�ؽ���", "�߰��ߴµ�", "�־ȵ�", "������"));
//		books.add(new BookModel("P006","�����", "�װڳ�", "��ġ�", "������"));
//		books.add(new BookModel("P007","��������", "���ݸ�", "����", "������"));
//		books.add(new BookModel("P008","���ڳ�", "���ݸ�", "����", "�Ű���"));
//		books.add(new BookModel("P009","������", "��������", "�����", "��������"));
//		books.add(new BookModel("P010","ö�ڸ�", "��Ʈ����", "���ô�", "����"));
//		books.add(new BookModel("P011","��ġ��", "�ϰ�ʹ�", "���þ߿Ͷ�", "��Ÿ���Ҽ�"));
//		books.add(new BookModel("P012","����", "�����", "����������", "��������"));
//		books.add(new BookModel("P013","�ᵵ", "�ڰ�Ͱ�", "�и����ε���", "��������"));
//		books.add(new BookModel("P014","sql����������", "�ڹٵ��ؾߵ�", "������", "��Ÿ���Ҽ�"));
//		books.add(new BookModel("P015","sql����", "�ϰ�", "������", "��Ÿ���Ҽ�"));
//		books.add(new BookModel("P016","�ڹٰ���", "�ʹ�", "������", "��Ÿ���Ҽ�"));
//		books.add(new BookModel("P017","���ε�", "����", "������", "��Ÿ���Ҽ�"));
//		dao.saveBook(books);
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application/kh/bms/view/Login.fxml"));
			Scene scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("��ٵ�����");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
