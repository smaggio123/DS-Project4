/**
 * Represents a binary tree with basic operations
 * @param <E>
 */
public class BaseBinaryTree<E> {
	/**
	   * The root of this tree
	   */
	TreeNode<E> root;
	
	/**
	   * Creates an empty binary tree.
	   */
	  public BaseBinaryTree() {
		  //initializes root
		  this.root=new TreeNode<E>(null,null,null);
	  }
	  
	  /**
	   * Creates a one-node binary tree whose root contains a root item.
	   * @param rootItem The item of the root
	   */
	  public BaseBinaryTree(E rootItem) {
		  //initializes root
	     this.root = new TreeNode<E>(rootItem, null, null);
	  } 
	  
	  /**
	   * Creates a one-node binary tree whose root contains a root item.
	   * @param r
	   */
	  public BaseBinaryTree(TreeNode<E> r) {
		  //initializes root
		  this.root=new TreeNode<E>(r.getElement(),r.getLeft(),r.getRight());
	  }
	  
	
	  /**
	   * Returns true if the tree is empty, else returns false.
	   * @return A value specifying if the tree is empty
	   */
	  public boolean isEmpty() {
		  //returns true if empty, false otherwise
		  return this.root == null;
	  } 
	
	  /**
	   * Removes all nodes from the tree.
	   */
	  public void makeEmpty() {
		  //sets root to null
	    this.root = null;
	  }
	
	  /**
	   * Returns the element in the tree's root.
	   * @return A reference to the item of the root
	   * @throws TreeException if the tree is empty
	   */
	  public E getRoot() throws TreeException {
		  
		  //if root is null
		  if (this.root == null) {
			  //throw exception
			  throw new TreeException("TreeException: Empty tree");
		  }else {
			  //return value of root
			  return this.root.getElement();
		  }
	  	}
	
	  /**
	   * Changes the root element of this binary tree. An UnsupportedOperationException object is 
	   * thrown if operation is not supported.
	   * @param newItem A reference to the new root
	   * @throws  UnsupportedOperationException if operation is not supported.
	   */
	public void setRoot(E e) throws UnsupportedOperationException{
		//set element of root
		this.root.setElement(e);
	}
	
	/**
	 * sets the right node
	 * @param r
	 */
	public void setRight(TreeNode<E> r) {
		//sets right node
		root.setRight(r);
	}
	
	/**
	 * sets the left node
	 * @param l
	 */
	public void setLeft(TreeNode<E> l) {
		//sets left node
		root.setLeft(l);
	}
	
	/**
	 * sets the root to a TreeNode
	 * @param r
	 */
	public void setRoot(TreeNode<E> r) {
		//sets element
		this.root.setElement(r.getElement());
		//sets left node
		this.root.setLeft(r.getLeft());
		//sets right node
		this.root.setRight(r.getRight());
	}
	
	
}
