class Node {
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
public class Preorder {
    Node root;
    Preorder() {root=null;}

    public void printPreorder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");

        printPreorder(node.left);
 
        printPreorder(node.right);
    }
    public void printPreorder() { printPreorder(root); }

    public static void main(String[] args)
    {
        Preorder tree = new Preorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
            "Preorder traversal of binary tree is ");
        tree.printPreorder();
 
    }
}