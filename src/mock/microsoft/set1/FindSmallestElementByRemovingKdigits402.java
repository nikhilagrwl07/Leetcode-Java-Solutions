/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set1;

public class FindSmallestElementByRemovingKdigits402 {
    public static void main(String[] args) {
        FindSmallestElementByRemovingKdigits402 ob = new FindSmallestElementByRemovingKdigits402();
        int k = 1;
//        String input = "1432219";
        String input = "100";
//        String input = "10200";
//        String input = "1000";
//        String input = "112";

        String removeKdigits = ob.removeKdigits(input, k);
        System.out.println(removeKdigits);

    }

    public String removeKdigits(String num, int k) {

        if (num == null || num.isEmpty()) {
            return "0";
        }

        if (k == num.length()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        result.append(num.charAt(0));

        for (int i = 1; i < num.length(); i++) {

            while (result.length() >= 1 && k > 0 &&
                    Character.getNumericValue(result.charAt(result.length() - 1)) >
                            Character.getNumericValue(num.charAt(i))) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(num.charAt(i));
        }

        // remove from last of result until k becomes 0
        while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        // remove an starting zeros
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            result.deleteCharAt(0);
        }

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();

    }
}
