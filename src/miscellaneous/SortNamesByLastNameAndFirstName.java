/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortNamesByLastNameAndFirstName {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("rajesh kumar 5", "nikhil agrawal 10 ",
                "ritu b 15", "ritu agrawal 35", "ritu agrawal 25");

        SortNamesByLastNameAndFirstName ob = new SortNamesByLastNameAndFirstName();
        List<String> sortByCustomRules = ob.sortByCustomRules(input);
        System.out.println(sortByCustomRules);
    }


    private List<String> sortByCustomRules(List<String> input) {


        Comparator<String> sortByLastNameThenFirstName = (s1, s2) -> {

            String[] splitFirst = s1.split(" ");
            String[] splitSecond = s2.split(" ");

            int result = splitFirst[1].compareTo(splitSecond[1]);
            if (result == 0) {
                result = splitFirst[0].compareTo(splitSecond[0]);
            }

            if(result ==0){
                result = Integer.valueOf(splitFirst[2]) - Integer.valueOf((splitSecond[2]));
            }
            return result;
        };

        input.sort(sortByLastNameThenFirstName);
        return input;
    }
}
