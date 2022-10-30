class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
   }
   
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   
   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }
   
   public void insertionSortSinglyLinked() {
      Node beforeCurrent = head;
      Node currentNode = head.next;
      while (currentNode != null) {
         Node nextNode = currentNode.next;
         Node position = findInsertionPosition(currentNode.data);
         if (position == beforeCurrent)
            beforeCurrent = currentNode;
         else {
            removeAfter(beforeCurrent);
            if (position == null)
               prepend(currentNode);
            else
               insertAfter(position, currentNode);
         }
         currentNode = nextNode;
      }
   }

   public Node findInsertionPosition(int dataValue) {
      Node positionA = null;
      Node positionB = head;
      while (positionB != null && dataValue > positionB.data) {
         positionA = positionB;
         positionB = positionB.next;
      }
      return positionA;
   }
   
   // Added for Stack/Queue section
   public int getHeadData() {
      return head.data;
   }
}