package com.amazonaws.lambda.editclients;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import modelClients.ClientsCrud;
import modelClients.ClientsErrors;

import java.util.HashMap;
import java.util.Map;

public class EditClientsHandler implements RequestHandler<HashMap<String, String>, Object> {

    @Override
    public Object handleRequest(HashMap<String, String> input, Context context) {

        try {
            System.out.println("request received to edit client");
            System.out.println(input.toString());

            return new ClientsCrud().editClient(input);

        } catch (DynamoDBMappingException e) {
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.payloadError());
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.clientNotFound());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(ClientsErrors.internalServerError());
        }
    }
}