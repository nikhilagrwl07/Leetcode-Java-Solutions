package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */

import java.util.Collections;
import java.util.Comparator;
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
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {

//        Comparator<Integer> min = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };
//
//        Comparator<Integer> max = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        };

        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // reverse order means maxHeap
        this.minHeap = new PriorityQueue<>();   //default is minheap
    }

    public double findMedian() {

        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public void addNum(int element) {

        // first element insertion
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.add(element);
            return;
        }

        if (maxHeap.size() > minHeap.size()) {

            if (element > findMedian()) {
                minHeap.add(element);
            } else {

                int maxElement = maxHeap.poll();
                minHeap.add(maxElement);
                maxHeap.add(element);
            }
        } else if (maxHeap.size() < minHeap.size()) {

            if (element > findMedian()) {
                int minElement = minHeap.poll();
                maxHeap.add(minElement);
                minHeap.add(element);
            } else {
                maxHeap.add(element);
            }
        } else {
            if (element > findMedian()) {
                minHeap.add(element);
            } else {
                maxHeap.add(element);
            }
        }
    }
}
