package leetcodeProblems;

import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
//        int course = 7;
//        int[][] prerequisites =
//                {{0, 5},
//                        {0, 4},
////                        {4, 0},
//                        {1, 0},
//                        {1, 2},
//                        {2, 0},
//                        {3, 5},
//                        {5, 4},
//                        {5, 6}};

//        int course = 2;
//        int[][] prerequisites =
//                {{0, 1}};

        int course = 0;
        int[][] prerequisites =
                {{0, 1}};

        CourseSchedule207 ob = new CourseSchedule207();
        boolean result = ob.canFinish(course, prerequisites);
        System.out.println(result);
    }


    Map<Integer, List<Integer>> adjList;
    private boolean isPossible;
    Map<Integer, String> nodeToStatus;
    Stack<Integer> topoloigcalOrder;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return true;
        }

        if (numCourses <= 0) {
            return false;
        }

        initialize(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (nodeToStatus.get(i).equals("UNPROCESSED")) {
                dfs(i);
            }
        }
        return isPossible;
    }

    private void dfs(int vertex) {

        if (!isPossible) {
            return;
        }
        nodeToStatus.put(vertex, "IN_PROGRESS");

        for (int destination : adjList.get(vertex)) {
            String destinationStatus = nodeToStatus.get(destination);
            if (destinationStatus.equals("UNPROCESSED")) {
                dfs(destination);
            } else if (destinationStatus.equals("IN_PROGRESS")) {
                isPossible = false;
                return;
            }
        }

        nodeToStatus.put(vertex, "COMPLETED");
        topoloigcalOrder.push(vertex);
    }


    private void initialize(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> dest = adjList.get(prerequisites[i][0]);
            dest.add(prerequisites[i][1]);
            adjList.put(prerequisites[i][0], dest);
        }

        isPossible = true;
        nodeToStatus = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            nodeToStatus.put(i, "UNPROCESSED");
        }

        topoloigcalOrder = new Stack<Integer>();
    }

}

