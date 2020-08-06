package modelLunch;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;

import java.util.HashMap;
import java.util.Map;

public class LunchCrud {

	private DynamoInvoker invoker;
	private LunchModel clientModel;

	public LunchCrud(){
		invoker = new DynamoInvoker();
		clientModel = new LunchModel(null, null,  null, null, null, null);
	}
	
	public LunchModel saveClient(HashMap<String, String> input) throws RuntimeException{

		System.out.println("Check if email already exist before signUp client and whether payload is invalid or not");

		Boolean existKeys = LunchUtils.checkHashMapKeys(input, LunchConstantsValidation.signUpArguments());
		LunchModel client = findClient(input);

		if(!existKeys)
			throw new DynamoDBMappingException();

		if(client != null)
			throw new IllegalArgumentException();

		String createdDate = LunchUtils.getCurrentDate();
		String passwordEncryption = LunchUtils.passwordEncryption(input.get("password"));

		clientModel.setEmail(input.get("email"));
		clientModel.setFullName(input.get("fullName"));
		clientModel.setPassword(passwordEncryption);
		clientModel.setPhone(input.get("phone"));
		clientModel.setCreatedDate(createdDate);
		clientModel.setUpdatedDate(createdDate);

		invoker.saveItem(clientModel);
		System.out.println("Client was registered");

		return LunchUtils.generateJsonObjectResponse(clientModel.toString());
	}

	public LunchModel findClient(Map<String, String> input) throws RuntimeException{
		return invoker.findItemByHasKey(input);
	}

	public Object signInClient(HashMap<String, String> input) throws RuntimeException {
		input.replace("password", LunchUtils.passwordEncryption(input.get("password")));

		Boolean existKeys = LunchUtils.checkHashMapKeys(input, LunchConstantsValidation.signInArguments());

		if(!existKeys)
			throw new DynamoDBMappingException();

		LunchModel client = invoker.findItemByIndex("Email-Password-index", input);

		if (client == null)
			throw new IllegalArgumentException();

		System.out.println("Client logged");
		System.out.println(client);

		return LunchUtils.generateJsonObjectResponse(client.toString());
	}

	public LunchModel editClient(HashMap<String, String> input) throws RuntimeException {
		Boolean existKeys = LunchUtils.checkHashMapKeys(input, LunchConstantsValidation.emailArgument());

		if(!existKeys)
			throw new DynamoDBMappingException();

		System.out.println("Check if email already exist before edit client");
		LunchModel client = findClient(input);

		if (!(client == null)) {
			String updatedDate = LunchUtils.getCurrentDate();

			System.out.println(input.get("se imprime full name"));
			System.out.println(input.get("fullName"));

			clientModel.setEmail(client.getEmail());
			clientModel.setFullName(input.get("fullName"));
			clientModel.setPhone(input.get("phone"));
			clientModel.setCreatedDate(client.getCreatedDate());
			clientModel.setUpdatedDate(updatedDate);

			System.out.println(input.get("password"));

			if (input.get("password") != null) {
				input.replace("password", LunchUtils.passwordEncryption(input.get("password")));

				clientModel.setPassword(input.get("password"));
			}

			invoker.updateItem(clientModel);
			return LunchUtils.generateJsonObjectResponse(clientModel.toString());
		}

		throw new IllegalArgumentException();
	}
	
	public LunchModel deleteClient(HashMap<String, String> input) {
		Boolean existKeys = LunchUtils.checkHashMapKeys(input, LunchConstantsValidation.emailArgument());

		if(!existKeys)
			throw new DynamoDBMappingException();

		System.out.println("Check if email already exist before delete client");
		LunchModel client = findClient(input);

		if(!(client == null)){
			clientModel.setEmail(client.getEmail());
			invoker.deleteItem(clientModel);
			return LunchUtils.generateJsonObjectResponse(client.toString());
		}

		throw new IllegalArgumentException();
	}
}
