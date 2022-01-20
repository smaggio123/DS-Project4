import java.lang.Comparable;

/**
 * represents Contact class
 * @author Steven Maggio
 *
 * @param <E>
 */
public class Contact<E> implements Comparable<E>{
	private String name; //holds name
	private Address address; //address of the contact
	private String phone; //phone number of the contact
	private String info; //all of the info of the contact
	
	/**
	 * default constructor
	 */
	public Contact() {
		
	}
	
	/**
	 * constructor of Contact that initializes private variables
	 * @param n
	 * @param a
	 * @param p
	 */
	public Contact(String n, Address a, String p) {
		name=n; //initializes name
		address=a; //initializes address
		phone=p; //initializes phone number
	}
	
	/**
	 * constructor of Contact that initializes private variables
	 * @param n
	 * @param a
	 * @param p
	 * @param i
	 */
	public Contact(String n, Address a, String p,String i) {
		name=n; //initializes name
		address=a; //initializes address
		phone=p; //initializes phone number
		info=i; //initializes the info of the contact
	}


	/**
	 * returns the name of the contact
	 * @return the name of the contact
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * this method compares two names using the string class's compareTo method
	 * @param other
	 * @return comparison number
	 */
	public int compareNames(Contact other) {
		//if name is greater
		if(this.getName().compareTo(other.getName())>0) {
			//return negative number
			return 1;
		}
		//if name is less
		else if(this.getName().compareTo(other.getName())<0) {
			//return negative number
			return -1;
		}
		//returns zero if names are equivalent
		return 0;
	}
	
	/**
	 * returns info of the contact
	 * @return info of the contact
	 */
	public String toString() {
		//prints info from a string so the output looks nice
		return info;
	}
	
	
	
	
	/**
	 * compareTo method
	 * @Override
	 * @return int
	 */
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	
}
