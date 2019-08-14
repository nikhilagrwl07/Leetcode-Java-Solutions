package mock.amazon.set8;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        FirstNonRepeatingCharacter ob = new FirstNonRepeatingCharacter();
        int firstUniqCharIndex = ob.firstUniqChar("leetcode");
        System.out.println(firstUniqCharIndex);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty())
            return -1;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
