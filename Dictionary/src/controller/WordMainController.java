package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Word;

public class WordMainController {
	@FXML
	private TableView<Word> wordTable;
	@FXML
	private TableColumn<Word, String> korean;
	@FXML
	private TableColumn<Word, String> english;
	
	private Main main;
	
	@FXML
	private void initialize() {
		korean.setCellValueFactory(cellData-> cellData.getValue().getKoreanProperty());
		english.setCellValueFactory(cellData -> cellData.getValue().getEnglishProperty());
	}
	public void setMain(Main main) {
		this.main = main;
		wordTable.setItems(main.getWordList());
	}
	public WordMainController() {
		
	}
	@FXML
	private void addAction() {
		
	}
	@FXML
	private void editAction() {
		
	}
	@FXML
	private void deleteAction() {
		
	}
}
