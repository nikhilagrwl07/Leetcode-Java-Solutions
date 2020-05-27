package practice;

import java.util.*;

public class CourseSchdule {
    public static void main(String[] args) {
        CourseSchdule ob = new CourseSchdule();

        int course1 = 7;
        int[][] prerequisites1 =
                {{0, 5},
                        {0, 4},
//                        {4, 0},
                        {1, 0},
                        {1, 2},
                        {2, 0},
                        {3, 5},
                        {5, 4},
                        {5, 6}};

        int course2 = 2;
        int[][] prerequisites2 = {{0, 1}};

        int course3 = 2;
        int[][] prerequisites3 = {{0, 1}, {1, 0}};

        int course4 = 2;
        int[][] prerequisites4 = {{}};

        int course5 = 4;
        int[][] prerequisites5 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int course6 = 3;
        int[][] prerequisites6 = {{1, 0}};

        int course7 = 4;
        int[][] prerequisites7 = {{3, 0}, {0, 1}};

        int course8 = 8;
        int[][] prerequisites8 = {{1, 0}, {2, 6}, {1, 7}, {5, 1}, {6, 4}, {7, 0}, {0, 5}};

//        System.out.println(Arrays.toString(ob.findOrder(course1, prerequisites1)));
//        System.out.println(Arrays.toString(ob.findOrder(course2, prerequisites2)));
//        System.out.println(Arrays.toString(ob.findOrder(course3, prerequisites3)));
//        System.out.println(Arrays.toString(ob.findOrder(course4, prerequisites4)));
//        System.out.println(Arrays.toString(ob.findOrder(course5, prerequisites5)));
//        System.out.println(Arrays.toString(ob.findOrder(course6, prerequisites6)));
//        System.out.println(Arrays.toString(ob.findOrder(course7, prerequisites7)));
        System.out.println(Arrays.toString(ob.findOrder(course8, prerequisites8)));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0)
            return new int[0];

        int[] result = new int[numCourses];

        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            List<Integer> nei = graph.get(pre[1]);
            if (nei == null) {
                nei = new ArrayList<>();
            }
            nei.add(pre[0]);
            graph.put(pre[1], nei);

            inDegree[pre[0]]++;
        }

        char[] status = new char[numCourses];
        List<Integer> order = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
            int node = e.getKey();
            if (inDegree[node] == 0) {
                if (!dfs(node, graph, status, order))
                    return new int[0];
            }
        }

        for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
            if (!order.contains(e.getKey()))
                return new int[0];
        }

        int index = 0;
        for (int i = order.size() - 1; i >= 0; i--) {
            result[index++] = order.get(i);
        }

        for (int i = 0; i <= numCourses - 1; i++) {
            if (!order.contains(i))
                result[index++] = i;
        }
        return result;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, char[] status, List<Integer> order) {
        if (status[node] == 'P')
            return false;

        if (status[node] == 'C')
            return true;

        status[node] = 'P';


        List<Integer> neighbours = graph.getOrDefault(node, new ArrayList<>());
        for (Integer nei : neighbours) {
            boolean dfs = dfs(nei, graph, status, order);
            if (!dfs)
                return false;
        }

        order.add(node);
        status[node] = 'C';
        return true;
    }
}
