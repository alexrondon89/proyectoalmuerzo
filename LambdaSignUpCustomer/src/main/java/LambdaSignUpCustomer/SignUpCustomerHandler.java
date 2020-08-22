package LambdaSignUpCustomer;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import modelClients.ClientsCrud;
import modelClients.ClientsErrors;

public class SignUpClientsHandler implements RequestHandler<HashMap<String, String>, Object> {

    @Override
    public Object handleRequest(HashMap<String, String> input, Context context) {

        try {
            System.out.println("request received to signup  client");
            System.out.println(input.toString());

            return new ClientsCrud().saveClient(input);

        } catch (DynamoDBMappingException e) {
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.payloadError());

        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.duplicatedUserError());

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.internalServerError());
        }
    }

}
