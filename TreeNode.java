

public class TreeNode {
    /*
      AUthor: Dustin Hu
      Date: 13-01-2015
      Purpose: To be the node class

      Methods:
          TreeNode: Creates the node, no parametrs
	  TreeNode: Creates the node, a value parameter
	  inOrder: Gets the string of the node (In-ordered)
	  preOrder: Gets the string of the node (Pre-ordered)
	  postOrder: Gets the string of the node (Post-ordered);
	  height: Returns the height of the tree from this node
	  nodes: Gets the number of nodes below (including this one) the current tree
	  heightBalanced: Checks if the tree is height balanced 
	  perfectlyBalanced: Checks if this tree is perfectly balanced
	  breadthOrder: Gets the string in breadth order
	  inTree: Checks if a value is in the tree
	  add: Adds a new node
	  delete: Delets a node
	  isLeaf: Checks if this onde is a leaf
	  sibling: Returns the sibling of the given integer
	  recurseInOrder: Gets the string of the node (In-ordered)
	  recursePreOrder: Gets the string of the node (Pre-ordered)
	  recursePostOrder: Gets the string of the node (Post-ordered)
	  recurseHeight: Gets the height of the tree from this node
	  recurseNodes: Gets the number of nodes (Including this one) in the current tree
	  recurseHeightBalanced: Checks to see if this tree is height balanced

	  rotateLeft: Rotates the tree left


      Data fields:
          data: An integer, the value
	  left: the left node
	  right: the right node
     */

