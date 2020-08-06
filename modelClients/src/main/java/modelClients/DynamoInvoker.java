package modelClients;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamoInvoker {

    private final DynamoDBMapper mapper ;

    public DynamoInvoker(){
        mapper = MapperDynamoFactory.getInstance();
    }

    public ClientsModel findItemByIndex(String indexName, Map<String, String> input) {
        HashMap<String, AttributeValue> attributeValues = new HashMap<>();
        attributeValues.put(":email",  new AttributeValue().withS(input.get("email")));
        attributeValues.put(":password",  new AttributeValue().withS(input.get("password")));

        DynamoDBQueryExpression<ClientsModel> queryExpression = new DynamoDBQueryExpression<ClientsModel>().withIndexName(indexName)
                                                                                                           .withConsistentRead(false)
                                                                                                           .withKeyConditionExpression("Email = :email and Password = :password")
                                                                                                           .withExpressionAttributeValues(attributeValues);

        System.out.println("Searching client in list with dynamo invoker");
        return mapper.query(ClientsModel.class, queryExpression).get(0);
    }

    public void saveItem(ClientsModel clientModel){
        System.out.println("Saving new client with dynamo invoker");
        mapper.save(clientModel);
    }

    public ClientsModel findItemByHasKey(Map<String, String> input){
        System.out.println("Searching email "+ input.get("email"));

        ClientsModel client = mapper.load(ClientsModel.class, input.get("email"), new DynamoDBMapperConfig(DynamoDBMapperConfig.ConsistentReads.CONSISTENT));

        System.out.println(client);
        return client;
    }

    public ClientsModel updateItem(ClientsModel clientModel){
        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder().withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                                                                                      .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES)
                                                                                      .build();

        System.out.println("Updating client with dynamo invoker");
        mapper.save(clientModel, dynamoDBMapperConfig);

        return clientModel;
    }

    public Object deleteItem(ClientsModel clientModel){
        System.out.println("Deleting client with email" + clientModel.getEmail());
        mapper.delete(clientModel);

        return clientModel;
    }
}
