package leetcodeProblems.medium;

import java.util.*;

public class TaskScheduler621 {
    public static void main(String[] args) {

//        char[] tasks = {'B', 'F', 'J', 'J', 'H', 'A', 'D', 'C', 'C', 'D', 'J', 'E', 'B', 'E', 'C', 'H', 'E', 'E', 'G', 'E', 'H', 'I', 'I', 'E', 'H', 'F', 'C', 'G', 'H', 'F', 'E', 'E', 'I', 'D', 'D', 'A', 'E', 'A', 'C', 'E', 'F', 'J', 'E', 'F', 'G', 'J', 'A', 'A', 'A', 'B', 'E', 'J', 'H', 'C', 'A', 'E', 'D', 'A', 'E', 'I', 'H', 'B', 'A', 'C', 'E', 'F', 'J', 'D', 'F', 'I', 'I', 'H', 'J', 'E', 'B', 'H', 'H', 'A', 'J', 'C', 'C', 'D', 'C', 'B', 'C', 'H', 'H', 'I', 'H', 'D', 'C', 'B', 'D', 'C', 'H', 'A', 'F', 'A', 'J', 'D', 'F', 'E', 'H', 'I', 'D', 'A', 'E', 'B', 'H', 'J', 'F', 'D', 'C', 'J', 'J', 'I', 'A', 'I', 'J', 'H', 'A', 'I', 'I', 'G', 'C', 'C', 'H', 'D', 'B', 'B', 'B', 'H', 'I', 'D', 'B', 'C', 'H', 'I', 'I', 'G', 'E', 'D', 'D', 'A', 'E', 'D', 'H', 'C', 'J', 'H', 'C', 'E', 'I', 'F', 'A', 'I', 'E', 'G', 'A', 'E', 'F', 'I', 'B', 'J', 'B', 'J', 'B', 'G', 'A', 'D', 'C', 'B', 'I', 'A', 'C', 'J', 'J', 'J', 'B', 'E', 'E', 'E', 'B', 'E', 'B', 'H', 'B', 'J', 'H', 'F', 'G', 'B', 'B', 'I', 'C', 'D', 'I', 'D', 'D', 'A', 'I', 'D', 'H', 'A', 'J', 'D', 'J', 'D', 'I', 'G', 'F', 'F', 'B', 'G', 'A', 'F', 'I', 'I', 'H', 'C', 'B', 'H', 'H', 'E', 'F', 'A', 'H', 'G', 'F', 'D', 'G', 'F', 'A', 'C', 'F', 'D', 'F', 'C', 'J', 'A', 'D', 'H', 'G', 'D', 'D', 'G', 'C', 'G', 'C', 'I', 'B', 'G', 'E', 'J', 'C', 'G', 'J', 'G', 'E', 'F', 'F', 'I', 'D', 'D', 'E', 'G', 'F', 'A', 'F', 'H', 'D', 'C', 'B', 'E', 'H', 'G', 'H', 'B', 'A', 'D', 'A', 'J', 'A', 'C', 'B', 'G', 'C', 'A', 'J', 'E', 'I', 'G', 'H', 'J', 'A', 'J', 'I', 'D', 'I', 'G', 'B', 'G', 'I', 'A', 'B', 'J', 'B', 'H', 'E', 'G', 'G', 'I', 'G', 'G', 'C', 'J', 'J', 'J', 'H', 'G', 'A', 'G', 'B', 'G', 'I', 'G', 'A', 'D', 'B', 'A', 'E', 'I', 'H', 'E', 'G', 'H', 'J', 'F', 'H', 'I', 'A', 'E', 'A', 'I', 'A', 'D', 'D', 'B', 'D', 'G', 'E', 'C', 'J', 'C', 'C', 'B', 'F', 'F', 'B', 'E', 'A', 'G', 'D', 'I', 'G', 'D', 'J', 'D', 'G', 'I', 'B', 'J', 'J', 'B', 'F', 'D', 'I', 'C', 'I', 'B', 'J', 'B', 'D', 'D', 'A', 'D', 'C', 'G', 'A', 'G', 'C', 'G', 'C', 'E', 'C', 'G', 'A', 'J', 'C', 'E', 'F', 'C', 'C', 'E', 'J', 'D', 'H', 'H', 'F', 'E', 'D', 'G', 'E', 'E', 'I', 'B', 'G', 'A', 'C', 'C', 'E', 'J', 'F', 'H', 'C', 'A', 'G', 'H', 'G', 'A', 'G', 'A', 'D', 'B', 'E', 'F', 'H', 'C', 'C', 'B', 'I', 'F', 'H', 'I', 'C', 'H', 'G', 'G', 'C', 'E', 'A', 'J', 'F', 'F', 'F', 'B', 'D', 'I', 'E', 'I', 'F', 'E', 'F', 'G', 'G', 'A', 'D', 'I', 'A', 'J', 'A', 'H', 'J', 'I', 'H', 'H', 'A', 'B', 'B', 'B', 'I', 'C', 'J', 'C', 'G', 'J', 'G', 'E', 'I', 'H', 'D', 'E', 'H', 'J', 'A', 'G', 'A', 'G', 'A', 'C', 'F', 'C', 'G', 'E', 'G', 'J', 'D', 'H', 'H', 'B', 'J', 'F', 'J', 'J', 'B', 'J', 'D', 'D', 'G', 'B', 'I', 'I', 'H', 'G', 'B', 'I', 'E', 'D', 'H', 'H', 'I', 'B', 'A', 'A', 'A', 'D', 'H', 'J', 'H', 'D', 'J', 'E', 'D', 'G', 'J', 'B', 'B', 'F', 'G', 'J', 'G', 'E', 'G', 'E', 'E', 'F', 'H', 'F', 'J', 'A', 'G', 'I', 'D', 'C', 'H', 'A', 'C', 'F', 'B', 'J', 'E', 'I', 'A', 'G', 'J', 'D', 'I', 'F', 'I', 'J', 'H', 'E', 'D', 'J', 'A', 'E', 'G', 'B', 'B', 'J', 'I', 'J', 'H', 'F', 'D', 'F', 'F', 'A', 'G', 'F', 'F', 'I', 'C', 'H', 'E', 'E', 'G', 'A', 'D', 'F', 'I', 'D', 'D', 'C', 'B', 'G', 'C', 'D', 'G', 'H', 'F', 'D', 'J', 'D', 'B', 'A', 'J', 'J', 'I', 'H', 'F', 'G', 'D', 'J', 'H', 'I', 'H', 'I', 'A', 'A', 'I', 'C', 'B', 'H', 'G', 'I', 'C', 'F', 'E', 'J', 'J', 'F', 'F', 'D', 'F', 'A', 'J', 'H', 'B', 'G', 'A', 'F', 'D', 'G', 'D', 'C', 'F', 'J', 'F', 'G', 'D', 'H', 'J', 'C', 'A', 'E', 'C', 'G', 'J', 'G', 'I', 'C', 'G', 'H', 'G', 'J', 'D', 'D', 'G', 'D', 'F', 'F', 'J', 'B', 'D', 'C', 'E', 'F', 'G', 'D', 'A', 'J', 'H', 'D', 'F', 'C', 'B', 'H', 'C', 'I', 'D', 'C', 'F', 'E', 'C', 'D', 'J', 'D', 'E', 'G', 'C', 'D', 'H', 'J', 'E', 'H', 'I', 'I', 'A', 'C', 'E', 'C', 'I', 'B', 'A', 'B', 'E', 'E', 'H', 'E', 'B', 'H', 'C', 'G', 'B', 'C', 'C', 'D', 'G', 'G', 'A', 'F', 'A', 'B', 'D', 'G', 'F', 'A', 'H', 'G', 'C', 'E', 'D', 'B', 'H', 'D', 'F', 'F', 'G', 'A', 'J', 'H', 'E', 'B', 'C', 'B', 'B', 'B', 'H', 'D', 'F', 'B', 'B', 'C', 'G', 'A', 'C', 'E', 'J', 'H', 'F', 'F', 'D', 'G', 'J', 'D', 'F', 'J', 'G', 'H', 'B', 'D', 'B', 'D', 'D', 'G', 'J', 'H', 'B', 'D', 'F', 'E', 'E', 'G', 'D', 'H', 'B', 'A', 'I', 'E', 'B', 'E', 'B', 'D', 'I', 'C', 'A', 'A', 'E', 'J', 'A', 'B', 'A', 'F', 'C', 'J', 'F', 'F', 'F', 'A', 'I', 'J', 'F', 'H', 'G', 'C', 'F', 'E', 'D', 'C', 'B', 'C', 'G', 'G', 'G', 'A', 'B', 'J', 'J', 'F', 'J', 'G', 'C', 'D', 'B', 'C', 'F', 'H', 'I', 'F', 'D', 'C', 'I', 'J', 'D', 'I', 'G', 'B', 'G', 'I', 'J', 'E', 'H', 'G', 'G', 'J', 'J', 'A', 'E', 'E', 'I', 'G', 'E', 'H', 'F', 'F', 'C', 'A', 'J', 'I', 'I', 'D', 'C', 'E', 'G', 'A', 'A', 'H', 'F', 'A', 'I', 'B', 'H', 'J', 'H', 'B', 'H', 'A', 'A', 'A', 'G', 'I', 'I', 'D', 'F', 'F', 'C', 'H', 'D', 'B', 'J', 'F', 'G', 'E', 'F', 'J', 'A', 'I', 'G', 'J', 'J', 'F', 'F', 'G', 'B', 'B', 'D', 'F', 'E', 'G', 'D', 'D', 'A', 'D', 'D', 'G', 'C', 'C', 'I', 'C', 'H', 'I', 'C', 'E', 'G', 'C', 'E', 'J', 'F', 'G', 'J', 'B', 'I', 'B', 'B', 'C', 'B', 'G', 'A', 'J', 'H', 'C', 'G', 'D', 'E', 'H', 'E', 'H', 'A', 'H', 'I', 'A', 'J', 'C', 'G', 'B', 'G', 'H', 'G', 'H'};
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A'}; // 10 waiting time + 6
//        char[] tasks = {'A','A'};
        int n = 4;

        TaskScheduler621 ob = new TaskScheduler621();
        int totalTimeTaken = ob.leastInterval(tasks, n);
        System.out.println(totalTimeTaken);

    }

    public int leastInterval(char[] tasks, int n) {

        int[] occurrence = new int[26];

        // finding freq of tasks
        for (char task : tasks) {
            occurrence[task - 'A'] += 1;
        }

        // inserting tasks in PQ
        Queue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int task : occurrence) {
            if (task > 0)
                pq.offer(task);
        }

        int time = 0; // global level time
        List<Integer> tempTasks = new ArrayList<>();

        while (!pq.isEmpty()) {
            int coolingTimer = 0;
            tempTasks.clear();

            while (coolingTimer <= n) {

                if (!pq.isEmpty()) {
                    // if freq > 1
                    if (pq.peek() > 1)
                        tempTasks.add(pq.poll() - 1);
                        // if freq is 1
                    else
                        pq.poll();
                }

                time++;
                coolingTimer++;

                if (tempTasks.isEmpty() && pq.isEmpty())
                    break;
            }
            pq.addAll(tempTasks);
        }
        return time;

    }

}
