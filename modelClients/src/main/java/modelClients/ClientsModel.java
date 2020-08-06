package modelClients;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DynamoDBTable(tableName = "Clients")
public class ClientsModel {
	
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String createdDate;
    private String updatedDate;

    public ClientsModel(String email, String fullName, String password, String phone, String createdDate, String updatedDate) {
    	this.email = email;
    	this.fullName = fullName;
    	this.password = password;
    	this.phone = phone;
    	this.createdDate = createdDate;
    	this.updatedDate = updatedDate;
    }
    
    public ClientsModel() {
    	
    }

    @DynamoDBHashKey(attributeName = "Email")
    @DynamoDBAttribute(attributeName = "Email")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "Email-Password-index", attributeName = "Email")
    public String getEmail() {
		return email;
	}
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    @DynamoDBAttribute(attributeName = "FullName")
	public String getFullName() {
		return fullName;
	}
    
    public void setFullName(String fullName) {
    	this.fullName =fullName;
    }

    @DynamoDBAttribute(attributeName = "Password")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "Email-Password-index", attributeName = "Password")
    public String getPassword() {
		return password;
	}

    public void setPassword(String password) {
    	this.password = password;
    }
    
    @DynamoDBAttribute(attributeName = "Phone")
	public String getPhone() {
		return phone;
	}
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }

    @DynamoDBAttribute(attributeName = "CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @DynamoDBAttribute(attributeName = "UpdatedDate")
    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
    	return "{\"fullName\": \""+ fullName + "\", " +
                "\"email\": \"" + email + "\", " +
                "\"phone\": \"" + phone + "\", " +
                "\"createdDate\": \"" + createdDate + "\", " +
                "\"updatedDate\": \"" + updatedDate + "\"}";

    }
	
}