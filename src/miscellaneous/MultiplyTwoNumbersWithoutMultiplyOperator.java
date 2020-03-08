package miscellaneous;

public class MultiplyTwoNumbersWithoutMultiplyOperator {
    public static void main(String[] args) {

        MultiplyTwoNumbersWithoutMultiplyOperator ob = new MultiplyTwoNumbersWithoutMultiplyOperator();
        int x = 0, y = -20;

        int multiplyResult = ob.multiply(x, y);
        System.out.println(multiplyResult);

    }

    public int multiply(int x, int y) {

        boolean opposite = false;
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            opposite = true;
        }

        int result;

        x = Math.abs(x);
        y = Math.abs(y);

        if (Math.min(x, y) == x) {
            result = multiplyUtil(y, x);
        } else {
            result = multiplyUtil(x, y);
        }

        if (opposite) {
            result = result * -1;
        }

        return result;
    }

    private int multiplyUtil(int a, int b) {
        if (b == 0)
            return 0;

        a += multiplyUtil(a, b - 1);
        return a;
    }
}
