package PeopleUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class GenerateResponse {

    public static String generateJsonStringResponse(HashMap<String, String> input) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(input);
    }

    public static Object generateJsonObjectResponse(String input) throws JsonProcessingException {
        return new ObjectMapper().readValue(input, Object.class);
    }
}
