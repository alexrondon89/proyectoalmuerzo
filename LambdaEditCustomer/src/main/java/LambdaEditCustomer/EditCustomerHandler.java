package LambdaEditCustomer;

import PeopleBase.PeopleFactory;
import PeopleBase.PeopleInterface;
import PeopleCrud.CustomerCrud;
import PeopleErrors.CustomerErrors;
import PeopleUtils.CustomerArgumentsValidation;
import PeopleUtils.GenerateResponse;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;

public class EditCustomerHandler implements RequestHandler<HashMap<String, String>, Object> {

    @Override
    public Object handleRequest(HashMap<String, String> input, Context context) {

        try {
            System.out.println("Request received to signup  customer");
            System.out.println(input.toString());

            PeopleInterface customer = PeopleFactory.generateObject("1", input);
            CustomerCrud customerCrud = new CustomerCrud();

            //CustomerArgumentsValidation.signInArgumentsValidation(input);
            customerCrud.editCustomer(customer);

            return GenerateResponse.generateJsonObjectResponse(customer.toString());

        } catch (DynamoDBMappingException e){
            e.printStackTrace();
            throw new RuntimeException(CustomerErrors.payloadError());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException(CustomerErrors.customerNotFound());

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(CustomerErrors.internalServerError());
        }
    }
}
