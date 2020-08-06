package modelLunch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LunchUtils {

	private final static String keyEncryption = "encryptionAndDecriptionKey";

	public static ObjectMapper generateJsonObject(){
		return  new ObjectMapper();
	}

	public static String generateJsonStringResponse(HashMap<String, Object> mapObject){
		try{
			return LunchUtils.generateJsonObject().writeValueAsString(mapObject);

		}catch (JsonProcessingException e){
			System.out.println("Error creating jsonString");
			e.printStackTrace();
			return null;
		}
	}

	public static LunchModel generateJsonObjectResponse(String jsonString) {
		try {
			System.out.println(jsonString);
			return LunchUtils.generateJsonObject().readValue(jsonString, LunchModel.class);

		} catch (IOException e) {
			System.out.println("Error creating jsonObject");
			e.printStackTrace();
			return null;
		}
	}

	public static String getCurrentDate() {
		Instant instant = Instant.now();
		ZoneId zoneId = ZoneId.of( "America/Buenos_Aires" );
		ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String currentDate = zdt.format(formatter);

		System.out.println("Geting current date: " + currentDate);

		return currentDate;
	}

	public static String passwordEncryption(String password){
		return EncryptionAndDecryption.encrypt(password);
	}

	public static String passwordDecryption(String password){
		return EncryptionAndDecryption.decrypt(password);
	}

	public static Boolean checkHashMapKeys(HashMap<String, String> input, HashSet validation){
		Set<String> keys = input.keySet();
		System.out.println("set input keys " + keys);
		System.out.println("set validation keys " + validation);
		return keys.contains("email");
	}
}
