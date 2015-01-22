



public class Tree{
        /*
      AUthor: Dustin Hu
      Date: 13-01-2015
      Purpose: To be the tree class

      Methods:
          Tree: Creates the node, no parametrs
	  Tree: Creates the node, a value parameter
	  inOrder: Gets the string of the tree (In-ordered)
	  preOrder: Gets the string of the tree (Pre-ordered)
	  postOrder: Gets the string of the tree (Post-ordered);
	  height: Returns the height of the tree from the root
	  nodes: Gets the number of nodes below (including this one) the current tree
	  heightBalanced: Checks if the tree is height balanced 
	  perfectlyBalanced: Checks if this tree is perfectly balanced
	  breadthOrder: Gets the string in breadth order
	  inTree: Checks if a value is in the tree
	  add: Adds a new node
	  delete: Delets a node
	  isLeaf: Checks if this onde is a leaf
	  sibling: Returns the sibling of the given integer

	  rotateLeft: Rotates the tree left, given an address
	  rotateRight: Rotates the tree right, given an address
	  
	  find: Finds the node

	  rotateLeft: Rotates the tree left, given an integer
	  rotateRight: Rotates the tree right, given an integer

	  balance: Balances the tree

	  countNodesAtLevel: Counts the nodes at a target level
	  recursivelyCountNodesAtLevel: Recursively counts the nodes at a given level
	  
	  nodesAtLevel: Gets the  nodes at the target level
	  rNodesAtLevel: Gets the nodes at a target level recursively
	  getAllNodesSortedByLevel: Gets all the nodes, sorted by level

	  prettifyLevel: Prettifies a level
	  prettyPrint: Prettily prints the tree
	  integerPowers: Raises a base to an exponent and returns an integer
	  padInt: Pads an integer and returns a string
     Data fields:
         root: the root

	*/
    protected TreeNode root;

    
    public Tree(){
	// Author: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To create the tree
	// Input: None
	// Output: None
	this(0);
    }
    public Tree(int data){
	// Author: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To create the tree
	// Input: The value of the node
	// Output: None
	this.root = new TreeNode(data);

    }
    public String inOrder(){
	// AUthor: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To get the in order string of the Node
	// Input: None
	// Output: The string of the node, in the order of left-data-right
	return this.root.inOrder();
    }
    public String preOrder(){
	// AUthor: Dustin Hu
	// Date: 13-01-2015
	// Purpose: To get the pre order string of the Node
	// Input: None
	// Output: The string of the node, in the order of data-left-right
	return this.root.preOrder();

    }
    public String postOrder(){
	// Author: Dsutin Hu
	// Date: 14-01-2015
	// Purpose: To get the string of the node in post order
	// Input: None
	// OUtput: The string of this tree in post-order notation
	return this.root.postOrder();
	
    }
    public int height (){
	// Author: dusitn Hu
	// Date: 14-01-2015
	// Purpose: To get the height from this tree
	// Input: None
	// Output: The height from this node
	return this.recursiveHeight(this.root);

    }
    public int recursiveHeight(TreeNode input){
	// Author: Dustin Hu
	// Date: 23-01-2015
	// Purpose: To recursively get the height of this tree
	// Input: The node we're currently on
	// OUtput: An integer, the height
	int output = 0;
	int leftHeight;
	int rightHeight;
	if (input != null){
	    leftHeight = this.recursiveHeight(input.left);
	    rightHeight = this.recursiveHeight(input.right);
	    if (leftHeight > rightHeight){
		output = leftHeight + 1;
	    }
	    else{
		output = rightHeight + 1;
	    }
	}
	return output;
	
    }
    public int nodes(){
	// Author: Dustin Hu
	// Date: 14-01-2015
	// Purpose: To call the recursive node counter
	// Input: None
	// Output: The number of nodes in this tree
	return this.root.nodes();
    }
    public boolean heightBalanced(){
	// AutohR: Dustin Hu
	// Date: 15-01-2015
	// Purpoes: To check if this tree is height balanced
	// Input: None
	// Output: Boolean true if this is balanced, false if not
	return this.root.heightBalanced();
	    
    }
    public boolean perfectlyBalanced(){
	// Author; Dustin Hu
	// Date: 15-01-2015
	// Purpose: To check whetehr or not the tree is perfectly balanced
	// Input: None
	// Output: True if perfectly balanced, false if not
	return this.root.perfectlyBalanced();
    }
    public String breadthOrder(){
    	// Authr: DUsitn Hu
    	// Date: 15-01-2015
    	// Purpose: To get the string of the tree i nbreadth order
    	// Input: None
   	// Output: The string of the tre in breadth order
	return this.root.breadthOrder();
    }
    public boolean inTree(int input){
	// Author :Dustin Hu
	// Date: 16-01-2015
	// Purpose: To check if a value is in the tree
	// Input: The value to check for
	// OUtput: True if the value is in the tree, false otherwise
	return this.root.inTree(input);
    }
    public void add(int input){
	// Autohr: Dustin Hu
	// Date: 16-01-2015
	// Purpose: To add an integer
	// Input: The integer to add
	// Output: None
	this.root.add(input);
    }
    public void delete(int input){
	// Author: Dustin Hu
	// Date: 16-01-2015
	// Purpoes: To delete a node from the tree
	// Input: THe node to delete
	// OUtput: None
	this.root.delete(input);
    }
    public TreeNode sibling(int input){
	// Author: Dustin Hu
	// date: 19-01-2015
	// Purpoes: To get the sibling of the given integer
	// Input: The integer to find a sibling of
	// OUtput: Null if tehre is no sibling, otherwise the node's address
	return this.root.sibling(input);
    }

