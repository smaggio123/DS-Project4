import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Helper class
 * @author Steven Maggio
 */
public class Helper {
	
	/**
	 * start method
	 * @throws FileNotFoundException
	 */
	public static void start() throws FileNotFoundException {
		//makes address book
		AddressBook booky=new AddressBook();
		//calls create method
		create(booky);
	}
	
	/**
	 * fills in the address book
	 * @param b
	 * @throws FileNotFoundException
	 */
	public static void create(AddressBook b) throws FileNotFoundException {
		//adding items from file
		System.out.println("Adding items from file");
		//find file
		File file= new File("C:\\Users\\cptna\\Documents\\contacts.txt");
		//makes scanner
		Scanner sc = new Scanner(file);
		//traversing through the file
		while(sc.hasNextLine()){
			//initialize string to hold info
			String line = sc.nextLine();
			//adds info to the tree
			b.insert(line);
		}
		//close file
		sc.close();
		//calls runOperation method
		runOperations(b);
		
		
	}
	
	/**
	 * runs the operations of address book
	 * @param b
	 */
	public static void runOperations(AddressBook b) {
		//displays the content of the tree
		display(b);
		
		//getting James Butt's informations
		System.out.println("getting James Butt's info");
		System.out.println(b.get("James Butt"));
		
		//displaying whether James Butt is in the address book or not
		System.out.println("Is James Butt in the address book?");
		//if James Butt is in the address book
		if(b.exists("James Butt")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		//removing James Butt
		System.out.println("removing James Butt");
		b.remove("James Butt");
		
		//displaying whether or not James Butt is in the address book
		System.out.println("Is James Butt in the address book?");
		//if James Butt is in the address book
		if(b.exists("James Butt")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		//displaying the address book
		//display(b);
		
		//displaying size of the address book
		System.out.println("Size of the address book is: "+b.size());
		
		//displaying whether or not other contacts exist
		System.out.println("is Art Venere in the address book?");
		//if Art Venre is in the address book
		if(b.exists("Art Venere")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		System.out.println("Is Josephine Darakjy in the address book?");
		//if Josephine Darakjy is in the address book
		if(b.exists("Josephine Darakjy")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		//getting Natatie Fern's info if it exists
		System.out.println("Finding Natalie Fern's info");
		//if Natalie Fern is in the address book
		if(b.exists("Natalie Fern")) {
			System.out.println(b.get("Natalie Fern"));
		}
		else {
			System.out.println("no info found");
		}
		
		//removing Natalie Fern from the address book
		System.out.println("removing Natalie Fern");
		b.remove("Natalie Fern");
		
		//Trying to get Natalie Fern's info that is no longer in the address book
		System.out.println("Finding Natalie Fern's info");
		//if Natalie Fern is in the address book
		if(b.exists("Natalie Fern")) {
			System.out.println(b.get("Natalie Fern"));
		}
		else {
			System.out.println("no info found");
		}
		
		//printing the size of the tree
		System.out.println("the size of the adress book is: "+ b.size());
		
		//printing the tree
		//display(b);
		
		//determine that the tree is not empty
		System.out.println("is the address book empty?");
		//if address book is empty
		if(b.isEmpty()) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		//clear the address book
		System.out.println("clearing address book");
		b.clear();
		
		//print that the tree is empty
		System.out.println("is the address book empty?");
		//if address book is empty
		if(b.isEmpty()) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		//printing the empty tree
		display(b);
	}
	/**
	 * prints size of list and prints the elements in the bag
	 * @param b
	 */
	public static void display(AddressBook b) {
		//prints the tree in postorder
		b.getPostOrder();
		System.out.println();
		//prints the tree inorder
		b.getInOrder();
		System.out.println();
		//prints the tree in preorder
		b.getPreOrder();
		System.out.println();
	}
	
	
}
