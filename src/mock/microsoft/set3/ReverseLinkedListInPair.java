package mock.microsoft.set3;

public class ReverseLinkedListInPair {

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ReverseLinkedListInPair ob = new ReverseLinkedListInPair();
        ListNode swapPairs = ob.swapPairs(one);
        System.out.println(swapPairs);


    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;


        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode swap1 = dummy.next;
        ListNode swap2 = swap1.next;
        ListNode headTOReturn = null;


        while (true) {

            dummy.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;


            if (headTOReturn == null) {
                headTOReturn = dummy.next;
            }


            if (swap1.next == null || swap1.next.next == null) {
                break;
            }

            dummy = swap1;
            swap1 = dummy.next;
            swap2 = swap1.next;

        }
        return headTOReturn;

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " " + next;
        }
    }
}
