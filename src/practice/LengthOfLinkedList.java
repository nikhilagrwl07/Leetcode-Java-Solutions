package practice;

public class LengthOfLinkedList {
    public static void main(String[] args) {
        LengthOfLinkedList ob = new LengthOfLinkedList();

//        int[] input = {1, 4, -1, 3, 2};
        int[] input = {-1};
        int length = ob.findLength(input);
        System.out.println(length);
    }

    public int findLength(int[] input) {
        if (input == null || input.length == 0 || input[0] == -1)
            return 0;

        int length = 0;
        int index = 0;
        while (true) {
            index = input[index];
            length++;
            if (index == -1)
                break;
        }
        return length;
    }
}
