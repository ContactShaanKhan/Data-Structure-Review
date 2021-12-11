// "static void main" must be defined in a public class.
public class Stack {
    Node root;
    
    public boolean isEmpty(){
        if (root == null) 
            return true;
        else
            return false;
    }
    
    public void push(int data){
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        }
        else {
            Node temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }
    
    public int pop(){
        int popped = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = root.value;
            root = root.next;
        }
        return popped;
    }
    
    public int peek()
    {
        if (root == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return root.value;
        }
    }
    
    public static void main(String[] args) {
        Stack sll = new Stack();
        
        sll.push(10);
        sll.push(20);
        sll.push(30);
 
        System.out.println(sll.pop()
                           + " popped from stack");
 
        System.out.println("Top element is " + sll.peek());
    }
}
class Node{
    public int value;
    public Node next;
    
    public Node(int value){
        this.value = value;
    }
}
