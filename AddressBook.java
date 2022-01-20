import java.util.LinkedList; //called for tree iterator
/**
 * Represents an address book
 * @author Steven Maggio
 *
 */
public class AddressBook implements ADTAddressBook {

	private BinarySearchTree<Contact> tree=new BinarySearchTree<Contact>();//BinarySearchTree is the data structure used for AddressBook
	private int count; //keeps track of the size of the address book
	
	
	/**
	 * inserts a contact into the AddressBook
	 * @param info
	 * @Override
	 */
	public void insert(String info) {
		// TODO Auto-generated method stub
		//splits the information into an array of Strings
		String[] arr = info.split("\\s+");
		//makes an Address object
		Address address=new Address(getStreet(arr),arr[arr.length-4],arr[arr.length-3],arr[arr.length-2]);
		//makes a Contact object
		Contact contact=new Contact(arr[0]+" "+arr[1],address," "+arr[arr.length-1],info);
		//adds contact to the address book
		tree.insert(contact);
		//increases the size of the address book
		count++;
	}
	
	/**
	 * makes a string that holds the street information
	 * @param arr
	 * @return street
	 */
	public String getStreet(String[] arr) {
		//string that holds data
		String str="";
		//traverse through the array
		for(int i=2;i<arr.length-4;i++) {
			//adds info to the string
			str+=arr[i]+" ";
		}
		//returns string with the street info
		return str;
	}
	
	

	
	/**
	 * removes a contact from the AddressBook
	 * @param name
	 * @Override
	 * @throws TreeException
	 */
	public void remove(String name) throws TreeException{
		// TODO Auto-generated method stub
		//makes a Contact object with the info of the contact to be removed
		Contact contact=new Contact(name,null,null);
		//if the contact is in the tree
		if(tree.find(contact)) {
			//remove the contact
			tree.remove(contact);
			//decrease size count
			count--;
		}
		else {
			throw new TreeException("The value isn't in the tree");
			
		}
	}

	
	/**
	 * checks to see if contact can be found in the AddressBook
	 * @param name
	 * @Override
	 * @return true if contact is in book, false otherwise
	 */
	public boolean exists(String name) {
		// TODO Auto-generated method stub
		//makes a Contact Object with information we are searching for
		Contact contact=new Contact(name,null,null);
		//returns true if the contact is in the address book, false otherwise
		return tree.find(contact);
		
	}

	
	/**
	 * returns the contact info of the contact in the AddressBook
	 * @param name
	 * @Override
	 * @return Contact info
	 */
	public Contact get(String name) {
		// TODO Auto-generated method stub
		//creates Contact object with the information to search for
		Contact contact=new Contact(name,null,null);
		//if the contact is in the tree
		if(tree.find(contact)) {
			//return the contact information
			return tree.getContact(name);
		}
		else {
			//print that the contact is not in the tree
			System.out.println("contact does not exist");
			return null;
		}
	}

	
	/**
	 * returns the size of the Addressbook
	 * @Override
	 * @return
	 */
	public int size() {
		// TODO Auto-generated method stub
		//return the size of the address book
		return count;
	}

	

	
	/**
	 * clears the AddressBook
	 * @Override
	 */
	public void clear() {
		// TODO Auto-generated method stub
		//clears the address book by making a new binary search tree
		tree=new BinarySearchTree<Contact>();
		//sets count to zero
		count=0;
	}

	
	/**
	 * checks if AddressBook is empty
	 * @Override
	 * @return true if AddressBook is empty, false otherwise
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//returns true if address book is empty, false otherwise
		return count==0;
	}
	
	/**
	 * prints the elements in the address book in post order
	 */
	public void getPostOrder() {
		System.out.println("printing elements in post order");
		//makes a linked list to hold values in tree
		LinkedList list=tree.iteratorInPostOrder().getList();
		//traversing through list
		while(list.peek()!=null) {
			//print the elements in the list
			System.out.println(list.pop().toString());
		}
	}
	
	/**
	 * prints the elements in the address book in pre order
	 */
	public void getPreOrder() {
		System.out.println("Printing elements in pre order");
		//makes a linked list to hold values in the tree
		LinkedList list=tree.iteratorInPreOrder().getList();
		//traversing through the list
		while(list.peek()!=null) {
			//print the elements in the list
			System.out.println(list.pop().toString());
		}
	}
	
	/**
	 * prints the elements in the address book in order
	 */
	public void getInOrder() {
		System.out.println("Printing elements in order");
		//makes a linked list to hold values in the tree
		LinkedList list=tree.iteratorInOrder().getList();
		//traversing through the list
		while(list.peek()!=null) {
			//print the elements in the list
			System.out.println(list.pop().toString());
		}
	}

	
}
