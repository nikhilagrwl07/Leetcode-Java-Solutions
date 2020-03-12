package practice;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZombieInMatrix {
    public static void main(String[] args) {
        ZombieInMatrix ob = new ZombieInMatrix();

//        List<List<Integer>> matrix = Arrays.asList(
//                Arrays.asList(0, 1, 1, 0, 1),
//                Arrays.asList(0, 1, 0, 1, 0),
//                Arrays.asList(0, 0, 0, 0, 0),
//                Arrays.asList(0, 1, 0, 0, 1)
//        );


        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(0, 0)
        );

        int minHours = ob.minHours(matrix.size() - 1, matrix.get(0).size() - 1, matrix);
        System.out.println(minHours);
    }

    public int minHours(int rows, int columns, List<List<Integer>> grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int visitedNodesCount = 0, timeElapsed = 0;
        int totalCells = grid.size() * grid.get(0).size();

        for (int i = 0; i <= rows; i++) {
            List<Integer> col = grid.get(i);
            for (int j = 0; j <= columns; j++) {
                if (col.get(j) == 1) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    q.offer(pair);
                    visitedNodesCount++;
                }
            }
        }
        int[][] neighbours = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

        while (!q.isEmpty()) {
            int size = q.size();

            if (visitedNodesCount == totalCells)
                return timeElapsed;

            while (size > 0) {
                Pair<Integer, Integer> pair = q.poll();
                int x = pair.getKey();
                int y = pair.getValue();

                for (int[] neighbour : neighbours) {

                    int nr = x + neighbour[0];
                    int nc = y + neighbour[1];

                    if (nr >= 0 && nr <= rows && nc >= 0 && nc <= columns && grid.get(nr).get(nc) == 0) {
                        Pair<Integer, Integer> p = new Pair<>(nr, nc);
                        grid.get(nr).set(nc, 1);
                        visitedNodesCount++;
                        q.offer(p);
                    }
                }
                size--;
            }
            timeElapsed++;
        }
        return -1;  // -1 indicates that no cell has zombie. All are human cells so it's impossible
                    // to convert all humans to zombie
    }
}
