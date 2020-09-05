package PeopleBase;

import java.util.HashMap;

public class PeopleFactory {

    public static PeopleInterface generateObject(String type, HashMap<String, String> input){

        //Generate customer object
        if (type.equals("1")){
            return Customer.generateModel(input);

        }else{
            return Employee.generateModel(input);

        }
    }
}
