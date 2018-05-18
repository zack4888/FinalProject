package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.*;

public class Data {

	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	    private  SimpleStringProperty PRICE;
	    private  String Date;
	    private  String Company;
	 
	    public Data(String price, String date, String company) {
	        this.PRICE = new SimpleStringProperty(price);
	        this.Date = new String(date);
	        this.Company = new String(company);
	    }
	 
	    public String getPrice() {
	        return PRICE.get();
	    }
	    public StringProperty priceProp() {
	    	return PRICE;
	    }
	    public void setPrice(String P) {
	        PRICE.set(P);
	    }
	        
	    public String getDate() {
	        return Date;
	    }
	    public void setLastName(String D) {
	        Date = D;
	    }
	    
	    public String getCompany() {
	        return Company;
	    }
	    public void setCompany(String C) {
	        Company = C;
	    }
	        
	

}
