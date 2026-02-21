import java.util.Iterator;
import java.util.ListIterator;

public class DoublyLinkedList<T> implements List<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		if (isEmpty()){
			tail = new Node(item);
			head = tail;
			numberOfElements++;
			return;
		}
		Node n = new Node(item, null, tail);
		tail.next = n;
		tail = n;
		numberOfElements++;
	}

	@Override
	public void addFirst(T item) {
		if (isEmpty()){
			head = new Node(item);
			tail = head;
			numberOfElements++;
			return;
		}
		Node n = new Node(item, head, null);
		head.previous = n;
		head = n;
		numberOfElements++;
	}

	@Override
	public T get(int position) {
		if (position < 0 || position > numberOfElements-1){
			return null;
		}
		Node n = head;
		for(int i = 0; i < position; i++){
			n = n.next;
		}
		return n.data;
	}

	@Override
	public void print() {
		if (isEmpty()){
			System.out.println("Empty List");
			return;
		}
		Node n = head;
		while(n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	@Override
	public void printBackwards() {
		if (isEmpty()){
			System.out.println("Empty List");
			return;
		}
		Node n = tail;
		while(n != null){
			System.out.print(n.data + " ");
			n = n.previous;
		}
		System.out.println();
	}

	@Override
	public boolean remove(T item) {
		if(isEmpty()){
			return false;
		}

		// handle case with only 1 item and we want to remove it
		if(numberOfElements == 1 && head.data == item){
			head = null;
			tail = null;
			numberOfElements = 0;
			return true;
		}
		
		// handle case if the head match
		boolean present = false;
		if (head.data == item){
			head.next.previous = null;
			head = head.next;
			present = true;
			numberOfElements--;
		}
		// go through rest of the list, stopping just before tail
		Node n = head;
		while(n.next != null){
			if (n.data == item){
				n.previous.next = n.next;
				n.next.previous = n.previous;
				present = true;
				numberOfElements--;
			}
			n = n.next;
		}

		// handle case if the tail match
		if (tail.data == item){
			tail.previous.next = null;
			tail = tail.previous;
			present = true;
			numberOfElements--;
		}
		return present;
	}

	@Override
	public boolean isEmpty() {
		return head == null || tail == null; 
	}

	@Override
	public int getLength() {
		return numberOfElements;
	
	}

	@Override
	public ListIterator<T> listIterator(int pos){
		return new LinkedListIterator(pos);
	}
	
	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}

	/*
	 Inner iterator class
	 */
	private class LinkedListIterator implements ListIterator<T>{
		private Node headNode = head;
		private Node tailNode = tail;
		private Node curNode = headNode;
		private int index = 0;

		public LinkedListIterator(int pos){
			index = pos;
			for (int i = 0; i < pos; i++){
				curNode = curNode.next;
			}
		}

		public void set(T data){
			curNode.data = data;
		}

		public int previousIndex(){
			return index-1;
		}

		public int nextIndex(){
			return index+1;
		}

		public T previous(){
			curNode = curNode.previous;
			return curNode.data;
		}

		public boolean hasPrevious(){
			return curNode != headNode;
		}

		public T next(){
			curNode = curNode.next;
			return curNode.data;
		}

		public boolean hasNext(){
			return curNode != tailNode;
		}

		public void remove(){
			return;
		}

		public void add(T data){
			return;
		}
	}


}

