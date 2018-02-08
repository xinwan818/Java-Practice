import org.omg.CORBA.Object;

/*
This is undebugged code!!!
non-circled array deque

*/

public class ArrayDeque<Stuff> {
    private Stuff[] items;
    private int size;
    private int arrayLen;


    /* create empty deque*/
    public ArrayDeque(){
        items = (Stuff[]) new Object[8];
        size = 0;
        arrayLen = 8;
    }

    public ArrayDeque(Stuff[] l){
        size = l.length;
        items = (Stuff[]) new Object[size];

        for(int i = 0;i<size;i++){
            items[i] = l[i];
        }
    }

    private void  widen(int expect){
        Stuff[] temp = items;
        while(arrayLen<expect){
            arrayLen *= 2
        }
        items = (Stuff[]) new Object[arrayLen];
        System.arraycopy(temp,0,items,0,size-1);

    }

    private void shorten(){
        arrayLen = size*2;
        Stuff[] temp = (Stuff[]) new Object[arrayLen];
        System.arraycopy(items,0,temp,0,size);
        items = temp;
    }

    public void addFirst(Stuff x) {
        if(size+1>arrayLen){
            widen(size+1);
        }
        Stuff[] temp = (Stuff[]) Object[arrayLen];
        temp[0] = x;
        System.arraycopy(items,1,temp,0,size);
        size+=1;
        items =  temp;

    }

    public addLast(Stuff x){
        if(size+1>arrayLen){
            widen(size+1);
        }

        items[size] = x;
        size+=1;

    }

    public Stuff removeFirst(){
        if(size==0){
            return null;
        }

        Stuff returnValue = items[0];
        Stuff[] temp = (Stuff[]) Object[arrayLen];
        System.arraycopy(items,1,temp,0,size-1);
        size-=1;
        items =  temp;

        if(size<=arrayLen/4){
            shorten();
        }

        return returnValue;

    }

    public Stuff removeLast(){
        if(size==0){
            return null;
        }

        Stuff returnValue = items[size-1];
        items[size]=null;
        size-=1;

        if(size>=16 && size<=arrayLen/4){
            shorten();
        }

        return returnValue;

    }

    public Stuff get(int index){
        if(index>=size){
            return null;
        }
        return items[index];

    }



    public void printDeque(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }



}