    private boolean rotateLeft(TreeNode pivot){
	// Author: Dustin Hu & Jacky Xao
	// Date: Jan 21 2015
	// Purpose: To rotate the pivot point left
	// Input: Node of the pivot point
	// Output: True if succesful rotation
	boolean rotate = false;
	
	if (pivot != null && pivot.right != null){
	    rotate = true;
	    boolean loop = true;
	    TreeNode newRoot = pivot.right;
	    TreeNode pivotNewRight = newRoot.left;
	    newRoot.left = pivot;
	    pivot.right = pivotNewRight;
	    
	    if (pivot == this.root){
		this.root = newRoot;
	    }
	    else{
		TreeNode parent = this.root;
		while (loop){
		    if (pivot.data > parent.data){
			if (pivot.data == parent.right.data){
			    loop = false;
			}
			else{
			    parent = parent.right;
			}
		    }
		    else if (pivot.data < parent.data){
			if (pivot.data == parent.left.data){
			    loop = false;
			}
			else{
			    parent = parent.left;
			}
		    }
		    else{
			parent = null;
		    }
		}
		if (pivot.data > parent.data){
		    parent.right = newRoot;
		}
		else{
		    parent.left = newRoot;
		}
	    }
	}
	return rotate;

    }
    private boolean rotateRight(TreeNode pivot){
	// Author: Dustin Hu & Jacky Xao
	// Date: Jan 21 2015
	// Purpose: To rotate the pivot point right
	// Input: Node of the pivot point
	// Output: True if succesful rotation
	boolean rotate = false;
	
	if (pivot != null && pivot.left != null){
	    rotate = true;
	    boolean loop = true;
	    TreeNode newRoot = pivot.left;
	    TreeNode pivotNewLeft = newRoot.right;
	    newRoot.right = pivot;
	    pivot.left = pivotNewLeft;
	    
	    if (pivot == this.root){
		this.root = newRoot;
	    }
	    else{
		TreeNode parent = this.root;
		while (loop){
		    if (pivot.data > parent.data){
			if (pivot.data == parent.right.data){
			    loop = false;
			}
			else{
			    parent = parent.right;
			}
		    }
		    else if (pivot.data < parent.data){
			if (pivot.data == parent.left.data){
			    loop = false;
			}
			else{
			    parent = parent.left;
			}
		    }
		    else{
			parent = null;
		    }
		}
		if (pivot.data > parent.data){
		    parent.right = newRoot;
		}
		else{
		    parent.left = newRoot;
		}
	    }
	}
	return rotate;

    }
    public TreeNode find(int input){
	// Author: Dustin hu
	// Date: 21-01-2015
	// Purpsoe: To find the tree node of the inptu
	// Input: the number to find
	// Output: A address if it exists, null otherwise
	TreeNode output = null;
	if (this.inTree(input)){
	    TreeNode current = this.root;
	    while (current.data != input){
		if (input > current.data){
		    current = current.right;
		}
		else{
		    current = current.left;
		}
	    }
	    output = current;
	}

	return output;
    }

