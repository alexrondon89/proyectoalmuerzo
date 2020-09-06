package LambdaRegisterLunch;

import OrdersBase.OrdersFactory;
import OrdersBase.OrdersInterface;
import OrdersCrud.LunchCrud;
import OrdersErrors.LunchErrors;
import OrdersUtils.GenerateResponse;
import OrdersUtils.LunchArgumentsValidation;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;

public class RegisterLunchHandler implements RequestHandler<HashMap<String, String>, Object> {

    @Override
    public Object handleRequest(HashMap<String, String> input, Context context) {

        try {
            System.out.println("Request received to register lunch");
            System.out.println(input.toString());

            OrdersInterface lunch = OrdersFactory.generateObject("1");
            LunchCrud lunchCrud = new LunchCrud();

            LunchArgumentsValidation.registerLunchArgumentsValidation(input);
            lunchCrud.saveLunch(lunch, input);

            return GenerateResponse.generateJsonObjectResponse(lunch.toString());

        } catch (DynamoDBMappingException e) {
            e.printStackTrace();
            throw new RuntimeException(LunchErrors.payloadError());

        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new RuntimeException(LunchErrors.duplicatedLunchError());

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(LunchErrors.internalServerError());
        }
    }

}
