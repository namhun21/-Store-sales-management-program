package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SDTO {

    private final SimpleStringProperty list; // 메뉴랑 날짜 각각 저장
    private final SimpleStringProperty sum; // 총 액수
    
    public SDTO(String list, String sum) {

        this.list = new SimpleStringProperty (list);
        this.sum = new SimpleStringProperty (sum);
    }
    
    public SDTO(String list) {

      this.list = new SimpleStringProperty (list);
      this.sum = new SimpleStringProperty ();
  }

   public StringProperty getlist() {
      return list;
   }
   public StringProperty getSum() {
      return sum;
   }

   public void setlist(String list) {
      this.list.set(list);
   }
   public void setsum(String sum) {
      this.sum.set(sum);
   }
}