package application.kh.bms.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.BookModel;
import application.kh.bms.model.vo.BookTable;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class BookController {

	int count = 0;
	BookModel book = new BookModel();
	ArrayList<BookModel> books = new ArrayList<BookModel>();
	ArrayList<BookModel> realBooks = null;
	private LoadSave dao = LoadSave.getDao();

	public ArrayList<BookModel> getBooks() {
		books = dao.loadBook();
		return books;
	}

	public void setBooks(ArrayList<BookModel> books) {
		this.books = books;
	}

	public boolean checkCode(String code) {
		boolean result = true; // true : �ߺ��� ���, �߰� ����
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getCode().equals(code)) {
				result = false; // ������ ������, true -> false
				break; // false : �ߺ��� ���� -> �߰� �Ұ���.
			}
		}
		return result; // �� ���� ��� �Ҹ� �� ����!!
	}

	public boolean addBook(BookModel newBook) {
		books = dao.loadBook();
		boolean isSucc = false;
		if (checkCode(newBook.getCode())) {
			books.add(newBook);
			dao.saveBook(books);
			isSucc = true;
		} else {
			System.out.println("�ߺ�");
			isSucc = false;
		}
		return isSucc;
	}

	public void remove(String bookCode) {
		realBooks = dao.loadBook();
		if (realBooks != null) {
			for (int i = 0; i < realBooks.size(); i++) {
				if (realBooks.get(i).getCode().equals(bookCode)) {
					if (!realBooks.get(i).isRental()) {
						realBooks.remove(i);
						dao.saveBook(realBooks);
						break;
					}
				}
			}
		}
	}

}
