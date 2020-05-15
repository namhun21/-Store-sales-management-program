package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Customer;

public class OrderController {
	private Button loginButton;
	@FXML
	private TextField nameField;
	@FXML 
	private TextField idField;
	@FXML
	private TextField pwField;
	@FXML
	private TextField phoneField;
	
	private Stage OrderStage;
	private Customer customer;
	private int returnValue = 0;
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	private void initialize() {
		
	}
	
}
