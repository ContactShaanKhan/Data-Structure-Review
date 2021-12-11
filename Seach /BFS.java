import java.util.*;

class Node {
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
public class BFS {
    Node root;
    public BFS() {root = null;}

    public void BFSsearch(){
        Deque<Node> queue = new ArrayDeque<>();
        queue.push(root);

        while(!queue.isEmpty()){
            Node node = queue.removeLast();
            if(node.left != null){
                queue.push(node.left);
            }
            if(node.right != null){
                queue.push(node.right);
            }
            System.out.print(node.key);
        }
    }
    public static void main(String[] args){
        BFS tree = new BFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
            "Inorder traversal of binary tree is ");
        tree.BFSsearch();
    }
}