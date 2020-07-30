package practice;

import java.util.Arrays;

public class MergeOneArrayIntoAnotherArray {
    public static void main(String[] args) {

        MergeOneArrayIntoAnotherArray ob = new MergeOneArrayIntoAnotherArray();
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        ob.merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1, j = n-1;
        int index = nums1.length-1;

        while (i>=0 && j>=0){

            if(nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i--];
            }
            else{
                nums1[index--] = nums2[j--];
            }
        }

        while (j>=0){
            nums1[index--] = nums2[j--];
        }
    }
}
