/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set7;

import java.util.*;

public class CourseScheduleOrder {
    public static void main(String[] args) {
//        int courses = 2;
//        int[][] prerequisites = {{1, 0}, {0, 1}};

//        int courses = 3;
//        int[][] prerequisites = {{2, 0}, {2, 1}};
//        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};

//        int courses = 4;
//        int[][] prerequisites = {{3, 0}, {0, 1}};

        int courses = 3;
        int[][] prerequisites = {{0, 1}};

//        int[][] prerequisites = {{1, 0}};

        CourseScheduleOrder ob = new CourseScheduleOrder();
        int[] canFinish = ob.findOrder(courses, prerequisites);
        System.out.println(Arrays.toString(canFinish));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

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


}
