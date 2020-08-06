package web.almuerzos.ClientsApi;

public enum ClientsAction {

		CREATE("CREATE"),
		SIGNIN("SIGNIN"),
		EDITINFO("EDITINFO"),
		DELETE("DELETE");
		
	private String action;
	
	private ClientsAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}
	
	
}
