import java.util.Scanner;

public class RedBlackTreeDemo {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
       
      System.out.print("Enter insert values with spaces between: ");
      String userValuesStr = scnr.nextLine();
      System.out.println();

      // Create an RedBlackTree object and add the values
      RedBlackTree tree = new RedBlackTree();
      for (String value : userValuesStr.split(" ")) {
         tree.insert(Integer.parseInt(value));
      }
  
      // Display the height and tree after all inserts are complete
      System.out.printf("Red-black tree with %d nodes has height %d\n", 
         tree.getLength(), tree.getHeight());
      System.out.println(RBTPrint.treeToString(tree.getRoot()));

      // Read user input to get a list of values to remove
      System.out.print("Enter remove values with spaces between: ");
      userValuesStr = scnr.nextLine();
      System.out.println();

      for (String value : userValuesStr.split(" ")) {
         int toRemove = Integer.parseInt(value);
         System.out.printf("Remove node %s: ", value);
         if (tree.remove(toRemove)) {
            System.out.printf("Red-black tree with %d nodes has height %d\n",
               tree.getLength(), tree.getHeight());
         }
         else {
            System.out.println("*** Key not found. Tree is not changed. ***");
         }
      }
      
      // Print the tree
      System.out.println(RBTPrint.treeToString(tree.getRoot()));
   }
}
