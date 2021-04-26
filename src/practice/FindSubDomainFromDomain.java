package practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FindSubDomainFromDomain {

    public static void main(String[] args) {
        String[] input = {"9001 discuss.leetcode.com"};

        System.out.println(subdomainVisits(input));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {

        if (cpdomains == null || cpdomains.length == 0)
            return new ArrayList<>();


        List<String> result = new ArrayList<>();

        for (String str : cpdomains) {

            String[] splittedStr = str.split(" ");
            String freq = splittedStr[0];
            String[] domains = splittedStr[1].split("\\.+");

            StringBuilder sb = new StringBuilder();
            for (int i = domains.length - 1; i >= 0; i--) {
                sb.insert(0, domains[i]);
                String finalCandidate = freq + " " + sb.toString();
                result.add(finalCandidate);
                sb.insert(0, ".");
            }
        }

        return result;
    }
}
