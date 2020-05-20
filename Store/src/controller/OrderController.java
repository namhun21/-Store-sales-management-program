package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.MenuDAO;
import model.OrderDAO;
import model.TableRowDataModel;

public class OrderController implements Initializable{
	private Main main;
	private String user_id;
	@FXML
	private ImageView img_01, img_02, img_03, img_04, img_05, img_06, img_07, img_08, img_09;
	@FXML
	private Button coffeeImg, latteImg, fruitImg, inputItemsButton;
	@FXML
	private Button btn_01, btn_02, btn_03, btn_04, btn_05, btn_06, btn_07, btn_08, btn_09;
	@FXML
	private Label priceLabel_01, nameLabel_01, priceLabel_02, nameLabel_02, priceLabel_03, nameLabel_03, priceLabel_04,
			nameLabel_04, priceLabel_05, nameLabel_05, priceLabel_06, nameLabel_06, priceLabel_07, nameLabel_07,
			priceLabel_08, nameLabel_08, priceLabel_09, nameLabel_09, welcomeLabel;
	@FXML
	private TableView<TableRowDataModel> orderListTable;
	@FXML
	private TableColumn<TableRowDataModel, String> Mname;
	@FXML
	private TableColumn<TableRowDataModel, Integer> Mprice;
	@FXML
	private TableColumn<TableRowDataModel, Integer> Mcount;

	
	ArrayList<ImageView> imgViewlist = new ArrayList<ImageView>();
	ArrayList<Label> nameLabellist = new ArrayList<Label>();
	ObservableList<TableRowDataModel> itemList = FXCollections.observableArrayList();
	private Window primaryStage;

	public void setMain(Main main) {
		this.main = main;
	}
	// Event Listener on Button[#coffeeImg].onAction
	@FXML
	public void changeCategory(ActionEvent event) {
		if (event.getSource().equals(coffeeImg)) {
			String menuSeq = "���������� �Ƹ޸�ī�� ī��� ī���ī īǪġ�� ī��Ḷ���ƶ� ȭ��Ʈī���ī �ٴҶ�� ����ī��";
			StringTokenizer st = new StringTokenizer(menuSeq);
			changeMenu(st);
		} else if (event.getSource().equals(latteImg)) {
			String menuSeq = "��������� �������� ����� ������ ������ ȭ��Ʈ���ڶ� �ٳ����� ���۹�Ʈ ���߻���";
			StringTokenizer st = new StringTokenizer(menuSeq);
			changeMenu(st);
		} else if (event.getSource().equals(fruitImg)) {
			String menuSeq = "ü�����̵� �����̵� ���ڿ��̵� �ڸ����̵� �����ƾ��̽�Ƽ ���⽺���� Ű���ֽ� �����ֽ� �����ֽ�";
			StringTokenizer st = new StringTokenizer(menuSeq);
			changeMenu(st);
		}
	}

	@FXML
	public void inputItems(ActionEvent event) throws IOException {
		MenuDAO menuDAO = new MenuDAO();
		menuDAO.inputOrder(orderListTable, user_id);
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.setOrderList();
		
		// �˾� ó��
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/OrderCompletePopupController.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage dialogStage = new Stage();
		dialogStage.setTitle("�ֹ��Ϸ�");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);

		OrderCompletePopupController controller = loader.getController();
		controller.setDialogStage(dialogStage);
		dialogStage.showAndWait();
		orderListTable.getItems().clear();
	}

	@FXML
	public void inputItem(ActionEvent event) {
		// todo �̹� ��� ��ǰ Ŭ���� ó��
		if (event.getSource().equals(btn_01)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_01.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_01.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_02)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_02.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_02.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_03)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_03.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_03.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_04)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_04.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_04.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_04)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_04.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_04.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_05)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_05.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_05.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_06)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_06.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_06.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_07)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_07.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_07.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_08)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_08.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_08.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
		} else if (event.getSource().equals(btn_09)) {
			itemList.add(new TableRowDataModel(new SimpleStringProperty(nameLabel_09.getText()),
					new SimpleIntegerProperty(Integer.parseInt(priceLabel_09.getText())),
					new SimpleIntegerProperty(1)));
			inputItemToTable(itemList);
			
		}
	}

	public void changeMenu(StringTokenizer st) {
		int i = 0;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			String path = String.format("C:\\Users\\Lenovo\\Desktop\\javafxproject\\Store\\src\\image\\%s.jpg", s);
			File file = new File(path);
			nameLabellist.get(i).setText(s);
			imgViewlist.get(i++).setImage(new Image(file.toURI().toString()));
		}
	}

	public void inputItemToTable(ObservableList<TableRowDataModel> itemList) {
		Mname.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		Mcount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
		Mprice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		orderListTable.setItems(itemList);
	}

	@FXML
	public void finish(ActionEvent event) {
		int selectedIndex = orderListTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			orderListTable.getItems().remove(selectedIndex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imgViewlist.add(img_01);
		imgViewlist.add(img_02);
		imgViewlist.add(img_03);
		imgViewlist.add(img_04);
		imgViewlist.add(img_05);
		imgViewlist.add(img_06);
		imgViewlist.add(img_07);
		imgViewlist.add(img_08);
		imgViewlist.add(img_09);

		nameLabellist.add(nameLabel_01);
		nameLabellist.add(nameLabel_02);
		nameLabellist.add(nameLabel_03);
		nameLabellist.add(nameLabel_04);
		nameLabellist.add(nameLabel_05);
		nameLabellist.add(nameLabel_06);
		nameLabellist.add(nameLabel_07);
		nameLabellist.add(nameLabel_08);
		nameLabellist.add(nameLabel_09);

		//welcomeLabel.setText(String.format("%s�� ȯ���մϴ�", user_id));
	}

//	public OrderController(String user_id) {
//		this.user_id = user_id;
//	}
	public void setUserID(String user_id) {
		this.user_id = user_id;
	welcomeLabel.setText(String.format("%s�� ȯ���մϴ�", user_id));
	}
	
}
