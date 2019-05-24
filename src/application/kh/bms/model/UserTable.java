package application.kh.bms.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTable {
	private final SimpleIntegerProperty userNo;
	private final SimpleStringProperty id, name, addr, gender, phone;

	public UserTable(Integer userNo, String id, String name, String addr, String gender, String phone) {
		super();
		this.userNo = new SimpleIntegerProperty(userNo);
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.addr = new SimpleStringProperty(addr);
		this.gender = new SimpleStringProperty(gender);
		this.phone = new SimpleStringProperty(phone);
	}

	public Integer getUserNo() {
		return userNo.get();
	}

	public String getId() {
		return id.get();
	}

	public String getName() {
		return name.get();
	}

	public String getAddr() {
		return addr.get();
	}

	public String getGender() {
		return gender.get();
	}

	public String getPhone() {
		return phone.get();
	}

}
