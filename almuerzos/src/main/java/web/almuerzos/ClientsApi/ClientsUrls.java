package web.almuerzos.ClientsApi;

public enum ClientsUrls {
		
	SIGNUP("https://by6cs1ocj4.execute-api.us-east-1.amazonaws.com/develop/signup"),
	SIGNIN("https://by6cs1ocj4.execute-api.us-east-1.amazonaws.com/develop/signin"),
	EDITINFO("https://by6cs1ocj4.execute-api.us-east-1.amazonaws.com/develop/clientinfo"),
	DELETE("https://by6cs1ocj4.execute-api.us-east-1.amazonaws.com/develop/delete-account");
	
	private String url;

	private ClientsUrls(String url) {
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}

}
