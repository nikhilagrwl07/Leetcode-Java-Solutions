package leetcodeProblems.medium;

public class RandomPickWithWeight528 {
    public static void main(String[] args) {
//        Solution ob1 = new Solution(new int[] {1,3});
//        Solution ob1 = new Solution(new int[]{188, 927, 949, 95, 151, 659, 405, 906, 481, 363, 728, 839});
        Solution ob1 = new Solution(new int[]{29, 243, 543, 577, 339, 351, 572, 293, 62, 896, 142, 576, 782, 136});

        for(int i=1;i<=100;i++){
            System.out.println(ob1.pickIndex());
        }


//        Solution ob2 = new Solution(new int[] {2, 2});
//        System.out.println(ob2.pickIndex());
//        System.out.println(ob2.pickIndex());
//        System.out.println(ob2.pickIndex());
//        System.out.println(ob2.pickIndex());
//        System.out.println(ob2.pickIndex());
    }

}

class Solution {
    int[] freq;
    int[] backFreq;
    Integer startIndex = 0;

    public Solution(int[] w) {
        int len = w.length;
        freq = new int[len];
        backFreq = new int[len];

        int totalWeight = 0;

        // calculate total weight
        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i];
        }

        for (int i = 0; i < w.length; i++) {
            freq[i] = (w[i] * 100) / totalWeight;
            backFreq[i] = freq[i];
        }
    }

    public int pickIndex() {
        int randomNumber = startIndex;
        freq[startIndex]--;

        // reset
        if (startIndex == freq.length - 1 && freq[startIndex] == 0) {
            for (int i = 0; i < backFreq.length; i++) {
                freq[i] = backFreq[i];
            }
            startIndex = 0;
        } else {
            if (freq[startIndex] == 0) {
                for (int i = startIndex + 1; i < freq.length; i++) {
                    if (freq[i] > 0) {
                        startIndex = i;
                        break;
                    }
                }
            }
        }
        return randomNumber;
    }
}
