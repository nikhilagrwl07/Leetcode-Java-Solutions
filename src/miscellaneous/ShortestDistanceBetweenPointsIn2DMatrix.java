/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import javafx.util.Pair;

public class ShortestDistanceBetweenPointsIn2DMatrix {
    public static void main(String[] args) {


//    s represents ‘source’
//    d represents ‘destination’
//    * represents cell you can travel
//    0 represents cell you can not travel
        char[][] matrix = {{'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}};


//        char[][] matrix = {{'0', '*', '0', 's'},
//                {'*', '0', '*', '*'},
//                {'0', '*', '*', '*'},
//                {'d', '0', '0', '0'}};

        ShortestDistanceBetweenPointsIn2DMatrix ob = new ShortestDistanceBetweenPointsIn2DMatrix();
        int shortestDistanceFromSourceToDest = ob.shortestDistanceFromSourceToDest(matrix);
        System.out.println(shortestDistanceFromSourceToDest);

    }


    // DFS approach
    public int shortestDistanceFromSourceToDest(char[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
//        Queue<TreeNode> q = new LinkedList<>();

        Pair<Integer, Integer> source = new Pair<>(-1, -1);
        Pair<Integer, Integer> destination = new Pair<>(-1, -1);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == 's') {
                    source = new Pair<>(row, col);
                }

                if (matrix[row][col] == 'd') {
                    destination = new Pair<>(row, col);
                }

                if (matrix[row][col] == '0') {
                    isVisited[row][col] = true; // marking cells with '0' as true
                }
            }
        }

        return dfs(source.getKey(), source.getValue(), matrix, destination, isVisited);

    }


    // DFS approach
    public int dfs(int x, int y, char[][] matrix, Pair<Integer, Integer> destination, boolean[][] isVisited) {

        if (!isSafe(matrix, x, y, isVisited))
            return -1;

        if (x == destination.getKey() && y == destination.getValue()) {
            return 0;
        }

        isVisited[x][y] = true;

        int up = dfs(x + 1, y, matrix, destination, isVisited);
        int down = dfs(x - 1, y, matrix, destination, isVisited);
        int left = dfs(x, y - 1, matrix, destination, isVisited);
        int right = dfs(x, y + 1, matrix, destination, isVisited);

        int minDistance = Integer.MAX_VALUE;

        if (up != -1 && minDistance > up) {
            minDistance = up;
        }

        if (down != -1 && minDistance > down) {
            minDistance = down;
        }

        if (left != -1 && minDistance > left) {
            minDistance = left;
        }
        if (right != -1 && minDistance > right) {
            minDistance = right;
        }

        isVisited[x][y] = false;

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance + 1;
    }

    // BFS approach
//    public int shortestDistanceFromSourceToDest(char[][] matrix) {
//        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
//        Queue<TreeNode> q = new LinkedList<>();
//
//        Pair<Integer, Integer> source = new Pair<>(-1, -1);
//        Pair<Integer, Integer> destination = new Pair<>(-1, -1);
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//
//                if (matrix[row][col] == 's') {
//                    source = new Pair<>(row, col);
//                }
//
//                if (matrix[row][col] == 'd') {
//                    destination = new Pair<>(row, col);
//                }
//
//                if (matrix[row][col] == '0') {
//                    isVisited[row][col] = true; // marking cells with '0' as true
//                }
//            }
//        }
//
//
//        q.add(new TreeNode(source.getKey(), source.getValue(), 0));
//        isVisited[source.getKey()][source.getValue()] = true;
//
//        while (!q.isEmpty()) {
//
//            TreeNode node = q.poll();
//            if (node.x == destination.getKey() && node.y == destination.getValue()) {
//                return node.distance;
//            }
//
//
//            if (isSafe(matrix, node.x + 1, node.y, isVisited)) {
//                q.add(new TreeNode(node.x + 1, node.y, node.distance + 1));
//                isVisited[node.x + 1][node.y] = true;
//            }
//
//            if (isSafe(matrix, node.x - 1, node.y, isVisited)) {
//                q.add(new TreeNode(node.x - 1, node.y, node.distance + 1));
//                isVisited[node.x - 1][node.y] = true;
//            }
//
//            if (isSafe(matrix, node.x, node.y + 1, isVisited)) {
//                q.add(new TreeNode(node.x, node.y + 1, node.distance + 1));
//                isVisited[node.x][node.y + 1] = true;
//            }
//
//            if (isSafe(matrix, node.x, node.y - 1, isVisited)) {
//                q.add(new TreeNode(node.x, node.y - 1, node.distance + 1));
//                isVisited[node.x][node.y - 1] = true;
//            }
//        }
//
//        return -1;
//
//    }

    private boolean isSafe(char[][] matrix, int x, int y, boolean[][] isVisited) {

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || isVisited[x][y])
            return false;

        return true;

    }

    public class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
