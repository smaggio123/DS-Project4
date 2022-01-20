import java.lang.RuntimeException;

/**
 * Represents a BinarySearchTree
 * @author Steven Maggio
 *
 * @param <E>
 */
public class BinarySearchTree<E> implements Comparable<E>, ADTBinarySearchTree<E>{
	
	//root of the BinarySearchTree
	private TreeNode<E> root;
	//base of the BinarySearchTree
	private BaseBinaryTree<E> base;
	
	/**
	 * constructor of the BinarySearchTree that initializes the private variables
	 */
	public BinarySearchTree() {
		//sets base to null
		base=null;
		//sets root to null
		root=null;
	}
	
	/**
	 * constructor of the BinarySearchTree that initializes the private variables
	 * @param contact
	 */
	public BinarySearchTree(E contact) {
		//initializes root
		root=new TreeNode<E>(contact);
		//initializes base
		base.setRoot(contact);
	}
	
	/**
	 * searches for a value to determine whether or not it is in the tree (an exists method)
	 * @param e
	 * @Override
	 * @return true if the node is found, false otherwise
	 */
	public boolean find(E e) {
		//makes node to search for
		TreeNode<E> node=new TreeNode<E>(e);
		//temporary variable is made so the root node is unaffected
		TreeNode<E> temp=new TreeNode<E>(root.getElement(),root.getLeft(),root.getRight());
		
		//if root is the node we are looking for
		if(root.compareContacts(node)==0) {
			//return true
			return true;
		}
		//while searching through tree
		while(true) {
			//if the value of temp is greater than node
			if(temp.compareContacts(node)>0) {
				//if there is a right node
				if(temp.getRight()!=null) {
					//set temp equal to the right node
					temp = temp.getRight();
				}
				//otherwise
				else {
					//return false
					return false;
				}
		}
			//of the value of temp is less than node
			else if(temp.compareContacts(node)<0){
				//if there is a left node
				if(temp.getLeft() !=null) {
					//set temp equal to the left node
					temp = temp.getLeft();
				}
				//otherwise
				else {
					//return false
					return false;
				}
			}
			//if the value of temp equals the value of node
			else if(temp.compareContacts(node)==0) {
				//returns true
				return true;
			}
		}
		
		
	}
	
	/**
	 * inserts a node into the binary tree
	 * @Override
	 * @param contact
	 */
	public void insert(E contact) {
		//calls  insert node method to insert the node
		root=insertNode(root,contact);
	}
	
	/**
	 * inserts node with value value
	 * @param r
	 * @param value
	 * @return node with inserted nodes attached to it
	 */
	public TreeNode<E> insertNode(TreeNode<E> r, E value){
		//makes a node with the value to insert
		TreeNode<E> node=new TreeNode<E>(value);
		//if r is null
		if(r==null) {
			//returns the node with the value value
			return new TreeNode<E>(value);
		}
		//if the value of r is greater than node
		if(r.compareContacts(node)>0) {
			//sets right node while calling the insertNode recursively 
			r.setRight(insertNode(r.getRight(),value));
		}
		//if the value of the node is less than equal to r
		else {
			//sets left node while calling the insertNode recursively
			r.setLeft(insertNode(r.getLeft(),value));
		}
		//returns node with inserted nodes
		return r;
	}
	
	
	/**
	 * gets the contact info of the specified name
	 * @param str
	 * @Override
	 * @return contact info of the specified name
	 */
	public Contact getContact(String str) {
		//makes a Contact object with the info we are comparing
		Contact contact=new Contact(str,null,null);
		//makes a node object with the info we are comparing
		TreeNode<E> node=new TreeNode<E>((E)contact);
		//makes a temporary node so we do not mess up the root node
		TreeNode<E> temp=new TreeNode<E>(root.getElement(),root.getLeft(),root.getRight());
		//if the value of the root equals 
		if(root.compareContacts(node)==0) {
			//return the contact info of the node
			return (Contact) root.getElement();
		}
		//while searching for the node
		while(true) {
			//if the value of temp is greater than the value of node
			if(temp.compareContacts(node)>0) {
				//if there is a right node
				if(temp.getRight()!=null) {
					//set temp equal to the right node
					temp = temp.getRight();
				}
				//if there is no right node
				else {
					//return null
					return null;
				}
		}
			//if the value of temp is less than the value of node
			else if(temp.compareContacts(node)<0){
				//if there is a left node
				if(temp.getLeft() !=null) {
					//set temp equal to the left node
					temp = temp.getLeft();
				}
				//if there is no left node
				else {
					//return null
					return null;
				}
			}
			//if the nodes are equal
			else if(temp.compareContacts(node)==0) {
				//return the contact info
				return (Contact) temp.getElement();
			}
		}
	}
	
