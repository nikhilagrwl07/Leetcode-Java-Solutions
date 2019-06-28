package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class CutOffTrees675 {
    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();

//        List<Integer> f3 = new ArrayList<>();
//        f3.add(1);
//        f3.add(2);
//        f3.add(3);
//        forest.add(f3);
//
//        List<Integer> f2 = new ArrayList<>();
//        f2.add(0);
//        f2.add(0);
//        f2.add(5);
//        forest.add(f2);
//
//
//        List<Integer> f1 = new ArrayList<>();
//        f1.add(8);
//        f1.add(7);
//        f1.add(6);
//        forest.add(f1);

        Integer[][] array = {
                {54581641, 64080174, 24346381, 69107959},
                {86374198, 61363882, 68783324, 79706116},
                {668150, 92178815, 89819108, 94701471},
                {83920491, 22724204, 46281641, 47531096},
                {89078499, 18904913, 25462145, 60813308}
        };

        forest = twoDArrayToList(array);

        CutOffTrees675 ob = new CutOffTrees675();
        int steps = ob.cutOffTree(forest);
        System.out.println(steps);
    }

    public static <Integer> List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (Integer[] array : twoDArray) {
            List<Integer> l = new ArrayList<>(Arrays.asList(array));
            list.add(l);
        }
        return list;
    }


    private int cutOffTree(List<List<Integer>> forest) {

        if (forest.isEmpty()) {
            return -1;
        }

        boolean[][] isVisited = constructIsVisited(forest);
        Queue<Entry> q = new LinkedList<>();
        int row = 0, column = 0;
        q.add(new Entry(row, column, 0));
        isVisited[row][column] = true;
        markCutDown(forest, row, column);

        int maximumSteps = Integer.MIN_VALUE;

        int[] tree = findTargetTree(forest);

        while (!q.isEmpty()) {

            Entry entry = q.remove();

            if (isAllTreeCut(isVisited, forest) &&
                    entry.row == tree[0] && entry.column == tree[1]) { //entry.distance > maximumSteps &&
                maximumSteps = entry.distance;
                break;
            }

            row = entry.row;
            column = entry.column;

            // Going right
            int r = row;
            int c = column + 1;
            if (isSafe(forest, r, c) && !isVisited[r][c]) {
                q.add(new Entry(r, c, entry.distance + 1));

                if (forest.get(r).get(c) > 1) {
                    isVisited[r][c] = true;
                    markCutDown(forest, row, column);
                }
            }

            // Going left
            r = row;
            c = column - 1;
            if (isSafe(forest, r, c) && !isVisited[r][c]) {
                q.add(new Entry(r, c, entry.distance + 1));

                if (forest.get(r).get(c) > 1) {
                    isVisited[r][c] = true;
                    markCutDown(forest, row, column);
                }
            }

            // Going up
            r = row - 1;
            c = column;
            if (isSafe(forest, r, c) && !isVisited[r][c]) {
                q.add(new Entry(r, c, entry.distance + 1));

                if (forest.get(r).get(c) > 1) {
                    isVisited[r][c] = true;
                    markCutDown(forest, row, column);
                }
            }

            r = row + 1;
            c = column;
            if (isSafe(forest, r, c) && !isVisited[r][c]) {
                q.add(new Entry(r, c, entry.distance + 1));

                if (forest.get(r).get(c) > 1) {
                    isVisited[r][c] = true;
                    markCutDown(forest, row, column);
                }
            }
        }

        return maximumSteps;
    }

    private void markCutDown(List<List<Integer>> forest, int row, int column) {

        List<Integer> forestRow = forest.get(row);
        forestRow.set(column, 1);
        forest.set(row, forestRow);
    }

    private int[] findTargetTree(List<List<Integer>> forest) {

        int[] result = new int[2];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                {
                    if (maxValue < forest.get(i).get(j)) {    // || forest.get(i).get(j) == 1
                        maxValue = forest.get(i).get(j);
                        result[0] = i;
                        result[1] = j;
                    }
                }

            }
        }
        return result;
    }

    private boolean isAllTreeCut(boolean[][] isVisited, List<List<Integer>> forest) {

        for (int i = 0; i < isVisited.length; i++) {

            for (int j = 0; j < isVisited[i].length; j++) {
                if (forest.get(i).get(j) > 1 && !isVisited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[][] constructIsVisited(List<List<Integer>> forest) {

        boolean[][] isVisted = new boolean[forest.size()][forest.get(0).size()];


        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                {
                    if (forest.get(i).get(j) == 0) {    // || forest.get(i).get(j) == 1
                        isVisted[i][j] = true;
                    }
                }

            }
        }
        return isVisted;
    }

    private boolean isSafe(List<List<Integer>> forest, int r, int c) {

        return r >= 0 && r <= forest.size() - 1 && c >= 0 && c <= forest.get(r).size() - 1;

    }

    static class Entry {
        private int row;
        private int column;
        private int distance;

        public Entry(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }
}


//    private int[] findUnvisitedAndMinimum(int row, int column, boolean[][] isVisited,
//                                          List<List<Integer>> forest, Queue<Entry> q) {
//
//        int currentHeight = forest.get(row).get(column);
//
//
//        int minNext = Integer.MAX_VALUE;
//        int rNext = -1;
//        int cNext = -1;
//
//        // Going right
//        int r = row;
//        int c = column + 1;
//        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
//            if (minNext > forest.get(r).get(c)) {
//                minNext = forest.get(r).get(c);
//                rNext = r;
//                cNext = c;
//            }
//        }
//
//        // Going left
//        r = row;
//        c = column - 1;
//        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
//            if (minNext > forest.get(r).get(c)) {
//                minNext = forest.get(r).get(c);
//                rNext = r;
//                cNext = c;
//            }
//        }
//
//        // Going up
//        r = row - 1;
//        c = column;
//        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
//            if (minNext > forest.get(r).get(c)) {
//                minNext = forest.get(r).get(c);
//                rNext = r;
//                cNext = c;
//            }
//        }
//
//        //Going down
//        r = row + 1;
//        c = column;
//        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
//            if (minNext > forest.get(r).get(c)) {
//                minNext = forest.get(r).get(c);
//                rNext = r;
//                cNext = c;
//            }
//        }
//
////        // Going topLeft
////        r = row - 1;
////        c = column - 1;
////        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
////            if (minNext > forest.get(r).get(c)) {
////                minNext = forest.get(r).get(c);
////                rNext = r;
////                cNext = c;
////            }
////        }
////
////        //Going topRight
////        r = row - 1;
////        c = column + 1;
////        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
////            if (minNext > forest.get(r).get(c)) {
////                minNext = forest.get(r).get(c);
////                rNext = r;
////                cNext = c;
////            }
////        }
////
////        //Going BottomRight
////        r = row + 1;
////        c = column + 1;
////        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
////            if (minNext > forest.get(r).get(c)) {
////                minNext = forest.get(r).get(c);
////                rNext = r;
////                cNext = c;
////            }
////        }
////
////        //Going BottomLeft
////        r = row + 1;
////        c = column - 1;
////        if (isSafe(forest, r, c) && !isVisited[r][c] && forest.get(r).get(c) > currentHeight) {
////            if (minNext > forest.get(r).get(c)) {
////                minNext = forest.get(r).get(c);
////                rNext = r;
////                cNext = c;
////            }
////        }
//
//        int[] result = new int[2];
//        result[0] = rNext;
//        result[1] = cNext;
//        return result;
//    }
