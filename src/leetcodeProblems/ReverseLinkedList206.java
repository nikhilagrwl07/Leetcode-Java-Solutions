
package leetcodeProblems;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        ReverseLinkedList206 ob = new ReverseLinkedList206();
        System.out.println(one);
        ListNode reverseList = ob.reverseList(one);
        System.out.println(reverseList);

    }

    // recursive
    public ListNode reverseListRecusrive(ListNode h) {
        ListNode[] result = new ListNode[1];
        dfs(null, h, result);
        return result[0];
    }

    private void dfs(ListNode previous, ListNode head, ListNode[] result) {
        if (head == null) {
            result[0] = previous;
            return;
        }
        System.out.print(head.val + " ");

        ListNode remainingList = head.next;
        head.next = previous;

        dfs(head, remainingList, result);
    }

    // iterative
    public ListNode reverseList(ListNode h) {
        if (h == null || h.next == null)
            return h;

        ListNode previous = null, head = h, next = head.next;

        while (next != null) {
            //step 1
            head.next = previous;

            //step 2
            previous = head;
            head = next;
            next = next.next;
        }
        head.next = previous;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "  " + next + "  ";
        }
    }
}
