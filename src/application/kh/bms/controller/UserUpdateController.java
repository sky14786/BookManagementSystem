package application.kh.bms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.kh.bms.model.User;

public class UserUpdateController {
	private ArrayList<User> users = null;
//	private static User nowUser = null;
	private int nowUserIndex = 0;

	// ArrayList�� �̿��Ͽ� ������ ������ ������ �Ķ���ͷ� �޾ƿ� �ش� userNo�� Set ��
	public void updateUser(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
//		nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		User nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		users.set(nowUserIndex, nowUser);
		saveUsers();
	}

	// ������ PW �� ���� 8~12�� üũ
	public boolean pwCheck(String pw) {
		if (pw.length() >= 8 && pw.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	// DATA �ҷ������ ����
	public void loadUser() {

		ObjectInputStream ois = null;
		try {
			String fileName = "user.txt";
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
//			User user;
//			while ((user = (User) ois.readObject()) != null) {
//				users.add(user);
//			}
			users = (ArrayList<User>) ois.readObject();
		} catch (Exception e) {
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// DATA ����� ����
	public void saveUsers() {
		ObjectOutputStream oos = null;
		try {
			String fileName = "user.txt";
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ȸ���������� ���� �����κ��� �α����� ������ userNo�� �޾ƿ� �ش� ������ ���������� �ε��Ŵ
	public User loadData(int userNo) {
		loadUser();
		int i;
		for (i = 0; i < users.size(); i++) {
			if (users.get(i).getUserNo() == userNo) {
				nowUserIndex = i;
				break;
			}
		}
		return users.get(i);
	}

	// �׽�Ʈ�� ����
	public void enrollTest(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
		User tempUser = new User(userNo, id, pw, name, addr, gender, phone);
		users.add(tempUser);
		saveUsers();
	}

}
