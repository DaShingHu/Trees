
public class Node{

    /*
      Author: Dustin Hu
      Date: 08-01-2015
      Purpose: To be the Node
      
      Methods:
          Constructor: Cerates the Node, with no parameters
	  Consturctor: Creates the Node with the parameter of max order time
	  toSTring: Gets the string of the Node
      Fields:
          orderTime: An integer between 1 and x
	  waitTime: The time the customer has to wait
	  next: The next customer in line
     */
    protected TreeNode data;
    protected Node next;

    public Node(){
	// Author: Dsutin Hu
	// Date: 08-01-2015
	// Purpose: To ceraet the customer with no parameters
	// Input: None
	// Output: None
	this.data = null;
	this.next = null;
    }
    public Node(TreeNode input){
	// Author: Dsutin Hu
	// Date: 08-01-2015
	// Purpose: To ceraet the customer with no parameters
	// Input: The order time
	// Output: None
	this.data = input;
	this.next = null;
    }

	
}
