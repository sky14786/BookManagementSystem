package application.kh.bms.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import application.kh.bms.model.User;

public class UserUpdateController {
	private static ArrayList<User> users = new ArrayList<User>();
	private static User nowUser = new User(3, "admin", "root", "test", "경기도 안산시", "남자", "010-1234-5678");
	private int nowUserIndex;

	public void updateUser(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
		nowUser = new User(userNo, id, pw, name, addr, gender, phone);
		users.set(nowUserIndex, nowUser);
		saveUsers();
	}

	public void loadUser() {
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String temp;
			while ((temp = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(temp, "\t");
				int userNo = Integer.parseInt(st.nextToken());
				String id = st.nextToken();
				String pw = st.nextToken();
				String name = st.nextToken();
				String gender = st.nextToken();
				String addr = st.nextToken();
				String phone = st.nextToken();

				User user = new User(userNo, id, pw, name, gender, addr, phone);
				users.add(user);
			}
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void saveUsers() {
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < users.size(); i++) {
				fw.write(users.get(i).getUserNo() + "\t");
				fw.write(users.get(i).getId() + "\t");
				fw.write(users.get(i).getPw() + "\t");
				fw.write(users.get(i).getName() + "\t");
				fw.write(users.get(i).getGender() + "\t");
				fw.write(users.get(i).getAddr() + "\t");
				fw.write(users.get(i).getPhone() + "\r\n");
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User loadData() {
		return nowUser;
	}

}
