// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer() {
        first = 0;
        last = 0;
        fillCount = 0;
        capacity = 0;

        rb = null;
    }

    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;

        rb = (T[]) new Object[capacity];

    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount < capacity) {
            rb[last] = x;
            fillCount += 1;
            last += 1;

            if (last >= capacity) {
                last = 0;
            }

        } else {
            throw new RuntimeException("Ring buffer overflow");
        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount > 0) {
             if (first < capacity - 1) {
                 T returnValue = rb[first];
                 rb[first] = null;
                 fillCount -= 1;
                 first += 1;

                 return returnValue;
             } else {
                T returnValue = rb[first];
                rb[first] = null;
                fillCount -= 1;
                first = 0;

                return returnValue;
            }
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.

        if (fillCount == 0) {
            throw new RuntimeException("Empty Queue!");
        } else {
            return rb[first];
        }


    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0;i<capacity;i++) {
            res += Double.toString( (Double) rb[i]);
            res+= ", ";
        }

        res += "]";

        return res;
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    private class ARBIter implements Iterator{
        private int ptr;
        public ARBIter() {
            ptr = first;
        }
        @Override
        public boolean hasNext() {
            return capacity > fillCount;
        }

        @Override
        public T next(){

            T returnValue =  (T) rb[ptr];
            if (ptr<rb.length-1 || ptr < first) {
                ptr++;
            } else if (ptr == rb.length-1) {
                ptr = 0;
            } else {
                throw new RuntimeException("No Iterator left!");
            }
            
            return returnValue;
        }
    }

    @Override
    public ARBIter iterator() {
        ARBIter it = this.new ARBIter();
        return it;

    }


}
