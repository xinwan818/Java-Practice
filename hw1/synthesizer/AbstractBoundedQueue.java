package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue <T>{
    protected int fillCount;
    protected int capacity;


    /*

    // can be omitted!
    public abstract T peek();

    public abstract T dequeue();

    public abstract void enqueue(T var1);

    */
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return  fillCount;
    }


}
