/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set4;

public class MultiplyStrings43 {
    public static void main(String[] args) {

        MultiplyStrings43 ob = new MultiplyStrings43();
        String num1 = "123", num2 = "456";
        String multiply = ob.multiply(num2, num1);
        System.out.println(multiply);
    }

    // Not completed--> remaining to do
    public String multiply(String num1, String num2) {

        if (num1.length() == 1 && num1.charAt(0) == '0') {
            return "0";
        }


        if (num2.length() == 1 && num2.charAt(0) == '0') {
            return "0";
        }

        StringBuilder output = new StringBuilder();
        int remainder = 0;

        int i = num1.length() - 1;
        int offset = 0;

        while (i >= 0) {
            int x = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int j = num2.length() - 1;

            while (j >= 0) {

                if (i == num1.length() - 1) {

                    int y = Integer.parseInt(String.valueOf(num2.charAt(j)));
                    int value = (x * y) + remainder;

                    if (value >= 10) {
                        remainder = value / 10;
                        output.insert(0, value % 10);
                    } else {
                        remainder = 0;
                        output.insert(0, value);
                    }
                } else {

                    int y = Integer.parseInt(String.valueOf(num2.charAt(j)));
                    ;
                    int value = (x * y) + remainder + Integer.parseInt(String.valueOf(output.charAt(offset)));

                    if (value >= 10) {
                        remainder = value / 10;
                        output.insert(0, value % 10);
                    } else {
                        remainder = 0;
                        output.insert(0, value);
                    }
                }
                j--;
            }

            if (i == num1.length() - 1) {
                offset = output.length() - 2;
            } else {
                offset--;
            }
            i--;

            if (remainder > 0) {
                output.insert(0, remainder);
            }
        }
        return output.toString();

    }
}
