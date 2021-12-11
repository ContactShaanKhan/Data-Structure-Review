class Node {
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
public class Inorder {
    Node root;
    Inorder() {root=null;}

    public void printInorder(Node node){
        if(node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key+" ");
        printInorder(node.right);
    }
    public void printInorder(){ printInorder(root);}

    public static void main(String[] args)
    {
        Inorder tree = new Inorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
            "\nInorder traversal of binary tree is ");
        tree.printInorder();
 
    }
}