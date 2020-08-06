package web.almuerzos.ClientsApi;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import web.almuerzos.baseApi.BaseApi;

@Component
public  final class ClientsApi {
	
	public BaseApi baseClient;
	
	public ClientsApi() {
		baseClient =  BaseApi.getIntance();
	}
	
	public  String signUp(String fullName, String email, String password,  String phone) {
			//hay que averiguar como crear la inyeccion de dependencia
			//HttpHeaders headers = new HttpHeaders();
			//JSONObject personJsonObject =  new JSONObject();
		    //headers.setContentType(MediaType.APPLICATION_JSON);
			//HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
	
			JSONObject newClient = baseClient.getJsonObject().put("fullName", fullName)
																									   .put("email", email)
																									   .put("password", password)
																									   .put("phone", phone)
																									   .put("action", Enum.valueOf(ClientsAction.class, "CREATE").getAction());
	
			return baseClient.getRest().postForObject(Enum.valueOf(ClientsUrls.class, "SIGNUP").getUrl(), 
																					 baseClient.getRequest(newClient, baseClient.getHeadersApplicationJson()), 
																					 String.class);
		}
	
	public String signIn(String email, String password) {
		JSONObject signIn = baseClient.getJsonObject().put("email", email)
																							.put("password", password)
																							.put("action", Enum.valueOf(ClientsAction.class, "SIGNIN").getAction());

		return baseClient.getRest().postForObject(Enum.valueOf(ClientsUrls.class, "SIGNIN").getUrl(),
																										  baseClient.getRequest(signIn, baseClient.getHeadersApplicationJson()),
																										  String.class);
	}
	
	public String clientInfoEdit(String fullName, String password,  String phone) {
		JSONObject clientInfoEdit = baseClient.getJsonObject().put("fullName", fullName)
																										.put("password", password)
																										.put("phone", phone)
																										.put("action", Enum.valueOf(ClientsAction.class, "EDITINFO").getAction());

		return baseClient.getRest().postForObject(Enum.valueOf(ClientsUrls.class, "EDITINFO").getUrl(),
																				  baseClient.getRequest(clientInfoEdit, baseClient.getHeadersApplicationJson()),
																				  String.class);	
	}

	public String deleteAccount(String email, String password) {
		JSONObject clientInfoEdit = baseClient.getJsonObject().put("email", email)
																										.put("password", password)
																										.put("action", Enum.valueOf(ClientsAction.class, "DELETE").getAction());

		return baseClient.getRest().postForObject(Enum.valueOf(ClientsUrls.class, "DELETE").getUrl(),
																				  baseClient.getRequest(clientInfoEdit, baseClient.getHeadersApplicationJson()),
																				  String.class);	
	}

}
