class RedBlackTree {
   private RBTNode root;
   
   public RedBlackTree() {
      root = null;
   }
   
   public RBTNode getRoot() {
      return root;
   }
   
   public int getLength() {
      if (root == null) {
         return 0;
      }
      return root.count();
   }
   
   // Returns the height of this tree
   public int getHeight() {
      return getHeightRecursive(root);
   }

   private int getHeightRecursive(RBTNode node) {
      if (node == null) {
         return -1;
      }
      int leftHeight = getHeightRecursive(node.left);
      int rightHeight = getHeightRecursive(node.right);
      return 1 + Math.max(leftHeight, rightHeight);
   }
   
   public void insert(int key) {
      RBTNode newNode = new RBTNode(key, null, true, null, null);
      insertNode(newNode);
   }
   
   public void insertNode(RBTNode node) {
      // Begin with normal BST insertion
      if (root == null) {
         // Special case for root
         root = node;
      }
      else {
         RBTNode currentNode = root;
         while (currentNode != null) {
            if (node.key < currentNode.key) {
               if (currentNode.left == null) {
                  currentNode.setChild(RBTNode.Child.LEFT, node);
                  break;
               }
               else {
                  currentNode = currentNode.left;
               }
            }
            else {
               if (currentNode.right == null) {
                  currentNode.setChild(RBTNode.Child.RIGHT, node);
                  break;
               }
               else {
                  currentNode = currentNode.right;
               }
            }
         }
      }
      
      // Color the node red, then balance
      node.color = RBTNode.Color.RED;
      insertionBalance(node);
   }
   
   public void insertionBalance(RBTNode node) {
      // If node is the tree's root, then color node black and return
      if (node.parent == null) {
         node.color = RBTNode.Color.BLACK;
         return;
      }
        
      // If parent is black, then return without any changes
      if (node.parent.isBlack()) {
         return;
      }
    
      // References to parent, grandparent, and uncle are needed for remaining operations
      RBTNode parent = node.parent;
      RBTNode grandparent = node.getGrandparent();
      RBTNode uncle = node.getUncle();
        
      // If parent and uncle are both red, then color parent and uncle black, color grandparent
      // red, recursively balance  grandparent, then return
      if (uncle != null && uncle.isRed()) {
         parent.color = uncle.color = RBTNode.Color.BLACK;
         grandparent.color = RBTNode.Color.RED;
         insertionBalance(grandparent);
         return;
      }

      // If node is parent's right child and parent is grandparent's left child, then rotate left
      // at parent, update node and parent to point to parent and grandparent, respectively
      if (node == parent.right && parent == grandparent.left) {
         rotateLeft(parent);
         node = parent;
         parent = node.parent;
      }
      // Else if node is parent's left child and parent is grandparent's right child, then rotate
      // right at parent, update node and parent to point to parent and grandparent, respectively
      else if (node == parent.left && parent == grandparent.right) {
         rotateRight(parent);
         node = parent;
         parent = node.parent;
      }

      // Color parent black and grandparent red
      parent.color = RBTNode.Color.BLACK;
      grandparent.color = RBTNode.Color.RED;
                
      // If node is parent's left child, then rotate right at grandparent, otherwise rotate left
      // at grandparent
      if (node == parent.left) {
         rotateRight(grandparent);
      }
      else {
         rotateLeft(grandparent);
      }
   }
   
   // Performs a left rotation at the given node. Returns the
   // subtree's new root.
   public RBTNode rotateLeft(RBTNode node) {
      // Define a convenience pointer to the right child of the 
      // left child.
      RBTNode rightLeftChild = node.right.left;
        
      // Step 1 - the right child moves up to the node's position.
      // node is temporarily detached from the tree, but will be reattached
      // later.
      if (node.parent != null) {
         node.parent.replaceChild(node, node.right);
      }
      else { // node is root
         root = node.right;
         root.parent = null;
      }

      // Step 2 - the node becomes the left child of what used
      // to be node's right child, but is now node's parent. This will
      // detach rightLeftChild from the tree.
      node.right.setChild(RBTNode.Child.LEFT, node);
        
      // Step 3 - reattach rightLeftChild as the right child of node.
      node.setChild(RBTNode.Child.RIGHT, rightLeftChild);
        
      return node.parent;
   }
   
   // Performs a right rotation at the given node. Returns the
   // subtree's new root.
   public RBTNode rotateRight(RBTNode node) {
      // Define a convenience pointer to the left child of the 
      // right child.
      RBTNode leftRightChild = node.left.right;
        
      // Step 1 - the left child moves up to the node's position.
      // node is temporarily detached from the tree, but will be reattached
      // later.
      if (node.parent != null) {
         node.parent.replaceChild(node, node.left);
      }
      else { // node is root
         root = node.left;
         root.parent = null;
      }

      // Step 2 - the node becomes the right child of what used
      // to be node's left child, but is now node's parent. This will
      // detach leftRightChild from the tree.
      node.left.setChild(RBTNode.Child.RIGHT, node);
        
      // Step 3 - reattach leftRightChild as the right child of node.
      node.setChild(RBTNode.Child.LEFT, leftRightChild);
        
      return node.parent;
   }
   
   private void bstRemove(int key) {
      RBTNode node = search(key);
      bstRemoveNode(node);
   }

