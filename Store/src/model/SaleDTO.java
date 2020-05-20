package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SaleDTO {
	private final SimpleStringProperty name;
    private final SimpleStringProperty list;
    private final SimpleStringProperty sum;
    
    public SaleDTO(String list, String sum) {
        this.name = new SimpleStringProperty();
        this.list = new SimpleStringProperty (list);
        this.sum = new SimpleStringProperty (sum);
    }
    
    public SaleDTO(String name,String list, String sum) {
        this.name = new SimpleStringProperty(name);
        this.list = new SimpleStringProperty ();
        this.sum = new SimpleStringProperty (sum);
    }
    
    public SaleDTO(String list) {
      this.name = new SimpleStringProperty();
      this.list = new SimpleStringProperty (list);
      this.sum = new SimpleStringProperty ();
  }
    
    public StringProperty getname() {
		return name;
	}
	public StringProperty getlist() {
		return list;
	}
	public StringProperty getSum() {
		return sum;
	}
	
	public void setname(String name) {
		this.name.set(name);
	}
	public void setlist(String list) {
		this.list.set(list);
	}
	public void setsum(String sum) {
		this.sum.set(sum);
	}
}
