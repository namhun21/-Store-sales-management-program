package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.OrderHistoryDAO;
import model.OrderHistoryDTO;

public class OrderHistoryController implements Initializable{
	private String user_id;
	public OrderHistoryController() {}
	
	@FXML
	private TableView<OrderHistoryDTO> orderHistory;
	@FXML
	private TableColumn<OrderHistoryDTO, String> userID;
	@FXML
	private TableColumn<OrderHistoryDTO, String> date;
	@FXML
	private TableColumn<OrderHistoryDTO, String> menuName;
	@FXML
	private TableColumn<OrderHistoryDTO, String> price;
	@FXML
	private TableColumn<OrderHistoryDTO, String> count;
	@FXML
	private Label totalPriceLabel;
	private Main main;
	private ObservableList<OrderHistoryDTO> ohList;
	private Stage dialogStage;
	OrderHistoryDAO ohDAO = new OrderHistoryDAO();
	
	public void initialize(URL location, ResourceBundle resources) {
		
//			customer_view();

		ohList = FXCollections.observableArrayList();
		this.userID.setCellValueFactory(cellData -> cellData.getValue().getUserIDProperty());
		this.date.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
		this.menuName.setCellValueFactory(cellData -> cellData.getValue().getMenuNameProperty());
		this.count.setCellValueFactory(cellData -> cellData.getValue().getCountProperty());
		this.price.setCellValueFactory(cellData-> cellData.getValue().getPriceProperty());
		
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	public void setUserID(String id) {
		this.user_id = id;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void orderHistoryView() {
		try {
			Main.historyList.clear();
			ObservableList<OrderHistoryDTO> tmpList = ohDAO.setHistoryList(this.user_id);
			String ans = ohDAO.setTotalOrderPrice(this.user_id);
			for(int i = 0; i<tmpList.size(); i++) {
				Main.historyList.add(tmpList.get(i));
			}
			orderHistory.getItems().clear();
			totalPriceLabel.setText(String.valueOf(ans));
			orderHistory.setItems(main.gethistoryList());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
