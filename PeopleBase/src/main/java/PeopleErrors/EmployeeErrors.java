package PeopleErrors;

import PeopleEnums.EmployeeEnumErros;
import PeopleUtils.GenerateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class EmployeeErrors {

    public static String internalServerError() {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.INTERNAL_SERVER_ERROR.getMapError());
    }

    public static String employeeNotFound() {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.EMPLOYEE_NOT_FOUND.getMapError());
    }

    public static String payloadError() {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.PAYLOAD_ERROR.getMapError());
    }

    public static String duplicatedEmployeeError() {
        return GenerateResponse.generateJsonStringResponse(EmployeeEnumErros.DUPLICATED_EMPLOYEE.getMapError());
    }

}
