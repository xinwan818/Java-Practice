public class LinkedListDeque<Stuff> implements Deque <Stuff> {

    /** define node */
    public class LinkedListNode{
        public Stuff item;
        public LinkedListNode prev;
        public LinkedListNode next;


        public LinkedListNode(LinkedListNode n, Stuff x,LinkedListNode m){
            prev = n;
            next = m;
            item = x;
        }

    }


    private LinkedListNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new LinkedListNode(sentinel,null,sentinel);
        size = 0;
    }

    public LinkedListDeque(Stuff x){
        sentinel = new LinkedListNode(sentinel,null,sentinel);
        LinkedListNode newNode = new LinkedListNode(sentinel,x,sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        this.size+=1;
    }

    @Override
    public void addFirst(Stuff a){
        if(sentinel.next == null){
            sentinel.next = new LinkedListNode(sentinel,a,sentinel);
            sentinel.prev = sentinel.next;
        }else{
            LinkedListNode newNode = new LinkedListNode(sentinel,a,sentinel.next);
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        }

        size+=1;
    }

    @Override
    public void addLast(Stuff a){
        if(sentinel.next == null){
            sentinel.next = new LinkedListNode(sentinel,a,sentinel);
            sentinel.prev = sentinel.next;

        }else{
            LinkedListNode newNode = new LinkedListNode(sentinel.prev,a,sentinel);
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
        }

        size+=1;
    }

    @Override
    public Stuff removeFirst(){
        if (size == 0){
            return null;
        }
        Stuff returnValue = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size-=1;
        return returnValue;

    }

    @Override
    public Stuff removeLast(){
        if (this.size == 0){
            return null;
        }
        Stuff returnValue = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size-=1;

        return returnValue;
    }
/*
    public LinkedListNode get(LinkedListNode g){
        LinkedListNode ptr = sentinel;

        while(ptr != null) {
            if (ptr.item == g.item){
                return ptr;
            }
            ptr = ptr.next;
        }
        return null;

    }
*/

    @Override
    public Stuff get(int i){
        if (i>=size || size == 0){
            return null;
        }
        return find(sentinel.next,i);
    }

    private Stuff find(LinkedListNode n, int r){
        if(n == null){
            return null;
        }
        if (r==0){
            return n.item;
        }else{
            return find(n.next,r-1);
        }
    }


    @Override
    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size(){
        return this.size;
    }


    @Override
    public void printDeque(){
        LinkedListNode ptr = sentinel.next;

        while (ptr.item!=null){
            System.out.print(ptr.item);
            System.out.print(" ");
            ptr = ptr.next;
        }

    }
}
