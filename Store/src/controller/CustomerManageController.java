package controller;

import java.net.URL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.CumaDTO;
import model.CustoManageDAO;
import model.SDAO;
import model.SDTO;
import javafx.scene.control.TableColumn;

public class CustomerManageController implements Initializable {
	@FXML
	private TableView<CumaDTO> viewtable;
	@FXML
	private TableColumn<CumaDTO, String> Cname;
	@FXML
	private TableColumn<CumaDTO, String> CID;
	@FXML
	private TableColumn<CumaDTO, String> totalprice;
	private ObservableList<CumaDTO> CUMA;
	CustoManageDAO cDAO;
	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	public void initialize(URL location, ResourceBundle resources) {
		cDAO = new CustoManageDAO();
//			customer_view();

		CUMA = FXCollections.observableArrayList();
		Cname.setCellValueFactory(cellData -> cellData.getValue().getuname());
		CID.setCellValueFactory(cellData -> cellData.getValue().getuid());
		totalprice.setCellValueFactory(cellData -> cellData.getValue().getSum());
	}

	public void customer_view() {
		try {
			ObservableList<CumaDTO> tmpList = cDAO.Cus_value();
			for (int i = 0; i < tmpList.size(); i++) {
				Main.Cumalist.add(tmpList.get(i));
//				System.out.println(Main.Cumalist.get(i).getName());
			}

			viewtable.setItems(main.getcumaList());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data를 테이블에 가져올 수 없습니다.");
		}
	}

	@FXML
	private void cancleAction(ActionEvent event) {
		int selectedIndex = viewtable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			viewtable.getItems().remove(selectedIndex);
		}
	}

	@FXML
	public void back(ActionEvent event) throws Exception {
//	      Parent Mains = FXMLLoader.load(getClass().getResource("../view/AdminPage.fxml"));
//	      Scene scene3 = new Scene(Mains);
//	      Stage primaryStage = (Stage) back.getScene().getWindow();
//	      primaryStage.setTitle("연습");
//	      primaryStage.setScene(scene3);

		this.main.orderList.clear();
		this.main.Cumalist.clear();
		this.main.setAdminView();
	}

}
