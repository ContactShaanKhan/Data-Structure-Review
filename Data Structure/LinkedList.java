// "static void main" must be defined in a public class.
public class LinkedList {
    private Node head;
    
    public void addLastNode(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void addTargetNode(int targetValue, int newValue){
        Node newNode = new Node(newValue);
        if (head == null){
            head = newNode;
        }else{
            Node current = head;
            Node previous = null;
            while(current.value != targetValue){
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;
        }
    }
    
    public Node deletedLastNode(){
        Node current = head;
        Node previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    
    public Node deletedTargetNode(int value){
        Node current = head;
        Node previous = null;
        while (current.value != value){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }
    
    public String toString(){
        String temp = "";
        Node current = head;
        while (current != null){
            temp = temp + current.value;
            current = current.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList temp = new LinkedList();
        temp.addLastNode(1);
        temp.addLastNode(5);
        temp.addLastNode(7);
        temp.addLastNode(8);
        temp.addLastNode(9);
        System.out.println(temp.toString());
        //print 15789

        temp.addTargetNode(7, 6);
        System.out.println(temp.toString());
        //print 156789

        temp.deletedLastNode();
        System.out.println(temp.toString());
        //print 15678
        
        temp.deletedTargetNode(6);
        System.out.println(temp.toString());
        //print 1578
    }
}
class Node{
    public int value;
    public Node next;
    
    public Node(int value){
        this.value = value;
    }
}