    public boolean rotateLeft(int input){
	// Author: Dsutin Hu
	// Date: 21-01-2015
	// Purpose: To rotate the tree left
	// Input: The integer to rotate at
	// Output: False if not rotated or node does not exist
	boolean output = false;
	if (this.inTree(input)){
	    output = this.rotateLeft(this.find(input));
	}
	return output;
    }
    public boolean rotateRight(int input){
	// Author: Dsutin Hu
	// Date: 21-01-2015
	// Purpose: To rotate the tree right
	// Input: The integer to rotate at
	// Output: False if not rotated or node does not exist
	boolean output = false;
	if (this.inTree(input)){
	    output = this.rotateRight(this.find(input));
	}
	return output;
    }

    public void balance (){
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpose: To balance the tree
	// Input: None
	// Output: None
	this.recursivelyBalance(this.root);
    }
    private void recursivelyBalance(TreeNode input){
	// Author: dustin Hu
	// Date: 21-01-2015
	// Purpose: To recursively balance the tree
	// Input: The node to balance
	// Output: None
	if (input != null){
	    this.recursivelyBalance(input.left);
	    this.recursivelyBalance(input.right);

	    if ((this.recursiveHeight(input.left) - this.recursiveHeight(input.right)) > 1){
		if (this.recursiveHeight(input.left.left) < this.recursiveHeight(input.left.right)){
		    this.rotateLeft(input.left);
		}
		this.rotateRight(input);
		this.recursivelyBalance(input);
	    }
	    else if ((this.recursiveHeight(input.right) - this.recursiveHeight(input.left)) > 1){
		if (this.recursiveHeight(input.right.right) < this.recursiveHeight(input.right.left)){
		    if (this.recursiveHeight(input.right.right)< this.recursiveHeight(input.right.left)){
			this.rotateRight(input.right);
		    }
		    this.rotateLeft(input);
		    this.recursivelyBalance(input);
		    

		}
	    }

	}
    }

