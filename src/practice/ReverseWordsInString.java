package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString ob = new ReverseWordsInString();
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = " a good   example";
        String s4 = "a";
        String s5 = "a          cdf";


//        System.out.println(ob.reverseWords(s1));
//        System.out.println(ob.reverseWords(s2));
        System.out.println(ob.reverseWords(s3));
//        System.out.println(ob.reverseWords(s4));
//        System.out.println(ob.reverseWords(s5));

    }


    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;

        // to remove any leading whitespace
        s= s.trim();

        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    // Time - O(N)
//    public String reverseWords(String s) {
//
//        if (s == null || s.isEmpty())
//            return s;
//
//        StringBuilder result = new StringBuilder();
//        StringBuilder tmp = new StringBuilder();
//        int index = 0;
//        while (index < s.length()) {
//            if (s.charAt(index) == ' ') {
//                if (tmp.length() > 0) {
//                    if (result.length() > 0) {
//                        result.insert(0, " ");
//                    }
//                    result.insert(0, tmp.toString());
//                    tmp = new StringBuilder();
//                }
//            } else {
//                tmp.append(s.charAt(index));
//            }
//            index++;
//        }
//
//        if (tmp.length() > 0) {
//            if (result.length() > 0)
//                result.insert(0, " ");
//
//            result.insert(0, tmp.toString());
//        }
//        return result.toString();
//    }

}
