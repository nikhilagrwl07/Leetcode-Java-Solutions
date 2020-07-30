package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResolveIpAddress {
    public static void main(String[] args) {
        ResolveIpAddress ob = new ResolveIpAddress();
        String i1 = "25525511135";
        String i2 = "010010";

        System.out.println(ob.restoreIpAddresses(i1));
        System.out.println(ob.restoreIpAddresses(i2));

    }

    public List<String> restoreIpAddresses(String s) {

        String[] result = new String[4];
        Set<String> finalResult = new HashSet<>();

        recur(s, result, 0, finalResult);

        return new ArrayList<>(finalResult);
    }

    private void recur(String s, String[] result, int index, Set<String> finalResult) {

        if (index == 4 && !s.isEmpty())
            return;

        if (s.isEmpty() && index == 4) {

            for(String str : result){
                // first char is non zero

                if(str.length()>=2 && str.startsWith("0"))
                    return;
            }
            finalResult.add(String.join(".", result));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String tmp = sb.append(s.charAt(i)).toString();

            int val = Integer.parseInt(tmp);
            if (val > 255)
                break;

            result[index] = tmp;
            recur(s.substring(i + 1), result, index + 1, finalResult);

        }
    }
}
