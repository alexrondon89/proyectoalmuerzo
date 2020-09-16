package LambdaCustomersList;

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

public class CustomersListHandler implements RequestHandler<HashMap<String, String>, Object> {

    @Override
    public Object handleRequest(HashMap<String, String> input, Context context) {

        try {
            CustomerCrud customerCrud = new CustomerCrud();

            return customerCrud.getCustomersList();

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
