package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderHistoryDTO {
	private final StringProperty userID;
	private final StringProperty date;
	private final StringProperty menuName;
	private final StringProperty price;
	private final StringProperty count;
	
	public OrderHistoryDTO(String userID,String date, String menuName,String price, String count) {
		this.userID = new SimpleStringProperty(userID);
		this.date = new SimpleStringProperty(date);
		this.menuName = new SimpleStringProperty(menuName);
		this.count = new SimpleStringProperty(count);
		this.price = new SimpleStringProperty(price);
	}
	
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	public StringProperty getDateProperty() {
		return date;
	}
	
	public String getUserID() {
		return userID.get();
	}
	public void setUserID(String userID) {
		this.userID.set(userID);
	}
	public StringProperty getUserIDProperty() {
		return userID;
	}
	
	public String getMenuName() {
		return menuName.get();
	}
	public void setMenuName(String menuName) {
		this.menuName.set(menuName);
	}
	public StringProperty getMenuNameProperty() {
		return menuName;
	}
	public String getCount() {
		return count.get();
	}
	public void setCount(String count) {
		this.count.set(count);
	}
	public StringProperty getCountProperty() {
		return count;
	}
	
	public String getPrice() {
		return price.get();
	}
	public void setPrice(String price) {
		this.count.set(price);
	}
	public StringProperty getPriceProperty() {
		return price;
	}
	
}
