/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set5;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public static void main(String[] args) {

        FloodFill733 ob = new FloodFill733();

        int[][] mat = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(Arrays.deepToString(mat));
        int[][] floodFill = ob.floodFill(mat, 1, 1, 2);
        System.out.println(Arrays.deepToString(floodFill));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int startPixelColor = image[sr][sc];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr, sc));
        boolean[][] isVisited = new boolean[image.length][image[0].length];

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.remove();

            image[pair.getKey()][pair.getValue()] = newColor;


            int x = pair.getKey();
            int y = pair.getValue();

            if (isSafe(x, y + 1, image) && !isVisited[x][y + 1] && image[x][y + 1] == startPixelColor) {
                q.add(new Pair<>(x, y + 1));
                isVisited[x][y + 1] = true;
            }

            if (isSafe(x, y - 1, image) && !isVisited[x][y - 1] && image[x][y - 1] == startPixelColor) {
                q.add(new Pair<>(x, y - 1));
                isVisited[x][y - 1] = true;
            }

            if (isSafe(x + 1, y, image) && !isVisited[x + 1][y] && image[x + 1][y] == startPixelColor) {
                q.add(new Pair<>(x + 1, y));
                isVisited[x + 1][y] = true;
            }

            if (isSafe(x - 1, y, image) && !isVisited[x - 1][y] && image[x - 1][y] == startPixelColor) {
                q.add(new Pair<>(x - 1, y));
                isVisited[x - 1][y] = true;
            }
        }

        return image;
    }

    private boolean isSafe(int x, int y, int[][] image) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return false;

        return true;
    }
}
