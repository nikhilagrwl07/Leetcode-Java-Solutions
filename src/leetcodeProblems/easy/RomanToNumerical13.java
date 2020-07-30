package leetcodeProblems.easy;
import java.util.HashMap;
import java.util.Map;

public class RomanToNumerical13 {
    public static void main(String[] args) {
//        String input = "III";
//        String input = "IV";
//        String input = "LVIII";
        String input = "MCMXCIV";

        System.out.println(romanToInt(input));
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            String current = s.substring(i, i+1);

            if (i + 1 < s.length() && map.get(current + s.substring(i + 1, i + 2)) != null) {
                String newCurrent = current + s.substring(i + 1, i + 2);

                // Case 1 - Length of 2 string present in map
                ans = ans + map.get(newCurrent);
                i = i + 2;

            } else {
                ans = ans + map.get(current);
                i++;
            }
        }
        return ans;

    }
}
