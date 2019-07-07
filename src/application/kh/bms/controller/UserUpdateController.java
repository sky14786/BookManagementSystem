package application.kh.bms.controller;

import java.util.ArrayList;

import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.User;

public class UserUpdateController {
	private LoadSave dao = LoadSave.getDao();
	private ArrayList<User> users = null;
	private String targetId = "";
//	private static User nowUser = null;

	// ArrayList�� �̿��Ͽ� ������ ������ ������ �Ķ���ͷ� �޾ƿ� �ش� userNo�� Set ��
	public void updateUser(String id, String name, String addr, String gender, String phone) {
		ArrayList<User> users = dao.loadUser();
		int nowUser = -1;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(targetId)) {
				nowUser = i;
				users.get(i).setName(name);
				users.get(i).setAddr(addr);
				users.get(i).setGender(gender);
				users.get(i).setPhone(phone);
				break;
			}
		}
//		User temp = new User(targetId, users.get(nowUser).getPw(), name, addr, gender, phone,users.get(nowUser).isAdminCheck());
//		System.out.println(temp.toString());
//		users.set(nowUser, temp);
		dao.saveUser(users);
	}

	// ������ PW �� ���� 8~12�� üũ
	public boolean pwCheck(String pw) {
		if (pw.length() >= 8 && pw.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	// ȸ���������� ���� �����κ��� �α����� ������ userNo�� �޾ƿ� �ش� ������ ���������� �ε��Ŵ
	public User loadData(String id) {
		targetId = id;
		ArrayList<User> users = dao.loadUser();
		User temp = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(targetId)) {
				temp = users.get(i);
				break;
			}
		}
		return temp;
	}
}
