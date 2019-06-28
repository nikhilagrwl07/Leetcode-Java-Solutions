/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class CourseSchedule210 {
    public static void main(String[] args) {
//                int course = 7;
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

        int course = 2;
        int[][] prerequisites =
                {{1, 0},
                        {0,1}};

//        int course = 4;
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        CourseSchedule210 ob = new CourseSchedule210();
        int[] result = ob.findOrder(course, prerequisites);
        System.out.println(Arrays.toString(result));
    }


    Map<Integer, List<Integer>> adjList;
    private boolean isPossible;
    Map<Integer, String> nodeToStatus;
    Stack<Integer> topoloigcalOrder;


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = i;
            }
            return order;
        }

        if (numCourses <= 0) {
            return new int[0];
        }

        initialize(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (nodeToStatus.get(i).equals("UNPROCESSED")) {
                dfs(i);
            }
        }

        int[] result;
        if(isPossible){
            result = new int[numCourses];
            int index = numCourses-1;
            while (!topoloigcalOrder.isEmpty()) {
                result[index--] = topoloigcalOrder.pop();
            }
        }
        else {
            result = new int[0];
        }
        return result;
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

