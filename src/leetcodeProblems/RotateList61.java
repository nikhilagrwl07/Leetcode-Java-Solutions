package leetcodeProblems;

public class RotateList61 {
    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        System.out.println(one);
        RotateList61 ob = new RotateList61();
        int k = 4;

        ListNode newHead = ob.rotateRight(one, k);
        System.out.println(newHead);
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k <= 0)
            return head;

        ListNode tmp = head;
        int len = 0;

        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }


        if (k > len) {
            k = k % len;
        }

        if (k == len || k <= 0)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nextHead = slow.next;
        ListNode newHead = slow.next;
        slow.next = null;

        while (nextHead.next != null) {
            nextHead = nextHead.next;
        }
        nextHead.next = head;


        return newHead;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " " + next + " ";
        }
    }
}
