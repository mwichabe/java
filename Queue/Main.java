package Queue;

import java.util.LinkedList;

import java.util.Queue;



class CustomerOrder {
    String customerName;

    String type;

    char size;

    public CustomerOrder(String customerName, String type, char size) {

        this.customerName = customerName;

        this.type = type;

        this.size = size;

    }
}



class QueueMantyper {

    private Queue<CustomerOrder> queue;



    public QueueMantyper() {
        queue = new LinkedList<>();
    }



    public void enqueue(CustomerOrder cutomerOrder) {
        queue.add(cutomerOrder);
    }

    public CustomerOrder dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public CustomerOrder peek() {
        return queue.peek();
    }

    public void printNextOrder() {
        if (!isEmpty()) {
            CustomerOrder nextOrder = peek();
            System.out.println("Next Order: " + nextOrder.customerName + ", " + nextOrder.type + ", " + nextOrder.size);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

}


public class Main {

    public static void main(String[] args) {

        QueueMantyper customerOrderQueue = new QueueMantyper();

        CustomerOrder order1 = new CustomerOrder("Smith", "Expresso", 'M');
        CustomerOrder order2 = new CustomerOrder("Martin", "Latte", 'L');
        CustomerOrder order3 = new CustomerOrder("Bob", "Cappuccino", 'S');
        
        // Adding orders to the queue
        customerOrderQueue.enqueue(order1);
        customerOrderQueue.enqueue(order1);
        customerOrderQueue.enqueue(order3);

        // Print next order without removing it
        customerOrderQueue.printNextOrder();

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + customerOrderQueue.isEmpty());

        // Removing the next order from the queue
        CustomerOrder removedOrder = customerOrderQueue.dequeue();
        if (removedOrder != null) {
            System.out.println("Removed Order: " + removedOrder.customerName + ", " + removedOrder.type + ", " + removedOrder.size);
        }

        // Check if the queue is not empty
        System.out.println("Is the queue not empty? " + customerOrderQueue.isNotEmpty());

    }

}