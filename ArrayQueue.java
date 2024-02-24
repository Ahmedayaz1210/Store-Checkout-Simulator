package QueuePackage;
import QueuePackage.EmptyQueueException;
public final class ArrayQueue<T> implements QueueInterface<T> {
	
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean integrityOK;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings ("unchecked")
	public ArrayQueue (int capacity) {
		T[] temp = (T[]) new Object [capacity];
		queue = temp;
		this.capacity = capacity;
		frontIndex = 0;
		backIndex = capacity - 1;
	}

	

	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		backIndex = (backIndex+1)%capacity;
		queue[backIndex] = newEntry;
		if(isFull()) {
			ensureCapacity();
		}
	}

	@Override
	public T dequeue() {
		if (isEmpty ())
			throw new EmptyQueueException ("Empty queue: cannot dequeue");
		T front = queue [ frontIndex] ;
		queue [ frontIndex] = null; // mark for garbage
			//collection
		frontIndex = (frontIndex +1) % capacity;
		if (isEmpty () ) {
			frontIndex = 0;
			if (capacity > DEFAULT_CAPACITY )
			capacity = DEFAULT_CAPACITY;
			queue = (T[]) new Object[capacity];
			backIndex = capacity - 1;
		}
		return front;
	}

	@Override
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontIndex == (backIndex + 1)%capacity;
	}
	
	private boolean isFull() {
		return (frontIndex == (backIndex + 2)%capacity);
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
		
	}
	
	private void ensureCapacity() {
		T[] oldQueue = queue;
		T[] temparray = (T[]) new Object[2*capacity];
		int index;
		for (index = 0; index < capacity; index ++){
		temparray[index] = oldQueue[(frontIndex + index)%capacity ];
		}
		frontIndex = 0;
		backIndex = capacity - 2;
		capacity *= 2;
		queue = temparray;
		}

}
