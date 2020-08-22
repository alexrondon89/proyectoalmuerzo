package PeopleBase;

import java.util.HashMap;

public class PeopleFactory {

    public PeopleInterface generateObject(String type, HashMap<String, String> input){

        //Generate customer object
        if (type.equals("1")){
            return Customer.generateModel(input);

        }else if (type.equals("2")){
            return Employee.generateModel(input);

        }else{
            return null;
        }
    }
}
