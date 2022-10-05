

public class MaxQPQUse {
    public static void main(String[] args) throws PriorityQueueException {
        MaxPQClass<Integer> pq = new MaxPQClass<>();
        pq.insert(10,10);
        pq.insert(20,8);
        pq.insert(30,7);
        System.out.println("Element with max priority : " + pq.getMax());
        pq.insert(40,11);
        System.out.println("Element with max priority : " + pq.getMax());
        int removed = pq.removeMax();
        System.out.println("Removed element : " + removed);
        System.out.println("Element with max priority : " + pq.getMax());

    }
}
