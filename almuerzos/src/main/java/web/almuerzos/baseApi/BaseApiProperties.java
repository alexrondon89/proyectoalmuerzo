package web.almuerzos.baseApi;

import java.time.Duration;

public class BaseApiProperties {

	private static Duration readTimeout =  Duration.ofSeconds(20);
	private static Duration connectTimeout  = Duration.ofSeconds(20);

	public static Duration getReadTimeout() {
		return readTimeout;
	}

	public static Duration getConnectTimeout() {
		return connectTimeout;
	}
	
}
