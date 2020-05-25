package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CumaDTO;
import model.Customer;
import model.OrderDAO;
import model.OrderList;



public class Main extends Application{ // ��Ʈ�ѷ��� ���� ��ȯ�Ǵ� ȭ�� �ٷ�� ���� �Լ�
	private Stage primaryStage;
	private AnchorPane MainFrameView;
	public static ObservableList<OrderList> orderList = FXCollections.observableArrayList();
	public static ObservableList<CumaDTO> Cumalist = FXCollections.observableArrayList();
	public static String uid;
	public Main() {
		
		
	}
	
	public ObservableList<OrderList> getOrderList() {
		return orderList;
	}
	
	public ObservableList<CumaDTO> getcumaList() {
		return Cumalist;
	}
	@Override 
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cafe Sales Management System");
		setMainFrameView();
		//setAdminView();
	}
	public void setMainFrameView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/LoginView.fxml"));
			MainFrameView = (AnchorPane) loader.load();
			 
			Scene scene = new Scene(MainFrameView);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			LoginController controller = loader.getController();
			controller.setMain(this);
			uid = "";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setOrderView(String id) { //������� ��� �ֹ�ȭ�� ����������
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/OrderListPage.fxml"));
            Parent afterLogin = loader.load();
            Scene scene = new Scene(afterLogin);
            primaryStage.setScene(scene);
            primaryStage.show();
			primaryStage.setResizable(false);
			
			OrderController controller = loader.getController();
            controller.setMain(this);
            controller.setUserID(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void setAdminView() { //�������� ��� ������ ȭ�� ����������
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/AdminPage.fxml"));
			MainFrameView = (AnchorPane) loader.load();
			Scene scene = new Scene(MainFrameView);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
			AdminController controller = loader.getController();
			controller.setMain(this);
			controller.setOrderListView(controller);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setSellView() { //�����ڰ� ������� ��ư�� �������� �̵��Ǵ� ȭ��
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Sales.fxml"));
	        Parent Sellbutton = loader.load();
	        Scene scene = new Scene(Sellbutton);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			primaryStage.setResizable(false);
			
			SellController controller = loader.getController();
	        controller.setMain(this);
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setmanageView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Customer.fxml"));
	        Parent Managebutton = loader.load();
	        Scene scene = new Scene(Managebutton);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			primaryStage.setResizable(false);
			
			CustomerManageController controller = loader.getController();
	        controller.setMain(this);
	        controller.customer_view();
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setSignUpView(Customer customer) { //ȸ������ ��ư Ŭ���� �̵��Ǵ� ȭ��
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Signup.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("ȸ������");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			SignupController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			//controller.setCustomer(customer);
			
			dialogStage.showAndWait();
			//return controller.getReturnValue();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return 0;
	}


	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}