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

	// ArrayList를 이용하여 수정된 유저의 정보를 파라미터로 받아와 해당 userNo에 Set 함
	public void updateUser(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
//		nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		User nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		users.set(nowUserIndex, nowUser);
		saveUsers();
	}

	// 설정한 PW 의 길이 8~12자 체크
	public boolean pwCheck(String pw) {
		if (pw.length() >= 8 && pw.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	// DATA 불러오기용 로직
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

	// DATA 저장용 로직
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

	// 회원정보수정 이전 씬으로부터 로그인한 유저의 userNo를 받아와 해당 값으로 유저정보를 로드시킴
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

	// 테스트용 로직
	public void enrollTest(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
		User tempUser = new User(userNo, id, pw, name, addr, gender, phone);
		users.add(tempUser);
		saveUsers();
	}

}
