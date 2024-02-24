package QueuePackage;

public class Register {
    private QueueInterface<Customer> queue;
    private double lastCustomerRemainingTime;
    private int lineLength;

    public Register() {
        queue = new ArrayQueue<>(); 
        lastCustomerRemainingTime = 0.0;
        lineLength = 0;
    }

    public void enqueue(Customer customer) {
        queue.enqueue(customer);
        lastCustomerRemainingTime = customer.getRemainingTime();
        lineLength++;
    }

    public Customer dequeue() {
        if (!isEmpty()) {
            lineLength--;
        }
        return queue.dequeue();
    }

    public Customer getFront() {
        return queue.getFront();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return lineLength >= 4;
    }

    public int getLineLength() {
        return lineLength;
    }

    public double getLastCustomerRemainingTime() {
        return lastCustomerRemainingTime;
    }
}
