package leetcodeProblems.medium;

import java.util.*;

public class MinimumHeightTrees310 {
    public static void main(String[] args) {
        MinimumHeightTrees310 ob = new MinimumHeightTrees310();
        int n = 6;
        int[][] edges = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4},
        };

//        int n = 4;
//        int[][] edges = {
//                {1, 0},
//                {1, 2},
//                {1, 3}
//        };

//        int n=1;
//        int[][] edges= {};

//        int n = 2;
//        int[][] edges = {{0, 1}};

//        int n = 6;
//        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        List<Integer> minHeightTrees = ob.findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1 || edges.length == 0) {
            return Collections.singletonList(0);
        }

        if (n == 2) {
            return Arrays.asList(0, 1);
        }

        Map<Integer, List<Integer>> g = new HashMap<>(n);

        for (int[] e : edges) {
            g.computeIfAbsent(e[0], integer -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], integer -> new ArrayList<>()).add(e[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> lastQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1)
                queue.offer(i);
        }

        LinkedList<Integer> tmpQueue = new LinkedList<>();

        while (true) {
            while (!queue.isEmpty()) {
                Integer currentVertex = queue.pop();
                List<Integer> neighbours = g.get(currentVertex);

                for (Integer nei : neighbours) {
                    g.get(nei).remove(currentVertex);

                    if (g.get(nei).size() == 1) {
                        tmpQueue.offer(nei);
                    }
                }
                g.remove(currentVertex);
            }

            if (tmpQueue.isEmpty())
                break;
            else
                lastQueue.clear();

            while (!tmpQueue.isEmpty()) {
                Integer poll = tmpQueue.poll();
                queue.add(poll);
                lastQueue.add(poll);
            }
        }
        return lastQueue;
    }
}
