package ProjectBase;

import PeopleBase.Customer;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.HashMap;

public class DynamoInvoker {

    private DynamoDB dynamoDB;
    private Table table;

    public DynamoInvoker(String tableName){
        this.dynamoDB = DynamoClientFactory.getConection();
        this.table = dynamoDB.getTable(tableName);
    }

    public DynamoDB getDynamoDB() {
        return dynamoDB;
    }

    public Table getTable() {
        return table;
    }

    public Object saveItem(HashMap<String, String> input){

        Customer customer = new Customer(input);

        Item item = new Item().withPrimaryKey("email", input.get("email"))
                .withString("fullName", input.get("fullName"))
                .withString("password", )
                .withStringSet("Authors", new HashSet<String>(Arrays.asList("Author12", "Author22")))
                .withNumber("Price", 20).withString("Dimensions", "8.5x11.0x.75").withNumber("PageCount", 500)
                .withBoolean("InPublication", false).withString("ProductCategory", "Book");
        table.putItem(item);


    }
}

