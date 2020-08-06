package web.almuerzos.baseApi;

import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestOperations;

public class BaseApi  extends BaseApiProperties{
	
	private final RestOperations rest;
	private final RestTemplateBuilder builder;
	private final HttpHeaders headers;

	private BaseApi() {
		builder = new RestTemplateBuilder();
		rest = builder.setReadTimeout(BaseApiProperties.getReadTimeout()).setConnectTimeout(BaseApiProperties.getConnectTimeout()).build();
		headers =  new HttpHeaders();
	}
	
	private static BaseApi createInstance() {
		return new BaseApi();
	}
	
	public static  BaseApi getIntance() {
		return BaseApi.createInstance();
	}
	
	public RestOperations getRest() {
		return rest;
	}
	
	public HttpHeaders getHeadersApplicationJson() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public  JSONObject getJsonObject() {
		return new JSONObject();
	}
	
	public HttpEntity<String> getRequest(JSONObject jsonObject, HttpHeaders headers){
		return new HttpEntity<String>(jsonObject.toString(), headers);
	}
	
}
