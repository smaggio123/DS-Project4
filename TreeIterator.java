//import java.util.Iterator;
import java.util.LinkedList;

/**
 * An iterator over a binary tree.
 *
 * @param <E>
 */
public class TreeIterator<E> implements java.util.Iterator<E>{
	
	/**
	   * The collection traversed by this iterator
	   */
	private BaseBinaryTree<E> tree;
	
	/**
	   * An ordered list of nodes traversed by this iterator. 
	   * Empty list indicates no traversal type currently selected or 
	   * end of current traversal has been reached
	   */
	private LinkedList<TreeNode<E>> list;
	
	/**
	   * Constructs an iterator over a binary tree. 
	   * @param tree A reference to a binary tree
	   */
	  public TreeIterator(BaseBinaryTree<E> tree) {
		  //initializes tree
		  this.tree = tree;
	      // empty queue indicates no traversal type currently
	      // selected or end of current traversal has been reached
		  this.list = new LinkedList<TreeNode<E>>();
	  }
	
	
	
	  /**
	   * Returns the next element in the iteration.
	   * @return the next element in the iteration
	   * @throws NoSuchElementException if the iteration has no more elements
	   */
	  public E next() throws java.util.NoSuchElementException {
	      return this.list.remove().getElement();
	  }
	
	/**
	   * Returns true if the iteration has more elements. 
	   * (In other words, returns true if next() would return an element rather than throwing an exception.)
	   * @return A boolean value specifying if there is an element to be returned
	   */
	  public boolean hasNext() {
		  //returns true if there is a next value, false otherwise
	     return !this.list.isEmpty();
	  }
	
	  /**
	   * Removes from the underlying binary tree the last element returned by this iterator (optional operation). 
	   * It can be called only once per call to next() method. The behavior of an iterator is unspecified if the underlying 
	   * collection is modified while the iteration is in progress in any way other than by calling this method.
	   * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
	   * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been 
	   *                               called after the last call to the next method
	   */
	  public void remove() throws UnsupportedOperationException{
		  // Optional means we can implement it or throw an UnsupportedOperationException. This operation is optional because 
		  // sometimes we just don't want the iterator's content to be modified. An iterator is normally used for executing. 
		  //The default implementation throws an instance of UnsupportedOperationException and performs no other action.
		  this.list.remove();
	      //throw new UnsupportedOperationException();
	  }


	  /**
	   * Sets the traversal type to be preorder.
	   */
	  public void setPreorder() {
		  //clears linked list
		  this.list.clear();
		  //calls preorder method
	      this.preorder(this.tree.root);
	  }
	
	  /**
	   * Sets the traversal type to be inorder.
	   */
	  public void setInorder() {
		  //clears linked list
		  this.list.clear();
		  //calls inorder method
	      this.inorder(this.tree.root);
	  }
	
	  /**
	   * Sets the traversal type to be postorder.
	   */
	  public void setPostorder() {
		  //clears linked list
		  this.list.clear();
		  //calls postorder method
	      this.postorder(this.tree.root);
	  }
	  
	  
	  /**
	   * Traverses in preorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void preorder(TreeNode<E> treeNode) {
		  //traversing through linked list
	    if(treeNode != null){
	    	//adds to linked list
	    	this.list.add(treeNode);
	    	//calls preorder recursively with left node
	    	preorder(treeNode.getLeft());
	    	//calls preorder recursively with right node
	    	preorder(treeNode.getRight());
	    	
	    }
	  }

	  /**
	   * Traverses in inorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void inorder(TreeNode<E> treeNode) {
		  //traversing through linked list
		  if(treeNode != null){
			//calls inorder recursively with left node  
	    	inorder(treeNode.getLeft());
	    	//adds to the linked list
	    	this.list.add(treeNode);
	    	//calls inorder recursively with right node
	    	inorder(treeNode.getRight());
		    	
		    }
	  }

	  /**
	   * Traverses in postorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void postorder(TreeNode<E> treeNode) {
		  //traversing through linked list
		  if(treeNode != null){
			//calls post order recursively with left node  
		    postorder(treeNode.getLeft());
		    //calls post order recursively with right node
	    	postorder(treeNode.getRight());
	    	//adds to linked list
	    	this.list.add(treeNode);
		    	
		    }
	  }
	  
	  /**
	   * returns the linkedList that traversed through the tree
	   * @return list
	   */
	  public LinkedList<TreeNode<E>> getList(){
		  //prints size of linked list
		  System.out.println("size of list: "+list.size());
		  //returns linked list
		  return this.list;
	  }
	  
	  

}
