
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

    // Iterative approach
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = previous;
            previous = head;
            head = tmp;
        }
        return previous;
    }


//    ListNode reveresedHead = null;
    // recursive approach
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//
//        reverseListUtil(head, null);
//        return reveresedHead;
//    }
//
//    public ListNode reverseListUtil(ListNode head, ListNode previous) {
//
//        if (head == null)
//            return null;
//
//        ListNode tmp = head.next;
//        head.next = previous;
//        ListNode listNode = reverseListUtil(tmp, head);
//        if(listNode==null){
//            reveresedHead = head;
//        }
//        return head;
//    }


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
