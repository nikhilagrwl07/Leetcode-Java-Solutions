package leetcodeProblems;
import java.util.*;

public class ReorderLogFiles937 {
    public static void main(String[] args) {
        ReorderLogFiles937 ob = new ReorderLogFiles937();
//        String[] inputLogs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
//        String[] inputLogs =
//                {"l evmbcyaqe zx", "pk amxcdvhuhavi", "cx 965 84 9 20", "b 401957007189", "ez xodjwnc awg", "96t oxgsdkuj j", "af 611441988 6", "l9d 21 6 77 795", "l khuxbzszqarfz", "4zj 6115548620", "l6 fzqtxlo qi j", "anr 76976970 17", "of vtqfbyxaxtce", "j 544232 60 554", "108 u amvyjml s"};

//        String[] inputLogs = {"1 n u",
//                "r 527",
//                "j 893",
//                "6 14",
//                "6 82"
//        };

        String[] inputLogs = {
                "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
        };
        String[] orderedLogs = ob.reorderLogFiles(inputLogs);
        System.out.println(Arrays.toString(orderedLogs));


    }

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1) {
            return logs;
        }

        List<String> digitsLogs = new LinkedList<>();
        List<String> letterLogs = new ArrayList<>();

        Comparator<String> letterComparator = (o1, o2) -> {
            int e1 = o1.indexOf(' ');
            int e2 = o2.indexOf(' ');

            String s1p1 = o1.substring(0, e1);
            String s1p2 = o1.substring(e1 + 1);

            String s2p1 = o2.substring(0, e2);
            String s2p2 = o2.substring(e2 + 1);

            int result = s1p2.compareTo(s2p2);
            if (result != 0)
                return result;

            return s1p1.compareTo(s2p1);
        };

        for (String s : logs) {
            if (Character.isDigit(s.charAt(s.indexOf(' ') + 1))) {
                digitsLogs.add(s);
            } else {
                letterLogs.add(s);
            }
        }

        Collections.sort(letterLogs, letterComparator);

        String[] finalResult = new String[logs.length];
        int index = 0;
        while (index < letterLogs.size()) {
            finalResult[index] = letterLogs.get(index);
            index++;
        }
        int i = 0;
        while (i < digitsLogs.size()) {
            finalResult[index++] = digitsLogs.get(i++);
        }

        return finalResult;
    }
}