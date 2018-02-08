/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();


        // for normal palindromes
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        // for off-N palindromes
        System.out.println("#########################################################");
        System.out.println("Start Printing Off By 5 Words !");
        CharacterComparator cc = new OffByN(5);
        In in1 = new In("../library-sp18/data/words.txt");
        while (!in1.isEmpty()) {
            String word = in1.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
    }
}
