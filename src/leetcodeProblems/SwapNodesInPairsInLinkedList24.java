/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class SwapNodesInPairsInLinkedList24 {
    public static void main(String[] args) {
        SwapNodesInPairsInLinkedList24 ob = new SwapNodesInPairsInLinkedList24();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        System.out.println(one.toString());
        ListNode reversedHead = ob.swapPairs(one);
        System.out.println(reversedHead);

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode swap1 = dummy.next;
        ListNode swap2 = swap1.next;
        ListNode headToReturn = null;

        while (true) {

            // Step 1 -
            dummy.next = swap2;

            // Step 2 -
            swap1.next = swap2.next;

            // Step 3 -
            swap2.next = swap1;

            // headToReturn store the head of first reversed LinkedList which is our answer
            if (headToReturn == null) {
                headToReturn = dummy.next;
            }


            // update dummy
            dummy = swap1;

            // if node next to dummy OR node next to next of dummy is null means break it
            if (dummy.next == null || dummy.next.next == null)
                break;

            // once above condition is verified then it is safe to update swap1 and swap 2
            swap1 = dummy.next;
            swap2 = swap1.next;
        }

        return headToReturn;


    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return
                    "  " + val +
                            "  " + next;
        }
    }
}
