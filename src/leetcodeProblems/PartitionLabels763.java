package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
//        String S = "ababcbacadefegdehijhklij";
//        String S = "caedbdedda";
//        String S = "ntswuqqbidunnixxpoxxuuupotaatwdainsotwvpxpsdvdbwvbtdiptwtxnnbtqbdvnbowqitudutpsxsbbsvtipibqpvpnivottsxvoqqaqdxiviidivndvdtbvadnxboiqivpusuxaaqnqaobutdbpiosuitdnopoboivopaapadvqwwnnwvxndpxbapixaspwxxxvppoptqxitsvaaawxwaxtbxuixsoxoqdtopqqivaitnpvutzchkygjjgjkcfzjzrkmyerhgkglcyffezmehjcllmlrjghhfkfylkgyhyjfmljkzglkklykrjgrmzjyeyzrrkymccefggczrjflykclfhrjjckjlmglrmgfzlkkhffkjrkyfhegyykrzgjzcgjhkzzmzyejycfrkkekmhzjgggrmchkeclljlyhjkchmhjlehhejjyccyegzrcrerfzczfelzrlfylzleefgefgmzzlggmejjjygehmrczmkrc";

//        String S = "ababcbacadefegdehijhklij";
        String S = "aebbedaddc";
        PartitionLabels763 ob = new PartitionLabels763();
        List<Integer> list = ob.partitionLabels(S);
        System.out.println(list);

    }

//    public List<Integer> partitionLabels(String s) {
//        if (s.isEmpty()) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> list = new ArrayList<>();
//        dfs(s, list);
//        return list;
//    }
//
//    public void dfs(String s, List<Integer> list) {
//        if (s.isEmpty())
//            return;
//
//        int start = 0;
//        char c = s.charAt(start);
//        int end = s.lastIndexOf(c);
//
//        while (start <= end) {
//            char t = s.charAt(start);
//            if (s.lastIndexOf(t) > end) {
//                end = s.lastIndexOf(t);
//            }
//            start++;
//        }
//        list.add(end + 1);
//        dfs(s.substring(end+1), list);
//    }


    public List<Integer> partitionLabels(String s) {
        if (s.length() <= 1)
            return new ArrayList<Integer>() {{
                add(1);
            }};


        // marking all char as unvisted with -1
        int[] lastOccurence = new int[26];
        for (int i = 0; i < lastOccurence.length; i++) {
            lastOccurence[i] = -1;
        }

        // last occurence
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int index = current - 'a';
            lastOccurence[index] = i+1;
        }

        char current = s.charAt(0);
        int index = current - 'a';
        int lastLength = lastOccurence[index];

        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            index = current - 'a';

            if (lastOccurence[index] < lastLength) {
                lastOccurence[index] = lastLength;
            } else {
                lastLength = lastOccurence[index];
            }

        }
        List<Integer> result = new LinkedList<>();
        Arrays.sort(lastOccurence);

        for (int i = 0; i < 26; i++) {
            if (lastOccurence[i] >= 0 && !result.contains(lastOccurence[i])) {
                result.add(lastOccurence[i]);
            }
        }

        List<Integer> finalResult = new LinkedList<Integer>();
        finalResult.add(result.get(0));

        for (int i = 1; i < result.size(); i++) {
            finalResult.add(result.get(i) - result.get(i - 1));
        }
        return finalResult;
    }
}
