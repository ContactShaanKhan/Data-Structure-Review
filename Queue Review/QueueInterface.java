interface QueueInterface<T> {
    public void enqueue(T obj) throws IllegalAccessException;
    public T dequeue() throws IllegalAccessException;
    public T peek() throws IllegalAccessException;
    public boolean isfull();
    public boolean isempty();
    public int getCapacity();
    @Override
    public String toString();
}