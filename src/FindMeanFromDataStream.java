import java.util.*;

public class FindMeanFromDataStream {
    public PriorityQueue<Integer> first;
    public PriorityQueue<Integer> second;
    
    public FindMeanFromDataStream() {
        //max heap
        first = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
           public int compare(Integer i1, Integer i2) {
               return i2 - i1;
           }
        });
        //min heap, default
        second = new PriorityQueue<Integer>();
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        //default add to first queue, to avoid null case
         if (first.size() + second.size() == 0 || first.size() + second.size() == 1) {
             first.add(num);
         } else {
             //num is less than the max of the first half
             if (num <= first.peek()) {
                 first.add(num);
             } else {
                 second.add(num);
             }
         }
         // balance the two queues
         if (Math.abs(first.size() - second.size()) >= 2) {
             balance();
         }
    }
    
    public void balance() {
        //its already balanced
        if (Math.abs(first.size() - second.size()) < 2) {
            return;
        }
        
        if (first.size() > second.size()) {
            second.add(first.remove());
        } else {
            first.add(second.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (first.size() > second.size()){
            return (double)first.peek();
        } else if (first.size() < second.size()) {
            return (double)second.peek();
        } else {
            return (double)(first.peek() + second.peek()) / 2.0;
        }
    }
    // Your MedianFinder object will be instantiated and called as such:
    // MedianFinder mf = new MedianFinder();
    // mf.addNum(1);
    // mf.findMedian();
}
