/*
This is undebugged code!!!
Circled array deque


Circle idea refer to:
https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g1094ff4355_0_450
*/


import org.omg.CORBA.Object;

public class ArrayDeque<Stuff> {
    private Stuff[] items;
    private int size;
    private int arrayLen;
    private int nextStart;
    private int nextEnd;


    /* create empty deque*/
    public ArrayDeque() {
        items = (Stuff[]) new Object[8];
        size = 0;
        arrayLen = 8;
        nextStart = 7;
        nextEnd = 0;
    }

    public ArrayDeque(Stuff[] l) {
        size = l.length;
        if (size <= 8) {
            arrayLen = 8;
        } else if (size <= 16) {
            arrayLen = 16;
        } else{
            arrayLen = size * 2;
        }

        items = (Stuff[]) new Object[arrayLen];

        System.arraycopy(l,0,  items, 0, size);
        nextStart = arrayLen - 1;
        nextEnd = size;
    }

    private void  widen(int expect) {
        Stuff[] temp = items;
        int curtArrayLen = arrayLen;
        while (curtArrayLen < expect) {
            curtArrayLen *= 2;
        }
        items = (Stuff[]) new Object[curtArrayLen];
        System.arraycopy(temp, nextStart + 1, items, 0, arrayLen - nextStart - 1);
        System.arraycopy(temp, 0, items, arrayLen - nextStart, size - (arrayLen - nextStart - 1));

        nextStart = curtArrayLen - 1;
        nextEnd = size;
        arrayLen = curtArrayLen;
    }

    private void shorten() {
        Stuff[] temp = items;
        int curtArrayLen = size * 2;
        items = (Stuff[]) new Object[curtArrayLen];

        System.arraycopy(temp, nextStart+1, items, 0, arrayLen - nextStart - 1);
        System.arraycopy(temp, 0, items, arrayLen-nextStart, size - (arrayLen - nextStart - 1));

        nextStart = curtArrayLen-1;
        nextEnd = size;
        arrayLen = curtArrayLen;
    }

    public void addFirst(Stuff x) {
        if(size + 1 > arrayLen) {
            widen(size+1);
        }

        items[nextStart] = x;
        size += 1;
        nextStart -= 1;


    }

    public void addLast(Stuff x){
        if (size + 1 > arrayLen){
            widen(size + 1);
        }

        items[nextEnd] = x;
        size += 1;
        nextEnd += 1;

    }

    public Stuff removeFirst() {
        if(size == 0) {
            return null;
        }

        Stuff returnValue = items[0];
        Stuff[] temp = (Stuff[]) new Object[arrayLen];
        System.arraycopy(items,1, temp, 0, size - 1);
        size -= 1;
        items =  temp;

        if(size <= arrayLen / 4){
            shorten();
        }

        return returnValue;

    }

    public Stuff removeLast() {
        if (size == 0) {
            return null;
        }

        Stuff returnValue = items[size - 1];
        items[size]=null;
        size -= 1;

        if (size >= 16 && size <= arrayLen/4) {
            shorten();
        }

        return returnValue;

    }

    public Stuff get(int index) {
        if (index >= size) {
            return null;
        }
        return items[index];

    }



    public void printDeque() {
        for (int i = nextStart + 1; i < arrayLen; i++) {
            System.out.print(items[i]);
            System.out.print(' ');
        }

        for (int j = 0; j < size - (arrayLen - nextStart - 1) + 1; j++) {
            System.out.print(items[j]);
            System.out.print(' ');
        }
        System.out.println(' ');
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }



}
