/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals56 {
    public static void main(String[] args) {

        MergeIntervals56 ob = new MergeIntervals56();

//        int[][] intervals = {{15, 18}, {2, 6}, {1, 3}, {8, 10},};
//        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] intervals = {};
        int[][] mergedIntervals = ob.merge(intervals);
        System.out.println(Arrays.deepToString(mergedIntervals));
    }


    public int[][] merge(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return new int[0][0];
        }

        int column = 0;
        Comparator<int[]> comparatorByStartTime = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[column] - o2[column];
            }
        };

        //Sorting by startTime
        Arrays.sort(intervals, comparatorByStartTime);

        int[][] result = new int[intervals.length][intervals[0].length];
        int rowIndex = 0;
        result[rowIndex][0] = intervals[0][0];
        result[rowIndex][1] = intervals[0][1];

        for (int i = 1; i <= intervals.length - 1; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            if (startTime >= result[rowIndex][0] && startTime <= result[rowIndex][1]) {
                result[rowIndex][0] = Math.min(result[rowIndex][0], startTime);
                result[rowIndex][1] = Math.max(result[rowIndex][1], endTime);
            } else {
                rowIndex++;
                result[rowIndex][0] = startTime;
                result[rowIndex][1] = endTime;
            }
        }

        return Arrays.copyOfRange(result, 0, rowIndex + 1);
    }

}
