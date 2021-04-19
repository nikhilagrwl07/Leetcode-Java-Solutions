package java8;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        System.out.println(solution(54));
    }

    public static long solution(long n) {
        return ways(n);
    }

    public static long ways(long target) {
        if (target == 0 || target == 1)
            return target;

        long[] steps = new long[3];
        steps[0] = 1;
        steps[1] = 2;
        steps[2] = 3;

        long startingSum = 0;

        long[] result = new long[1];
        result[0] = 0;

        Map<Long, Long> lookup = new HashMap<>();


        recursion(target, startingSum, steps, result, lookup);
        return result[0];
    }

    public static void recursion(long target, long startingSum, long[] steps, long[] result, Map<Long, Long> lookup) {
        if (startingSum > target) return;

        if(lookup.containsKey(target-startingSum)){
            result[0] += lookup.get(target-startingSum);
            return;
        }

        lookup.put(target, result[0]);

        if (target == startingSum) {
            result[0] += 1L;
            return;
        }

        for (long s : steps) {
            recursion(target, startingSum + s, steps, result, lookup);
        }

    }

}
