package ch.bbw.ecustomer;

public class Customer {
	
	public int id;
	public String firstname;
	public String lastname;
	public String email;
	public String message;
	
	public Customer() {
		
		firstname="";
		lastname="";
	}
	
	public Customer(String firstname, String lastname, String email, String message, int id){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.message = message;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
