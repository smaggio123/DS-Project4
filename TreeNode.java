/**
 * Represents a node in a binary tree. Each tree node contains a data portion - a name 
 * and two references, one for each of the node's children.
 */
public class TreeNode<E> {
	
	/**
	 * The data portion of this node
	 */
	private E element;
	/**
	 * The reference to left child of this node
	 */
	private TreeNode<E> left;
	
	/**
	 * The TreeNode<E> to right child of this node
	 */
	private TreeNode<E> right;

	/**
	 * Constructs a default node.
	 */
	public TreeNode() {
		this(null, null, null);
	}
	
	/**
	 * Constructs a node with a specific element.
	 * @param element A reference to the item of this node
	 */
	public TreeNode(E e) {
		this(e, null, null);
	}

	/**
	 * Constructs a node with an element and two descendant nodes. 
	 * @param element A reference to the data of this node
	 * @param left Reference to the left child of this node
	 * @param right Reference to the right child of this node
	 */
	public TreeNode(E e, TreeNode<E> l, TreeNode<E> r) {
		//sets element to e
		this.element = e;
		//sets left node to l
		this.left = l;
		//sets right node to r
		this.right = r;
	}

	/**
	 * Returns the element of this node.
	 * @return A reference to the element of this node
	 */
	public E getElement() {
		//returns element of node
		return this.element;
	}

	/**
	 * Changes the element of this node.
	 * @param element The element of this node
	 */
	public void setElement(E e) {
		//sets element to e
		this.element = e;
	}

	/**
	 * Returns the left node.
	 * @return A reference to the left child of this node
	 */
	public TreeNode<E> getLeft() {
		//returns the left node
		return this.left;
	}

	/**
	 * sets the left node to l.
	 * @param leftChild A reference to the left child of this node
	 */
	public void setLeft(TreeNode<E> l) {
		//sets the left node to l
		this.left = l;
	}

	/**
	 * Returns the right node. 
	 * @return A reference to the tight child of this node
	 */
	public TreeNode<E> getRight() {
		//returns the right node
		return this.right;
	}

	/**
	 * sets the right node to r. 
	 * @param rightChild A reference to the right child of this node
	 */
	public void setRight(TreeNode<E> r) {
		//sets the right node to r
		this.right = r;
	}
	
	/**
	 * compares contact info of two nodes
	 * @param other
	 * @return comparison value
	 */
	public int compareContacts(TreeNode other) {
		//make a Contact object with information of this node
		Contact thisContact=(Contact) this.getElement();
		//make a Contact object with information of the other node
		Contact otherContact=(Contact)other.getElement();
		//calls compare name method in the Contact class
		//if this contact is greater than other contact
		if(thisContact.compareNames(otherContact)>0) {
			//return positive value
			return 1;
		}
		//calls compare name method in the Contact class
		//if this contact is less than other contact
		else if(thisContact.compareNames(otherContact)<0) {
			//return negative value
			return -1;
		}
		//return zero if names are equivalent
		return 0;
	}
	
	/**
	 * compares contact info
	 * @param otherContact
	 * @return comparison value
	 */
	public int compareContacts(Contact otherContact) {
		//make a Contact object with information of this node
		Contact thisContact=(Contact) this.getElement();
		//calls compare name method in the Contact class
		//if this contact is greater than other contact
		if(thisContact.compareNames(otherContact)>0) {
			//returns a positive value
			return 1;
		}
		//calls compare name method in the Contact class
		//if this contact is less than other contact
		else if(thisContact.compareNames(otherContact)<0) {
			//returns a negative value
			return -1;
		}
		//return zero if names are equivalent
		return 0;
	}
	
	
	/**
	 * returns contact info
	 * @return contact info
	 */
	public String toString() {
		//makes a Contact object with node info
		Contact c=(Contact)this.getElement();
		//calls Contact method toString
		return c.toString();
	}
}