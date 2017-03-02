public class MyLinkedList<E>{
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public MyLinkedList(){
        head = new ListNode<E>(null);
        tail = new ListNode<E>(null);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
}
