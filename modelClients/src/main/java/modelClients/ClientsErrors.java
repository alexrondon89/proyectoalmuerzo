package modelClients;

public class ClientsErrors {

    public static String internalServerError(){
        return ClientsUtils.generateJsonStringResponse(ClientsEnumsErrors.INTERNAL_SERVER_ERROR.getMapError());
    }

    public static String clientNotFound(){
        return ClientsUtils.generateJsonStringResponse(ClientsEnumsErrors.CLIENT_NOT_FOUND.getMapError());
    }

    public static String payloadError(){
        return ClientsUtils.generateJsonStringResponse(ClientsEnumsErrors.PAYLOAD_ERROR.getMapError());
    }

    public static String duplicatedUserError(){
        return ClientsUtils.generateJsonStringResponse(ClientsEnumsErrors.DUPLICATED_USER.getMapError());
    }

}
