/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set6;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public static void main(String[] args) {
        ValidAnagram242 ob = new ValidAnagram242();
        String s = "anagram", t = "nagaram";
        boolean isAnagram = ob.isAnagram(s, t);
        System.out.println(isAnagram);

    }

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null)
            return true;

        if (s == null && t != null) {
            return false;
        }

        if (s != null && t == null) {
            return false;
        }

        if (s.length() != t.length())
            return false;


        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {

            if (freq.get(c) == null || freq.get(c) == 0) {
                return false;
            } else {
                freq.put(c, freq.get(c) - 1);
            }
        }

        return true;
    }

}