	/**
	 * calls the removeNode class which removes a node from the binary tree
	 * @Override
	 * @param contact
	 */
	public void remove(Contact contact) {
		//if the root is null
		if(root==null) {
			//throw tree exception
			throw new TreeException("TreeException: Empty tree");
		}
		else {
			//calls remove node
			removeNode(root,contact);
		}
		
	}
	/*
	public void remove(TreeNode<E> r,Contact contact) {
		int count=0;
			//TreeNode<E> temp= new TreeNode<E>(root.getElement(),root.getLeft(),root.getRight());
			//TreeNode<E> fakeRootNode= new TreeNode<E>(root.getElement(),root.getLeft(),root.getRight());
		TreeNode<E> beforeNextNode=new TreeNode<E>(r.getElement(),r.getLeft(),r.getRight());
		boolean done=false;
			boolean wentLeftNode=false;
		while(!done) {
				
				 if(r.compareContacts(contact)>0) {
					beforeNextNode=new TreeNode<E>(r.getElement(),r.getLeft(),r.getRight());
					remove(r.getRight(),contact);
					//fakeRootNode=new TreeNode<E>(temp.getElement(),temp.getLeft(),temp.getRight());
					//temp=temp.getRight();
					count++;
					wentLeftNode=false;
				}
				else if(r.compareContacts(contact)<0) {
					beforeNextNode=new TreeNode<E>(r.getElement(),r.getLeft(),r.getRight());
					//new TreeNode<E>(r.getElement(),r.getLeft(),r.getRight());
					remove(r.getLeft(),contact);
					//fakeRootNode=new TreeNode<E>(temp.getElement(),temp.getLeft(),temp.getRight());
					//temp=temp.getLeft();
					count++;
					wentLeftNode=true;
				}
				else if(r.compareContacts(contact)==0) {
					System.out.println("Hi");
					count++;
					done=true;
					if(wentLeftNode) {
						System.out.println("hi left");
						//System.out.println(r.getLeft());
						beforeNextNode.setLeft(removeNode(r,contact));
						
						//temp=removeNode(temp,contact);
						//fakeRootNode.setLeft(temp);
						//return beforeNextNode;
					}
					else {
						System.out.println("high right");
						System.out.println(r.getRight());
						beforeNextNode.setRight(removeNode(r,contact));
						
						//temp=removeNode(temp,contact);
						//fakeRootNode.setRight(temp);
						//return beforeNextNode;
					}
					
					if(count>1) {
						System.out.println("emergency break");
						break;
					}
					
					
					//replaceNode(temp,contact);
				}
				 done=true;
				// break;
				
				 if(count>10) {
					System.out.println("emergency break");
					break;
				}
				
			}
			
		//TreeNode<E> apple=new TreeNode<E>();
				//return apple;
	}
	*/
	
