import java.util.HashMap;
import java.util.Scanner;

public class AddressBookDao {
	HashMap <String, PersonEntity> contactList = new HashMap<String, PersonEntity>();
	Scanner scanner = new Scanner(System.in);
	
	public void getUserChoice() {
		System.out.println("Enter your option");
		System.out.println("1: Add new contact \n" +
				"2: Exit \n");
		int option = scanner.nextInt();
		switch(option) {
			case 1:
				PersonEntity person = getUserInput();
				contactList.put(person.getEmailId(), person);
		 		System.out.println("Contact added !");
		 		break;
			case 2:
				System.out.println("Exiting..");
                break;
			default:
				System.out.println("Please provide correct option");
				break;
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
