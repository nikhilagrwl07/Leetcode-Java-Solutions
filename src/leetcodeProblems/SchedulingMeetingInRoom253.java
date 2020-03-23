package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SchedulingMeetingInRoom253 {
    public static void main(String[] args) {
//        int[][] meeting = {{0, 30}, {15, 20}, {5, 10}};
        int[][] meeting = {{7,10}, {2, 4}};
//        int[][] meeting = {{5,8}, {6, 8}};
//        int[][] meeting = {{1,5}, {8, 9}, {8, 9}};
//        int[][] meeting = {{13, 15}, {1, 13}};
//        int[][] meeting = {{2,15},{36,45},{9,29},{16,23},{4,9}};

        SchedulingMeetingInRoom253 ob = new SchedulingMeetingInRoom253();

        int minMeetingRooms = ob.minMeetingRooms(meeting);
        System.out.println(minMeetingRooms);
    }

    //Approach - Chronological order sorting
    // Time Complexity - O(Nlogn)
    // Space Complexity - O(N)
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        int counter = 0;
        for (int[] i : intervals) {
            start[counter] = i[0];
            end[counter] = i[1];
            counter++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int room = 1;
        int s = 1;
        int e = 0;

        for (; s < start.length; s++) {
            if (start[s] < end[e]) {
                room++;
            } else {
                e++;
            }
        }
        return room;
    }

    //Approach - Heap
    // Time Complexity - O(Nlogn)
    // Space Complexity - O(N)
//    public int minMeetingRooms(int[][] intervals) {
//        if (intervals == null || intervals.length == 0)
//            return 0;
//
//        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
//
//        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
//
//        for (int[] l : intervals) {
//            Integer latestEndTime = minHeap.peek();
//            if (latestEndTime != null && latestEndTime <= l[0]) {
//                minHeap.poll();
//            }
//            minHeap.offer(l[1]);
//        }
//        return minHeap.size();
//    }
}
