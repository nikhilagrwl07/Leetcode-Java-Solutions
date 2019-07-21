/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set6;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConvertRomanToInteger {

    public static void main(String[] args) {

        ConvertRomanToInteger ob = new ConvertRomanToInteger();
        String s = "MCMXCIV";
//        String s = "LVIII";

        int romanToInt = ob.romanToInt(s);
        System.out.println(romanToInt);
    }

    public int romanToInt(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s == null || s.isEmpty())
            return 0;

        int index = 0;
        int value = 0;

        while (index <= s.length() - 1) {

            if (index + 1 <= s.length() - 1 && map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
                value += map.get(s.charAt(index + 1)) - map.get(s.charAt(index));
//                sb.append(map.get(s.charAt(index + 1)) - map.get(s.charAt(index)));
                index = index + 2;
            } else {
                value += map.get(s.charAt(index));
//                sb.append(map.get(s.charAt(index)));
                index++;
            }
        }

        return value;

    }
}