    public int countNodesAtLevel(int level){
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpose: To count the nodes at a certain level
	// Input: The level to count to
	// Output: The number of nodes at a certain level
	return recursivelyCountNodesAtLevel(this.root, 1, level);
    }
    private int recursivelyCountNodesAtLevel(TreeNode walk, int currentLevel, int targetLevel ){
	// Author: Dsutin Hu
	// Date: 21-01-2015
	// Purpose: To count the nodes at a certain level
	// Input: The node we're currently on, the current level we're on, and the target level
	// Output: 1 if we've found a node on the target level, 0 if we have'nt
	int output = 0;

	if (currentLevel != targetLevel){
	    if (walk.left != null){
		output = output + recursivelyCountNodesAtLevel(walk.left, currentLevel + 1, targetLevel);		
	    }
	    if (walk.right != null){
		output = output + recursivelyCountNodesAtLevel(walk.right, currentLevel + 1, targetLevel);		
	    }

	}
	else{
	    output = 1;
	}
	return output;
    }
    public Queue nodesAtLevel(int targetLevel){
	// author: Dustin Hu
	// Date: 21-01-2015
	// Purpose: To get the nodes at a level
	// Input: THe target level
	// Output: THe queue containing all the nodes, from left to right, on that level
	return this.rNodesAtLevel(root, 1, targetLevel);
    }
    private Queue rNodesAtLevel(TreeNode walk, int currentLevel, int targetLevel){
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpsoe: To get the nodes at a level in the form of a queue
	// Input: The current node, the int level, and the target level
	// OUtput: THe queue witha ll the nodes at a given level, all null nodes are represented with INTEGER.MIN_VALUE

	Queue output = new Queue();
	Queue leftQ;
	Queue rightQ;
	TreeNode a = null;
	if (currentLevel != targetLevel){
	    if (walk.left != null){
		output.add(rNodesAtLevel(walk.left, currentLevel + 1, targetLevel));
	    }
	    else{
		output.add(new TreeNode(Integer.MIN_VALUE));
	    }
	    if (walk.right != null){
		output.add( rNodesAtLevel(walk.right, currentLevel + 1, targetLevel));
	    }
	    else{
		output.add(new TreeNode(Integer.MIN_VALUE));
	    }
	}
	else{
	    // Because the current level is equal to the target level, we add the current node to the queue and return it
	    output.add(walk);
	}
	return output;
	
	
    }
    public Queue [] getAllNodesSortedByLevel() {
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpose: To get all the nodes sorted by level in an array
	// Input: None
	// Output: The queue [] holding all the nodes, where each index indicates the level
	Queue[] output = new Queue[this.height()];

	for (int i = 0; i < this.height() ; i++){
	    output[i]= this.nodesAtLevel(i + 1);
	}
	return output;
	    
    }
    private String prettifyLevel(Queue input, int currentLevel, int maxLevel){
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpsoe: To prettify a level's string
	// Input: The level's queue, the current level, the max level, the max size of the numbers
	// Output: A string with the prettified version of the current level. This works with the assumption that
	//         the largest number i the tree is double digit
	
	// The formula for the spaces are as follow:
	// Front spaces: (2 ^ (MaxHeight - CurrentLevel)) - 1
	// Middle spaces: (2 ^ ((MaxHeight - CurrentLevel) + 1)) - 1
	int current;
	int frontSpaces = this.integerPowers(2, (maxLevel - currentLevel)) - 1;
	int middleSpaces = this.integerPowers(2, ((maxLevel - currentLevel) + 1)) - 1;
	String output = "";
	String fSpace = "";
	String mSpace = "";
	String currentString;

	for (int i = 0; i < frontSpaces; i++){
	    fSpace = fSpace + "  ";
	}
	for (int i = 0; i < middleSpaces; i++){
	    mSpace = mSpace + "  ";
	}

	output = output + fSpace;

	while (!input.isEmpty()){
	    current = input.remove();
	    if (current != Integer.MIN_VALUE){
		currentString = this.padInt(2, current);
		output = output + currentString + mSpace;
	    }
	    else{
		output = output + "  " + mSpace;
	    }
	}
	return output;
    }
    public void prettyPrint(){
	// Author: Dustin Hu
	// Date: 21-01-2015
	// Purpose: To print out a tree prettily
	// Input: None
	// Output: None
	Queue[] temp = this.getAllNodesSortedByLevel();
	for (int i = 0; i < temp.length; i++){
	    System.out.println(this.prettifyLevel(temp[i], i + 1, this.height() ));
	    System.out.println("");
	}
    }
    public int integerPowers(int base, int exp){
	// author: DUstin Hu
	// DAte: 21-01-2015
	// Purpose: To get the integer power of a number
	// Input: The base and the exponent
	// Output: The integer power of the number
	int output = 1;
	for (int i = 0; i < exp; i++){
	    output = output * base;
	}
	return output;
    }
    public String padInt(int size, int input ){
	// author: Dustin Hu
	// Date: 22-01-2015
	// Purpose: To pad a integer to the right
	// INput: THe size to pad to, and the input number to pad
	// Output: The padded string
	String output = "";
	String inputString = String.valueOf(input);
	while ((output.length() + inputString.length()) < size ){
	    output = output + " ";
	}
	output = output + inputString;
	return output;
    }
    
}
