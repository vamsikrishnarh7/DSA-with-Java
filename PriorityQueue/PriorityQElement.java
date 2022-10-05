/*
this class contains the structure of the priority queue which is implemented using Heap
the heap element contians two fields...one is value and another one is priority...and is implemented using the ArrayList 
*/


public class PriorityQElement<T>{
    T value;
    int priority;
    public PriorityQElement(T value, int priority){
        this.value = value;
        this.priority = priority;
    }
}
