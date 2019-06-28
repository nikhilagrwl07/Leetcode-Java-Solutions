package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDaysSelf {
    public static void main(String[] args) {
//        int[] cells = {1, 0, 0, 1, 0, 0, 1, 1};
//        int N = 1000000000;

        int[] cells = {1, 0, 0, 1, 0, 0, 1, 1};
        int N = 7;

        System.out.println(Arrays.toString(cells));
        PrisonCellsAfterNDaysSelf ob = new PrisonCellsAfterNDaysSelf();
        int[] prisonAfterNDays = ob.prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(prisonAfterNDays));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length <= 2) {
            return cells;
        }

        int state = convertLayoutToState(cells, 0, cells.length-1);
        Map<Integer, Integer> seen = new HashMap<>();

        while (N > 0) {
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state, cells.length);
            }
        }

        return convertStateToLayout(state, cells.length);
    }

    private static int nextDay(int state, int numberOfPrison) {
        int[] prisonLayout = convertStateToLayout(state, numberOfPrison);

        int[] result = new int[prisonLayout.length];
//        result[0] = prisonLayout[0];
//        result[numberOfPrison-1] = prisonLayout[numberOfPrison-1];

        for (int i = 1; i <= (numberOfPrison - 2); i++) {
            if (prisonLayout[i - 1] == prisonLayout[i + 1]) {
                result[i] = 1;
            } else
                result[i] = 0;
        }
        return convertLayoutToState(result, 0,numberOfPrison-1);

    }

    private static int convertLayoutToState(int[] cells, int low, int high) {
        int state = 0;
        for (int length = low; length <= high; length++) {

            if (cells[length] == 1) {
                state += ((int) Math.pow(2, length));
            }
        }
        return state;
    }

    private static int[] convertStateToLayout(int n, int length) {

        int[] binary = new int[length];
        int index = 0;
        while (n > 0) {
            binary[index++] = n % 2;
            n = n / 2;
        }

        return binary;
    }
}
