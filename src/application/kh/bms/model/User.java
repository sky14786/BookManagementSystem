package application.kh.bms.model;

public class User {
	private static int no = 0;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	private int userNo;
	private String id, pw, name, addr, gender;

	public User() {
	}

	public static int getNo() {
		return no;
	}

	public User(String id, String pw, String name, String addr, String gender) {
		this.userNo = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
	}

	public static void addUser() {
		no++;
	}

	public static void subtractUser() {
		no--;
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

}
