package modelClients;

import java.util.HashMap;

public enum ClientsEnumsErrors {

    INTERNAL_SERVER_ERROR("Internal Server Error", "999", "500"),
    CLIENT_NOT_FOUND("Cliente no existe", "1001", "400"),
    PAYLOAD_ERROR("Hubo un error en el payload enviado", "1002","400"),
    DUPLICATED_USER("Email ya registrado", "1003", "400");

    private String message;
    private String code;
    private String httpStatus;
    private HashMap<String, Object> mapError;

    private ClientsEnumsErrors(String message, String code, String httpStatus){
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.mapError = new HashMap<>();
    }

    public HashMap<String, Object> getMapError() {
        mapError.put("message", message);
        mapError.put("code", code);
        mapError.put("httpStatus", httpStatus);

        return mapError;
    }
}
