package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Customer;
import model.Word;

public class Main extends Application{
	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane rootLayout2;
	private ObservableList<Word> wordList = FXCollections.observableArrayList();
	private static ObservableList<Customer> customerList = FXCollections.observableArrayList();
	
	public Main() {

	}
	public ObservableList<Word> getWordList() {
		return wordList;
	}
	public ObservableList<Customer> getCustomerList() {
		return customerList;
	}
	@Override 
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Test");
		//setRootLayout2();
		setMainFrameView();
	}

	public void setWordMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/WordMainView.fxml"));
			AnchorPane wordMainView = (AnchorPane) loader.load();
			rootLayout.setCenter(wordMainView);
			
			WordMainController controller = loader.getController();
			controller.setMain(this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public int setCustomerDataview(Customer customer) {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("../view/CustomerDataView.fxml"));
//		AnchorPane CustomerDatadMainView = (AnchorPane) loader.load();
//	}
	public void setMainFrameView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/MainFrame.fxml"));
			AnchorPane MainFrameView = (AnchorPane) loader.load();
			 
			Scene scene = new Scene(MainFrameView);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			//CustomerDataController controller = loader.getController();
			//controller.setMain(this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setRootLayout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
public void setRootLayout2() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/RootLayout2.fxml"));
			rootLayout2 = (AnchorPane) loader.load();
			
			Scene scene = new Scene(rootLayout2);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}
