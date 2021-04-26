package practice;

public class FindElementWithMinimumDifference {
    public static void main(String[] args) {
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
         System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
         System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
         System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }

    public static int searchMinDiffElement(int[] arr, int key) {
        if(arr==null) return -1;

        int[] ceiling = ceiling(arr, key);

        if(arr[ceiling[0]] == key){
            return arr[ceiling[0]];
        }

        if(key - arr[ceiling[0]] > arr[ceiling[1]]-key)
            return arr[ceiling[1]];
        else
            return arr[ceiling[0]];
    }

    public static int[] ceiling(int[] arr, int key){
        int l = 0, m , h = arr.length-1;
        if(key > arr[arr.length-1]) return new int[]{arr.length-1, arr.length-1};

        while(l<=h){
            m  = l +(h-l)/2;
            if(arr[m]==key)
                return new int[]{m,m};
            else if(arr[m] < key)
                l = m+1;
            else
                h = m-1;
        }
        return new int[]{h, l};
    }
}
