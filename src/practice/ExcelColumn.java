package practice;

public class ExcelColumn {
    public static void main(String[] args) {

        ExcelColumn ob = new ExcelColumn();
        System.out.println(ob.titleToNumber("ZY"));
        System.out.println(ob.titleToNumber("AB"));
        System.out.println(ob.titleToNumber("A"));
    }


    public int titleToNumber(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            result += ((int) Math.pow(26, s.length() - 1 - i)) * (s.charAt(i) - 'A' + 1);
        }

        return result;

    }
}
