public class Palindrome {

    public Deque <Character> wordToDeque(String word) {
        int len = word.length();

        if (len == 0) {
            return new LinkedListDeque();
        }

        Deque head = new LinkedListDeque(word.charAt(0));

        for (int i = 1; i < len; i++) {
            head.addLast(word.charAt(i));
        }
        return head;
    }

    // for task 3a
    public boolean isPalindrome(String word) {
        int len = word.length();

        if (len == 0 || len == 1) {
            return true;
        }

        int r = len -1;
        int l = 0;

        while (r>l) {
            if (word.charAt(r) != word.charAt(l)) {
                return false;
            }

            r -= 1;
            l += 1;

        }

        return true;
    }


    //  for task 3b
    public boolean isPalindrome(Deque<Character> d) {
        int len = d.size();

        if (len == 0 || len == 1) {
            return true;
        }

        Character first = d.removeFirst();
        Character last = d.removeLast();
        boolean isP = true;

        if (first != last) {
            return false;
        } else {
            isP = isPalindrome(d);
        }

        return isP;

    }

    // for task 4

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();

        if (len == 0 || len ==1) {
            return true;
        }

        int l = 0;
        int r = len - 1 ;

        while (l < r) {
            if (cc.equalChars(word.charAt(l), word.charAt(r))) {
                l += 1;
                r -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
