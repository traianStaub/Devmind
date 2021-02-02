package guest;

public class Guest {
	
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	//constructor
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	//setters
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//getters
	public String getLastName() {
		return lastName;
	}
		
	public String getFirstName() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//equals
	public boolean equalsName(Object obj) {
		
		if(!basicEquals(obj))
			return false;
		
		Guest compObj = (Guest)obj;
		
		if(!nameFieldComp(this.firstName, compObj.getFirstName()))
			return false;
		
		if(!nameFieldComp(this.lastName, compObj.getLastName()))
			return false;
		
		return true;
	}
	
	public boolean equalsEmail(Object obj) {
		if(!basicEquals(obj))
			return false;
		
		Guest compObj = (Guest)obj;
		
		if(!fieldComp(this.email, compObj.getEmail()))
			return false;
		
		return true;
	}
	
	public boolean equalsPhone(Object obj) {
		if(!basicEquals(obj))
			return false;
		
		Guest compObj = (Guest)obj;
		
		if(!fieldComp(this.phoneNumber, compObj.getPhoneNumber()))
			return false;
		
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!basicEquals(obj))
			return false;
		
		Guest compObj = (Guest)obj;
		
		if(!nameFieldComp(this.firstName, compObj.getFirstName()))
			return false;
		
		if(!nameFieldComp(this.lastName, compObj.getLastName()))
			return false;
		
		if(!fieldComp(this.email, compObj.getEmail()))
			return false;
		
		if(!fieldComp(this.phoneNumber, compObj.getPhoneNumber()))
			return false;
		
		return true;
		
	}
	
		
	//private methods
	private boolean basicEquals(Object obj) {
		
		if(obj == this)
			return true;
		
		if(obj == null)
			return false;
		
		if(obj.getClass() != this.getClass())
			return false;
		
		return true;
	}
	
	private boolean fieldComp(String guest, String compObj) {
		
		if(guest == null) {
			if(compObj != null)
				return false;
			
		} else if(!guest.equals(compObj.trim()))
			return false;
		
		return true;
	}
	
	private boolean nameFieldComp(String guest, String compObj) {
		
		if(guest == null) {
			if(compObj != null)
				return false;
			
		} else if(!guest.equalsIgnoreCase(compObj.trim()))
			return false;
		
		return true;
	}
	
	//to string
	@Override
	public String toString() {
		return "Nume: " + this.lastName + " " + this.firstName + ", Email: " + this.email 
				+ ", Telefon: " + this.phoneNumber;
	}
	
	//for testing
	public String nameString() {
		return this.lastName;
	}
	
	
	
}
