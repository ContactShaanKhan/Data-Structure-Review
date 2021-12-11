public class Queue  {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;
    
    public Queue() {
        front = -1;
        rear = -1;
    }
    
    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
          return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        if (front == -1)
          return true;
        else
          return false;
    }
    
    public void enQueue(int element){
        if (isFull()) {
          System.out.println("Queue is full");
        }
        else {
          if (front == -1) {
            front = 0;
          }
          rear++;
          // insert element at the rear
          items[rear] = element;
          System.out.println("Insert " + element);
        }
    }
    
    public int deQueue() {
        int element;
        if (isEmpty()) {
          System.out.println("Queue is empty");
          return (-1);
        }
        else {
          element = items[front];
          if (front >= rear) {
            front = -1;
            rear = -1;
          }
          else {
            front++;
          }
          System.out.println( element + " Deleted");
          return (element);
        }
    }
    
    public void display(){
        String temp = "";
        for (int i = front; i<= rear; i++)
            temp = temp + items[i];
        System.out.println(temp);
    } 
    public static void main(String[] args) {
        Queue q = new Queue();
        q.deQueue();

        for(int i = 1; i < 6; i ++) {
          q.enQueue(i);
        }
        q.enQueue(6);

        q.display();

        q.deQueue();

        q.display();

  }
}
