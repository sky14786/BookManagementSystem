package application.kh.bms.controller;

import java.util.ArrayList;

import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.User;

public class UserEnrollController {

	private LoadSave dao = LoadSave.getDao();
	private ArrayList<User> temp = dao.loadUser();

	//���̵� üũ
	public boolean checkedId(String id) {
		boolean check=true;
		
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i).getId().equals(id)) {
				check=false;
				break;
			}
		}
		return check;
	}

	// ��� üũ
	public boolean checkPw(String pw) {
		if (pw.length() >= 8 && pw.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}


	//��ĭüũ
	public boolean checkNull(String id,String pw, String name, String gender, String phone,String addr ) {
		boolean bool = true;
		//------------------------------------------
		if((id.isEmpty())||(pw.isEmpty())||(name.isEmpty())||(gender.equals("����"))||(addr.isEmpty())||(phone.isEmpty())) {
		//------------------------------------------
			bool=false;
		}
		return bool;
	}
	
	
	// ������üũ
	public boolean adminCheck(String adminNum) {
		if(adminNum.equals("��������ۿ���")) {
			return true;
		}else {
			return false;
		}
	}
	
	// �����߰�
	public void addUser(String regId,String regPw,String regName, String regGender,String regAddr,String regphone,boolean adChk) {
		temp.add(new User(regId,regPw, regName, regGender, regAddr, regphone,adChk));
		dao.saveUser(temp);
	}



}
