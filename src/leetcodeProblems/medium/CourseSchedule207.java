package leetcodeProblems.medium;

import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
        int course = 7;
        int[][] prerequisites =
                {{0, 5},
                        {0, 4},
//                        {4, 0},
                        {1, 0},
                        {1, 2},
                        {2, 0},
                        {3, 5},
                        {5, 4},
                        {5, 6}};

//        int course = 2;
//        int[][] prerequisites =
//                {{0, 1}};

//        int course = 0;
//        int[][] prerequisites =
//                {{0, 1}};

        CourseSchedule207 ob = new CourseSchedule207();
//        boolean result = ob.canFinish(course, prerequisites);
        boolean result = ob.canFinishDFS(course, prerequisites);
        System.out.println(result);
    }

    // Topological Sort
    // Time Complexity - O(E+V)
    // Space Complexity - O(E+V)
    public boolean canFinish(int course, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>(course);

        LinkedList<Integer> nodesWithIndegreeZero = new LinkedList<>();

        for (int i = 0; i < course; i++) {
            graph.put(i, new Node());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).addNeighbour(pre[0]);
            graph.get(pre[0]).incrementIndegree();
        }

        for (int c = 0; c < course; c++) {
            if (graph.get(c).indegree == 0)
                nodesWithIndegreeZero.offer(c);
        }

        int inputEdgeCount = prerequisites.length;
        int currentEdgeCount = 0;

        while (!nodesWithIndegreeZero.isEmpty()) {
            Node node = graph.get(nodesWithIndegreeZero.pop());

            for (Integer next : node.next) {
                graph.get(next).decrementIndegree();
                currentEdgeCount++;

                if (graph.get(next).indegree == 0) {
                    nodesWithIndegreeZero.offer(next);
                }
            }

        }
        return inputEdgeCount == currentEdgeCount;
    }

    static class Node {
        List<Integer> next = new ArrayList<>();
        int indegree = 0;

        public void addNeighbour(Integer neighbour) {
            next.add(neighbour);
        }

        public void incrementIndegree() {
            indegree++;
        }

        public void decrementIndegree() {
            indegree--;
        }
    }

    // DFS
    // Time Complexity - O(E+V)
    // Space Complexity - O(E+V)
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, Status> courseStatus = new HashMap<>(numCourses);

        Map<Integer, List<Integer>> courseToPrerequistic = new HashMap<>();
        for (int[] course : prerequisites) {
            if (course[1] == course[0])
                return false;

            List<Integer> prerequistic = courseToPrerequistic.getOrDefault(course[0], new ArrayList<>());
            prerequistic.add(course[1]);
            courseToPrerequistic.put(course[0], prerequistic);
        }

        for (Map.Entry<Integer, List<Integer>> e : courseToPrerequistic.entrySet()) {
            int course = e.getKey();

            if (courseStatus.get(course) == Status.PROCESSING)
                return false;

            if (courseStatus.get(course) == Status.COMPLETED)
                continue;

            if (!dfs(course, courseToPrerequistic, courseStatus))
                return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> courseToPrerequistic,
                        Map<Integer, Status> courseStatusMap) {

        courseStatusMap.put(course, Status.PROCESSING);
        for (Integer preRequsite : courseToPrerequistic.getOrDefault(course, new ArrayList<>())) {
            if (courseStatusMap.get(preRequsite) == Status.PROCESSING) {
                courseStatusMap.put(course, Status.COMPLETED);
                return false;
            }

            if (!dfs(preRequsite, courseToPrerequistic, courseStatusMap)) {
                courseStatusMap.put(course, Status.COMPLETED);
                return false;
            }
        }
        courseStatusMap.put(course, Status.COMPLETED);
        return true;
    }

    enum Status {
        PROCESSING,
        COMPLETED;
    }
}

