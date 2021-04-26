package practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinMaxheap {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }

}

class MedianFinder {
    Queue<Integer> minHeap; // all element greater than current median
    Queue<Integer> maxHeap; // all element less than current median

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
    }

    public void addNum(int num) {

        double currentMedian = findMedian();

        if (num <= currentMedian) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        balance();

    }

    public void balance() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        if (maxHeapSize - minHeapSize > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeapSize - maxHeapSize > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int maxHeapElement = (maxHeap.size() == 0) ? 0 : maxHeap.peek();
        int minHeapElement = (minHeap.size() == 0) ? 0 : minHeap.peek();

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }

        return (double) (maxHeapElement + minHeapElement) / 2.0;
    }
}
