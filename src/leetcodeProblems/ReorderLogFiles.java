package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class ReorderLogFiles {
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
        Map<String, List<String>> letterLogs = new HashMap<>(); // come first --> sort by remaining and then sort by identifier
        List<String> digitLogs = new LinkedList<>(); // come last --> sort by order in which element appears
        for (String input : logs) {
            String[] splittedString = input.split(" ");

            char c = splittedString[1].toCharArray()[0];

            //letter logs
            if (c >= 'a' && c <= 'z') {
                List<String> list = letterLogs.getOrDefault(splittedString[0], new ArrayList<>());
                list.add(input.substring(splittedString[0].length() + 1));
                Collections.sort(list);
                letterLogs.put(splittedString[0], list);
            } else {
                digitLogs.add(input);
            }
        }

        // Create a list from elements of HashMap

        List<Map.Entry<String, List<String>>> letterLogsList =
                new LinkedList<Map.Entry<String, List<String>>>(letterLogs.entrySet());

        // Sort the list

        Collections.sort(letterLogsList, new Comparator<Map.Entry<String, List<String>>>() {
            public int compare(Map.Entry<String, List<String>> o1,
                               Map.Entry<String, List<String>> o2) {

                int min = Math.min(o1.getValue().size(), o2.getValue().size());
                int compareValue = 0;
                for (int i = 0; i < min; i++) {
                    compareValue = o1.getValue().get(i).compareTo(o2.getValue().get(i));
                    if (compareValue != 0)
                        break;
                }

                if (compareValue == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return compareValue;
                }
            }
        });

        String[] result = new String[logs.length];
        int index = 0;
        for (Map.Entry<String, List<String>> m : letterLogsList) {
            for (String v : m.getValue()) {
                result[index++] = m.getKey() + " " + v;
            }
        }


        for (String digitLog : digitLogs) {
            result[index++] = digitLog;
        }

        return result;
    }
}