package practice;

public class VerifyPerfectSquareNumber {
    public static void main(String[] args) {
        VerifyPerfectSquareNumber ob = new VerifyPerfectSquareNumber();
         int number1 = 15;
         int number2 = 16;
         int number3 = 5;
         int number4 = 29;


        System.out.println(ob.isPerfectSquare(number1));
        System.out.println(ob.isPerfectSquare(number2));
        System.out.println(ob.isPerfectSquare(number3));
        System.out.println(ob.isPerfectSquare(number4));

    }

    public boolean isPerfectSquare(int n) {
        if (n < 0)
            return false;
        if (n == 0 || n == 1)
            return true;

        int half = n / 2;
        return binarySearch(1, half, n);

    }

    private boolean binarySearch(int low, int high, int target) {
        if (low > high)
            return false;

        if (low == high)
            return low * low == target;

        int mid = low + (high - low) / 2;
        int square = mid * mid;

        if (square == target)
            return true;

        if(square > target)
            return binarySearch(mid+1, high, target);
        else
            return binarySearch(low, mid-1, target);

    }
}
