package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParantheses22 {
    public static void main(String[] args) {

        GenerateParantheses22 ob = new GenerateParantheses22();

        System.out.println(ob.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        char[] c = new char[n*2];
        List<String> result = new ArrayList<>();
        recur(0, 0, n, c, 0, result);
        return result;
    }

    public void recur(int open, int closed, int n, char[] c, int index, List<String> result) {

        if (closed > open)
            return;

        if (closed == n && open == n) {
            result.add(new String(c));
            return;
        }

        if (open + 1 <= n) {
            c[index] = '(';
            recur(open + 1, closed, n, c, index + 1, result);
        }

        if (closed + 1 <= open) {
            c[index] = ')';
            recur(open, closed + 1, n, c, index + 1, result);
        }

    }
}
