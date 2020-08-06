package web.almuerzos.model;

import java.util.Date;

public class Client extends  Person {

	private int orderAccumulator;
	private int clientId;
	
	public Client(  String firstName, String lastName, String email, Date  createdDate, Date updatedDate,  int orderAccumulator, int clientId) {
		
		super (firstName, lastName, email, createdDate, updatedDate);
		
		this.clientId = clientId;
		this.orderAccumulator = orderAccumulator;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getOrderAccumulator() {
		return orderAccumulator;
	}

	public void setOrderAccumulator(int orderAccumulator) {
		this.orderAccumulator = orderAccumulator;
	}

}
