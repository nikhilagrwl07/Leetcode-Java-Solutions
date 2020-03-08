package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 ob = new PerfectSquares279();
        int minNumberOfSquares = ob.numSquares(12);
        System.out.println(minNumberOfSquares);
    }


    // Approach #3
    // Greedy + BFS approach
    // Time Complexity - can't understand. Have to revisit
    public int numSquares(int n) {

        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }

    private List<Integer> squareNumbers = new ArrayList<>();

    // Approach #2
    // Recursive + Greedy
    // Time Complexity - can't understand. Have to revisit
    public int numSquaresGreedy(int n) {
        if (n == 1 || n == 0)
            return n;

        for (int i = 1; i * i <= n; i++) {
            squareNumbers.add(i * i);
        }

        for (int count = 1; count <= n; count++) {
            if (number_divided_into_count_factors(n, count))
                return count;
        }
        return n;
    }

    private boolean number_divided_into_count_factors(int number, int count) {
        if (count == 1)
            return squareNumbers.contains(number);

        for (int index = 0; index <= squareNumbers.size() - 1; index++) {
            if (number_divided_into_count_factors(number - squareNumbers.get(index), count - 1)) {
                return true;
            }
        }
        return false;
    }


    // Approach #1
    //  Recursive approach
    // numSquares(n) =  numSquares(n-k) + 1 for all perfect squares k < n
    public int numSquaresRecursive(int n) {
        if (n == 1 || n == 0)
            return n;

        int squareRoot = (int) Math.sqrt(n);

        int min = Integer.MAX_VALUE;
        for (; squareRoot >= 1; squareRoot--) {
            min = Math.min(min, numSquaresRecursive(n - (squareRoot * squareRoot)) + 1);
        }
        return min;
    }
}
