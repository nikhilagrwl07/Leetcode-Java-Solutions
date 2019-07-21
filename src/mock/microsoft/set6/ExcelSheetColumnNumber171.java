/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set6;

public class ExcelSheetColumnNumber171 {
    public static void main(String[] args) {
        ExcelSheetColumnNumber171 ob = new ExcelSheetColumnNumber171();

        int titleToNumber = ob.titleToNumber("ZY");
        System.out.println(titleToNumber);
    }

    public int titleToNumber(String s) {

        int result = 0;
        int base = 26;
        int power = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            int currentValue = s.charAt(i) - 'A' + 1;
            result += Math.pow(base, power++) * currentValue;

        }
        return result;

    }
}
