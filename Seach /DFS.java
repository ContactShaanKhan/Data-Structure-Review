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
public class DFS {
    Node root;
    public DFS() {root = null;}

    public void DFSsearch(){
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        Node current = root;
        while(!stack.isEmpty()){
            // Drill down on left children
            while(current.left != null){
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            System.out.print(current.key);
            if(current.right != null) {
                current = current.right;                
                stack.push(current);
            }
        }
    }
    public static void main(String[] args){
        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
            "Inorder traversal of binary tree is ");
        tree.DFSsearch();
 
    }
}
