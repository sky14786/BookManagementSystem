package application.kh.bms.model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4193961501486761372L;

	private int userNo;
	private String id, pw, name, addr, gender, phone;

	public int getUserNo() {
		return userNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public User() {
	}

	public User(int userNo, String id, String pw, String name, String addr, String gender, String phone) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}

}
