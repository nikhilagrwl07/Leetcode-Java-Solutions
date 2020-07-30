package practice;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber ob = new SingleNumber();
        int[] a1 = {2, 2, 1};
        int[] a2 = {4, 1, 2, 1, 2};

        System.out.println(ob.singleNumber(a1));
        System.out.println(ob.singleNumber(a2));

    }

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;


    }
}
