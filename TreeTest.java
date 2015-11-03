import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TreeTest{
    // Author: dustin Hu
    // Date: 19-01-2015
    // Purpose: To demontstrate the tree class
    // Methods: Main: The main
    
    // Data fields: None

    public static void main (String [] args) throws IOException{
	// Author: Dustin Hu
	// Date: 19-01-2015
	// Purpose: To demonstrate the Tree clss
	// Input: None
	// Output: None


	boolean loop = true;
	BufferedReader input = new BufferedReader(
						  new InputStreamReader(System.in));
	String userInput;
	Tree tree = new Tree(52);
	tree.add(4);
	tree.add(19);
	tree.add(42);
	tree.add(82);
	tree.add(28);
	tree.add(41);
	tree.add(12);
	tree.add(92);

	tree.balance();
	tree.prettyPrint();
	// System.out.println("Hello, welcome to the Tree Tester");
	// while (loop){
	//     System.out.println("Your options are as follow: ");
	//     System.out.println("1) Print your tree in order");
	//     System.out.println("2) Print your tree post order");
	//     System.out.println("3) Print your tree pre order");
	//     System.out.println("4) Print your tree breadth order");
	//     System.out.println("5) Print out the height of you tree");
	//     System.out.println("6) Get the number of nodes in you tree");
	//     System.out.println("7) Check if your tree is height balanced");
	//     System.out.println("8) Check if your tree is perfecly balanced");
	//     System.out.println("9) Add a node to your tree");
	//     System.out.println("10) Delete a node from your tree");
	//     System.out.println("11) Get the sibling of a number (If it exists)");
	//     System.out.println("12) Balance the tree");
	//     System.out.println("13) View the tree in tree format");
	//     System.out.println("14) Exit");

	//     userInput = input.readLine();
	//     if (userInput.equals("1")){
	// 	System.out.println(tree.inOrder());
	//     }
	//     else if (userInput.equals("2")){
	// 	System.out.println(tree.postOrder());
	//     }
	//     else if (userInput.equals("3")){
	// 	System.out.println(tree.preOrder());
	//     }
	//     else if (userInput.equals("4")){
	// 	System.out.println(tree.breadthOrder());
	//     }
	//     else if (userInput.equals("5")){
	// 	System.out.println("Your tree is height of " + tree.height());
	//     }
	//     else if (userInput.equals("6")){
	// 	System.out.println("Your tree has " + tree.nodes() + " nodes");
	//     }
	//     else if (userInput.equals("7")){
	// 	System.out.println("Height balanced: " + tree.heightBalanced());
	//     }
	//     else if (userInput.equals("8")){
	// 	System.out.println("Perfectly balanced: " + tree.perfectlyBalanced());
	//     }
	//     else if (userInput.equals("9")){
	// 	tree.add(Integer.parseInt(input.readLine()));
	//     }
	//     else if (userInput.equals("10")){
	// 	tree.delete(Integer.parseInt(input.readLine()));
	//     }
	//     else if (userInput.equals("11")){
	// 	userInput = input.readLine();
	// 	System.out.println("The sibling of "+ userInput + " is " + tree.sibling(Integer.parseInt(userInput)));
	//     }
	//     else if (userInput.equals("12")){
	// 	tree.balance();
	//     }
	//     else if (userInput.equals("13")){
	// 	tree.prettyPrint();
	//     }
	//     else if (userInput.equals("14")){
	// 	loop = false;
	// 	System.out.println("Bye bye!");
		
	//     }
	//     else {
	// 	System.out.println("Invalid input. Please enter one of the following:");
	//     }



	//	}
	// }}
    }
}
