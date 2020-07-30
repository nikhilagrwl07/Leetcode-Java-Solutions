package practice;

public class WildCardPatternMatching {
    public static void main(String[] args) {
        WildCardPatternMatching ob = new WildCardPatternMatching();

        String t1 = "aa" , p1 = "a";
        String t2 = "aa" , p2 = "*";
        String t3 = "cb" , p3 = "?a";
        String t4 = "adceb" , p4 = "*a*b";
        String t5 = "a" , p5 = "";


        System.out.println(ob.isMatch(t1, p1));
        System.out.println(ob.isMatch(t2, p2));
        System.out.println(ob.isMatch(t3, p3));
        System.out.println(ob.isMatch(t4, p4));
        System.out.println(ob.isMatch(t5, p5));


    }


    /*
        m[i][j] = m[i-1][j-1]            if t[i]==p[j] || p[j] == ?
                  m[i-1][j] || m[i][j-1]    if p[j] = * --> zero sequence or * --> 1 sequence

                else false
     */
    public boolean isMatch(String text, String pattern) {

        if ((text == null && pattern != null) || (text != null && pattern == null))
            return false;

        if (text == null && pattern == null)
            return true;

        if(!text.isEmpty() && pattern.isEmpty())
            return false;

        boolean[][] m = new boolean[text.length() + 1][pattern.length() + 1];

        //fill first row meaning empty text
        for (int c = 0; c <= m[0].length - 1; c++) {

            if (c == 0)
                m[0][0] = true;
            else {
                if (pattern.charAt(c - 1) == '*')
                    m[0][c] = m[0][c - 1];
                else
                    m[0][c] = false;
            }
        }


        // fill first col
        for (int r = 0; r <= m.length - 1; r++) {

            if (r == 0)
                m[0][0] = true;
            else {
                if (pattern.charAt(0) == '*')
                    m[r][0] = true;
                else
                    m[r][0] = false;
            }
        }


        // travserse matrix

        for (int r = 1; r <= m.length - 1; r++) {
            for (int c = 1; c <= m[0].length - 1; c++) {

                char t = text.charAt(r - 1);
                char p = pattern.charAt(c - 1);


                if (t == p || p == '?')
                    m[r][c] = m[r - 1][c - 1];
                else if (p == '*')
                    m[r][c] = m[r - 1][c] || m[r][c - 1];
                else
                    m[r][c] = false;
            }
        }

        return m[text.length()][pattern.length()];

    }
}
