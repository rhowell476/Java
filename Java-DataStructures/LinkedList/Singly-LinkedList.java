class Node {
   public int data;
   public Node next;

   public Node(int initialData) {
      data = initialData;
      next = null;
   }
}

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
         m_tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   
   public void removeAfter(Node currentNode) {
      if (currentNode == null && m_head != null) {
         // Special case: remove head
         Node succeedingNode = m_head.next;
         m_head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             m_tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            m_tail = currentNode;
         }
      }
   }
   
   public void insertionSortSinglyLinked() {
      Node beforeCurrent = m_head;
      Node currentNode = m_head.next;
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
      Node positionB = m_head;
      while (positionB != null && dataValue > positionB.data) {
         positionA = positionB;
         positionB = positionB.next;
      }
      return positionA;
   }
}