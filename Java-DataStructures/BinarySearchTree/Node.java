class Node {
   public int key;
   public int level = 0; //value of the node's level
   public Node left;
   public Node right;

   public Node(int nodeKey) {
      key = nodeKey;
      left = null;
      right = null;
   }
}
