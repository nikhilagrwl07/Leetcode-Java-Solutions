/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class ReverseWordsInString151 {
    public static void main(String[] args) {

        ReverseWordsInString151 ob = new ReverseWordsInString151();
        String input = "the sky is blue";
//        String input = "  hello world!  ";
//        String input = "        a good   example";
//        String input = " ";
        String reverseWords = ob.reverseWords(input);
        System.out.println(reverseWords);


    }

    // Time Taken - 1 ms much faster than below stream
    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;

        StringBuilder sb = new StringBuilder();
        String[] splitted = s.trim().split(" ");

        for (int i = splitted.length - 1; i >= 0; i--) {
            if (!splitted[i].isEmpty()) {
                sb.append(splitted[i]);
                sb.append(" ");
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(0, sb.length() - 1);
    }


    // Time Taken - 39 ms slower
//    public String reverseWords(String s) {
//        if (s == null || s.isEmpty())
//            return s;
//
//        StringBuilder sb = new StringBuilder();
//        Arrays.stream(s.trim().split(" "))
//                .filter(s1 -> !s1.isEmpty())
//                .forEach(s1 -> {
//                    sb.insert(0, s1);
//                    sb.insert(0, " ");
//                });
//
//        if (sb.length() == 0) {
//            return "";
//        }
//        return sb.substring(1, sb.length());
//    }
}
