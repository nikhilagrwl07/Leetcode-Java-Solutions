package practice;

public class FindCycleInSingleLinkedList {
    public static void main(String[] args) {
        //3,2,0,-4, pos =1

        ListNode negativeFour = new ListNode(-4);
        ListNode zero = new ListNode(0, negativeFour);
        ListNode two = new ListNode(2, zero);
        ListNode three = new ListNode(3, two);
        negativeFour.next=two;

        ListNode ten = new ListNode(10, null);

        FindCycleInSingleLinkedList ob = new FindCycleInSingleLinkedList();
        boolean hasCycle = ob.hasCycle(ten);
        System.out.println(hasCycle);

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
        return false;
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
