package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testArrayRingBuffer() {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        Integer e = 5;


        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);


        // test abstract
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());

        // test interface
        assertTrue(arb.isEmpty());


        arb.enqueue(a); // [1]
        arb.enqueue(b); // [1,2]
        assertEquals(a, arb.peek());
        arb.enqueue(c);
        arb.enqueue(d); // [1,2,3,4]
        arb.dequeue();
        arb.dequeue(); // [3,4]

        assertEquals(2, arb.fillCount);
        assertEquals(new Integer(3), arb.peek());


        for (int i = 0; i<7; i++) {
            arb.enqueue(e);
        }

        // [3,4,5,5,5,5,5,5,5]

        assertEquals(9,arb.fillCount());
        assertFalse(arb.isFull());

        for (int i = 0; i<5; i++) {
            arb.dequeue();
        }

        // [5,5,5,5]
        assertEquals(4,arb.fillCount());
        assertEquals(e,arb.peek());




    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
