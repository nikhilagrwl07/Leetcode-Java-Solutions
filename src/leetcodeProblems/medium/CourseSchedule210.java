/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems.medium;

import java.util.*;

public class CourseSchedule210 {
    public static void main(String[] args) {
        CourseSchedule210 ob = new CourseSchedule210();
                int course4 = 7;
        int[][] prerequisites4 =
                {{0, 5},
                        {0, 4},
//                        {4, 0},
                        {1, 0},
                        {1, 2},
                        {2, 0},
                        {3, 5},
                        {5, 4},
                        {5, 6}};

        int course1 = 2;
        int[][] prerequisites1 =
                {{1, 0},
                        {0, 1}};

        int course2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};

        int course3 = 8;
        int[][] prerequisites3 = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}};

        System.out.println(Arrays.toString(ob.findOrder(course3, prerequisites3)));
        System.out.println(Arrays.toString(ob.findOrderUsingDFS(course3, prerequisites3)));
    }


    public int[] findOrder(int course, int[][] prerequisites) {
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

        int[] orderOfCourse = new int[course];
        int index = 0;
        while (!nodesWithIndegreeZero.isEmpty()) {
            Integer startNode = nodesWithIndegreeZero.pop();
            orderOfCourse[index++] = startNode;

            Node node = graph.get(startNode);

            for (Integer next : node.next) {
                graph.get(next).decrementIndegree();
                currentEdgeCount++;

                if (graph.get(next).indegree == 0) {
                    nodesWithIndegreeZero.offer(next);
                }
            }

        }
        if (inputEdgeCount != currentEdgeCount)
            return new int[0];

        return orderOfCourse;
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

    public int[] findOrderUsingDFS(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            int[] courses = new int[numCourses];

            for (int i = 0; i < courses.length; i++) {
                courses[i] = i;
            }
            return courses;
        }

        Map<Integer, List<Integer>> subjectToPreRequistic = new HashMap<>(numCourses);

        for (int s = 0; s <= prerequisites.length - 1; s++) {
            List<Integer> preRequisticOrDefault = subjectToPreRequistic.getOrDefault(prerequisites[s][0], new ArrayList<>());
            preRequisticOrDefault.add(prerequisites[s][1]);
            subjectToPreRequistic.put(prerequisites[s][0], preRequisticOrDefault);
        }

        for (int s = 0; s <= numCourses - 1; s++) {

            if (subjectToPreRequistic.get(s) == null) {
                subjectToPreRequistic.put(s, new ArrayList<>());
            }
        }


        Map<Integer, NodeStatus> nodeStatusMap = new HashMap<>(numCourses);
        for (Integer subjectId : subjectToPreRequistic.keySet()) {
            nodeStatusMap.put(subjectId, NodeStatus.UNPROCESSED);
        }

        Stack<Integer> order = new Stack<>();

        // trigger dfs from each node
        for (Integer subjectId : subjectToPreRequistic.keySet()) {

            if (!(nodeStatusMap.get(subjectId) == NodeStatus.COMPLETED)) {
                if (!dfs(subjectId, subjectToPreRequistic, nodeStatusMap, order)) {
                    return new int[0];
                }
            }
        }

        int[] courseOrder = new int[numCourses];

        for (int i = numCourses - 1; i >= 0; i--) {

            if (!order.isEmpty()) {
                courseOrder[i] = order.pop();
            }
        }
        return courseOrder;

    }

    private boolean dfs(Integer subjectId, Map<Integer, List<Integer>> subjectToPreRequistic,
                        Map<Integer, NodeStatus> nodeStatusMap, Stack<Integer> order) {

        if ((nodeStatusMap.get(subjectId) == NodeStatus.COMPLETED)) {
            return true;
        }

        // UNPROCESSED will go down
        nodeStatusMap.put(subjectId, NodeStatus.PROCESSING);
        for (Integer prerequisite : subjectToPreRequistic.get(subjectId)) {
            if (nodeStatusMap.get(prerequisite) == NodeStatus.PROCESSING) {
                return false;
            } else if (nodeStatusMap.get(prerequisite) == NodeStatus.UNPROCESSED) {
                nodeStatusMap.put(prerequisite, NodeStatus.PROCESSING);
                if (!dfs(prerequisite, subjectToPreRequistic, nodeStatusMap, order)) {
                    return false;
                }
            }
        }

        nodeStatusMap.put(subjectId, NodeStatus.COMPLETED);
        order.push(subjectId);
        return true;

    }

    public enum NodeStatus {
        UNPROCESSED,
        PROCESSING,
        COMPLETED;
    }


    public int[] findOrderApproach3(int numCourses, int[][] prerequisites) {

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

