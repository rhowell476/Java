public class workingwithnodes {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node nodeA = new Node(40);
        Node nodeB = new Node(20);
        Node nodeC = new Node(60);
        Node nodeD = new Node(10);
        Node nodeE = new Node(50);
        Node nodeF = new Node(55);

        nodeA.setChild(Node.Child.LEFT, nodeB);
        nodeA.setChild(Node.Child.RIGHT, nodeC);
        nodeB.setChild(Node.Child.LEFT, nodeD);
        nodeC.setChild(Node.Child.LEFT, nodeE);
        nodeE.setChild(Node.Child.RIGHT, nodeF);

        tree.insert(nodeA);
        System.out.println(BSTPrint.treeToString(tree.getRoot()));
    }
}
