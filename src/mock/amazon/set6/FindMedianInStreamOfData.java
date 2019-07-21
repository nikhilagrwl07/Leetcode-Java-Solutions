/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianInStreamOfData {

    public static void main(String[] args) {

        FindMedianInStreamOfData obj = new FindMedianInStreamOfData();
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());

        obj.addNum(6);
        System.out.println(obj.findMedian());

        obj.addNum(5);
        System.out.println(obj.findMedian());
    }

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public FindMedianInStreamOfData() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        double median = findMedian();
        if (num <= median) {

            // maxheap size is more
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
        } else if (num > median) {

            // maxheap size is more
            if (minHeap.size() <= maxHeap.size()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        int minheapPeek = 0;
        int maxheapPeek = 0;

        if (!minHeap.isEmpty()) {
            minheapPeek = minHeap.peek();
        }

        if (!maxHeap.isEmpty()) {
            maxheapPeek = maxHeap.peek();
        }


        return (minheapPeek + maxheapPeek) / 2.0;

    }
}
