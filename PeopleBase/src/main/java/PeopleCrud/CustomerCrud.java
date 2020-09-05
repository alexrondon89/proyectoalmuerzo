package PeopleCrud;

import PeopleBase.PeopleInterface;
import PeopleUtils.GenerateDates;
import ProjectBase.DynamoClientFactory;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.google.common.collect.Iterators;

import java.util.HashMap;
import java.util.Map;

public class CustomerCrud {

    private Table table;
    private Index index;

    public CustomerCrud() {
        DynamoDB dynamoDB = DynamoClientFactory.getConection();
        this.table = dynamoDB.getTable("Clients");
        this.index = table.getIndex("Email-Password-index");

    }

    public void saveCustomer(PeopleInterface customer) {
        Item resultExistCustomer= existCustomer(customer);

        if(resultExistCustomer != null){
            throw new IllegalArgumentException();
        }

        String currentDate = GenerateDates.getCurrentDate();
        customer.setCreatedDate(currentDate);
        customer.setUpdatedDate(currentDate);

        Item item = new Item().withPrimaryKey("Email", customer.getEmail())
                .withString("FullName", customer.getFullName())
                .withString("Phone", customer.getPhone())
                .withString("Password", customer.getPassword())
                .withString("CreatedDate", customer.getCreatedDate())
                .withString("UpdatedDate", customer.getUpdatedDate());

        table.putItem(item);
    }

    public Item existCustomer(PeopleInterface customer) throws IllegalArgumentException {

        Item item = table.getItem("Email", customer.getEmail(), "Email, FullName, Phone, CreatedDate, UpdatedDate", null);

        System.out.println("Printing customer after retrieving it....");
        System.out.println(item);

        return item;

    }

    public void getCustomerByIndex(PeopleInterface customer) throws RuntimeException {
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("#e = :email_value and #p = :password_value")
                .withNameMap(new NameMap()
                        .with("#e", "Email")
                        .with("#p", "Password"))
                .withValueMap(new ValueMap()
                        .withString(":email_value",customer.getEmail())
                        .withString(":password_value",customer.getPassword()));

        ItemCollection<QueryOutcome> items = index.query(spec);

        int size = Iterators.size(items.iterator());

        if(size==0){
            throw new IllegalArgumentException();
        }

        if(size>1){
            throw new RuntimeException();
        }

        Map item = items.iterator().next().asMap();

        System.out.println("Printing customer after retrieving it....");
        System.out.println(item);

        customer.setFullName(item.get("FullName").toString());
        customer.setPhone(item.get("Phone").toString());
        customer.setCreatedDate(item.get("CreatedDate").toString());
        customer.setUpdatedDate(item.get("UpdatedDate").toString());

    }

    public void deleteCustomer(PeopleInterface customer) throws RuntimeException{
        Item resultExistCustomer = existCustomer(customer);

        if(resultExistCustomer == null){
            throw new IllegalArgumentException();
        }

        System.out.println("Printing customer before delete it....");
        System.out.println(customer);

        DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("Email", customer.getEmail() );
        table.deleteItem(deleteItemSpec);

    }

    public void editCustomer(PeopleInterface customer) throws RuntimeException{
        Item resultExistCustomer = existCustomer(customer);

        if(resultExistCustomer == null){
            throw new IllegalArgumentException();
        }

        Map<String, Object> customerMap = resultExistCustomer.asMap();

        System.out.println("Printing customer before edit it....");
        System.out.println(customerMap);

        String password = String.valueOf(customer.getPassword()).equals("null") ? String.valueOf(customerMap.get("Password")) : customer.getPassword();
        String fullName = String.valueOf(customer.getFullName()).equals("null") ? String.valueOf(customerMap.get("FullName")) : customer.getFullName();
        String phone = (String.valueOf(customer.getPhone()).equals("null") ? String.valueOf(customerMap.get("Phone")) : customer.getPhone());
        String updatedDate = GenerateDates.getCurrentDate();
        String createdDate = String.valueOf(customerMap.get("CreatedDate"));

        customer.setPassword(password);
        customer.setFullName(fullName);
        customer.setPhone(phone);
        customer.setUpdatedDate(updatedDate);
        customer.setCreatedDate(createdDate);

        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("Email", customerMap.get("Email"))
                .withReturnValues(ReturnValue.ALL_NEW)
                .withUpdateExpression("set #p = :newPasswordValue, #fn = :newFullNameValue, #ph = :newPhoneValue, #ud = :newUpdatedDateValue")
                .withNameMap(new NameMap()
                        .with("#p", "Password")
                        .with("#fn", "FullName")
                        .with("#ph", "Phone")
                        .with("#ud", "UpdatedDate"))
                .withValueMap(new ValueMap()
                        .withString(":newPasswordValue", customer.getPassword())
                        .withString(":newFullNameValue", customer.getFullName())
                        .withString(":newPhoneValue", customer.getPhone())
                        .withString(":newUpdatedDateValue", customer.getUpdatedDate()));

        table.updateItem(updateItemSpec);
    }

}