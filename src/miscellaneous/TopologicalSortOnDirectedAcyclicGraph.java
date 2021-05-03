package miscellaneous;

import java.util.*;

public class TopologicalSortOnDirectedAcyclicGraph {
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
        List<Integer>[] head;
        Map<Integer, Integer> inDegreeMap;

        public Graph(int vertexCount) {
            head = new ArrayList[vertexCount];
            inDegreeMap = new HashMap<>();
            for (int i = 0; i < head.length; i++) {
                head[i] = new ArrayList<>();
                inDegreeMap.put(i, 0);
            }
        }

        private void insert(int source, int destination) {
            List<Integer> nodes = head[source];
            nodes.add(destination);
            head[source] = nodes;
            inDegreeMap.put(destination, inDegreeMap.get(destination) + 1);
        }

        // Time Complexity - O(V+E)
        private void topologicalSort() {
            Queue<Integer> zeroInDegreeVertics = new LinkedList<>();
            for (Map.Entry<Integer, Integer> e : inDegreeMap.entrySet()) {
                if (e.getValue() == 0)
                    zeroInDegreeVertics.offer(e.getKey());
            }

            List<Integer> sortedOrder = new ArrayList<>();

            while (!zeroInDegreeVertics.isEmpty()) {
                Integer currentVertex = zeroInDegreeVertics.poll();
                sortedOrder.add(currentVertex);

                for (Integer child : head[currentVertex]) {
                    inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                    if (inDegreeMap.get(child) == 0) {
                        zeroInDegreeVertics.offer(child);
                    }
                }
            }

            if (sortedOrder.size() != head.length) {
                System.out.println("Topological Sort not possible since graph is not DAG and has cycle");
                return;
            }
            System.out.println(sortedOrder);
        }
    }

}

