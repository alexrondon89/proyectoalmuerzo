package web.almuerzos.model;

import java.util.Date;

public class Administrator  extends Person {

	private int administratorId;
	
	public Administrator(String firstName, String lastName, String email, Date createdDate, Date updatedDate, int administratorId) {
		super (firstName, lastName, email, createdDate, updatedDate);
		
		this.administratorId = administratorId;
	}

	public int getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

}
