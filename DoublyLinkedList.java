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
		// TODO 
			
	}

	@Override
	public void addFirst(T item) {
		// TODO 
		
			
	}

	@Override
	public T get(int position) {
		// TODO 
		return null; 
	}

	@Override
	public void print() {
		// TODO
				
	}

	@Override
	public void printBackwards() {
		// TODO 
			
	}

	@Override
	public boolean remove(T item) {
		// TODO 
	
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return true; 
	}

	@Override
	public int getLength() {
		// TODO 
	
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


}

