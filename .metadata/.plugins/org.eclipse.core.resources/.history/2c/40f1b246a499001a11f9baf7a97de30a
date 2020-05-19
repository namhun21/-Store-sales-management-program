package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Order;
import model.OrderDAO;
import model.OrderList;

public class AdminController implements Initializable{
	
	public AdminController(){}
	
	@FXML
	private TableView<OrderList> orderList2;
	@FXML
	private TableColumn<OrderList, String> orderID;
	@FXML
	private TableColumn<OrderList, String> userID;
	@FXML
	private TableColumn<OrderList, String> menuName;
	@FXML
	private TableColumn<OrderList, String> price;
	@FXML
	private TableColumn<OrderList, String> count;
	
	
	private Main main;
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void manageAction() {
		
	}
	@FXML
	private void salesAction() {
		
	}
	@FXML
	private void completeAction() {
		 int selectedIndex = orderList2.getSelectionModel().getSelectedIndex();
	     if(selectedIndex >= 0) {
	    	 orderList2.getItems().remove(selectedIndex);
	    	 System.out.println(main.getOrderList().size());
	     }
	         
	}
	@FXML
	private void sendAction() {
		
	}
	@FXML
	private void lookUpAction() {
		System.out.println(main.getOrderList().size());
		orderList2.setItems(main.getOrderList());
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		OrderDAO orderDAO = new OrderDAO();
		ObservableList<OrderList> tmpList = orderDAO.getOrderList();
		for(int i = 0; i< tmpList.size();i++) {
			main.orderList.add(tmpList.get(i));
			System.out.println(main.orderList.get(i).getMenuName());
		}
		
		this.orderID.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		this.userID.setCellValueFactory(cellData -> cellData.getValue().getUserIDProperty());
		this.menuName.setCellValueFactory(cellData -> cellData.getValue().getMenuNameProperty());
		this.count.setCellValueFactory(cellData -> cellData.getValue().getCountProperty());
		this.price.setCellValueFactory(cellData-> cellData.getValue().getPriceProperty());
		//
	}
}
