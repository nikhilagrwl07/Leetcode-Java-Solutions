package leetcodeProblems.medium;

import java.util.*;

public class NetworkDelayPath {
    public static void main(String[] args) {
        NetworkDelayPath ob = new NetworkDelayPath();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4, K = 2;

        int[][] times2 = {{1, 2, 1}, {2, 1, 3}};
        int N2 = 2, K2 = 2;

        int[][] times3 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        int N3 = 3, K3 = 1;

        int[][] times4 = {{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}};
        int N4 = 5, K4 = 5;

        int[][] times5 = {{2, 13, 18}, {15, 10, 92}, {6, 15, 80}, {2, 14, 68}, {13, 14, 65}, {14, 3, 63}, {10, 13, 59}, {9, 7, 42}, {1, 14, 70}, {15, 14, 34}, {11, 1, 48}, {6, 7, 2}, {8, 13, 48}, {15, 6, 92}, {8, 7, 19}, {9, 14, 53}, {3, 5, 48}, {3, 10, 70}, {3, 8, 57}, {5, 15, 5}, {10, 14, 8}, {9, 3, 8}, {15, 8, 52}, {10, 5, 96}, {4, 7, 52}, {14, 13, 87}, {14, 10, 91}, {5, 2, 17}, {3, 15, 5}, {5, 1, 39}, {13, 3, 39}, {7, 13, 71}, {13, 2, 41}, {4, 13, 20}, {11, 12, 61}, {8, 4, 4}, {9, 8, 80}, {9, 2, 45}, {7, 9, 88}, {8, 15, 96}, {1, 12, 92}, {2, 7, 0}, {7, 2, 43}, {3, 9, 21}, {4, 2, 95}, {2, 12, 35}, {2, 5, 32}, {1, 9, 97}, {4, 9, 95}, {15, 4, 81}, {5, 13, 30}, {1, 6, 43}, {1, 7, 22}, {10, 3, 60}, {11, 4, 9}, {4, 11, 55}, {14, 5, 5}, {7, 4, 13}, {15, 13, 72}, {11, 3, 55}, {11, 8, 50}, {3, 7, 25}, {12, 11, 29}, {7, 10, 71}, {7, 5, 24}, {12, 14, 18}, {9, 13, 89}, {7, 3, 25}, {2, 9, 2}, {5, 11, 83}, {6, 4, 48}, {14, 1, 27}, {14, 11, 21}, {8, 14, 12}, {10, 1, 74}, {4, 1, 97}, {4, 10, 46}, {14, 8, 16}, {13, 5, 39}, {9, 4, 6}, {11, 7, 98}, {1, 13, 10}, {8, 11, 22}, {9, 11, 96}, {1, 8, 56}, {3, 14, 81}, {6, 11, 45}, {5, 4, 48}, {4, 6, 71}, {11, 15, 64}, {3, 12, 74}, {2, 6, 71}, {7, 8, 35}, {11, 2, 20}, {7, 12, 12}, {6, 14, 8}, {2, 15, 42}, {8, 2, 24}, {6, 12, 67}, {5, 8, 90}, {2, 10, 36}, {15, 7, 0}, {15, 1, 68}, {12, 4, 43}, {1, 5, 78}, {13, 9, 97}, {2, 4, 51}, {13, 15, 39}, {9, 12, 93}, {5, 3, 79}, {7, 1, 34}, {8, 12, 37}, {12, 15, 36}, {8, 5, 92}, {7, 11, 96}, {14, 9, 94}, {8, 1, 31}, {14, 2, 18}, {2, 8, 62}, {15, 3, 84}, {6, 1, 3}, {10, 4, 91}, {1, 3, 75}, {1, 4, 9}, {11, 10, 69}, {7, 15, 88}, {6, 9, 25}, {9, 6, 44}, {6, 8, 68}, {6, 2, 96}, {1, 15, 16}, {6, 3, 61}, {12, 9, 50}, {13, 11, 27}, {8, 6, 40}, {13, 12, 45}, {14, 7, 61}, {4, 15, 8}, {12, 2, 87}, {14, 4, 94}, {11, 6, 37}, {12, 8, 10}, {13, 6, 0}, {9, 15, 70}, {1, 10, 26}, {14, 6, 30}, {15, 2, 58}, {3, 1, 12}, {10, 7, 96}, {2, 3, 4}, {5, 14, 99}, {8, 3, 85}, {12, 10, 38}, {14, 15, 34}, {4, 8, 31}, {10, 8, 13}, {4, 12, 57}, {12, 7, 4}, {3, 2, 65}, {15, 5, 85}, {12, 5, 42}, {3, 6, 53}, {4, 3, 3}, {10, 15, 29}, {9, 5, 47}, {4, 5, 43}, {9, 1, 98}, {13, 4, 72}, {3, 4, 88}, {5, 9, 21}, {10, 12, 41}, {13, 10, 3}, {3, 11, 77}, {13, 7, 21}, {5, 7, 88}, {6, 5, 22}, {12, 6, 72}, {15, 12, 37}, {9, 10, 94}, {11, 14, 0}, {1, 11, 51}, {5, 10, 44}, {14, 12, 34}, {15, 9, 85}, {11, 13, 74}, {6, 10, 54}, {8, 10, 9}, {13, 8, 68}, {2, 11, 13}, {2, 1, 91}, {12, 3, 31}, {12, 13, 99}, {1, 2, 84}, {12, 1, 89}, {4, 14, 9}, {5, 12, 34}, {7, 14, 53}, {7, 6, 87}, {11, 9, 20}, {3, 13, 6}, {6, 13, 40}, {13, 1, 94}, {10, 11, 20}, {10, 6, 67}, {5, 6, 27}, {8, 9, 97}, {11, 5, 66}, {10, 2, 73}, {10, 9, 17}, {15, 11, 48}};
        int N5 = 15, K5 = 2;

        int[][] times6 = {{1, 2, 1}};
        int N6 = 2, K6 = 2;

        int[][] times7 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
        int N7 = 3, K7 = 2;

        int[][] times8 = {{1, 3, 68}, {1, 4, 20}, {4, 1, 65}, {3, 2, 74}, {2, 1, 44}, {3, 4, 61}, {4, 3, 68}, {3, 1, 26}, {5, 1, 60}, {5, 3, 3}, {4, 5, 5}, {2, 5, 36}, {2, 3, 94}, {1, 2, 0}, {3, 5, 90}, {2, 4, 28}, {4, 2, 12}, {5, 4, 52}, {5, 2, 85}, {1, 5, 42}};
        int N8 = 5, K8 = 4;

        System.out.println(ob.networkDelayTime(times, N, K));
//        System.out.println(ob.networkDelayTime(times2, N2, K2));
//        System.out.println(ob.networkDelayTime(times3, N3, K3));
//        System.out.println(ob.networkDelayTime(times4, N4, K4));
//        System.out.println(ob.networkDelayTime(times5, N5, K5));
//        System.out.println(ob.networkDelayTime(times6, N6, K6));
//        System.out.println(ob.networkDelayTime(times7, N7, K7));
//        System.out.println(ob.networkDelayTime(times8, N8, K8));
    }

    // Time - O(N * N) in worst case if each vertex are connected to all remaining vertices
    // Space - O(N)
    public List<Integer> networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int[] r = times[i];
            List<int[]> defaultList = graph.getOrDefault(r[0], new ArrayList<>());
            defaultList.add(new int[]{r[1], r[2]});
            graph.put(r[0], defaultList);
        }


        Queue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
            return o1[1]-o2[1];
        });
        int[] currentNode;
        pq.offer(new int[] {K, 0});

        Map<Integer, Integer> vertexToDistance = new HashMap<>();

        List<Integer> shortestPath = new ArrayList<>();

        while (!pq.isEmpty()) {

            currentNode = pq.poll(); // shortest distance

            shortestPath.add(currentNode[0]);

            if(vertexToDistance.containsKey(currentNode[0]))
                continue;

            vertexToDistance.put(currentNode[0], currentNode[1]);

            List<int[]> nei = graph.get(currentNode[0]);
            if (nei == null)
                continue;

            // BFS
            for (int[] t : nei) {
                if (!vertexToDistance.containsKey(t[0])) {
                    pq.offer(new int[] {t[0], vertexToDistance.get(currentNode[0]) + t[1]});
                }
            }
        }

        return shortestPath;
    }
}
