package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CumaDTO {
	private final SimpleStringProperty uname; // ¸Þ´º¶û ³¯Â¥ °¢°¢ ÀúÀå
    private final SimpleStringProperty uid; // ÃÑ ¾×¼ö
    private final SimpleStringProperty sumpri; // ÃÑ ¾×¼ö
    
    public CumaDTO(String uname, String uid, String sumpri) {
    	this.uname = new SimpleStringProperty (uname);
        this.uid = new SimpleStringProperty (uid);
        this.sumpri = new SimpleStringProperty (sumpri);
    }
   

   public StringProperty getuname() {
      return uname;
   }
   public StringProperty getuid() {
	      return uid;
	   }
   public StringProperty getSum() {
      return sumpri;
   }

   public void setuname(String uname) {
      this.uname.set(uname);
   }
   public void setuid(String uid) {
	      this.uid.set(uid);
	   }
   public String getid() {
	      return uid.get();
	   }
   public void setsum(String sum) {
      this.sumpri.set(sum);
   }
}
