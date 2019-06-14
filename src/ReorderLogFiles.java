/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
//        String[] inputLogs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
//        String[] inputLogs = {"1 n u",
//                "r 527",
//                "j 893",
//                "6 14",
//                "6 82"
//        };

        String[] inputLogs = {
                "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
        };
        String[] orderedLogs = reorderLogFiles(inputLogs);

        System.out.println(Arrays.toString(orderedLogs));


    }

    private static String[] reorderLogFiles(String[] logs) {
        Map<String, String> letterLogs = new LinkedHashMap<>();
        Map<String, String> digitLogs = new LinkedHashMap<>();
        int i = 0;
        for (String input : logs) {
            String[] splittedString = input.split(" ");

            char c = splittedString[1].toCharArray()[0];

            //letter logs
            if (c >= 'a' && c <= 'z') {
                letterLogs.put(splittedString[0] + i, input.substring(splittedString[0].length() + 1));
            } else {
                String value = input.substring(splittedString[0].length() + 1);
                digitLogs.put(splittedString[0] + i, value);
            }
            i++;
        }

        // Create a list from elements of HashMap
        List<Map.Entry<String, String>> letterLogsList =
                new LinkedList<Map.Entry<String, String>>(letterLogs.entrySet());

        // Sort the list
        Collections.sort(letterLogsList, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        // Create a list from elements of HashMap
        List<Map.Entry<String, String>> digitLogsList =
                new LinkedList<Map.Entry<String, String>>(digitLogs.entrySet());

        // Sort the list
//        Collections.sort(digitLogsList, new Comparator<Map.Entry<String, String>>() {
//            public int compare(Map.Entry<String, String> o1,
//                               Map.Entry<String, String> o2) {
//
//                char[] s1 = o1.getValue().toCharArray();
//                char[] s2 = o2.getValue().toCharArray();
//
//                for(int i=0;i<Math.min(s1.length, s2.length); i++){
//                    if (s1[i] < s2[i])
//                    {
//                        return -1;
//                    }
//                    else if(s1[i] > s2[i])
//                    {
//                        return 1;
//                    }
//                }
//
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });

        String[] result = new String[logs.length];
        i = 0;
        for (Map.Entry<String, String> m : letterLogsList) {
            result[i++] = m.getKey().substring(0, m.getKey().length() - 1) + " " + m.getValue();
        }

        for (Map.Entry<String, String> m : digitLogsList) {

            String value = String.valueOf(m.getValue());
            result[i++] = m.getKey().substring(0, m.getKey().length() - 1) + " " + value;
        }
        return result;
    }
}