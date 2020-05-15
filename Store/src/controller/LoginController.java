package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Customer;
import model.CustomerDAO;

public class LoginController {
	private Main main;
	private Button loginButton;
	@FXML 
	private TextField nameField;
	@FXML 
	private TextField idField;
	@FXML
	private TextField pwField;
	private Stage dialogStage;
	private Customer customer;
	private int returnValue = 0;
	
	
	public LoginController() {
		
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	@FXML
	private void loginAction() {
		if(valid()) {
			
			String id = idField.getText();
			String pw = pwField.getText();
			
			returnValue = 1;
			CustomerDAO customerDAO = new CustomerDAO();
			int result = customerDAO.confirmInfo(id, pw);
			if(result == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initOwner(this.main.getPrimaryStage());
				alert.setTitle("�α��� ����");
				alert.setHeaderText("�������. ī���Դϴ�.");
				alert.setContentText(id+"�� ȯ���մϴ�.");
				alert.showAndWait();
				this.main.setOrderView(customer);
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(this.main.getPrimaryStage());
				alert.setTitle("�α��� ����");
				alert.setHeaderText("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				alert.setContentText("���̵�� ��й�ȣ�� �ٽ� �Է��� �ּ���.");
				alert.showAndWait();
			}
		}
	}
	public void getIdPw(Customer customer) {
		idField.setText(customer.getID());
		pwField.setText(customer.getPw());
	}
	public int getReturnValue() {
		return returnValue;
	}
	@FXML
	private void signupAction() {
		Customer customer = new Customer("","","","");
		main.setSignUpView(customer);
	}
	
	private boolean valid() {
		String errorMessage = "";
		
		if(idField.getText() == null || idField.getText().equals(""))
			errorMessage += "id�� �Է��ϼ��� \n";
		
		if(pwField.getText() == null || pwField.getText().equals(""))
			errorMessage += "pw�� �Է��ϼ��� \n";
		
		if(errorMessage.equals(""))
			return true;
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("���� �޼���");
			alert.setHeaderText("���� ����� �Է��� �ּ���");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	
	}
}
