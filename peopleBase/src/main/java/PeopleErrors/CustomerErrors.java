package PeopleErrors;

import PeopleEnums.CustomerEnumErrors;
import PeopleUtils.GenerateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CustomerErrors {

    public static String internalServerError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(CustomerEnumErrors.INTERNAL_SERVER_ERROR.getMapError());
    }

    public static String customerNotFound() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(CustomerEnumErrors.CUSTOMER_NOT_FOUND.getMapError());
    }

    public static String payloadError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(CustomerEnumErrors.PAYLOAD_ERROR.getMapError());
    }

    public static String duplicatedCustomerError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(CustomerEnumErrors.DUPLICATED_CUSTOMER.getMapError());
    }

}
