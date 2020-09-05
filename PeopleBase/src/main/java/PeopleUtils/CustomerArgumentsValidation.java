package PeopleUtils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CustomerArgumentsValidation {

    public static void signUpArgumentsValidation(HashMap<String, String> input) throws DynamoDBMappingException {

        System.out.println("Checking whether sign up arguments are ok ");

        Set<String> signUpArgumentsSet = new HashSet<>();
        signUpArgumentsSet.add("email");
        signUpArgumentsSet.add("fullName");
        signUpArgumentsSet.add("password");
        signUpArgumentsSet.add("phone");

        Set<String> keys = input.keySet();

        System.out.println("mandatory arguments: "+ signUpArgumentsSet);
        System.out.println("arguments submitted: "+ keys);

        if (!signUpArgumentsSet.equals(keys)){
            throw new DynamoDBMappingException();
        }

    }

    public static void signInArgumentsValidation(HashMap<String, String> input){

        System.out.println("Checking whether sign in arguments are ok ");

        Set<String> signInArgumentsSet = new HashSet<>();
        signInArgumentsSet.add("email");
        signInArgumentsSet.add("password");

        Set<String> keys = input.keySet();

        System.out.println("mandatory arguments: "+ signInArgumentsSet);
        System.out.println("arguments submitted: "+ keys);

        if (!signInArgumentsSet.equals(keys)){
            throw new DynamoDBMappingException();
        }
    }

    public static void emailArgumentValidation(HashMap<String, String> input){
        System.out.println("Checking whether email argument is ok ");

        Set<String> argumentSet = new HashSet<>();
        argumentSet.add("email");

        Set<String> keys = input.keySet();

        System.out.println("mandatory arguments: "+ argumentSet);
        System.out.println("arguments submitted: "+ keys);

        if (!argumentSet.equals(keys)){
            throw new DynamoDBMappingException();
        }
    }
}
