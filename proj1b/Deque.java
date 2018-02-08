public interface Deque <Stuff> {
    public void addFirst(Stuff item);

    public void addLast(Stuff item);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public Stuff removeFirst();
    public Stuff removeLast();
    public Stuff get(int index);

}
