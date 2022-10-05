

public class MinimumPQUse {
    public static void main(String[] args) throws PriorityQueueException {
        MininumPQ<Integer> pq =  new MininumPQ<>();
        pq.insert(10,7);
        pq.insert(20,10);
        pq.insert(30,11);
        System.out.println(pq.getMin());
        pq.insert(40,5);
        System.out.println("No.of nodes in present in the PQ :" + pq.size());
        System.out.println("element with minimum priority in the PQ : " + pq.getMin());
        int removed = pq.removeMin();
        System.out.println("Removed element is : " + removed);
        System.out.println("Minimum priority element after removing " + removed +" : " + pq.getMin());
    }
}
