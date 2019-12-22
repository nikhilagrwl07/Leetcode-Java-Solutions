package practice;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ob = new RotateArray();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
//        int[] a = {-1};
//        int[] a = {1};
        int k = 10;
        System.out.println("input - " + Arrays.toString(a));
        ob.rotate(a, k);
        System.out.println("output - " + Arrays.toString(a));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, nums.length - k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1 - k);
        reverseArray(nums, 0, nums.length - 1);
    }

    public void reverseArray(int[] a, int l, int h) {
        while (l < h) {
            int tmp = a[l];
            a[l] = a[h];
            a[h] = tmp;
            l++;
            h--;
        }
    }
}
