/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.Arrays;

public class StringCompression443 {
    public static void main(String[] args) {

//        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
//        char[] input = {'a'};
        char[] input = {'a', 'a', 'a', 'a', 'a', 'b'};
        StringCompression443 ob = new StringCompression443();
        int compressCount = ob.compress(input);
        System.out.println(compressCount);
        System.out.println(input);
    }

    public int compress(char[] chars) {

        int result = 0;
        for (int index = 0; index <= chars.length - 1; ) {
            int forward = index;
            while (forward + 1 <= chars.length - 1 && chars[forward + 1] == chars[forward]) {
                forward++;
            }
            int diff = forward - index + 1;
            if (diff == 1) {
                chars[result] = chars[forward];
                index = forward + 1;
                result++;
            } else if (diff >= 2 && diff <= 9) {

                chars[result] = chars[forward];
                chars[result + 1] = (char) (diff + '0');
                result += 2;

                index = forward + 1;

            } else if (diff > 9) {

                chars[result++] = chars[forward];
                String tmp = String.valueOf(diff);
                int len = 0;
                while (len < tmp.length()) {
                    chars[result++] = tmp.charAt(len++);
                }

                index = forward + 1;

            }
        }

        chars = Arrays.copyOfRange(chars, 0, result);
        return result;
    }
}
