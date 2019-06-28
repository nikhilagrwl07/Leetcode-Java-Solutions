/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class DFSOnDirrectedAcyclicGraph {
    public static void main(String[] args) {
        int vetexCount = 4;
        Graph g = new Graph(4);
        g.insert(0, 1);
        g.insert(0, 2);
        g.insert(1, 2);
        g.insert(2, 0);
        g.insert(2, 3);
        g.insert(3, 3);

        g.dfs();
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

        private void dfs() {
            boolean[] isVisited = new boolean[head.length];
            List<Integer> dfsPath = new ArrayList<>();

            for (int vertex = 0; vertex < head.length; vertex++) {
                dfsUtil(vertex, isVisited, dfsPath);
            }


            dfsPath.forEach(node -> {
                System.out.print(node + " ");
            });
        }

        private void dfsUtil(int source, boolean[] isVisited, List<Integer> dfsPath) {

            if (isVisited[source]) {
                return;
            }

            dfsPath.add(source);
            isVisited[source] = true;

            List<Integer> neighbours = head[source];

            for (Integer neighbour : neighbours) {
                dfsUtil(neighbour, isVisited, dfsPath);
            }
        }
    }

}

