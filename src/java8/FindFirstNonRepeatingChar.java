package java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FindFirstNonRepeatingChar {
    public static void main(String[] args) {

        String input1 = "NN";
        Optional<Character> findNonRepeatingChar = findFirstNonRepeatingCharInString(input1);

        if(findNonRepeatingChar.isPresent())
            System.out.println(findNonRepeatingChar.get());
        else
            System.out.println("No found");
    }

    public static Optional<Character> findFirstNonRepeatingCharInString(String input) {

        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e: freq.entrySet()){
            if(e.getValue()==1)
                return Optional.of(e.getKey());
        }
        return Optional.ofNullable(null);
    }
}
