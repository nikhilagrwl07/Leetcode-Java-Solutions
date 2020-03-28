package leetcodeProblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfStreamData295 {
    public static void main(String[] args) {

//        int[] stream = {41, 35, 62, 5, 97, 108};
//        int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        int[] stream = {1, 2, 3};
        MedianFinder medianFinder = new MedianFinder();

        for (int i = 0; i < stream.length; i++) {
            medianFinder.addNum(stream[i]);
            System.out.println(medianFinder.findMedian());
        }

    }
}

class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    // Time - O(Log n) where n is total number of elements
    // Space - O(n)
    public void addNum(int num) {

        //first element
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        if (num <= findMedian()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        if (minHeap.size() < maxHeap.size())
            return maxHeap.peek();

        return (minHeap.peek() + maxHeap.peek()) / 2d;
    }

    public void balance() {
        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.offer(maxHeap.poll());
        }
    }
}
