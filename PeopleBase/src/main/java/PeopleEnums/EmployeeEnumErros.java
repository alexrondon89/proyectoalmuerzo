package PeopleEnums;

import java.util.HashMap;

public enum EmployeeEnumErros {

    INTERNAL_SERVER_ERROR("Internal Server Error", "999", "500"),
    EMPLOYEE_NOT_FOUND("Empleado no existe", "2001", "400"),
    PAYLOAD_ERROR("Hubo un error en el payload enviado", "2002","400"),
    DUPLICATED_EMPLOYEE("Email ya registrado", "2003", "400");

    private String message;
    private String code;
    private String httpStatus;
    private HashMap<String, String> mapError;

    private EmployeeEnumErros(String message, String code, String httpStatus){
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.mapError = new HashMap<>();
    }

    public HashMap<String, String> getMapError() {
        mapError.put("message", message);
        mapError.put("code", code);
        mapError.put("httpStatus", httpStatus);

        return mapError;
    }
}
