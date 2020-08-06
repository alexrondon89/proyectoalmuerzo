package modelClients;

import java.util.ArrayList;
import java.util.HashSet;

public class ClientsConstantsValidation {

    public static HashSet signUpArguments(){
        ArrayList<String> signUpArguments = new ArrayList<>();
        signUpArguments.add("email");
        signUpArguments.add("fullName");
        signUpArguments.add("password");
        signUpArguments.add("phone");

        System.out.println("List or argument necessaries to sigUp a client: " + signUpArguments);
        return new HashSet<>(signUpArguments);
    }

    public static HashSet signInArguments(){
        ArrayList<String> signInArguments = new ArrayList<>();
        signInArguments.add("email");
        signInArguments.add("password");

        System.out.println("List or argument necessaries to sigIn a client: " + signInArguments);
        return new HashSet<>(signInArguments);
    }

    public static HashSet emailArgument(){
        ArrayList<String> emailArgument = new ArrayList<>();
        emailArgument.add("email");

        System.out.println("List or argument necessaries to edit a client: " + emailArgument);
        return new HashSet<>(emailArgument);
    }
}
