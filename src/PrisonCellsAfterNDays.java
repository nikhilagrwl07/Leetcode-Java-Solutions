/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int N = 7;

//        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
//        int N = 1000000000;

        PrisonCellsAfterNDays ob = new PrisonCellsAfterNDays();
        System.out.println(Arrays.toString(cells));
        ob.prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(cells));
    }


    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
//                int previous = state;
                state = nextDay(state);
//                System.out.println(" Previous = " + previous + " state = " + state);

            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 0; i <= 8; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }
}