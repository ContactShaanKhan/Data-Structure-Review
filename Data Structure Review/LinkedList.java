class LLNode{
    public int value;
    public LLNode next;
    
    public LLNode(int value){
        this.value = value;
    }

    public LLNode(int value, LLNode next){
        this.value = value;
        this.next = next;
    }
}

// "static void main" must be defined in a public class.
public class LinkedList {
    private LLNode head;
    
    public void addLastNode(int value){
        LLNode newNode = new LLNode(value);
        if (head == null){
            head = newNode;
        }else{
            LLNode current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void addTargetNode(int targetValue, int newValue){
        LLNode newNode = new LLNode(newValue);
        if (head == null){
            head = newNode;
        }else{
            LLNode current = head;
            LLNode previous = null;
            while(current.value != targetValue){
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;
        }
    }

    public LLNode deletedLastNode(){
        LLNode current = head;
        LLNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    
    public LLNode deletedTargetNode(int value){
        LLNode current = head;
        LLNode previous = null;
        while (current.value != value){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }
    
    public String toString(){
        String temp = "";
        LLNode current = head;
        while (current != null){
            temp = temp + current.value + " -> ";
            current = current.next;
        }
        temp += " null";
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
