package modelClients;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;

import java.util.HashMap;
import java.util.Map;

public class ClientsCrud {

	private DynamoInvoker invoker;
	private ClientsModel clientModel;

	public ClientsCrud(){
		invoker = new DynamoInvoker();
		clientModel = new ClientsModel(null, null,  null, null, null, null);
	}
	
	public ClientsModel saveClient(HashMap<String, String> input) throws RuntimeException{

		System.out.println("Check if email already exist before signUp client and whether payload is invalid or not");

		Boolean existKeys = ClientsUtils.checkHashMapKeys(input, ClientsConstantsValidation.signUpArguments());
		ClientsModel client = findClient(input);

		if(!existKeys)
			throw new DynamoDBMappingException();

		if(client != null)
			throw new IllegalArgumentException();

		String createdDate = ClientsUtils.getCurrentDate();
		String passwordEncryption = ClientsUtils.passwordEncryption(input.get("password"));

		clientModel.setEmail(input.get("email"));
		clientModel.setFullName(input.get("fullName"));
		clientModel.setPassword(passwordEncryption);
		clientModel.setPhone(input.get("phone"));
		clientModel.setCreatedDate(createdDate);
		clientModel.setUpdatedDate(createdDate);

		invoker.saveItem(clientModel);
		System.out.println("Client was registered");

		return ClientsUtils.generateJsonObjectResponse(clientModel.toString());
	}

	public ClientsModel findClient(Map<String, String> input) throws RuntimeException{
		return invoker.findItemByHasKey(input);
	}

	public Object signInClient(HashMap<String, String> input) throws RuntimeException {
		input.replace("password", ClientsUtils.passwordEncryption(input.get("password")));

		Boolean existKeys = ClientsUtils.checkHashMapKeys(input, ClientsConstantsValidation.signInArguments());

		if(!existKeys)
			throw new DynamoDBMappingException();

		ClientsModel client = invoker.findItemByIndex("Email-Password-index", input);

		if (client == null)
			throw new IllegalArgumentException();

		System.out.println("Client logged");
		System.out.println(client);

		return ClientsUtils.generateJsonObjectResponse(client.toString());
	}

	public ClientsModel editClient(HashMap<String, String> input) throws RuntimeException {
		Boolean existKeys = ClientsUtils.checkHashMapKeys(input, ClientsConstantsValidation.emailArgument());

		if(!existKeys)
			throw new DynamoDBMappingException();

		System.out.println("Check if email already exist before edit client");
		ClientsModel client = findClient(input);

		if (!(client == null)) {
			String updatedDate = ClientsUtils.getCurrentDate();

			System.out.println(input.get("se imprime full name"));
			System.out.println(input.get("fullName"));

			clientModel.setEmail(client.getEmail());
			clientModel.setFullName(input.get("fullName"));
			clientModel.setPhone(input.get("phone"));
			clientModel.setCreatedDate(client.getCreatedDate());
			clientModel.setUpdatedDate(updatedDate);

			System.out.println(input.get("password"));

			if (input.get("password") != null) {
				input.replace("password", ClientsUtils.passwordEncryption(input.get("password")));

				clientModel.setPassword(input.get("password"));
			}

			invoker.updateItem(clientModel);
			return ClientsUtils.generateJsonObjectResponse(clientModel.toString());
		}

		throw new IllegalArgumentException();
	}
	
	public ClientsModel deleteClient(HashMap<String, String> input) {
		Boolean existKeys = ClientsUtils.checkHashMapKeys(input, ClientsConstantsValidation.emailArgument());

		if(!existKeys)
			throw new DynamoDBMappingException();

		System.out.println("Check if email already exist before delete client");
		ClientsModel client = findClient(input);

		if(!(client == null)){
			clientModel.setEmail(client.getEmail());
			invoker.deleteItem(clientModel);
			return ClientsUtils.generateJsonObjectResponse(client.toString());
		}

		throw new IllegalArgumentException();
	}
}
