package PeopleErrors;

import PeopleEnums.EmployeeEnumErros;
import PeopleUtils.GenerateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class EmployeeErrors {

    public static String internalServerError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.INTERNAL_SERVER_ERROR.getMapError());
    }

    public static String employeeNotFound() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.EMPLOYEE_NOT_FOUND.getMapError());
    }

    public static String payloadError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.PAYLOAD_ERROR.getMapError());
    }

    public static String duplicatedEmployeeError() throws JsonProcessingException {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.DUPLICATED_EMPLOYEE.getMapError());
    }

}
