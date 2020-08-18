package ProjectBase;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public final class DynamoClientFactory {

    private DynamoClientFactory(){

    }

    private static class DynamoClientFactoryHolder{
        private static final AmazonDynamoDB dynamoClientObject  = AmazonDynamoDBClientBuilder.standard().build();
        private static final DynamoDB dynamoDBObject = new DynamoDB(dynamoClientObject);
    }

    public static DynamoDB getConection(){
        return DynamoClientFactoryHolder.dynamoDBObject;
    }
}
