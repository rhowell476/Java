public class SortSinglyLinked {
   public static void main(String[] args) {
      int[] numbers = { 72, 91, 53, 12, 48, 19, 7, 1, 86 };
      
      // Initialize a new LinkedList
      LinkedList numList = new LinkedList();
      
      // Create and append nodes with the numbers
      for (int number : numbers) {
          Node node = new Node(number);
          numList.append(node);
      }

      // Output list
      System.out.print("List after adding nodes: ");
      numList.printList();

      // Sort the list
      numList.insertionSortSinglyLinked();

      // Output list
      System.out.print("List after insertion sort: ");
      numList.printList();
   }
}