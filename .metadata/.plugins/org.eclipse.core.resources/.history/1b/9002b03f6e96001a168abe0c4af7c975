package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
	private final StringProperty name;
	private final StringProperty id;
	private final StringProperty pw;
	private final StringProperty phone;
	
	public Customer(String name, String id, String pw, String phone) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleStringProperty(id);
		this.pw = new SimpleStringProperty(pw);
		this.phone = new SimpleStringProperty(phone);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty getNameProperty() {
		return name;
	}
	
	public String getID() {
		return id.get();
	}
	public void setID(String id) {
		this.id.set(id);
	}
	public StringProperty getIDProperty() {
		return id;
	}
	
	public String getPw() {
		return pw.get();
	}

	public void setPw(String pw) {
		this.pw.set(pw);
	}
	public StringProperty getPwProperty() {
		return pw;
	}
	
	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public StringProperty getPhoneProperty() {
		return phone;
	}
}
