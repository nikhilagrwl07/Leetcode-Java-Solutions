package mock.amazon.set2;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ob = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> rsult = ob.groupAnagrams(input);
        System.out.println(rsult);


    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> m = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sortedString = construct(strs[i]);

            List<String> r = m.getOrDefault(sortedString, new ArrayList<>());
            r.add(strs[i]);
            m.put(sortedString, r);
        }

        for (Map.Entry<String, List<String>> e : m.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }

    private String construct(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            int i = c - 97;
            freq[i] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char c = (char) (i + 97);
                sb.append(c);
                sb.append(freq[i]);
            }
        }

        return sb.toString();
    }
}
