/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class ClimbingStairs70 {
    public static void main(String[] args) {

        ClimbingStairs70 ob = new ClimbingStairs70();
        int climbStairs = ob.climbStairs(1);
        System.out.println(climbStairs);
    }

    public int climbStairs(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int steps[] = new int[n];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i <= steps.length - 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[steps.length - 1];
    }
}
