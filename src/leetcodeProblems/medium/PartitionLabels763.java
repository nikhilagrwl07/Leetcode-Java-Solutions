package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {

        PartitionLabels763 ob = new PartitionLabels763();
        String S = "ababcbacadefegdehijhklij";
//        String S = "aaaaabacdefgh";

        List<Integer> partitionLabels = ob.partitionLabels(S);
        System.out.println(partitionLabels);
    }

    public List<Integer> partitionLabels(String S) {
        int[] m = new int[26];

        List<Integer> result = new ArrayList<>();

        // character to last index
        for (int i = 0; i < S.length(); i++) {
            m[S.charAt(i) - 'a'] = i;
        }

        int index = 0;
        while (index < S.length()) {
            int lastIndex = dfs(index, S, m);
            int length = lastIndex - index + 1;
            result.add(length);
            index = lastIndex + 1;
        }

        return result;
    }

    private int dfs(int index, String s, int[] m) {
        if (m[s.charAt(index) - 'a'] == -1)
            return -1;

        int max = m[s.charAt(index) - 'a'];
        m[s.charAt(index) - 'a'] = -1;

        for (int i = index + 1; i < s.length() && i <= max; i++) {
            if (m[s.charAt(i) - 'a'] > max)
                max = Math.max(max, dfs(i, s, m));
        }

        return max;
    }
}
