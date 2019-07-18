/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class ReverseWordsInStringWithSpacesIntact {
    public static void main(String[] args) {

        String s = "the sky is blue";
//        String s = "the     sky is  blue";
        String reverseWordsInSentence = reverseWordsInSentence(s);
        System.out.println(reverseWordsInSentence);
    }


    private static String reverseWordsInSentence(String input) {

        StringBuilder result = new StringBuilder();

        int index = 0;
        StringBuilder sub = new StringBuilder();

        while (index <= input.length() - 1) {

            // find first non empty subString
            while (index <= input.length() - 1 && input.charAt(index) != ' ') {
                sub.append(input.charAt(index));
                index++;
            }

            if (sub.length() > 0) {
                result.insert(0, sub.toString());
            }

            sub.setLength(0);
            while (index <= input.length() - 1 && input.charAt(index) == ' ') {
                sub.append(input.charAt(index));
                index++;
            }

            if (sub.length() > 0) {
                result.insert(0, sub.toString());
            }

            sub.setLength(0);
        }

        return result.toString();

    }

//    private static String reverseWordsInSentence(String input) {
//
//        StringBuilder sb = new StringBuilder(input);
//        sb.reverse();
//
//        StringBuilder sub = new StringBuilder();
//        for (int i = 0; i <= sb.length() - 1; i++) {
//
//            if (sb.charAt(i) == ' ') {
//                sb.replace(i - sub.length(), i, sub.reverse().toString());
//                sub = new StringBuilder();
//            } else {
//                sub.append(sb.charAt(i));
//            }
//        }
//
//        sb.replace(sb.length() - sub.length(), sb.length(), sub.reverse().toString());
//        return sb.toString();
//    }
}