   private void bstRemoveNode(RBTNode node) {
      if (node == null) {
         return;
      }

      // Case 1: Internal node with 2 children
      if (node.left != null && node.right != null) {
         // Find successor
         RBTNode successorNode = node.right;
         while (successorNode.left != null) {
            successorNode = successorNode.left;
         }

         // Copy successor's key
         int successorKey = successorNode.key;

         // Recursively remove successor
         bstRemoveNode(successorNode);

         // Set node's key to copied successor key
         node.key = successorKey;
      }
      
      // Case 2: Root node (with 1 or 0 children)
      else if (node == root) {
         if (node.left == null) {
            root = node.left;
         }
         else {
            root = node.right;
         }
        
         // Make sure the new root, if non-null, has parent set to null
         if (root != null) {
            root.parent = null;
         }
      }
      
      // Case 3: Internal with left child only
      else if (node.left != null) {
         node.parent.replaceChild(node, node.left);
      }

      // Case 4: Internal with right child OR leaf
      else {
         node.parent.replaceChild(node, node.right);
      }
   }
   
   public boolean isNoneOrBlack(RBTNode node) {
      if (node == null) {
         return true;
      }
      return node.isBlack();
   }
   
   public boolean isNotNoneAndRed(RBTNode node) {
      if (node == null) {
         return false;
      }
      return node.isRed();
   }

   private void prepareForRemoval(RBTNode node) {
      if (tryCase1(node)) {
         return;
      }

      RBTNode sibling = node.getSibling();
      if (tryCase2(node, sibling)) {
         sibling = node.getSibling();
      }
      if (tryCase3(node, sibling)) {
         return;
      }
      if (tryCase4(node, sibling)) {
         return;
      }
      if (tryCase5(node, sibling)) {
         sibling = node.getSibling();
      }
      if (tryCase6(node, sibling)) {
         sibling = node.getSibling();
      }

      sibling.color = node.parent.color;
      node.parent.color = RBTNode.Color.BLACK;
      if (node == node.parent.left) {
         sibling.right.color = RBTNode.Color.BLACK;
         rotateLeft(node.parent);
      }
      else {
         sibling.left.color = RBTNode.Color.BLACK;
         rotateRight(node.parent);
      }
   }
   
   public boolean remove(int key) {
      RBTNode node = search(key);
      if (node != null) {
         removeNode(node);
         return true;
      }
      return false;
   }

   public void removeNode(RBTNode node) {
      if (node.left != null && node.right != null) {
         RBTNode predecessorNode = node.getPredecessor();
         int predecessorKey = predecessorNode.key;
         removeNode(predecessorNode);
         node.key = predecessorKey;
         return;
      }

      if (node.isBlack()) {
         prepareForRemoval(node);
      }
      bstRemove(node.key);

      // One special case if the root was changed to red
      if (root != null && root.isRed()) {
         root.color = RBTNode.Color.BLACK;
      }
   }
   
   // Searches for a node with a matching key. Does a regular
   // binary search tree search operation. Returns the node with the
   // matching key if it exists in the tree, or None if there is no
   // matching key in the tree.
   public RBTNode search(int desiredKey) {
      RBTNode currentNode = root;
      while (currentNode != null) {
         // Return the node if the key matches
         if (currentNode.key == desiredKey) {
            return currentNode;
         }
         
         // Navigate to the left if the search key is 
         // less than the node's key.
         else if (desiredKey < currentNode.key) {
            currentNode = currentNode.left;
         }
         
         // Navigate to the right if the search key is 
         // greater than the node's key.
         else {
            currentNode = currentNode.right;
         }
      }
      
      // The key was not found in the tree.
      return null;
   }

   private boolean tryCase1(RBTNode node) {
      if (node.isRed() || node.parent == null) {
         return true;
      }
      return false; // node case 1
   }
   
   private boolean tryCase2(RBTNode node, RBTNode sibling) {
      if (sibling.isRed()) {
         node.parent.color = RBTNode.Color.RED;
         sibling.color = RBTNode.Color.BLACK;
         if (node == node.parent.left) {
            rotateLeft(node.parent);
         }
         else {
            rotateRight(node.parent);
         }
         return true;
      }
      return false; // not case 2
   }
   
   private boolean tryCase3(RBTNode node, RBTNode sibling) {
      if (node.parent.isBlack() && sibling.areBothChildrenBlack()) {
         sibling.color = RBTNode.Color.RED;
         prepareForRemoval(node.parent);
         return true;
      }
      return false; // not case 3
   }
   
   private boolean tryCase4(RBTNode node, RBTNode sibling) {
      if (node.parent.isRed() && sibling.areBothChildrenBlack()) {
         node.parent.color = RBTNode.Color.BLACK;
         sibling.color = RBTNode.Color.RED;
         return true;
      }
      return false; // not case 4
   }
   
   private boolean tryCase5(RBTNode node, RBTNode sibling) {
      if (isNotNoneAndRed(sibling.left)) {
         if (isNoneOrBlack(sibling.right)) {
            if (node == node.parent.left) {
               sibling.color = RBTNode.Color.RED;
               sibling.left.color = RBTNode.Color.BLACK;
               rotateRight(sibling);
               return true;
            }
         }
      }
      return false; // not case 5
   }
   
   private boolean tryCase6(RBTNode node, RBTNode sibling) {
      if (isNoneOrBlack(sibling.left)) {
         if (isNotNoneAndRed(sibling.right)) {
            if (node == node.parent.right) {
               sibling.color = RBTNode.Color.RED;
               sibling.right.color = RBTNode.Color.BLACK;
               rotateLeft(sibling);
               return true;
            }
         }
      }
      return false; // not case 6
   }
}
