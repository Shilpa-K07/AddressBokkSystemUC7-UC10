import java.util.HashMap;
import java.util.Scanner;

public class AddressBookSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to AddressBook System");
		HashMap<String, AddressBookDao> addressBookList = new HashMap<String, AddressBookDao>();
		
		AddressBookDao familyAddressBook = new AddressBookDao();
        AddressBookDao officeAddressBook = new AddressBookDao();
        addressBookList.put("Family", familyAddressBook);
        addressBookList.put("Ofiice", officeAddressBook);
        
        boolean isTerminate = false;
        
        while(!isTerminate) {
        	System.out.println("Choose addres book");
        	System.out.println("1: Family address book \n" +
        			"2: Office address book \n"+
        			"3: Exit");
        	int option = scanner.nextInt();
        	switch(option) {
        	case 1:
        		familyAddressBook.getUserChoice();
        		break;
        	case 2:
        		officeAddressBook.getUserChoice();
        		break;
        	case 3:
        		isTerminate = true;
        		break;
        	default:
        		System.out.println("Please enter correct option");
        		break;
        	}
        }
	}
}
