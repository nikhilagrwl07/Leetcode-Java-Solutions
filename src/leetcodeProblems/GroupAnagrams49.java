/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        GroupAnagrams49 ob = new GroupAnagrams49();
//        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] input = {"", "", "a","b","ab" , "ba"};

        List<List<String>> result = ob.groupAnagrams(input);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] input) {
        if (input == null || input.length == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();

        if (input.length == 1) {
            ArrayList<String> rr = new ArrayList<>();
            rr.add(input[0]);
            result.add(rr);
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        int[] freq = new int[26];

        for (int i = 0; i < input.length; i++) {
            String s = input[i];


            for (char c : s.toCharArray()) {
                freq[c - 97] = freq[c - 97] + 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    char c = (char) (j + 97);
                    sb.append(c);
                    sb.append(freq[j]);
                }
            }

            String key = sb.toString();
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(s);
                map.put(key, list);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(key, l);
            }
            freq = new int[26];
        }


        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
