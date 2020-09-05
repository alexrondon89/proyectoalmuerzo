package PeopleBase;

import PeopleUtils.EncrytionAndDecrytionPassword;
import PeopleUtils.GenerateDates;

import java.util.HashMap;

public class Customer implements PeopleInterface{

    private String email;
    private String fullName;
    private String password;
    private String phone;
    private String createdDate;
    private String updatedDate;

    private Customer(HashMap<String, String> input) {
        this.email = input.get("email");
        this.fullName = input.get("fullName");
        this.password = EncrytionAndDecrytionPassword.encrypt(input.get("password"));
        this.phone = input.get("phone");
        this.createdDate = input.get("createdDate");
        this.updatedDate = input.get("updatedDate");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "{\"fullName\": \"" + fullName + "\", " +
                "\"email\": \"" + email + "\", " +
                "\"phone\": \"" + phone + "\", " +
                "\"createdDate\": \"" + createdDate + "\", " +
                "\"updatedDate\": \"" + updatedDate + "\"}";
    }

    public static Customer generateModel(HashMap<String, String> input){

        return new Customer(input);
    }
}
