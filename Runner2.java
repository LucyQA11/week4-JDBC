package sqlConnect.qa.com;

public class Runner2 {
	
	public static void main(String[] args) {
		
	

	Random db = new Random();
	db.DB();
	db.viewDB("Customers");
	db.create("Customers", 6, "Jan Blob", "34 Rome Ln", 23);
	db.update("Customers",4, "34 Sandy Ln");
	db.deleteCustomer("Customers", 5);
	
	

	
	
	
	
	
	
	
	
	
	}	
}
