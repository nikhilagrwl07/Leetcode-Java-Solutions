/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class KnightOnDialer935 {
    public static void main(String[] args) {

        KnightOnDialer935 ob = new KnightOnDialer935();

        int N = 2;
        int knightDialer = ob.knightDialer(N);
        System.out.println(knightDialer);
    }


    public int knightDialer(int N) {


        Map<Integer, List<Integer>> mapping = new HashMap<>(10);
        mapping.put(0, Arrays.asList(4, 6));
        mapping.put(1, Arrays.asList(8, 6));
        mapping.put(2, Arrays.asList(7, 9));
        mapping.put(3, Arrays.asList(8, 4));
        mapping.put(4, Arrays.asList(3, 9, 0));
        mapping.put(6, Arrays.asList(1, 7, 0));
        mapping.put(7, Arrays.asList(2, 6));
        mapping.put(8, Arrays.asList(1, 3));
        mapping.put(9, Arrays.asList(2, 4));
        mapping.put(5, Collections.emptyList());

        int stepTaken = 0;
        int[][] dp = new int[10][N];
        //  row denotes starting position
        // column denotes number of hopes  remaining
        for (int startingPos = 0; startingPos < 10; startingPos++) {
            dp[startingPos][stepTaken] = 1; // for zero remaining hopes possibility is 1 only
        }

        stepTaken++;

        while (stepTaken <= N - 1) {
            for (int startingPos = 0; startingPos < 10; startingPos++) {

                if (dp[startingPos][stepTaken - 1] == stepTaken) {
                    List<Integer> destination = mapping.get(startingPos);
                    for (int dest : destination) {

                        dp[dest][stepTaken] += dp[startingPos][stepTaken - 1] + 1;
                    }
                }
            }
            stepTaken++;
        }

        int uniqueDailedNumber = 0;
        for (int startingPos = 0; startingPos < 10; startingPos++) {
            uniqueDailedNumber += dp[startingPos][N - 1]; // for zero remaining hopes possibility is 1 only
        }
        return uniqueDailedNumber;
    }

//    public int BFS(int N, Map<Character, List<Character>> mapping) {
//
//        int count = 0;
//        Queue<Node> q = new LinkedList<>();
//        for (Character c : Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')) {
//            q.add(new Node(c, N - 1));
//        }
//
//        while (!q.isEmpty()) {
//
//            Node node = q.poll();
//            if (node.stepsRemaining == 0) {
////                System.out.println(node.current);
//                count++;
//                continue;
//            }
//
//            List<Character> destination = mapping.get(node.current);
//
//            if (destination != null) {
//                for (Character dest : destination) {
//                    q.add(new Node(dest, node.stepsRemaining - 1));
//                }
//            }
//
//        }
//
//        return count;
//
//    }
//
//    class Node {
//        Character current;
//        int stepsRemaining;
//
//        public Node(Character current, int stepsRemaining) {
//            this.current = current;
//            this.stepsRemaining = stepsRemaining;
//        }
//    }


}
