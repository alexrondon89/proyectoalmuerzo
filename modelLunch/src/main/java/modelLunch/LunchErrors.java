package modelLunch;

public class LunchErrors {

    public static String internalServerError(){
        return LunchUtils.generateJsonStringResponse(LunchEnumsErrors.INTERNAL_SERVER_ERROR.getMapError());
    }

    public static String clientNotFound(){
        return LunchUtils.generateJsonStringResponse(LunchEnumsErrors.CLIENT_NOT_FOUND.getMapError());
    }

    public static String payloadError(){
        return LunchUtils.generateJsonStringResponse(LunchEnumsErrors.PAYLOAD_ERROR.getMapError());
    }

    public static String duplicatedUserError(){
        return LunchUtils.generateJsonStringResponse(LunchEnumsErrors.DUPLICATED_USER.getMapError());
    }

}
