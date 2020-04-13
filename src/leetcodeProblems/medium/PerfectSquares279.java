package leetcodeProblems.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 ob = new PerfectSquares279();
        int minNumberOfSquares = ob.numSquares(12);
        System.out.println(minNumberOfSquares);
    }

    public int numSquares(int n) {
        if (n == 0 || n == 1)
            return n;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();


        int count = 1;
        for (int i = 1; i * i <= n; i++) {
            int remaining = n - (i * i);

            if (remaining == 0)
                return 1;

            q.offer(remaining);
            set.add(remaining);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int j = 1; j <= size; j++) {
                int number = q.poll();

                for (int i = 1; i * i <= number; i++) {
                    int remaining = number - (i * i);

                    if (remaining == 0)
                        return count;

                    if (set.contains(remaining))
                        continue;

                    q.offer(remaining);
                    set.add(remaining);
                }
            }
        }
        return count;
    }
}
