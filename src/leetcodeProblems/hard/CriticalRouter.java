package leetcodeProblems.hard;

import java.util.*;

public class CriticalRouter {
    public static void main(String[] args) {
//        int numNodes = 7, numEdges = 7;
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};


        int numNodes = 7, numEdges = 8;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {1, 6}, {3, 5}, {4, 5}};

        CriticalRouter ob = new CriticalRouter();
        List<Integer> criticalRouters = ob.criticalRouters(numNodes, numEdges, edges);
        System.out.println(criticalRouters);
    }

    // Time Complexity - O(V * (V+E))
    // Space Complexity - O(V+E)
    public List<Integer> criticalRouters(int numNodes, int numEdges, int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>(numNodes);

        for (int[] e : edges) {
            if (g.get(e[0]) == null) {
                List<Integer> dest = new ArrayList<>();
                dest.add(e[1]);
                g.put(e[0], dest);
            } else if (g.get(e[0]) != null) {
                g.get(e[0]).add(e[1]);
            }

            if (g.get(e[1]) == null) {
                List<Integer> dest = new ArrayList<>();
                dest.add(e[0]);
                g.put(e[1], dest);
            } else if (g.get(e[1]) != null) {
                g.get(e[1]).add(e[0]);
            }
        }

        List<Integer> result = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            int key = e.getKey();

            int[] count = {0};
            visited.add(key);

            dfs(g, g.get(key).get(0), visited, count);

            if (count[0] != numNodes - 1) {
                result.add(key);
            }
            visited.clear();
        }
        return result;

    }

    private void dfs(Map<Integer, List<Integer>> g, int key, Set<Integer> visited, int[] count) {
        if (visited.contains(key)) {
            return;
        }
        count[0] = count[0] + 1;
        visited.add(key);

        for (Integer nei : g.get(key)) {
            dfs(g, nei, visited, count);
        }
    }
}
