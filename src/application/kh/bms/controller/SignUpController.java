package application.kh.bms.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

import application.kh.bms.model.User;

public class SignUpController {
	ArrayList<User> users = new ArrayList<User>();
	private static int userNo;

	public void createUser(String id, String pw, String name, String addr, String gender) {
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, true);
			User newUser = new User(id, pw, name, addr, gender);
			User.addUser();
			fw.write(userNo + "\t");
			fw.write(newUser.getId() + "\t");
			fw.write(newUser.getPw() + "\t");
			fw.write(newUser.getName() + "\t");
			fw.write(newUser.getGender() + "\t");
			fw.write(newUser.getAddr() + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void duplicateCheck(String id) {
		try {
			String fileName = "C:\\test\\user.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String read = null;
			while ((read = br.readLine()) != null) {
				StringTokenizer temp = new StringTokenizer(read, " ");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
