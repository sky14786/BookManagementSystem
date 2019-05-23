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
	private static ArrayList<User> users = new ArrayList<User>();
	private static User nowUser = new User(3, "admin", "root", "test", "경기도 안산시", "남자", "010-1234-5678");
	private int nowUserIndex = 0;

	public void updateUser(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
//		nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		User nowUser = new User(userNo, id, pw, name, addr, gender, phone);

		users.add(nowUser);
		users.set(nowUserIndex, nowUser);
		saveUsers();
	}

	public boolean pwCheck(String pw) {
		if (pw.length() >= 8 && pw.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	public void loadUser() {
		ObjectInputStream ois = null;
		try {
			String fileName = "C:\\test\\user.txt";
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

	public void saveUsers() {
		ObjectOutputStream oos = null;
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
//			for (int i = 0; i < users.size(); i++) {
//				oos.writeObject(users.get(i));
//			}
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

	public User loadData() {
		return nowUser;
	}

//	public void loadUser() {
//		try {
//			String fileName = "C:\\test\\user.txt";
//			File file = new File(fileName);
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			String temp;
//			while ((temp = br.readLine()) != null) {
//				StringTokenizer st = new StringTokenizer(temp, "\t");
//				int userNo = Integer.parseInt(st.nextToken());
//				String id = st.nextToken();
//				String pw = st.nextToken();
//				String name = st.nextToken();
//				String gender = st.nextToken();
//				String addr = st.nextToken();
//				String phone = st.nextToken();
//
//				User user = new User(userNo, id, pw, name, gender, addr, phone);
//				users.add(user);
//			}
//			br.close();
//			fr.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

//	private void saveUsers() {
//		try {
//			String fileName = "C:\\test\\user.txt";
//			File file = new File(fileName);
//			FileWriter fw = new FileWriter(file);
//			for (int i = 0; i < users.size(); i++) {
//				fw.write(users.get(i).getUserNo() + "\t");
//				fw.write(users.get(i).getId() + "\t");
//				fw.write(users.get(i).getPw() + "\t");
//				fw.write(users.get(i).getName() + "\t");
//				fw.write(users.get(i).getGender() + "\t");
//				fw.write(users.get(i).getAddr() + "\t");
//				fw.write(users.get(i).getPhone() + "\r\n");
//				fw.flush();
//			}
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