    protected int data;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(){
	// Author: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To create the node
	// Input: None
	// Output: None
	this(0);
    }
    public TreeNode(int data){
	// Author: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To create the node
	// Input: The value of the node
	// Output: None
	this.data = data;
	this.left = null;
	this.right = null;
    }
    public String inOrder(){
	// AUthor: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To get the in order string of the Node
	// Input: None
	// Output: The string of the node, in the order of left-data-right
	return this.recurseInOrder();
    }
    public String preOrder(){
	// AUthor: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To get the pre order string of the Node
	// Input: None
	// Output: The string of the node, in the order of data-left-right
	return this.recursePreOrder();

    }
    public String postOrder(){
	// Author: Dsutin Hu
	// Date: 14-01-2015
	// Purpose: To get the string of the node in post order
	// Input: None
	// OUtput: The string of this tree in post-order notation
	return this.recursePostOrder();
	
    }
    public int height (){
	// Author: dusitn Hu
	// Date: 14-01-2015
	// Purpose: To get the height from this tree
	// Input: None
	// Output: The height from this node
	return this.recurseHeight();

    }
    public int nodes(){
	// Author: Dustin Hu
	// Date: 14-01-2015
	// Purpose: To call the recursive node counter
	// Input: None
	// Output: The number of nodes in this tree
	return this.recurseNodes();
    }
    public boolean heightBalanced(){
	// AutohR: Dustin Hu
	// Date: 15-01-2015
	// Purpoes: To check if this tree is height balanced
	// Input: None
	// Output: Boolean true if this is balanced, false if not
	return this.recurseHeightBalanced();
	    
    }
    public boolean perfectlyBalanced(){
	// Author; Dustin Hu
	// Date: 15-01-2015
	// Purpose: To check whetehr or not the tree is perfectly balanced
	// Input: None
	// Output: True if perfectly balanced, false if not
	return this.recursePerfectlyBalanced();
    } 
    public String breadthOrder(){
    	// Authr: DUsitn Hu
    	// Date: 15-01-2015
    	// Purpose: To get the string of the tree i nbreadth order
    	// Input: None
    	// Output: The string of the tre in breadth order

	String output = "";
	Queue temp = new Queue();
	temp.add(this);
	while (!temp.isEmpty()){
	    if (temp.front.data.left != null){
		temp.add(temp.front.data.left);
	    }
	    if (temp.front.data.right != null){
		temp.add(temp.front.data.right);
	    }
	    output = output + temp.remove() + " ";

	}
	return output;
    }
    public boolean inTree(int input){
	// Author :Dustin Hu
	// Date: 16-01-2015
	// Purpose: To check if a value is in the tree
	// Input: The value to check for
	// OUtput: True if the value is in the tree, false otherwise
	boolean output = false;
	boolean loop = true;
	TreeNode current = this;

	while (loop){
	    if (current == null){
		loop = false;
		output = false;
	    }
	    else if (current.data == input){
		loop = false;
		output = true;
	    }
	    else{
		if (input > current.data){
		    current = current.right;
		}
		else{
		    current = current.left;
		}
	    }
	}
	return output;
    }
    public void add(int input){
	// Autohr: Dustin Hu
	// Date: 16-01-2015
	// Purpose: To add an integer
	// Input: The integer to add
	// Output: None
	if (!this.inTree(input)){
	    if (input >= this.data && this.right != null){
		this.right.add(input);
	    }
	    else if (input < this.data && this.left != null){
		this.left.add(input);
	    }
	    else {
		if (input >= this.data){
		    this.right = new TreeNode(input);
		}
		else{
		    this.left = new TreeNode(input);
		}
	    }
	}
    }
    public void delete(int input){
	// Author: Dustin Hu
	// Date: 16-01-2015
	// Purpoes: To delete a node from the tree
	// Input: THe node to delete
	// OUtput: None
	TreeNode previous = this;
	TreeNode current = this;
	TreeNode leftRightMost;
	TreeNode leftRightMostPrevious;
	if (this.inTree(input)){
	    while (current.data != input){
		if (input > current.data){
		    previous = current;
		    current = current.right;
		}
		else if (input < current.data){
		    previous = current;
		    current = current.left;
		}
	    }
	    if (current.isLeaf()){
		if (input > previous.data){
		    previous.right = null;
		}
		else{
		    previous.left = null;
		}
	    }
	    else if (current.left == null || current.right == null){
		if (input > previous.data){
		    // If the input is greater than the previous node's data, then the previous node's right node
		    // Will be set to the child of thecurrent node 
		    if (current.left == null){
			previous.right = current.right;
		    }
		    else{
			previous.right = current.left;
		    }

		}
		else{
		    if (current.left == null){
			previous.left = current.right;
		    }
		    else{
			previous.left = current.left;
		    }
		}
		
		
	    }
	    else{
		if (current.left.right == null){
		    if (input > previous.data){
			previous.right = current.left;
			previous.right.right = current.right;
		    }
		    else{
			previous.left = current.left;
			previous.left.right = current.right;
		    }
		}
		else{
		    leftRightMost = current;
		    leftRightMostPrevious = leftRightMost;
		    while (!leftRightMost.isLeaf()){
			leftRightMostPrevious = leftRightMost;
			leftRightMost = leftRightMost.right;
		    }
		    leftRightMostPrevious.right = null;
		    leftRightMost.left = current.left;
		    leftRightMost.right = current.right;
		    if (input > previous.data){
			previous.right = leftRightMost;
		    }
		    else{
			previous.left = leftRightMost;
		    }
		}
	    }
	}
    }
    public boolean isLeaf(){
	// Author: Dustin Hu
	// Date: 19-01-2015
	// Purpoes: To chec kif this onde is a leaf
	// Input: None
	// Output: True if this node is a leaf, false if it's not-
	boolean output = false;
	if (this.left == null && this.right == null){
	    output = true;
	}
	return output;
    }
    public TreeNode sibling(int input){
	// Author: Dustin Hu
	// date: 19-01-2015
	// Purpoes: To get the sibling of the given integer
	// Input: The integer to find a sibling of
	// OUtput: Null if tehre is no sibling, otherwise the node's address
	TreeNode output = null;
	TreeNode previous = this;
	boolean loop = true;
	if (this.inTree(input)){
	    while (loop){
		if (input > previous.data ){
		    if (input == previous.right.data){
			loop = false;
			output = previous.left;
		    }
		    else{
			previous = previous.right;
		    }
		}
		else{
		    if (input == previous.left.data){
			loop = false;
			output = previous.right;
		    }
		    else{
			previous = previous.left;
		    }
		}
	    }
	    
	}
	return output;
    }
    private String recurseInOrder(){
	// AUthor: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To get the in order string of the Node
	// Input: None
	// Output: The string of the node, in the order of left-data-right
	String output = "(";

	if (this.left == null && this.right == null){
	    output = output + "null - " + this.data + " - null)";
	}
	else if (this.left == null && this.right != null){
	    output = output + "null - " + this.data + " - " + this.right.inOrder() + ")";
	}
	else if (this.left != null && this.right == null){
	    output = output + this.left.inOrder() + " - " + this.data + " - null)";
	}
	else{
	    output = output + this.left.inOrder() + " - " + this.data + " - " + this.right.inOrder() + ")";
	}
	return output;
    }
    private String recursePreOrder(){
	// Autohr: dusitn Hu
	// Date: 13-01-2015
	// Purpose: To get the pre-ordered sttring of the node
	// Input: None
	// output: The string of the node, in the order of data-left-right
	String output = "(Root: " + this.data + ", L: ";
	if (this.left == null && this.right == null){
	    output = output + "null, R: null)";
	}
	else if (this.left == null && this.right != null){
	    output = output + "null, R: " + this.right.preOrder() + ")";
	}
	else if (this.left != null && this.right == null){
	    output = output + this.left.preOrder() + ", R: null)";
	}
	else{
	    output = output + this.left.preOrder() + ", R: " + this.right.preOrder() + ")";
	}
	return output;
    }
    private String recursePostOrder(){
	// AUthor: Dustin Hu
	// Date: 14-01-2015
	// Purpoes: To get the sting of the node in post-order using recursion
	// Input: Nonne
	// Output: The string of this tree in post-order notaiton
	String output = "(L: ";
	if (this.left == null && this.right == null){
	    output = output + "null, R: null, Root: " + this.data ;
	}
	else if (this.left != null && this.right == null){
	    output = output + this.left.preOrder() + ", R: null, Root: " + this.data;
	}
	else if (this.left == null && this.right != null){
	    output = output + "null, R: " + this.right.preOrder() + ", Root: " + this.data;
	}
	else{
	    output = output + this.left.preOrder() + ", R: " + this.right.preOrder() + ", Root: " + this.data;
	}
	output = output + ")";

	return output;
    }
    private int recurseHeight (){
	// Author: dusitn Hu
	// Date: 14-01-2015
	// Purpose: To get the height from this tree
	// Input: None
	// Output: The height from this node
	int output = 1;

	if (this.left == null && this.right == null){
	}
	else if (this.left == null && this.right != null){
	    output = output + this.right.height();
	}
	else if (this.left != null && this.right == null){
	    output = output + this.left.height();
	}
	else{
	    if (this.left.height() > this.right.height()){
		output = output + this.left.height();
	    }
	    else{
		output = output + this.right.height();
	    }
	}
	return output;

    }
    private int recurseNodes(){
	// Author: Dusitn Hu
	// Date: 14-01-2015
	// Purpose: To count the nodes
	// Input: None
	// OUtput: The number of nodes in this tree
	int output = 1;
	if (this.left != null){
	    output = output + this.left.nodes();
	}
	if (this.right != null){
	    output = output + this.right.nodes();
	}
	return output;
    }
    private boolean recurseHeightBalanced(){
	// Author: Dustin Hu
	// Date: 15-01-2015
	// Purpose: To recursively see if this tree is height balanced
	// Input: None
	// Output: True if height balanced, false if not.
	boolean output = true;
	if(this.left == null && this.right == null){
	}
	else if (this.left != null && this.right == null){
	    if (this.left.height() > 1){
		output = false;
	    }
	}
	else if (this.left == null && this.right != null){
	    if (this.right.height() > 1){
		output = false;
	    }
	}
	else {
	    if (!this.left.heightBalanced() || !this.right.heightBalanced()){
		output = false;
	    }
	    else if (this.left.height() - this.right.height() > 1){
		output = false;
	    }
	    else if (this.right.height() - this.left.height() > 1){
		output = false;
	    }
	}
	return output;
	
    }
    private boolean recursePerfectlyBalanced(){
	// Author: Dustin Hu
	// Date: 15-01-2015
	// Purpsoe: To recurse to see if this tree is perfectly balanced
	// Input: None
	// Output: Boolean true if the tree is perfetly balanced, false if not
	boolean output = true;
	if (this.left == null && this.right == null){
	}
	else if (this.left != null && this.right == null){
	    if (this.left.nodes() > 1){
		output = false;
	    }
	}
	else if (this.left == null && this.right != null){
	    if (this.right.nodes()> 1){
		output = false;
	    }
	}
	else{
	    if (!this.left.perfectlyBalanced() || !this.right.perfectlyBalanced()){
		output = false;
	    }
	    else if (this.left.nodes() - this.right.nodes() > 1){
		output = false;
	    }
	    else if (this.right.nodes() - this.left.nodes() > 1){
		output = false;
	    }
	}
	return output;
    }

}
