package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReorderLogFiles937 {
    public static void main(String[] args) {
//        String[] inputLogs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] inputLogs =
                {"l evmbcyaqe zx", "pk amxcdvhuhavi", "cx 965 84 9 20", "b 401957007189", "ez xodjwnc awg", "96t oxgsdkuj j", "af 611441988 6", "l9d 21 6 77 795", "l khuxbzszqarfz", "4zj 6115548620", "l6 fzqtxlo qi j", "anr 76976970 17", "of vtqfbyxaxtce", "j 544232 60 554", "108 u amvyjml s"};

//        String[] inputLogs = {"1 n u",
//                "r 527",
//                "j 893",
//                "6 14",
//                "6 82"
//        };

//        String[] inputLogs = {
//                "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
//        };
        String[] orderedLogs = reorderLogFiles(inputLogs);

        System.out.println(Arrays.toString(orderedLogs));


    }

    private static String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new LinkedList<>();
        List<String> digitLogs = new LinkedList<>();
        for (String input : logs) {
            String[] splittedString = input.split(" ");

            char c = splittedString[1].toCharArray()[0];

            //letter logs
            if (c >= 'a' && c <= 'z') {
                letterLogs.add(input);
            } else {
                digitLogs.add(input);
            }
        }

        // Sort the letter logs
        Comparator<String> letterLogsComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] splitteds1 = o1.split(" ");
                String[] splitteds2 = o2.split(" ");

                int compare = splitteds1[1].compareTo(splitteds2[1]);

                if (compare != 0) {
                    return compare;
                } else {
                    return splitteds1[0].compareTo(splitteds2[0]);
                }
            }
        };

        letterLogs.sort(letterLogsComparator);

        int index = 0;
        String[] result = new String[logs.length];

        for (String letter : letterLogs) {
            result[index++] = letter;
        }

        for (String digitLog : digitLogs) {
            result[index++] = digitLog;
        }
        return result;
    }
}