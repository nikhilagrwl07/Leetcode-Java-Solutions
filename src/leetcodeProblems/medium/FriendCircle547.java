package leetcodeProblems.medium;

import java.util.HashSet;
import java.util.Set;

public class FriendCircle547 {
    public static void main(String[] args) {
        FriendCircle547 ob = new FriendCircle547();
        int[][] matrix1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] matrix2 = {{1, 1, 0}, {1, 1, 1}, {0, 0, 1}};
        int[][] matrix3 = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};

        System.out.println(ob.findCircleNum(matrix1));
        System.out.println(ob.findCircleNum(matrix2));
        System.out.println(ob.findCircleNum(matrix3));
    }

    public int findCircleNum(int[][] M) {
        int result = 0;

        boolean connected = false;
        Set<Integer> isVisited = new HashSet<>();
        for (int r = 0; r < M.length; r++) {
            for (int c = r; c < M[0].length; c++) {
                if (isVisited.contains(r))
                    break;
                else if (M[r][c] == 1) {
                    dfs(M, r, c, isVisited);
                    connected = true;
                }
            }
            if (connected)
                result++;

            isVisited.add(r);
            connected = false;
        }
        return result;
    }

    void dfs(int[][] m, int r, int c, Set<Integer> isVisited) {
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length || m[r][c] == 0)
            return;

        m[r][c] = 0;

        for (int newC = 0; newC < m.length; newC++) {
            if (m[c][newC] == 1)
                dfs(m, c, newC, isVisited);
        }
        isVisited.add(c);
    }
}
