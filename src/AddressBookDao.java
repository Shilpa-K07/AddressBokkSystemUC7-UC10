import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDao {
	HashMap <String, PersonEntity> contactList = new HashMap<String, PersonEntity>();
	HashMap <String, PersonEntity> cityDictionary = new HashMap<String, PersonEntity>();
	HashMap <String, PersonEntity> stateDictionary = new HashMap<String, PersonEntity>();
	
	Scanner scanner = new Scanner(System.in);
	
	public void getUserChoice() {
		boolean isTerminate = false;
		while (!isTerminate) {
		System.out.println("Enter your option");
		System.out.println("1: Add new contact \n" +
				"2: Update contact \n" +
				"3: Delete contact \n" +
				"4: Search contacts by city \n" +
				"5: Search contacts by state \n" +
				"6: View contacts by city \n" +
				"7: View contacts by state \n" +
				"8: Print address book \n"+
				"9: Exit \n");
		int option = scanner.nextInt();
		switch(option) {
			case 1:
				PersonEntity person = getUserInput();
				if(person != null) {
				contactList.put(person.getEmailId(), person);
				cityDictionary.put(person.getCity(), person);
				stateDictionary.put(person.getState(), person);
		 		System.out.println("Contact added !");
				}
		 		break;
			case 2:
				updateContact();
                break;
			case 3:
				deleteContact();
				break;
			case 4:
				searchByCity();
				break;
			case 5:
				seachByState();
				break;
			case 6:
				System.out.println(cityDictionary);
				break;
			case 7:
				System.out.println(stateDictionary);
				break;
			case 8:
				System.out.println(contactList);
				break;
			case 9:
				isTerminate = true;
				break;
			default:
				System.out.println("Please provide correct option");
				break;
			}
		}
	}
	
	private void seachByState() {
		System.out.println("Enter state name to search with ");
		String state = scanner.next();
		int personCount = 0;
		Iterator iterator = contactList.entrySet().iterator();

		while (iterator.hasNext()) { 
			Map.Entry<String, PersonEntity> mapElement = (Map.Entry)iterator.next(); 
			PersonEntity person = mapElement.getValue();
			if(state.equalsIgnoreCase(person.getState())){
				personCount++;
				System.out.println("FirstName =" + person.getFirstName() +
			", lastName = " + person.getLastName() + 
			", address = " + person.getAddress() + 
			", city = " + person.getCity() +
			", state = " + person.getState() + 
			", zip = " + person.getZip() + 
			", phoneNumber = " + person.getPhoneNumber() + 
			", email = " + person.getEmailId());
			}
		}
		System.out.println("\nNumber of contacts in "+state+" state is :"+personCount);
	}

	private void searchByCity() {
		System.out.println("Enter city name to search with ");
		String city = scanner.next();
		int personCount = 0;
		Iterator iterator = contactList.entrySet().iterator();

		while (iterator.hasNext()) { 
			Map.Entry<String, PersonEntity> mapElement = (Map.Entry)iterator.next(); 
			PersonEntity person = mapElement.getValue();
			if(city.equalsIgnoreCase(person.getCity())){
				personCount++;
				System.out.println("FirstName =" + person.getFirstName() +
			", lastName = " + person.getLastName() + 
			", address = " + person.getAddress() + 
			", city = " + person.getCity() +
			", state = " + person.getState() + 
			", zip = " + person.getZip() + 
			", phoneNumber = " + person.getPhoneNumber() + 
			", email = " + person.getEmailId());
			}
		}
		System.out.println("Number of contacts in "+city+" city is : "+personCount);
	}

	private boolean duplicateCheck(String emailId) {
		if(contactList.containsKey(emailId))
			return true;
		return false;
	}
	
	private void deleteContact() {
        System.out.println("Enter EmailId to delete");
        String emailId = scanner.next();
        if (!contactList.containsKey(emailId)) {
            System.out.println("Provided email Id is not found");
            deleteContact();
        }
        contactList.remove(emailId);
        System.out.println("Contact deleted !");
    }

	private void updateContact() {
		System.out.println("Enter emailId to update");
		String emailId = scanner.next();

		if (!contactList.containsKey(emailId)) {
			System.out.println("Email Id provided is wrong !");
			updateContact();
        }
		
		PersonEntity person = contactList.get(emailId);
		boolean isTerminate = false;
		while(!isTerminate) {
			System.out.println("Which field do you want to update?");
			System.out.println("1: First name \n" +
	                "2: Last Name \n" +
	                "3: Address \n" +
	                "4: City \n" +
	                "5: State \n" +
	                "6: Zip \n" +
	                "7: PhoneNumber \n" +
	                "8: Exit \n");

	        int option = scanner.nextInt();
	        switch (option) {
	            case 1:
	                System.out.println("Enter First Name ");
	                String firstName = scanner.next();
	                person.setFirstName(firstName);
	                break;
	            case 2:
	                System.out.println("Enter Last Name");
	                String lastName = scanner.next();
	                person.setLastName(lastName);
	                break;
	            case 3:
	                System.out.println("Enter Address");
	                String address = scanner.next();
	                person.setAddress(address);
	                break;
	            case 4:
	                System.out.println("Enter City");
	                String city = scanner.next();
	                person.setCity(city);
	                break;
	            case 5:
	                System.out.println("Enter State");
	                String state = scanner.next();
	                person.setState(state);
	                break;
	            case 6:
	                System.out.println("Enter Zip Code");
	                int zip=scanner.nextInt();
	                person.setZip(zip);
	                break;
	            case 7:
	                System.out.println("Enter Phone Number");
	                long phone = scanner.nextLong();
	                person.setPhoneNumber(phone);
	                break;
	            case 8:
	            	System.out.println("Exiting..");
	            	isTerminate = true;
	            default:
	                System.out.println("please select valid option");
	                break;
	        }
	        System.out.println("Details updated!\n");
		}
	}

	private PersonEntity getUserInput() {
		System.out.println("Enter First Name");
		String firstName = scanner.next();
		System.out.println("Enter Last Name");
		String lastName = scanner.next();
		System.out.println("Enter Address");
		String address = scanner.next();
		System.out.println("Enter City Name");
		String city = scanner.next();
		System.out.println("Enter the Zip Code");
		int zip = scanner.nextInt();
		System.out.println("Enter State Name");
		String state = scanner.next();
		System.out.println("Enter Phone Number");
		long phone = scanner.nextLong();
		System.out.println("Enter Email Id");
		String emailId = scanner.next();
		
		boolean result = duplicateCheck(emailId);
		if(result) {
			System.out.println("\nContact with this email is already exists"
					+ " in this address book");
			return null;
		}
		PersonEntity person = new PersonEntity();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		person.setCity(city);
		person.setZip(zip);
		person.setState(state);
		person.setPhoneNumber(phone);
		person.setEmailId(emailId);
		
		return person;
	}
}
