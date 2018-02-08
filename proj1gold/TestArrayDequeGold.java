import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {
    StudentArrayDeque student = new StudentArrayDeque<Integer>();
    ArrayDequeSolution solution = new ArrayDequeSolution<Integer>();


    // for task 1
    /*
    @Test
    public void testDeque() {


        for (int i = 0; i <= 10; i++) {
            int first = StdRandom.uniform(10);

            student.addFirst(first);
            solution.addFirst(first);

        }

        //student.printDeque();
        //solution.printDeque();


        for (int i = 0; i <= 10; i++) {
            assertEquals(student.removeFirst(), solution.removeFirst());
        }


        for (int i = 0; i <= 10; i++) {
            int last = StdRandom.uniform(11, 20);

            student.addLast(last);
            solution.addLast(last);
        }


        //student.printDeque();
        //solution.printDeque();


        for (int i = 0; i <= 10; i++) {
            assertEquals(student.removeLast(), solution.removeLast());
        }

    }
*/

    // for task 2
    @Test
    public void testWithMsg() {
        StudentArrayDeque stu = new StudentArrayDeque<Integer>();
        ArrayDequeSolution sol = new ArrayDequeSolution<Integer>();

        for (int i = 0; i <= 10; i++) {
            int last = StdRandom.uniform(11, 20);

            stu.addLast(last);
            sol.addLast(last);

        }

        String msg = helper1(sol);
        for (int i = 0; i <= 10; i++) {

            Object expected = sol.removeLast();
            Object actual = stu.removeLast();

            assertEquals(helper(i, msg), expected, actual);
        }


    }

    private String helper1(ArrayDequeSolution<Integer> ads) {
        String newMsg;
        String res = "Oh noooo!\n   This is bad:\n   Related Operation:\n";

        for(int i = 0; i<10; i++) {
            newMsg = "   addLast(" + ads.get(i) + ");\n";
            res += newMsg;
        }

        return res;
    }

    private String helper(int len, String msg) {

        for (int i = 0; i<len; i++) {
            msg += "   removeLast();\n";
        }
        return msg;
    }

}
