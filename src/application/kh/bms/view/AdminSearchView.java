//package application.kh.bms.view;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//import application.kh.bms.controller.BookController;
//import application.kh.bms.controller.BookSearchController;
//import application.kh.bms.model.dao.LoadSave;
//import application.kh.bms.model.vo.BookModel;
//import application.kh.bms.model.vo.BookTable;
//import application.kh.bms.model.vo.SelectedBook;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//public class AdminSearchView implements Initializable {
//   
//      
//      @FXML private Button viewAll;   //��ü����
//      
//      BookModel book = new BookModel();
//      ArrayList<BookModel> realBooks = null;
//      
//
//   
//   //���� ��ġ ������ å �߰� ���� ���� �� �� �ִ� ȭ��
//   //
//
//   @FXML private Button btnRemove;
//   @FXML private Button btnbtnEdit;
//   @FXML private Button btnEdit, loodDetailBtn;
//   @FXML private Button btnAddBook;
//   @FXML private Button btnSelect, btnBack;   //��ȸ
//   @FXML private Button btnAll;   //��ü����
//   
//   static BookTable model = new BookTable();
//
//   @FXML private TextField tfWord;
//
//   @FXML private ComboBox<String> comboBox;   //���м���
//
//   @FXML private TableView<BookTable> tableView;
//   @FXML private TableColumn<BookTable, String> codeCol;   //��ȣ
//   @FXML private TableColumn<BookTable, String> nameCol;   //������
//   @FXML private TableColumn<BookTable, String> authorCol;   //����
//   @FXML private TableColumn<BookTable, String> pubCol;   //���ǻ�
//   @FXML private TableColumn<BookTable, String> cateCol;   //�帣
//   @FXML private TableColumn<BookTable, Boolean> rentalCol;//�뿩����
//
//   BookSearchController bookSearchController = new BookSearchController();
//   BookController bookController = new BookController();
//   ArrayList<BookTable> books = new ArrayList<BookTable>();
//   private LoadSave dao = LoadSave.getDao();
//   private ArrayList<BookModel> temp = dao.loadBook();
//   
//   
//
//   
//
//   //���̺�����
//   public int row=-1;
//
//   //�޺��ڽ� list
//   private ObservableList<String> comboList = FXCollections.observableArrayList("������","����","���ǻ�","�帣");
//
//   private static String tfsel;   //�ؽ�Ʈ�ʵ� �����
//   private static String combosel;   //�޺��ڽ� �����
//   
//   
//   
//   
//   
//   public static BookTable selBook = new BookTable();
//
//   public static BookTable getSelBook() {
//      return selBook;
//   }
//
//   public static void setSelectUser(BookModel selectBook) {
//      AdminSearchView.selBook = selBook;
//   }
//   
//   
//   
//   
//   
//   
//   static {
//      tfsel = "";
//      combosel = "";
//   }
//
//   //��ü��ȸ ���̺��
//   public ObservableList<BookTable> bookList = FXCollections.observableArrayList();
//
//   //������ȸ ���̺��
//   public ObservableList<BookTable> selectBookList = FXCollections.observableArrayList();
//
//   @Override
//   public void initialize(URL location, ResourceBundle resources) {
//
//            
//      //��ư Ŭ������ �� ��ȸ �Ǵ°Ŷ� // �����Ǵ� �޼ҵ� 
//
//      codeCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("code"));
//      nameCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("bookName"));
//      authorCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("author"));
//      pubCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("publishingHouse"));
//      cateCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("category"));
//      rentalCol.setCellValueFactory(new PropertyValueFactory<BookTable, Boolean>("rental"));
//   
//      books = bookSearchController.bookTableLoad();
//
//      for(int i = 0; i < books.size(); i++) {
//         BookTable temp = books.get(i);
//         bookList.add(books.get(i));
//      }
//      tableView.setItems(bookList);
//
//      //      lookDetailBtn.setDisable(true);
//
//      comboBox.setItems(comboList);
//
//      
//
//
//      tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTable>()
//      {
//         public void changed(ObservableValue<? extends BookTable> observable, BookTable oldValue, BookTable newValue)
//         {
//            System.out.println("dddd");
//            model = tableView.getSelectionModel().getSelectedItem();
//
//            System.out.println("���õ� Item�� Index" +  tableView.getSelectionModel().getSelectedIndex());
//            System.out.println("���õ� ���� �����ڵ� : " + model.getCode());
//         }
//      });
//   }
//   
//   @FXML
//   public void runRemove() {
//      
//      bookController.remove(tableView.getSelectionModel().getSelectedItem().getCode());
//
//   }
//   
//   @FXML
//   public void moveBack() {
//      try {
//         Stage newStage = new Stage();
//         Parent root = FXMLLoader
//               .load(getClass().getClassLoader().getResource("application/kh/bms/view/MainSearch.fxml"));
//         Scene scene = new Scene(root);
//         newStage.setScene(scene);
//         newStage.setTitle("���� ��ȸ");
//         newStage.show();
//
//         Stage primaryStage = (Stage)btnBack.getScene().getWindow();
//         primaryStage.close();
//
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//   }
//   
//   
//   @FXML
//   public void addBook()
//   {
//      try {
//         Stage newStage = new Stage();
//         Parent root = FXMLLoader
//               .load(getClass().getClassLoader().getResource("application/kh/bms/view/AddBook.fxml"));
//         Scene scene = new Scene(root);
//         newStage.setScene(scene);
//         newStage.setTitle("Book Management System");
//         newStage.show();
//
//         Stage primaryStage = (Stage)btnAddBook.getScene().getWindow();
//         primaryStage.close();
//
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//   }
//   
//   
//   
//      
//   
//   @FXML
//   public void editBook()
//   {
//      
//      try {
//         System.out.println("�޾ƿԴ�? : " + model.getCode());
//         //detailPageView.loadSelectedRow(model);
//         SelectedBook.selBook.setBookName(model.getBookName());
//         SelectedBook.selBook.setAuthor(model.getAuthor());
//         SelectedBook.selBook.setPublishingHouse(model.getPublishingHouse());
//         SelectedBook.selBook.setCategory(model.getCategory());
//         SelectedBook.selBook.setRental(model.getRental().get());
//         SelectedBook.selBook.setCode(model.getCode());
//         System.out.println("����? : " + SelectedBook.selBook.getCode());
//         Stage newStage = new Stage();
//         Parent root = FXMLLoader
//               .load(getClass().getClassLoader().getResource("application/kh/bms/view/BookUpdateView2.fxml"));
//         Scene scene = new Scene(root);
//         newStage.setScene(scene);
//         newStage.setTitle("Book Management System");
//         newStage.show();
//
//         Stage primaryStage = (Stage)btnEdit.getScene().getWindow();
//
//         primaryStage.close();
//         
//         
//         
//
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//   }
//   
//   
//   
//
//   
//   //��ü���� ��ư Ŭ�� �׼� �޼ҵ�
//   public void viewAll() {
//
//      bookList.clear();
//      for (int i = 0; i < books.size(); i++) {
//         bookList.add(books.get(i));
//      }
//      tableView.setItems(bookList);
//
//      tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTable>()
//      {
//         public void changed(ObservableValue<? extends BookTable> observable, BookTable oldValue, BookTable newValue)
//         {
//            
//            model = tableView.getSelectionModel().getSelectedItem();
//
//            System.out.println("���õ� Item�� Index" +  tableView.getSelectionModel().getSelectedIndex());
//            System.out.println("���õ� ���� �����ڵ� : " + model.getCode());
//         }
//      });
//
//   }
//
//
//   //��ȸ��ư Ŭ�� �޼ҵ�
//   @FXML
//   public void openSelectView() {
//
//      if(comboBox.getValue()!=null && tfWord.getText()!=null) {
//
//         combosel = comboBox.getValue().toString();
//         tfsel = tfWord.getText().toString();
//
//         try {
//            Stage newStage = new Stage();
//            Parent root = FXMLLoader
//                  .load(getClass().getClassLoader().getResource("application/kh/bms/view/MainSearch.fxml"));
//            Scene scene = new Scene(root);
//            newStage.setScene(scene);
//            newStage.setTitle("������ȸ");
//            newStage.show();
//
//            Stage primaryStage = (Stage)btnSelect.getScene().getWindow();
//            primaryStage.close();
//
//         } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//      }
//
//   }
//  
//    public void selectSearch() {
//
//      int j = 0;
//      switch(combosel) {
//      case "������" : 
//         for(j = 0; j < books.size(); j++) {
//            if (books.get(j).getBookName().contains(tfsel)) {
//               selectBookList.add(books.get(j));
//            }
//         }
//         break;
//      case "����" :
//         for(j = 0; j < books.size(); j++) {
//            if (books.get(j).getAuthor().contains(tfsel)) {;
//            selectBookList.add(books.get(j));
//            }
//         }
//         break;
//      case "���ǻ�" : 
//         for(j = 0; j < books.size(); j++) {
//            if (books.get(j).getPublishingHouse().contains(tfsel)) {
//               selectBookList.add(books.get(j));
//            }
//
//         }
//         break;
//      case "�帣" : 
//         for(j = 0; j < books.size(); j++) {
//            if (books.get(j).getCategory().contains(tfsel)) {
//               selectBookList.add(books.get(j));
//            }
//         }
//         break;
//      }
//
//   }
//   
//   
//
//
//   public TextField getTfWord() {
//      return tfWord;
//   }
//
//   public void setTfWord(TextField tfWord) {
//      this.tfWord = tfWord;
//   }
//   
//}
//
//
//
//
//

