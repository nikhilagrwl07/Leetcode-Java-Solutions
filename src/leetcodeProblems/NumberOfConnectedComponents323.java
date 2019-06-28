/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponents323 {
    public static void main(String[] args) {

//        int[][] g = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
//        int n = 5;

        int[][] g = {{0, 1}, {2, 1}, {2, 0}, {2, 4}};
        int n = 5;

//        int[][] g = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
//        int n = 10;
//        int[][] g = {{1,0}, {0,2}, {2,1}};
//        int n = 3;

//        int[][] g = {};
//        int n = 1;

//        int[][] g = {{0, 1}, {2, 3}, {1, 2}};
//        int n = 4;

//        int[][] g = {{2, 3}, {1, 2}, {1, 3}};
//        int n = 4;

//        int[][] g = {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {3, 5}};
//        int n = 6;

        NumberOfConnectedComponents323 ob = new NumberOfConnectedComponents323();
        int countComponents = ob.countComponents(n, g);
        System.out.println(countComponents);
    }

    public int countComponents(int n, int[][] edges) {

        if (n <= 0 || edges == null || edges.length == 0) {
            return n;
        }

        Status[] isVisited = new Status[n];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = Status.NOT_STARTED;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int src = edges[i][0];
            int dest = edges[i][1];

            List<Integer> destinations = graph.getOrDefault(src, new ArrayList<>());
            destinations.add(dest);

            graph.put(src, destinations);

            List<Integer> srcs = graph.getOrDefault(dest, new ArrayList<>());
            srcs.add(src);

            graph.put(dest, srcs);
        }


        int countOfComponent = 0;

        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {

            int src = e.getKey();

            if (!dfs(graph, src, isVisited)) {
                countOfComponent++;
            }

            markCompleted(isVisited);
        }

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == Status.NOT_STARTED) {
                countOfComponent++;
            }
        }

        return countOfComponent;
    }

    private void markCompleted(Status[] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == Status.IN_PROGRESS) {
                isVisited[i] = Status.COMPLETED;
            }
        }
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int src, Status[] isVisited) {

        boolean countOfUnvisitedNodes = false;
        isVisited[src] = Status.IN_PROGRESS;

        List<Integer> destinations = graph.get(src);

        if (destinations != null && !destinations.isEmpty()) {
            for (int dest : destinations) {
                if (isVisited[dest] == Status.COMPLETED) {
                    countOfUnvisitedNodes = true;
                    dfs(graph, dest, isVisited);
                } else if (isVisited[dest] == Status.NOT_STARTED) {
                    countOfUnvisitedNodes = dfs(graph, dest, isVisited) || countOfUnvisitedNodes;
                }
            }
        }

        return countOfUnvisitedNodes;

    }

    enum Status {
        IN_PROGRESS,
        COMPLETED,
        NOT_STARTED;
    }
}