	/**
	 * removes a node from the tree
	 * @param r
	 * @param contact
	 * @return the node which points to other nodes that exclude the removed node
	 */
	public TreeNode<E> removeNode(TreeNode<E> r,Contact contact){
		//if the node equals node
		if(r == null) return r;
		//if the value of r is less than contact
        if(r.compareContacts(contact)<0) {
        	//calls removeNode recursively to find the node that will be removed
            r.setLeft(removeNode(r.getLeft(), contact));
        } 
        //if the value of r is less than contact
        else if(r.compareContacts(contact)>0) {
        	//calls removeNode recursively to find the node that will be removed
            r.setRight(removeNode(r.getRight(), contact));
        } 
        //once the node is found
        else {
            // node with no leaf nodes
            if(r.getLeft() == null && r.getRight() == null) {
                return null;
            } 
            // node with one node (no left node)
            else if(r.getLeft() == null) {
                //returns right node
                return r.getRight();
            } 
            // node with one node (no right node)
            else if(r.getRight() == null) {
                //returns left node
                return r.getLeft();
            } 
            // nodes with two nodes
            else {
                // search for min number in right sub tree
                //min value in E data type
            	E minValue = minValue(r.getRight());
                //min value in Contact data type
                Contact min=(Contact) minValue;
                //sets node to minimum value
                r.setElement(minValue);
                //sets right node
                r.setRight(removeNode(r.getRight(), min));
            }
        }
        //returns node
        return r;
	}
	
	/**
	 * finds value of node with the minimal value relative to node
	 * @param node
	 * @return value of node with the minimal value relative to node
	 */
	public E minValue(TreeNode<E> node) {
		//traversing through nodes
        if(node.getLeft() != null) {
        	//calls minValue recursively with left node
            return minValue(node.getLeft());
        }
        //returns element of the lowest value node
        return node.getElement();
    }
	
	
	
	
	/**
	 * returns the TreeIterator that calls a method to print the tree in post order
	 * @return reference to a TreeIterator
	 */
	public TreeIterator<E> iteratorInPostOrder(){
		//as long as the tree has elements
		if(root!=null) {
			//initialize BaseBinaryTree with root value
			BaseBinaryTree<E> base=new BaseBinaryTree<E>(root);
			//if base isn't null
			if(base.getRoot()!=null) {
				//make tree iterator
				TreeIterator<E> iterator= new TreeIterator<E>(base);
				//call post order method
				iterator.setPostorder();
				//return iterator
				return iterator;
			}
		}
		//make iterator
		TreeIterator<E> iterator= new TreeIterator<E>(null);
		//return iterator
		return iterator;
		
	}
	
	/**
	 * returns the TreeIterator that calls a method to print the tree in pre order
	 * @return reference to a TreeIterator
	 */
	public TreeIterator<E> iteratorInPreOrder(){
		//as long as the tree has elements
		if(root!=null) {
			//initialize BaseBinaryTree with root value
			BaseBinaryTree<E> base=new BaseBinaryTree<E>(root);
			//if base isn't null
			if(base.getRoot()!=null) {
				//make tree iterator
				TreeIterator<E> iterator= new TreeIterator<E>(base);
				//call pre order method
				iterator.setPreorder();
				//return iterator
				return iterator;
			}
		}
		//make iterator
		TreeIterator<E> iterator= new TreeIterator<E>(null);
		//return iterator
		return iterator;
		
	}
	
	/**
	 * returns the TreeIterator that calls a method to print the tree in pre order
	 * @return reference to a TreeIterator
	 */
	public TreeIterator<E> iteratorInOrder(){
		//as long as the tree has elements
		if(root!=null) {
			//initialize BaseBinaryTree with root value
			BaseBinaryTree<E> base=new BaseBinaryTree<E>(root);
			//if base isn't null
			if(base!=null) {
				//make tree iterator
				TreeIterator<E> iterator= new TreeIterator<E>(base);
				//call set in order method
				iterator.setInorder();
				//return iterator
				return iterator;
				}
			}
		//make iterator
		TreeIterator<E> iterator= new TreeIterator<E>(null);
		//return iterator
		return iterator;
	}
	
	/**
	 * returns the root
	 * @return root
	 */
	public TreeNode<E> getRoot(){
		return root;
	}
	
	
	
	/**
	 * compareTo method
	 * @Override
	 */
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	
	/**
	 * returns the iterator
	 * @Override
	 * @return a reference to the TreeIterator
	 */
	public TreeIterator<E> iterator() {
		// TODO Auto-generated method stub
		//initializes base with root node
		BaseBinaryTree<E> base=new BaseBinaryTree<E>(root);
		//makes tree iterator
		TreeIterator<E> iterator= new TreeIterator<E>(base);
		//returns iterator
		return iterator;
	}

}
