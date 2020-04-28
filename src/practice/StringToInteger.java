package practice;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger ob = new StringToInteger();
        String s1 = "   -42";
        String s2 = "42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "-000";
        String s7 = "-.1";
        String s8 = "+";
        String s9 = "+-2";
        String s10 = "-   +234";
        String s11 = "-00012a34";
        String s12 = "-5-";

        System.out.println(ob.myAtoi(s1));
        System.out.println(ob.myAtoi(s2));
        System.out.println(ob.myAtoi(s3));
        System.out.println(ob.myAtoi(s4));
        System.out.println(ob.myAtoi(s5));
        System.out.println(ob.myAtoi(s6));
        System.out.println(ob.myAtoi(s7));
        System.out.println(ob.myAtoi(s8));
        System.out.println(ob.myAtoi(s9));
        System.out.println(ob.myAtoi(s10));
        System.out.println(ob.myAtoi(s11));
        System.out.println(ob.myAtoi(s12));
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty())
            return 0;

        StringBuilder result = new StringBuilder();
        Integer sign = null;
        boolean validCharEncountered = false;


        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // case 1 --> Digit
            if (Character.isDigit(current)) {
                result.append(current);
                validCharEncountered = true;
                continue;
            }

            // case 2 --> Character
            if (Character.isLetter(current)) {
                if (validCharEncountered) {
                    break;
                } else {
                    return 0;
                }
            }

            // case 3 --> '+' or '-'
            if (current == '+' || current == '-') {

                if (validCharEncountered)
                    break;
                else
                    validCharEncountered = true;


                if (result.length() == 0) {
                    if (current == '-') {
                        sign = -1;
                    } else {
                        sign = 1;
                    }
                    continue;
                } else {
                    break;
                }
            }

            // case 4 --> whitespace
            if (current == ' ') {
                if (validCharEncountered) {
                    break;
                } else {
                    if (result.length() == 0) {
                        continue;
                    } else {
                        validCharEncountered = true;
                        break;
                    }
                }
            }

            // case 5 --> others
            if (result.length() == 0)
                return 0;
            else
                break;
        }

        if (result.length() == 0) {
            return 0;
        }

        if (sign == null)
            sign = 1;

        Integer finalInteger;

        try {
            finalInteger = Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        return sign * finalInteger;
    }
}