package application.kh.bms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.kh.bms.controller.BookController;
import application.kh.bms.controller.BookSearchController;
import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.BookModel;
import application.kh.bms.model.vo.BookTable;
import application.kh.bms.model.vo.SelectedBook;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminSearchView implements Initializable {
   ////

   // ���� ��ġ ������ å �߰� ���� ���� �� �� �ִ� ȭ��
   //

   // ���� ��ġ ������ å �߰� ���� ���� �� �� �ִ� ȭ��
   //

   @FXML
   private Button btnEdit, loodDetailBtn;
   @FXML
   private Button btnAll; // ��ü����
   @FXML
   private Button btnRemove;
   @FXML
   private Button btnbtnEdit;
   @FXML
   private Button btnAddBook;
   @FXML
   private Button btnSelect; // ��ȸ
   @FXML
   private Button viewAll; // ��ü����
   @FXML
   private Button btnBack;

   @FXML
   private TextField tfWord;

   @FXML
   private ComboBox<String> comboBox = new ComboBox<String>(); // ���м���

   @FXML
   private TableView<BookTable> tableView;
   @FXML
   private TableColumn<BookTable, String> codeCol; // ��ȣ
   @FXML
   private TableColumn<BookTable, String> nameCol; // ������
   @FXML
   private TableColumn<BookTable, String> authorCol; // ����
   @FXML
   private TableColumn<BookTable, String> pubCol; // ���ǻ�
   @FXML
   private TableColumn<BookTable, String> cateCol; // �帣
   @FXML
   private TableColumn<BookTable, Boolean> rentalCol;// �뿩����

   private LoadSave dao = LoadSave.getDao();
   private ArrayList<BookModel> temp = dao.loadBook();
   static BookTable model = new BookTable();

   BookModel book = new BookModel();
   BookSearchController bookSearchController = new BookSearchController();
   BookController bookController = new BookController();
   ArrayList<BookTable> books = new ArrayList<BookTable>();
   ArrayList<BookModel> realBooks = null;

   public static BookTable selBook = new BookTable();

   public static BookTable getSelBook() {
      return selBook;
   }

   public static void setSelectUser(BookModel selectBook) {
      AdminSearchView.selBook = selBook;
   }

   // ���̺�����
   public int row = -1;

   // �޺��ڽ� list
   private ObservableList<String> comboList = FXCollections.observableArrayList("������", "����", "���ǻ�", "�帣");

   private static String tfsel; // �ؽ�Ʈ�ʵ� �����
   private static String combosel; // �޺��ڽ� �����
   static {
      tfsel = "";
      combosel = "";
   }

   // ��ü��ȸ ���̺��
   public ObservableList<BookTable> bookList = FXCollections.observableArrayList();

   // ������ȸ ���̺��
   public ObservableList<BookTable> selectBookList = FXCollections.observableArrayList();

   @Override
   public void initialize(URL location, ResourceBundle resources) {

      // bookSearchController.bookTableSave(); //���� ���� test��

      codeCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("code"));
      nameCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("bookName"));
      authorCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("author"));
      pubCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("publishingHouse"));
      cateCol.setCellValueFactory(new PropertyValueFactory<BookTable, String>("category"));
      rentalCol.setCellValueFactory(new PropertyValueFactory<BookTable, Boolean>("rental"));
      books = bookSearchController.bookTableLoad();
