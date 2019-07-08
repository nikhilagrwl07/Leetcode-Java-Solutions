/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class DecodeWays91 {
    public static void main(String[] args) {

        DecodeWays91 ob = new DecodeWays91();
//        String input = "01";
//        String input = "01";
//        String input = "101";
        String input = "100";
//        String input = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
//        String input = "226";
//        String input = "12";
        int numDecodings = ob.numDecodings(input);
        System.out.println(numDecodings);
    }


    // DP
    public int numDecodings(String input) {

        if (input.startsWith("0"))
            return 0;

        if (input.length() == 1) {
            return 1;
        }

        int[] ways = new int[input.length()];

        if (input.charAt(0) != '0') {
            ways[0] = 1;
        }

        int w = 0;
        if (input.charAt(1) >= '1' && input.charAt(1) <= '9') {
            w++;
        }

        if (Integer.parseInt(input.substring(0, 2)) >= 10 &&
                Integer.parseInt(input.substring(0, 2)) <= 26) {
            w++;
        }
        ways[1] = w;

        for (int i = 2; i <= input.length() - 1; i++) {
            w = 0;

            if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                w += ways[i - 1];
            }
            if (Integer.parseInt(input.substring(i - 1, i + 1)) >= 10 &&
                    Integer.parseInt(input.substring(i - 1, i + 1)) <= 26) {
                w += ways[i - 2];
            }
            ways[i] = w;
        }

        return ways[input.length() - 1];

    }

    // BFS
//    public int numDecodings(String input) {
//
//        if (input.startsWith("0"))
//            return 0;
//
//        Queue<String> q = new LinkedList<>();
//        q.add(input);
//
//        Set<String> set = new HashSet<>();
//        q.add(input);
//
//        while (!q.isEmpty()) {
//            String s = q.poll();
//
//            char lastValue = s.charAt(s.length() - 1);
//            if (lastValue >= '0' && lastValue <= '9') {
//                List<String> decodedString = getDecodedString(s);
//                q.addAll(decodedString);
//            } else {
//                set.add(s);
//            }
//        }
//
//        return set.size();
//    }


//    public List<String> getDecodedString(String input) {
//
//        int index = 0;
//
//
//        List<String> result = new ArrayList<>();
//        while (index <= input.length() - 1) {
//            if (!(input.charAt(index) >= 'A' && input.charAt(index) <= 'Z')) {
//                break;
//            }
//            index++;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(input, 0, index);
//
//        if (index <= input.length() - 1) {
//
//            for (int length = 1; length <= 2 && index + length <= input.length(); length++) {
//
//                String substring = input.substring(index, index + length);
//
//                if (substring.startsWith("0")) {
//                    return new ArrayList<>();
//                }
//
//                if (Integer.parseInt(substring) >= 1 &&
//                        Integer.parseInt(substring) <= 26) {
//
//                    StringBuilder tmp = new StringBuilder();
//                    tmp.append(sb);
//                    tmp.append((char) (Integer.parseInt(substring) + 64));
//                    tmp.append(input.substring(index + length));
//                    result.add(tmp.toString());
//                }
//            }
//        }
//        return result;
//    }


}
