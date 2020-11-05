public class AddressBookSystem {
	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook System");
		
		AddressBookDao addressBook = new AddressBookDao();
		addressBook.getUserChoice();
	}
}
