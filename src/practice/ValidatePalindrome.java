package practice;

public class ValidatePalindrome {
    public static void main(String[] args) {
        ValidatePalindrome ob = new ValidatePalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "0P";
        String s4 = "QPPQ";

        System.out.println(ob.isPalindrome(s1));
        System.out.println(ob.isPalindrome(s2));
        System.out.println(ob.isPalindrome(s3));
        System.out.println(ob.isPalindrome(s4));

    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        if (s.length() == 1)
            return true;

        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {

            // find best possible char from left
            while (i < j && ((s.charAt(i) - 'a' < 0 || s.charAt(i) - 'a' > 25)) && !Character.isDigit(s.charAt(i))) {
                i++;
            }

            // find best possible char from right
            while (i < j && ((s.charAt(j) - 'a' < 0 || s.charAt(j) - 'a' > 25)) && !Character.isDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
