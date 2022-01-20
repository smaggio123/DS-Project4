/**
 * Represents the interface of a Binary Search Tree
 * @author Steven Maggio
 *
 * @param <E>
 */
public interface ADTBinarySearchTree<E> {

	/**
	 * determines whether the contact is in the tree or not
	 * @param e
	 * @return true if the contact is in the tree false otherwise
	 */
	public boolean find(E e);
	/**
	 * insets node into the tree
	 * @param contact
	 */
	public void insert(E contact);
	/**
	 * returns the contact info of the node
	 * @param str
	 * @return a reference to Contact
	 */
	public Contact getContact(String str);
	/**
	 * removes node from tree
	 * @param contact
	 */
	public void remove(Contact contact);
	/**
	 * returns the iterator
	 * @return a reference to the TreeIterator
	 */
	public TreeIterator<E> iterator();
	
}
