/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

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

        boolean[] notCelebrity = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!notCelebrity[i]) {
                for (int j = 0; j < n; j++) {

                    if (i != j) {
                        if (knows(i, j)) {
                            notCelebrity[i] = true;
                            break;
                        } else {
                            notCelebrity[j] = true;
                        }
                    }

                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (!notCelebrity[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {

                    if (i != j && knows(j, i)) {
                        count++;
                    }
                }
                if (count == n - 1) {
                    return i;
                }
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
