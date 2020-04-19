package leetcodeProblems.easy;

import java.util.Arrays;

public class FloodFill733 {
    public static void main(String[] args) {
        FloodFill733 ob = new FloodFill733();
//        int[][] image = {
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1},
//        };

        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println(Arrays.deepToString(image));
        ob.floodFill(image, 1, 1, 1);
        System.out.println(Arrays.deepToString(image));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image[sr][sc]==newColor)
            return image;

        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    // DFS
    // Time - O(Rows * Columns)
    // Space - O(Rows * Columns) in worst case
    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {


        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;

        if(image[sr][sc]==newColor)
            return;

        image[sr][sc]= newColor;

        if(sr-1>=0 && image[sr-1][sc]==oldColor) floodFill(image, sr-1, sc, newColor);
        if(sr+1<=image.length-1 && image[sr+1][sc]==oldColor) floodFill(image, sr+1, sc, newColor);

        if(sc-1>=0 && image[sr][sc-1]==oldColor) floodFill(image, sr, sc-1, newColor);
        if(sc+1<=image[0].length-1 && image[sr][sc+1]==oldColor) floodFill(image, sr, sc+1, newColor);


    }

    // BFS
    // Time - O(Rows * Columns)
    // Space - O(Rows * Columns) in worst case
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int oldColor = image[sr][sc];
//        int r = image.length - 1;
//
//        if(oldColor==newColor)
//            return image;
//
//        int c = image[0].length - 1;
//        Queue<Integer> q = new LinkedList<>();
//
//        int cCount = image[0].length;
//
//        q.offer(sr * cCount + sc);
//        image[sr][sc] = newColor;
//
//        int[][] nei = {
//                {-1, 0},
//                {1, 0},
//                {0, -1},
//                {0, 1},
//        };
//
//        while (!q.isEmpty()) {
//            Integer current = q.poll();
//            int x = current / cCount;
//            int y = current % cCount;
//
//
//            for (int[] ne : nei) {
//                int newX = x + ne[0];
//                int newY = y + ne[1];
//
//                if (newX >= 0 && newX <= r && newY >= 0 && newY <= c && image[newX][newY] == oldColor) {
//                    image[newX][newY] = newColor;
//                    q.offer(newX * cCount + newY);
//                }
//            }
//        }
//        return image;
//    }
}