//
//      if (combosel == "" && tfsel == "") {
      for (int i = 0; i < books.size(); i++) {
         bookList.add(books.get(i));
      }
      tableView.setItems(bookList);
//
//      }

//      else {
//         tableView.setItems(selectBookList);
//      }

      comboBox.setItems(comboList);

      // -----------������������

      tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTable>() {
         public void changed(ObservableValue<? extends BookTable> observable, BookTable oldValue,
               BookTable newValue) {
            model = tableView.getSelectionModel().getSelectedItem();

            if (model.getRental().getValue() == true) {
               btnEdit.setDisable(true);
            } else {
               btnEdit.setDisable(false);
            }
         }
      });
   }

   // ��ü��ȸ �ϰ�, ��ȸ�� ���̺��� ���� å�� ��Ż ���� true����, false���� Ȯ��
   // ���� true�� ���� �Ұ�
   // false �� ��� ����Ʈ���� ����
   // cf) nowBook�� �ڵ尪�� �Ѱ���
   // ��Ż�� ������ true

   @FXML
   public void runRemove() {

      bookController.remove(tableView.getSelectionModel().getSelectedItem().getCode());

      bookList.clear();
      books = bookSearchController.bookTableLoad();

      for (int i = 0; i < books.size(); i++) {
         bookList.add(books.get(i));
      }
      tableView.setItems(bookList);

   }

   @FXML
   public void moveBack() {
      try {
         Stage newStage = new Stage();
         Parent root = FXMLLoader
               .load(getClass().getClassLoader().getResource("application/kh/bms/view/MainSearch.fxml"));
         Scene scene = new Scene(root);
         newStage.setScene(scene);
         newStage.setTitle("���� ��ȸ");
         newStage.show();

         Stage primaryStage = (Stage) btnBack.getScene().getWindow();
         primaryStage.close();

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @FXML
   public void addBook() {
      try {
         Stage newStage = new Stage();
         Parent root = FXMLLoader
               .load(getClass().getClassLoader().getResource("application/kh/bms/view/AddBook.fxml"));
         Scene scene = new Scene(root);
         newStage.setScene(scene);
         newStage.setTitle("Book Management System");
         newStage.show();

         Stage primaryStage = (Stage) btnSelect.getScene().getWindow();
         primaryStage.close();

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @FXML
   public void editBook() {

      try {

         System.out.println("�޾ƿԴ�? : " + model.getCode());
         SelectedBook.selBook.setBookName(model.getBookName());
         SelectedBook.selBook.setAuthor(model.getAuthor());
         SelectedBook.selBook.setPublishingHouse(model.getPublishingHouse());
         SelectedBook.selBook.setCategory(model.getCategory());
         SelectedBook.selBook.setRental(model.getRental().get());
         SelectedBook.selBook.setCode(model.getCode());
         System.out.println("����? : " + SelectedBook.selBook.getCode());

         Stage newStage = new Stage();
         Parent root = FXMLLoader
               .load(getClass().getClassLoader().getResource("application/kh/bms/view/BookUpdateView2.fxml"));
         Scene scene = new Scene(root);
         newStage.setScene(scene);
         newStage.setTitle("Book Management System");
         newStage.show();

         Stage primaryStage = (Stage) btnEdit.getScene().getWindow();

         primaryStage.close();

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   // ��ü���� ��ư Ŭ�� �׼� �޼ҵ�
   @FXML
   public void viewAll() {
   
      comboBox.setValue("����");
      bookList.clear();
      books = bookSearchController.bookTableLoad();

      tfWord.setText("");
      
      for (int i = 0; i < books.size(); i++) {
         bookList.add(books.get(i));
      }
      tableView.setItems(bookList);

      
   }

   // ��ȸ��ư Ŭ�� �żҵ�
   @FXML
   public void selectSearch() {

      tfsel = tfWord.getText();
      System.out.println(tfsel);
      combosel = comboBox.getValue();
      System.out.println(combosel);

      if (tfsel.isEmpty() || (combosel == null||combosel.equals("����"))) {
         System.out.println("�˻������� �Է����ּ���");
      } else {    
         bookList.clear();
         int j = 0;
         switch (combosel) {
         case "������":
            for (j = 0; j < books.size(); j++) {
               if (books.get(j).getBookName().contains(tfsel)) {
                  bookList.add(books.get(j));
               }
            }
            break;
         case "����":
            for (j = 0; j < books.size(); j++) {
               if (books.get(j).getAuthor().contains(tfsel)) {
                  ;
                  bookList.add(books.get(j));
               }
            }
            break;
         case "���ǻ�":
            for (j = 0; j < books.size(); j++) {
               if (books.get(j).getPublishingHouse().contains(tfsel)) {
                  bookList.add(books.get(j));
               }

            }
            break;
         case "�帣":
            for (j = 0; j < books.size(); j++) {
               if (books.get(j).getCategory().contains(tfsel)) {
                  bookList.add(books.get(j));
               }
            }
            break;
         }

         tableView.setItems(bookList);
      }

   }

   public TextField getTfWord() {
      return tfWord;
   }

   public void setTfWord(TextField tfWord) {
      this.tfWord = tfWord;
   }

}