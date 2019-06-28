/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class KthLargestElementInArray215 {
    public static void main(String[] args) {
//        int[] a ={3,2,1,5,6,4};
//        int k = 2;


        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        KthLargestElementInArray215 ob = new KthLargestElementInArray215();
        int kthLargest = ob.findKthLargest(a, k);
        System.out.println(kthLargest);

    }

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        Comparator<Integer> c = (o1, o2) -> o1 - o2; // Minheap

        Queue<Integer> pq = new PriorityQueue<>(c);

        for (Integer i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
