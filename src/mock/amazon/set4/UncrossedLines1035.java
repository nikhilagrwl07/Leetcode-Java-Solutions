/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set4;

import java.util.*;

public class UncrossedLines1035 {
    public static void main(String[] args) {
//        int[] A = {2, 5, 1, 2, 5};
//        int[] B = {10, 5, 2, 1, 5, 2};

//        int[] A = {1,4,2};
//        int[] B = {1,2,4};

//        int[] A =  {1,3,7,1,7,5};
//        int[] B = {1,9,2,5,1};

//        int[] A = {2, 3, 4, 1, 3, 3, 2, 4, 2, 2, 1, 5, 2, 4, 3, 4, 4, 5, 1, 5, 1, 5, 4, 3, 1, 2, 5, 2, 4, 4};
//        int[] B = {2, 2, 4, 2, 4, 1, 1, 5, 5, 3, 2, 1, 1, 1, 3, 1, 2, 5, 2, 4, 3, 4, 5, 5, 3, 3, 5, 1, 4, 3};
//
//        int[] A = {4, 1, 2, 5, 1, 5, 3, 4, 1, 5};
//        int[] B = {3, 1, 1, 3, 2, 5, 2, 4, 1, 3, 2, 2, 5, 5, 3, 5, 5, 1, 2, 1};

//        int[] A = {3, 1, 4, 1, 1, 3, 5, 1, 2, 2};
//        int[] B = {4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3};

        int[] A = {1};
        int[] B = {1,3};

        UncrossedLines1035 ob = new UncrossedLines1035();
        int maxUncrossedLines = ob.maxUncrossedLines(A, B);
        System.out.println(maxUncrossedLines);

    }


    public int maxUncrossedLines(int[] A, int[] B) {

        Map<Integer, List<Integer>> bMap = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            List<Integer> orDefault = bMap.getOrDefault(B[i], new LinkedList<>());
            orDefault.add(i);
            bMap.put(B[i], orDefault);
        }

        int[] isVisited = new int[B.length];
        Arrays.fill(isVisited, -1);


        HashMap<Integer, Integer> cache = new HashMap<>();
        int dfsCount = dfs(A, 0, isVisited, bMap, cache);
        return dfsCount;
    }


    public int dfs(int[] A, int indexA, int[] isVisited, Map<Integer, List<Integer>> bMap,
                   Map<Integer, Integer> cache) {

        if (indexA >= A.length || isAllVisited(isVisited)) {
            return 0;
        }

        if (cache.containsKey(indexA)) {
            return cache.get(indexA);
        }

        int maxConnection = 0;

        int valueOfA = A[indexA];

        List<Integer> indexesOfBHavingSameAvalue = bMap.getOrDefault(valueOfA, new ArrayList<>());

        int maxConnectionAtA = 0;

        for (int index : indexesOfBHavingSameAvalue) {
            int count = 0;

            if (isVisited[index] == -1) {
                count = 1;
                markAllVisitedTillIndex(isVisited, index, indexA);

                for (int length = 1; length <= (A.length - indexA - 1); length++) {
                    int countOfLength = 0;
                    countOfLength = 1 + dfs(A, indexA + length, isVisited, bMap, cache);

                    count = Math.max(count, countOfLength);
                }

                maxConnectionAtA = Math.max(maxConnectionAtA, count);
                markAllUnVisitedTillIndex(isVisited, index, indexA);
            }
        }

        if (maxConnectionAtA != 0 && (cache.get(indexA) == null || cache.get(indexA) < maxConnectionAtA)) {
            cache.put(indexA, maxConnectionAtA);
        }
        maxConnection = Math.max(maxConnection, maxConnectionAtA);
        return maxConnection;
    }

    private void markAllVisitedTillIndex(int[] isVisited, int index, int value) {

        for (int i = index; i >= 0; i--) {
            if (isVisited[i] == -1) {
                isVisited[i] = value;
            } else {
                break;
            }
        }
    }

    private void markAllUnVisitedTillIndex(int[] isVisited, int index, int value) {

        for (int i = index; i >= 0; i--) {
            if (isVisited[i] == value) {
                isVisited[i] = -1;
            } else {
                break;
            }
        }
    }


    public boolean isAllVisited(int[] isVisited) {

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == -1)
                return false;
        }
        return true;
    }


//    public int maxUncrossedLines(int[] A, int[] B) {
//        int indexOfA = A.length - 1;
//        int indexOfB = B.length - 1;
//
//        int count = 0;
//        while (indexOfA >= 0 && indexOfB >= 0) {
//
//            int indexOfBFoundFromEnd = findIndexOfB(B, indexOfB, A[indexOfA]);
//            if (indexOfBFoundFromEnd != -1) {
//                count++;
//                indexOfB = indexOfBFoundFromEnd;
//            } else {
//                indexOfB--;
//            }
//            indexOfA--;
//        }
//        return count;
//    }
//
//    private int findIndexOfB(int[] B, int indexOfB, int target) {
//
//        while (indexOfB >= 0) {
//            if (B[indexOfB] == target) {
//                return indexOfB;
//            }
//            indexOfB--;
//        }
//        return -1;
//    }
}
