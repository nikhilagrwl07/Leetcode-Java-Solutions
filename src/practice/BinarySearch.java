package practice;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int[] a = {-1,0,3,5,9,12};
        int target = 9;
        int index = ob.search(a, target);
        System.out.println(index);
    }
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        int index = binarySearch(nums, low, high, target);
        return index;
    }

    public int binarySearch(int[] n, int l , int h, int target){
        if(l >h)
            return -1;
        int mid = l + (h-l)/2;

        if(n[mid]==target)
            return mid;
        if(n[mid] < target){
            return binarySearch(n, mid+1, h, target);
        }
        else{
            return binarySearch(n, l , mid-1, target);
        }
    }
}
