/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set3;

public class ReverseWordsInSentence557 {
    public static void main(String[] args) {

        ReverseWordsInSentence557 ob = new ReverseWordsInSentence557();
        String input = "Let's take LeetCode contest";
//        String input = "hehhhhhhe";
//        String input = "aaa";
        String reverseWords = ob.reverseWords(input);
        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty() || s.length() == 1)
            return s;

        StringBuilder sentence = new StringBuilder();
        StringBuilder word = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                sentence.append(word.reverse().toString());
                sentence.append(" ");
                word.setLength(0);
            } else {
                word.append(s.charAt(i));
            }
        }

        if (word.length() > 0) {
            sentence.append(word.reverse().toString());
        }

        return sentence.toString();
    }
}
