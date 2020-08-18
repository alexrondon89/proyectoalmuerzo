package PeopleBase;

import java.util.HashMap;

public class Employee implements PeopleInterface {

    private String fullName;

    private Employee(HashMap<String, String> input){
        this.fullName = input.get("fullName");
    }

    @Override
    public String toString(){
        return null;
    }

    public static Employee generateModel(HashMap<String, String> input){

        return new Employee(input);
    }
}
