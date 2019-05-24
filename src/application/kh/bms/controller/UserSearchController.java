package application.kh.bms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import application.kh.bms.model.User;
import application.kh.bms.model.UserTable;

public class UserSearchController {

	public ArrayList<UserTable> userTableLoad() {
		String fileName = "user.txt";
		File file = new File(fileName);
		ObjectInputStream ois = null;
		ArrayList<User> temp = new ArrayList<User>();
		ArrayList<UserTable> temp2 = new ArrayList<UserTable>();
		try {
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			temp = (ArrayList<User>) ois.readObject();
			for (int i = 0; i < temp.size(); i++) {
				UserTable ut = new UserTable(temp.get(i).getUserNo(), temp.get(i).getId(), temp.get(i).getName(),
						temp.get(i).getAddr(), temp.get(i).getGender(), temp.get(i).getPhone());
				temp2.add(ut);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp2;
	}
}
