package QueuePackage;


public class Store {
    private static final int NUM_REGS = 8;
    private static final double SERVICE_TIME = 5.5;
    private static final double ARRIVAL_TIME = 0.1;

    private Register[] registers;
    private int lost;
    private int served;

    public Store() {
        registers = new Register[NUM_REGS];
        for (int i = 0; i < NUM_REGS; i++) {
            registers[i] = new Register();
        }
        lost = 0;
        served = 0;
    }

    public void update() {
        // Update remaining times for every customer
        for (Register register : registers) {
            while (!register.isEmpty()) {
                Customer customer = register.getFront();
                customer.updateRemainingTime(ARRIVAL_TIME);
                if (customer.getRemainingTime() <= 0) {
                    register.dequeue();
                    served++; // Increment the served counter
                } else {
                    break; // No need to check other customers in the same register
                }
            }
        }

        // Find the register with the shortest line
        Register shortestLine = registers[0];
        for (Register register : registers) {
            if (register.getLineLength() < shortestLine.getLineLength()) {
                shortestLine = register;
            }
        }

        // Try to add a new customer to the shortest line
        if (shortestLine.isFull()) {
            lost++;
        } else {
            double remainingTime = shortestLine.isEmpty() ? SERVICE_TIME : shortestLine.getLastCustomerRemainingTime() + SERVICE_TIME;
            Customer newCustomer = new Customer(remainingTime);
            shortestLine.enqueue(newCustomer);
        }
    }


    public int getLostCustomers() {
        return lost;
    }

    public int getServedCustomers() {
        return served;
    }

    public static void main(String[] args) {
        Store store = new Store();
        double workdayHours = 16;
        double workdayMinutes = workdayHours * 60;
        int totalUpdates = (int) (workdayMinutes / ARRIVAL_TIME);

        for (int i = 0; i <= totalUpdates; i++) {
            store.update();
        }

        System.out.println("Served customers: " + store.getServedCustomers());
        System.out.println("Lost customers: " + store.getLostCustomers());
    }
}
