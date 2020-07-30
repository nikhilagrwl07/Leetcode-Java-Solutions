package leetcodeProblems.medium;

public class FindCelebrity277 {

    //        int[][] friends = {{1, 1, 1}, {1, 1, 0}, {0, 0, 1}};
    int[][] friends = {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
//    int[][] friends = {{1, 0}, {0, 1}};

    public static void main(String[] args) {

        FindCelebrity277 ob = new FindCelebrity277();
        int celebrity = ob.findCelebrity(3);
        System.out.println(celebrity);
    }


    public int findCelebrity(int n) {

        for (int col = 0; col < n; col++) {

            boolean isCelebrity = true;
            for (int row = 0; row < n; row++) {

                if (col != row && !knows(row, col)) {
                    isCelebrity = false;
                    break;
                }
            }

            if (isCelebrity) {

                int r = col;
                boolean isRowCelebrity = true;
                for (int c = 0; c < n; c++) {

                    if (r != c && knows(r, c)) {
                        isRowCelebrity = false;
                        break;
                    }
                }

                if (isRowCelebrity)
                    return col;

            }
        }

        return -1;

    }

    boolean knows(int a, int b) {

        if (friends[a][b] == 1) {
            return true;
        }
        return false;
    }
}
