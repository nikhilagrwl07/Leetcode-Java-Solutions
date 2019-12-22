package practice;

public class FindStartNodeOfCycleInSingleLinkedList {
    public static void main(String[] args) {
        //3,2,0,-4, pos =1

        ListNode negativeFour = new ListNode(-4);
        ListNode zero = new ListNode(0, negativeFour);
        ListNode two = new ListNode(2, zero);
        ListNode three = new ListNode(3, two);
        negativeFour.next = two;

        ListNode ten = new ListNode(10, null);

        FindStartNodeOfCycleInSingleLinkedList ob = new FindStartNodeOfCycleInSingleLinkedList();
        ListNode startNodeOfCycle = ob.detectCycle(three);
        System.out.println(startNodeOfCycle.val);

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                return findHeadOfCycle(head, slow);
            }
        }
        return null;
    }

    private ListNode findHeadOfCycle(ListNode head, ListNode slow) {

        while (slow != head) {
            slow = slow.next;
            head= head.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
