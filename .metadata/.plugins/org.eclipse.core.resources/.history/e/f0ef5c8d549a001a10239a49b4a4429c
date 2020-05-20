package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
	private final StringProperty orderID;
	private final StringProperty userID;
	private final StringProperty menuID;
	private final StringProperty date;
	private final StringProperty count;
	private final StringProperty isComplete;
	
	public Order(String orderID,String userID, String menuID, String date, String count,String isComplete) {
		this.orderID = new SimpleStringProperty(orderID);
		this.userID = new SimpleStringProperty(userID);
		this.menuID = new SimpleStringProperty(menuID);
		this.date = new SimpleStringProperty(date);
		this.count = new SimpleStringProperty(count);
		this.isComplete = new SimpleStringProperty(isComplete);
	}
	
	public String getOrderID() {
		return orderID.get();
	}
	public void setOrderID(String orderID) {
		this.orderID.set(orderID);
	}
	public StringProperty getOrderIDProperty() {
		return orderID;
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
	
	public String getMenuID() {
		return menuID.get();
	}
	public void setMenuID(String menuID) {
		this.menuID.set(menuID);
	}
	public StringProperty getMenuIDProperty() {
		return menuID;
	}
	
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	public StringProperty getDateIDProperty() {
		return date;
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
	
	public String getIsComplete() {
		return isComplete.get();
	}
	public void setIsComplete(String isComplete) {
		this.isComplete.set(isComplete);
	}
	public StringProperty getIsCompleteProperty() {
		return isComplete;
	}
}
