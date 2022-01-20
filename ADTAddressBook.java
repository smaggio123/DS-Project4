/**
 * This represents the AddressBook's interface
 * @author Steven Maggio
 *
 */
public interface ADTAddressBook {
	/**
	 * inserts a contact into the AddressBook
	 * @param info
	 */
	public void insert(String info);
	
	/**
	 * removes a contact from the AddressBook
	 * @param name
	 */
	public void remove(String name);
	
	/**
	 * checks to see if contact can be found in the AddressBook
	 * @param name
	 * @return true if contact is in book, false otherwise
	 */
	public boolean exists(String name);
	
	/**
	 * returns the contact info of the contact in the AddressBook
	 * @param name
	 * @return Contact info
	 */
	public Contact get(String name);
	
	/**
	 * returns the size of the Addressbook
	 * @return size
	 */
	public int size();
	
	/**
	 * checks if AddressBook is empty
	 * @return true if AddressBook is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * clears the AddressBook
	 */
	public void clear();
}
