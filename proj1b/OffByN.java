public class OffByN implements CharacterComparator {
    private int offNum;

    public OffByN(int x) {
        offNum = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == offNum || diff == (-1) * offNum) {
            return true;
        } else {
            return false;
        }
    }
}
