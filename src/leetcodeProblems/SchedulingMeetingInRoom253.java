package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SchedulingMeetingInRoom253 {
    public static void main(String[] args) {
//        int[][] meeting = {{0, 30}, {15, 20}, {5, 10}};
//        int[][] meeting = {{7,10}, {2, 4}};
        int[][] meeting = {{5,8}, {6, 8}};
//        int[][] meeting = {{1,5}, {8, 9}, {8, 9}};
//        int[][] meeting = {{13, 15}, {1, 13}};
//        int[][] meeting = {{2,15},{36,45},{9,29},{16,23},{4,9}};

        SchedulingMeetingInRoom253 ob = new SchedulingMeetingInRoom253();

        int minMeetingRooms = ob.minMeetingRooms(meeting);
        System.out.println(minMeetingRooms);
    }


    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals.length;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        MinHeap minHeap = new MinHeap();
        minHeap.insert(new Schedule(intervals[0][0], intervals[0][1])); // first end time inserted


        for (int i = 1; i <= intervals.length-1; i++) {

            Schedule newSchedule = new Schedule(intervals[i][0], intervals[i][1]);
            if(isTopRoomFreee(minHeap, newSchedule)){
                minHeap.deleteAndInsertAtTop(newSchedule);
            }
            else{
                minHeap.insert(newSchedule);
            }
        }

        return minHeap.getRoomCount();
    }

    private boolean isTopRoomFreee(MinHeap minHeap, Schedule newSchedule) {
        Schedule top = minHeap.getTop();
        return top.getStartTime() >= newSchedule.getEndTime() || top.getEndTime() <= newSchedule.getStartTime();
    }

    class MinHeap {

        List<Schedule> schedules;

        public MinHeap() {
            this.schedules = new ArrayList<>();
        }

        private int getRoomCount(){
            return schedules.size();
        }

        private Schedule getTop() {
            return schedules.get(0);
        }

        private void deleteAndInsertAtTop(Schedule schedule) {
            schedules.set(0, schedule);
            heapifyTopDown(0);
        }

        private void insert(Schedule newEndTime) {
            schedules.add(newEndTime);
            heapifybottomUp(newEndTime);
        }

        private void heapifybottomUp(Schedule schedule) {

            int indexOfNewEndTime = schedules.indexOf(schedule);
            int parent = getParent(indexOfNewEndTime);

            while (parent >= 0 && schedules.get(indexOfNewEndTime).getEndTime() < schedules.get(parent).getEndTime()) {
                swap(indexOfNewEndTime, parent);
                indexOfNewEndTime = parent;
                parent = getParent(indexOfNewEndTime);
            }

        }

        private void heapifyTopDown(int index) {

            int indexOfNewEndTime = index;
            int left = getLeft(indexOfNewEndTime);
            int right = getRight(indexOfNewEndTime);

            int minIndex = indexOfNewEndTime;


            if (left <= schedules.size() - 1) {
                if (schedules.get(minIndex).getEndTime() > schedules.get(left).getEndTime()) {
                    minIndex = left;
                }
            }

            if (right <= schedules.size() - 1) {
                if (schedules.get(minIndex).getEndTime() > schedules.get(right).getEndTime()) {
                    minIndex = right;
                }
            }

            if (minIndex != indexOfNewEndTime) {
                swap(minIndex, indexOfNewEndTime);
                heapifyTopDown(minIndex);
            }
        }

        private void swap(int i1, int i2) {
            Schedule t = schedules.get(i1);
            schedules.set(i1, schedules.get(i2));
            schedules.set(i2, t);
        }

        private int getLeft(int index) {
            return 2 * index + 1;
        }

        private int getRight(int index) {
            return 2 * index + 2;
        }

        private int getParent(int index) {
            return (index - 1) / 2;
        }
    }

    static class Schedule{
        int startTime;
        int endTime;

        public Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }
}
