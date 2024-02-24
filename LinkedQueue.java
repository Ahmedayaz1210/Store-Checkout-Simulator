package QueuePackage;
import QueuePackage.EmptyQueueException;
import utils.Node;
public final class LinkedQueue<T> implements QueueInterface<T> {
	
	private Node <T> firstNode;
	private Node <T> lastNode;
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}

	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry,null);
		if(isEmpty()) {
			firstNode = newNode;
		}else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
		
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		T front = firstNode.getData();
		firstNode = firstNode.getNext();
		if(firstNode == null) {
			lastNode = null;
		}
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return lastNode == null && firstNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		
	}

}
