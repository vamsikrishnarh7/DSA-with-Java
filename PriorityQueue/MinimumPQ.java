
import java.util.ArrayList;

public class MininumPQ<T>{
    private ArrayList<PriorityQElement<T>> heap;
    public MininumPQ(){
        heap = new ArrayList<>();
    }
    public void insert(T value, int priority){
        PriorityQElement<T> element = new PriorityQElement<>(value,priority);
        heap.add(element);
        int childindex = heap.size()-1;
        int parentindex = (childindex-1)/2;
        while(childindex > 0){
            if(heap.get(parentindex).priority > heap.get(childindex).priority){
                PriorityQElement<T> temp = heap.get(childindex);
                heap.set(childindex,heap.get(parentindex));
                heap.set(parentindex,temp);
                childindex = parentindex;
                parentindex = (childindex-1)/2;
            }
            else return;
        }

    }
    public T getMin() throws PriorityQueueException {
        if(isEmpty()) throw new PriorityQueueException();
        return heap.get(0).value;
    }
    public T removeMin() throws PriorityQueueException {
        if(isEmpty()) throw new PriorityQueueException();

        T ans = heap.get(0).value;
        heap.set(0,heap.get(size()-1));
        heap.remove(size()-1);

        int parentindex = 0;
        int leftchildindex = 2*parentindex+1;
        int rightchildindex = leftchildindex+1;
        heap.remove(parentindex);
        while(leftchildindex < heap.size()){
            int minIndex = parentindex;
            if(heap.get(leftchildindex).priority < heap.get(minIndex).priority){
                minIndex = leftchildindex;
            }
            if(rightchildindex < heap.size() && (heap.get(rightchildindex).priority < heap.get(minIndex).priority)){
                minIndex = rightchildindex;
            }
            if(minIndex == parentindex) break;
            PriorityQElement<T> temp = heap.get(minIndex);
            heap.set(minIndex,heap.get(parentindex));
            heap.set(parentindex,temp);
            parentindex = minIndex;
            leftchildindex = 2*parentindex+1;
            rightchildindex = leftchildindex+1;
        }
        return ans;
    }
    public int size(){
        return heap.size();

    }
    public boolean isEmpty(){
        if(size()==0) return true;
        else return false;
    }
}
