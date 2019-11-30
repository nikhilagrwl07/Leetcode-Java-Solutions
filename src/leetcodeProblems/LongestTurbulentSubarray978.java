package leetcodeProblems;

public class LongestTurbulentSubarray978 {
    public static void main(String[] args) {

        LongestTurbulentSubarray978 ob = new LongestTurbulentSubarray978();
//        int[] inputA = {9, 4, 2, 10, 7, 8, 1, 9};
        int[] inputA = {9, 4, 2, 10, 7, 8};
        int turbulenceSize = ob.maxTurbulenceSize(inputA);
        System.out.println(turbulenceSize);
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1)
            return 1;

        int maxLengthSoFar = Integer.MIN_VALUE;
        int index = 0;
        Direction currentDirection = null;
        while (index + 1 <= A.length - 1) {
            if (A[index] < A[index + 1]) {
                currentDirection = Direction.LESS;
//                index++;
                maxLengthSoFar = 2;
                break;
            } else if (A[index] > A[index + 1]) {
                currentDirection = Direction.MORE;
                maxLengthSoFar = 2;
//                index++;
                break;
            }
            index++;
        }

        if (currentDirection == null)
            return 0;

        int startIndex = index;

        while (index + 1 <= A.length - 1) {

            if (currentDirection == Direction.LESS) {
                if (A[index] <= A[index + 1]) {
                    maxLengthSoFar = Math.max(maxLengthSoFar, index - startIndex + 1);
                    index++;
                    startIndex = index;
                } else {
                    index++;
                    currentDirection = Direction.MORE;
                }
            } else if (currentDirection == Direction.MORE) {
                if (A[index] >= A[index + 1]) {
                    maxLengthSoFar = Math.max(maxLengthSoFar, index - startIndex + 1);
                    index++;
                    startIndex = index;
                } else {
                    index++;
                    currentDirection = Direction.LESS;
                }
            }
        }

        if (index == A.length - 1) {
            maxLengthSoFar = Math.max(maxLengthSoFar, index - startIndex + 1);
        }
        return maxLengthSoFar;
    }


    public enum Direction {
        LESS, MORE;
    }
}

