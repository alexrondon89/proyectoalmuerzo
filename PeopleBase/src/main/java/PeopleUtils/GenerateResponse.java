package PeopleUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class GenerateResponse {

    public static String generateJsonStringResponse(HashMap<String, String> input) {
        try {
            return new ObjectMapper().writeValueAsString(input);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;

        }
    }

    public static Object generateJsonObjectResponse(String input) {
        try {
            return new ObjectMapper().readValue(input, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
