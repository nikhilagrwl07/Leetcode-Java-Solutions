package practice;

public class CeilingOfNumber {
    public static void main(String[] args) {
        CeilingOfNumber ob = new CeilingOfNumber();
        int[] a1 = {4, 6, 10};
        int k1 = 6;
        int[] a2 = {1, 3, 8, 10, 15};
        int k2 = 0;
        int[] a3 = {1, 3, 8, 10, 15};
        int k3 = 11;
        int[] a4 = {1, 3, 8, 10, 15};
        int k4 = 2;

        System.out.println("Ceil ------- ");
        System.out.println(ob.searchCeilingOfANumber(a1, k1));
        System.out.println(ob.searchCeilingOfANumber(a2, k2));
        System.out.println(ob.searchCeilingOfANumber(a3, k3));
        System.out.println(ob.searchCeilingOfANumber(a4, k4));

        System.out.println("Floor ------- ");
        System.out.println(ob.searchFloorOfANumber(a1, k1));
        System.out.println(ob.searchFloorOfANumber(a2, k2));
        System.out.println(ob.searchFloorOfANumber(a3, k3));
        System.out.println(ob.searchFloorOfANumber(a3, k3));
        System.out.println(ob.searchFloorOfANumber(a4, k4));
    }

    public int searchCeilingOfANumber(int[] arr, int key) {
        if (arr == null) return -1;
        if (arr[arr.length - 1] < key) return -1;

        int start = 0, end = arr.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public int searchFloorOfANumber(int[] arr, int key) {
        if (arr == null) return -1;
        if (arr[0] > key) return -1;

        int start = 0, end = arr.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
