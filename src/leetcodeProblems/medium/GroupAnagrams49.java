package leetcodeProblems.medium;

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        GroupAnagrams49 ob = new GroupAnagrams49();
//        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] input = {"", "", "a","b","ab" , "ba"};

        List<List<String>> result = ob.groupAnagrams(input);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> hashCodeToAnagram = new HashMap<>();

        int[] f;
        for (String s : strs) {
            f = new int[26];
            for (int i = 0; i < s.length(); i++) {
                f[s.charAt(i) - 'a'] += 1;
            }
            int hashCode = Arrays.hashCode(f);

            if (hashCodeToAnagram.containsKey(hashCode)) {
                hashCodeToAnagram.get(hashCode).add(s);
            } else {
                List<String> st = new ArrayList<>();
                st.add(s);
                hashCodeToAnagram.put(hashCode, st);
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(hashCodeToAnagram.values());
        return result;
    }
}
