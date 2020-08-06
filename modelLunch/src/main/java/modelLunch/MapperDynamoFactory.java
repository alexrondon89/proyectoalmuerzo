package modelLunch;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public final class MapperDynamoFactory {
	
	private MapperDynamoFactory() {}
	
	private static class MapperDynamoFactoryHolder{
		private static final AmazonDynamoDB dynamoClientObject  = AmazonDynamoDBClientBuilder.standard().build();
		private static final DynamoDBMapper dynamoMapperObject = new DynamoDBMapper(dynamoClientObject);
	}
	
	public static DynamoDBMapper getInstance() {
		System.out.println("Getting dynamoMapperObject from MapperDynamoFactory");
		return MapperDynamoFactoryHolder.dynamoMapperObject;
	}	

}