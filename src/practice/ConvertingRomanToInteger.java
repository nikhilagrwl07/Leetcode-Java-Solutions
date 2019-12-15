package practice;

import java.util.HashMap;
import java.util.Map;

public class ConvertingRomanToInteger {
    public static void main(String[] args) {
        ConvertingRomanToInteger ob  = new ConvertingRomanToInteger();
//        int result = ob.romanToInt("LVIII");
//        int result = ob.romanToInt("MCMXCIV");
        int result = ob.romanToInt("IV");
        System.out.println(result);
    }

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = 0, result = 0;

        while (index <= s.length() - 2) {

            while (index + 1 <= s.length() - 1 && map.get(s.charAt(index)) >= map.get(s.charAt(index + 1))) {
                result += map.get(s.charAt(index));
                index++;
            }

            while (index + 1 <= s.length() - 1 && map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
                result += map.get(s.charAt(index + 1)) - map.get(s.charAt(index));
                index = index + 2;
            }
        }

        if (index == s.length() - 1) {
            result += map.get(s.charAt(index));
        }
        return result;
    }
}
