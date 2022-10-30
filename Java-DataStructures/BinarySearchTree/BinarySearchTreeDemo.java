import java.util.Scanner;

public class BinarySearchTreeDemo {
   public static void main(String[] args) {
      //create new BST
      BinarySearchTree tree2 = new BinarySearchTree();
      tree2.insert(new Node(10));
      tree2.insert(new Node(5));
      tree2.insert(new Node(15));
      tree2.insert(new Node(18));
      tree2.insert(new Node(13));
      tree2.insert(new Node(7));
      tree2.insert(new Node(6));
      tree2.insert(new Node(14));

      
      //print the BST
      System.out.println("Initial tree:");
      System.out.println(BSTPrint.treeToString(tree2.getRoot()));
      

      //Traversals:
      Node tree2Root = tree2.getRoot();

      //print inorder traversal
      //System.out.println("In-order traversal: ");
      //tree2.inorder(tree2Root); 

      //print preorder traversal
      //System.out.println("Pre-order traversal: ");
      //tree2.preorder(tree2Root);

      //print postorder traversal
      System.out.println("Post-order traversal: ");
      tree2.postorder(tree2Root);
      

      System.out.print("search key: " + tree2.search(14).key);
   }
}
