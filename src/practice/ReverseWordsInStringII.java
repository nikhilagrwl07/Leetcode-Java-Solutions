package practice;

public class ReverseWordsInStringII {
    public static void main(String[] args) {
        ReverseWordsInStringII ob = new ReverseWordsInStringII();
        String s1 = "the sky is blue";
//        String s2 = "hello world!";
//        String s3 = "a good example";
//        String s4 = "a";
//        String s5 = "a cdf";

        char[] chars = s1.toCharArray();
        ob.reverseWords(chars);
        System.out.println(chars);

//        System.out.println(ob.reverseWords(s2));
//        char[] chars = s3.toCharArray();
//        ob.reverseWords(chars);
//        System.out.println(chars);
//        System.out.println(ob.reverseWords(s4));
//        System.out.println(ob.reverseWords(s5));

    }

    public void reverseWords(char[] c) {
        if (c == null || c.length == 0)
            return;

        reverse(c, 0, c.length - 1);
        int s = 0, e = 0;

        while (e <= c.length - 1) {
            if (c[e] == ' ') {
                reverse(c, s, e - 1);
                s = e + 1;
                e = e + 1;
            } else {
                e++;
            }
        }

        if (s < e-1) {
            reverse(c, s, e-1);
        }

    }

    private void reverse(char[] c, int s, int e) {
        while (s < e) {
            char t = c[s];
            c[s] = c[e];
            c[e] = t;
            s++;
            e--;
        }

    }

}
