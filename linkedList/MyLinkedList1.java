package textgen;

//import static org.junit.Assert.assertEquals;

import java.util.AbstractList;

//import javax.xml.soap.Node;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 * @return
	 */
	public boolean add(E element)
	{
//		 TODO: Implement this method
		if(element.equals(null)){
			throw new NullPointerException();
		}
		else{
			LLNode<E> tmp;
			tmp = new LLNode<E>(element, tail, tail.prev);
			tail.prev.next = tmp;
			tail.prev = tmp;
			size++;
			return true;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) 
	{
		// TODO: Implement this method
		// adding to an empty list
//		if (size==0 && index==0){
//			this.add(element);
//		}
		if (index>size||index<0){
			System.out.println("index out of range");
			throw new IndexOutOfBoundsException();
		}
		else if (element.equals(null)){
			throw new NullPointerException();
		}
		else{
			LLNode<E> tmp;
			if (index < size/2) {
				tmp = head;
				for (int i=0; i<=index; i++){
					tmp = tmp.next;
				}
			}
			else{
				tmp = tail;
				for (int i=size; i>index; i--){
					tmp = tmp.prev;
				}
			}
			LLNode<E> toInsert = new LLNode<E>(element, tmp, tmp.prev);
			tmp.prev.next = toInsert;
			tmp.prev = toInsert;
			size++;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{

		// TODO: Implement this method.
		if (index < 0 || index > size-1) {
			System.out.println("index out of bounds");
			throw new IndexOutOfBoundsException();
		}
		else if (this.size==0) {
			System.out.println("Empty List");
			throw new NullPointerException();
		}
		else {
			LLNode<E> tmp;
			if (index == 0){
				return head.next.data;
			}
			else if (index < size/2) {
				tmp = head;
				for (int i=0; i<=index; i++){
					tmp = tmp.next;
				}
			}
			else {
				tmp = tail;
				for (int i=size; i>index; i--){
					tmp = tmp.prev;
				}
			}
			return tmp.data;
		}
	}

	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (this.size==0) {
			System.out.println("Empty List");
			throw new NullPointerException();
		}
		else if (index < 0 || index > size-1) {
			System.out.println("index out of bounds");
			throw new IndexOutOfBoundsException();
		}
		else {
			LLNode<E> tmp;
			if (index < size/2){
				tmp = head;
				for(int i=0; i<=index; i++){
					tmp = tmp.next;
				}
			}
			else{
				tmp = tail;
				for(int i=size; i>index; i--){
					tmp = tmp.prev;
				}
			}
//			tmp.prev.next = tmp.next;
//			tmp.next.prev = tmp.prev;
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			tmp.prev = null;
			tmp.next = null;
			size --;
			return tmp.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(size==0){
			System.out.println("Empty List");
			throw new NullPointerException();
		}
		else if(index<0 || index>size-1){
			System.out.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}
		else if(element == null){
			System.out.println("element is null");
			throw new NullPointerException();
		}
		else {
			LLNode<E> tmp;
			E dataChanged;
			if (index< size/2){
				tmp = head;
				for (int i=0; i<=index; i++){
					tmp = tmp.next;
				}
			}
			else {
				tmp = tail;
				for (int i=size; i>index; i--){
					tmp = tmp.prev;
				}
			}
			dataChanged = tmp.data;
			tmp.data = element;
			return dataChanged;
		}
	}

//	public String toString(){}
//	public static void main(String[] args){
//		MyLinkedList<Integer> listx = new MyLinkedList<Integer>();
//		for (int i=0; i<100; i+=10){
//			listx.add(i);
//		}
//		for (int i=0; i<listx.size(); i++){
//			listx.remove(0);
//		}
//	}
}
class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E element)
	{
		data = element;
		prev = null;
		next = null;
	}
	
	public LLNode(E element, LLNode<E> next, LLNode<E> prev){
		data = element;
		this.prev = prev;
		this.next = next;

	}
}