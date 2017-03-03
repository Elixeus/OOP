public class MyLinkedList<E>{
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public MyLinkedList(){
        // use sentinel (null) nodes at the beginning and the end of the list
        head = new ListNode<E>(null);
        tail = new ListNode<E>(null);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public addFirst(E data){
        head = new ListNode<E>(data, head);
    }

    public addLast(E data){
        ListNode<E> tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new ListNode<E>(data, null);
    }

    public void insertAfter(E key, E toInsert){
        ListNode<E> tmp = head;
        while(tmp != null && tmp.data.equals(key)){
            tmp = tmp.next;
        }
        if (tmp != null){
            tmp.next = new ListNode<E>(toInsert, tmp.next);
            tmp.next.next.prev = tmp.next;
        }
    }
}
