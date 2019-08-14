package leetcodeProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixWithNearestDistanceToZero542 {
    public static void main(String[] args) {

        MatrixWithNearestDistanceToZero542 ob = new MatrixWithNearestDistanceToZero542();
//        int[][] matrix = {{0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}};

//        int[][] matrix = {{0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}};


        int[][] matrix = {{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};

        int[][] distanceMatrix = ob.updateMatrix(matrix);
        System.out.println(Arrays.deepToString(distanceMatrix));
    }

    public int[][] updateMatrix(int[][] matrix) {

        int[][] distance = new int[matrix.length][matrix[0].length];

        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Avoid using Pair<> class of java, instead use int[] array to save memory
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == 0) {
                    q.offer(new int[]{row, col});
                    distance[row][col] = 0;
                } else {
                    distance[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int[] dir : direction) {

                int x = current[0];
                int y = current[1];

                int newX = x + dir[0];
                int newY = y + dir[1];


                if (newX >= 0 && newX <= distance.length - 1 &&
                        newY >= 0 && newY <= distance[0].length - 1 &&
                        distance[newX][newY] > distance[x][y] + 1) {
                    distance[newX][newY] = distance[x][y] + 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        return distance;
    }
}
