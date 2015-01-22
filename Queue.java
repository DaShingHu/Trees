
public class Queue{
        /*
      Author: Dustin Hu
      Date: 08-10-2015
      Purpoes: To hold the linked list queue
      
      Methods:
          Queue: Creates a new Queue
	  isEmpty: Checsk if the queue is empty
	  remove: Removes a customer from the queue
	  customersWait: Adds one to the customer's wait times
	  toString: Gets the string of the Queue
	  add: Adds a customer to the queue
	  
      Fields:
          front: A customer, the root.
	  back: The last customer, the end of the list
    
    */
    protected Node front;
    protected Node back;
    
    public Queue(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create the linked list quee
	// Input: None
	// Output: None
	this.front = null;
	this.back = null;
    }
    public boolean isEmpty(){
	// AUtohr: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To check if the queue is empty
	// Input: None
	// OUtput: True if the queue is empty, false if not
	boolean output;
	if (front == null){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public int remove(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: Remove the front
	// Input: None
	// OUtput: THe value of front, null if empty
	int output;
	if (!this.isEmpty()){
	    output = this.front.data.data;
	    this.front = this.front.next;
	}
	else{
	    output = Integer.MIN_VALUE;
	}
	return output;

    }
    public void add(TreeNode input){
	// AUthor: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To add a node to the queue
	// Input: The treenode to add
	// None
	Node temp = new Node(input);
	if (this.isEmpty()){
	    this.front = temp;
	    this.back = temp;
	}
	else{
	    this.back.next = temp;
	    this.back = temp;
	}
    }
    public void add (Queue input){
	//A uthor: Dustin HU
	// Date: 21-01-2015
	// Purpose: To add one queue to the current queue
	// Input: The queue to add
	// Output: None
	while (!input.isEmpty()){
	    this.add(new TreeNode(input.remove()));
	}
    }
}
