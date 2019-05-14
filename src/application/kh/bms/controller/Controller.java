package application.kh.bms.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.kh.bms.model.User;

public class Controller {
	ArrayList<User> users = new ArrayList<User>();
	private static int userNo;

	public void login(String id, String pw) {
		
	}
	
	public void createUser() {
		
	}

	public void saveDate() {
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, true);
			fw.write(userNo + "\t");
			fw.write(users.get(userNo).getId() + "\t");
			fw.write(users.get(userNo).getPw() + "\t");
			fw.write(users.get(userNo).getName() + "\t");
			fw.write(users.get(userNo).getAddr() + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
