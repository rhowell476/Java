// Node in a doubly-linked list
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

// Doubly-linked list
class LinkedList {
   private Node m_head;
   private Node m_tail;
    
   public LinkedList() {
      m_head = null;
      m_tail = null;
   }
    
   public void append(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         m_tail.next = newNode;
         newNode.previous = m_tail;
         m_tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else {
         newNode.next = m_head;
         m_head.previous = newNode;
         m_head = newNode;
      }
   }
   
   public void printList() {
      Node node = m_head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void insertAfter(Node currentNode, Node newNode) {
      if (m_head == null) {
         m_head = newNode;
         m_tail = newNode;
      }
      else if (currentNode == m_tail) {
         m_tail.next = newNode;
         newNode.previous = m_tail;
         m_tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
   }
   
   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;
      
      if (successor != null)
         successor.previous = predecessor;
         
      if (predecessor != null)
         predecessor.next = successor;
         
      if (currentNode == m_head)
         m_head = successor;
         
      if (currentNode == m_tail)
         m_tail = predecessor;
   }

   public void insertionSortDoublyLinked() {
      Node currentNode = m_head.next;
      while (currentNode != null) {
         Node nextNode = currentNode.next;
         Node searchNode = currentNode.previous;
         
         while (searchNode != null && searchNode.data > currentNode.data)
            searchNode = searchNode.previous;
      
         // Remove and re-insert currentNode
         remove(currentNode);
         if (searchNode == null) {
            currentNode.previous = null;
            prepend(currentNode);
         }
         else
            insertAfter(searchNode, currentNode);

         // Advance to next node
         currentNode = nextNode;
      }
   }
}