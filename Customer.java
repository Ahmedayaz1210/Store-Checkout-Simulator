package QueuePackage;

public class Customer {
    private double remainingTime;

    public Customer(double remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void updateRemainingTime(double time) {
        remainingTime -= time;
    }

    public double getRemainingTime() {
        return remainingTime;
    }
}