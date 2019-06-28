/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortOnDirrectedAcyclicGraph {
    public static void main(String[] args) {
        int vetexCount = 6;
        Graph g = new Graph(vetexCount);
        g.insert(5, 2);
        g.insert(5, 0);
        g.insert(4, 0);
        g.insert(4, 1);
        g.insert(2, 3);
        g.insert(3, 1);

        g.topologicalSort();
    }

    // DAG
    static class Graph {

        List<Integer> head[];

        public Graph(int vertexCount) {
            this.head = new ArrayList[vertexCount];
            for (int i = 0; i < head.length; i++) {
                head[i] = new ArrayList<>();
            }
        }

        private void insert(int source, int destination) {
            List<Integer> nodes = head[source];
            nodes.add(destination);
            head[source] = nodes;
        }

        // Time Complexity - O(V+E)

        private void topologicalSort() {
            boolean[] isVisited = new boolean[head.length];
            Stack<Integer> stack = new Stack<>();

            for (int source = 0; source < head.length; source++) {
                topologicalSortUtil(source, isVisited, stack);
            }

            for (int source = head.length-1; source >=0; source--) {
                topologicalSortUtil(source, isVisited, stack);
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }

        private void topologicalSortUtil(int source, boolean[] isVisited, Stack<Integer> stack) {

            if (isVisited[source]) {
                return;
            }

            isVisited[source] = true;

            List<Integer> neighbours = head[source];

            for (Integer neighbour : neighbours) {
                topologicalSortUtil(neighbour, isVisited, stack);
            }

            stack.push(source);

        }
    }

}

