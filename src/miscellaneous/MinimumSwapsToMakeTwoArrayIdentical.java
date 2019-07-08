/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import javafx.util.Pair;

import java.util.*;

public class MinimumSwapsToMakeTwoArrayIdentical {
    public static void main(String[] args) {

        int[] a = {3, 6, 4, 8};
        int[] b = {4, 6, 8, 3};

        MinimumSwapsToMakeTwoArrayIdentical ob = new MinimumSwapsToMakeTwoArrayIdentical();
        int minimumNumberOfSwapsToSortArray = ob.minimumNumberOfSwapsToSortArray(a, b);
        System.out.println(minimumNumberOfSwapsToSortArray);
    }


    private int minimumNumberOfSwapsToSortArray(int[] a, int[] b) {

        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            valueToIndex.put(b[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            int element = a[i];
            b[i] = valueToIndex.get(element);
        }

        return minimumNumberOfSwapsToSortArray(b);
    }


    //Source - https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
    // Algorithm - visualize given unsorted array as graph
    private int minimumNumberOfSwapsToSortArray(int[] a) {

        List<Pair<Integer, Integer>> adjacencyList = new ArrayList<>();

        boolean[] isVisited = new boolean[a.length];
        Arrays.fill(isVisited, false);

        for (int i = 0; i < a.length; i++) {
            Pair<Integer, Integer> p = new Pair<>(a[i], i);
            adjacencyList.add(p);
        }

        Comparator<Pair<Integer, Integer>> sortByValue = (o1, o2) -> o1.getKey() - o2.getKey();
        adjacencyList.sort(sortByValue);

        int minimumSwapCount = 0;

        for (int i = 0; i < a.length; i++) {

            //Condition 1 - if element is already present at sorted location
            //Condition 2 - is element is already marked as visited
            // If anyone of above two conditions are true, then continue

            if (adjacencyList.get(i).getValue() == i || isVisited[i]) {
                continue;
            }

            int cycleSize = 0;

            int j = i;

            while (!isVisited[j]) {

                isVisited[j] = true;
                cycleSize++;
                j = adjacencyList.get(j).getValue();
            }

            if (cycleSize > 0) {
                minimumSwapCount += (cycleSize - 1);
            }
        }

        return minimumSwapCount;
    }
}
