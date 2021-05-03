package practice;

import java.util.*;

public class test {
    public static void main(String[] args) {
        test ob = new test();
//        System.out.println(ob.letterCombinations("23"));
        System.out.println(ob.letterCombinations("78"));
        System.out.println(ob.letterCombinations(""));


    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();

        Map<Character, Character> dialPad = populateDialPad();
        Map<Character, Character> next = populateStart();

        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            sb.append(next.get(digits.charAt(i)));
        }

        q.offer(sb.toString());

        // bfs
        while (!q.isEmpty()) {
            String s = q.poll();
            seen.add(s);

            for (int i = 0; i < s.length(); i++) {
                if (dialPad.get(s.charAt(i)) == null)
                    break;

                sb = new StringBuilder();
                sb.append(s, 0, i);
                sb.append(dialPad.get(s.charAt(i)));
                sb.append(s.substring(i + 1));

                String str = sb.toString();
                if (!seen.contains(str)) {
                    q.offer(str);
                }
            }

        }
        return new ArrayList<>(seen);

    }

    public Map<Character, Character> populateStart() {
        Map<Character, Character> next = new HashMap<>();
        next.put('2', 'a');
        next.put('3', 'd');
        next.put('4', 'g');
        next.put('5', 'j');
        next.put('6', 'm');
        next.put('7', 'p');
        next.put('8', 't');
        next.put('9', 'w');
        return next;
    }

    public Map<Character, Character> populateDialPad() {
        Map<Character, Character> next = new HashMap<>();
        next.put('a', 'b');
        next.put('b', 'c');

        next.put('d', 'e');
        next.put('e', 'f');

        next.put('g', 'h');
        next.put('h', 'i');

        next.put('j', 'k');
        next.put('k', 'l');

        next.put('m', 'n');
        next.put('n', 'o');

        next.put('p', 'q');
        next.put('q', 'r');
        next.put('r', 's');

        next.put('t', 'u');
        next.put('u', 'v');

        next.put('w', 'x');
        next.put('x', 'y');
        next.put('y', 'z');

        return next;

    }
}
