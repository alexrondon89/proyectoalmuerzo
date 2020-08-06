package modelClients;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class ClientsDynamoFactory {
		
	public static AmazonDynamoDB initDynamoDbClient() {
        return AmazonDynamoDBClientBuilder.standard().build();
		}
}
