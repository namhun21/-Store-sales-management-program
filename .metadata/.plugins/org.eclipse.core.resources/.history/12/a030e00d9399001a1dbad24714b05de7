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
				alert.setTitle("로그인 성공");
				alert.setHeaderText("어서오세요. 카페입니다.");
				alert.setContentText(id+"님 환영합니다.");
				alert.showAndWait();
				this.main.setOrderView(customer);
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(this.main.getPrimaryStage());
				alert.setTitle("로그인 실패");
				alert.setHeaderText("아이디나 비밀번호가 일치하지 않습니다.");
				alert.setContentText("아이디와 비밀번호를 다시 입력해 주세요.");
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
			errorMessage += "id를 입력하세요 \n";
		
		if(pwField.getText() == null || pwField.getText().equals(""))
			errorMessage += "pw를 입력하세요 \n";
		
		if(errorMessage.equals(""))
			return true;
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("오류 메세지");
			alert.setHeaderText("값을 제대로 입력해 주세요");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}
	
	}
}
