/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString833 {
    public static void main(String[] args) {
        FindAndReplaceInString833 ob = new FindAndReplaceInString833();

        String S = "abcd";
        int[] indexes = {0, 2};

        String[] sources = {"a", "cd"};
//        String[] sources = {"ab","ec"};

        String[] targets = {"eee", "ffff"};


//        String S = "vmokgggqzp";
//        int[] indexes = {3, 5, 1};
//        String[] sources = {"kg", "ggq", "mo"};
//        String[] targets = {"s", "so", "bfr"};

        String replacedString = ob.findReplaceString(S, indexes, sources, targets);
        System.out.println(replacedString);


    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.isEmpty() || indexes == null || indexes.length == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        Map<Integer, String> m = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            int currentIndex = indexes[i];
            String source = sources[i];
            String destination = targets[i];
            if (startsWith(S, currentIndex, source)) {
                m.put(currentIndex, destination);
                m2.put(currentIndex, source.length());
            }
        }

        for (int i = 0; i < S.length(); ) {
            if (m.containsKey(i)) {
                sb.append(m.get(i));
                i = i + m2.get(i);
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    private boolean startsWith(String s, int currentIndex, String source) {
        return s.substring(currentIndex, currentIndex + source.length()).equals(source);

    }
}
