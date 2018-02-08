import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String a = "peers";
        String b = "";
        String c = "a";
        String d = "abba";


        assertFalse(palindrome.isPalindrome(a));
        assertTrue(palindrome.isPalindrome(b));
        assertTrue(palindrome.isPalindrome(c));
        assertTrue(palindrome.isPalindrome(d));


        Deque A = palindrome.wordToDeque(a);
        Deque B = palindrome.wordToDeque(b);
        Deque C = palindrome.wordToDeque(c);
        Deque D = palindrome.wordToDeque(d);

        assertFalse(palindrome.isPalindrome(A));
        assertTrue(palindrome.isPalindrome(B));
        assertTrue(palindrome.isPalindrome(C));
        assertTrue(palindrome.isPalindrome(D));

    }

    @Test
    public void testOffOneP() {
        String a = "flake";
        String b = "aaa";

        assertTrue(palindrome.isPalindrome(a,offByOne));
        assertFalse(palindrome.isPalindrome(b,offByOne));
    }
}
