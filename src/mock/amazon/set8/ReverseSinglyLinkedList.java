package mock.amazon.set8;

public class ReverseSinglyLinkedList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
        one.next = two;
//        two.next = three;

        ReverseSinglyLinkedList ob = new ReverseSinglyLinkedList();
        System.out.println(one.toString());
        ListNode reverseList = ob.reverseList(one);
        System.out.println(reverseList);

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode currentHead = head;
        ListNode nextTohead;

        while (currentHead != null) {
            nextTohead = currentHead.next;
            currentHead.next = previous;

            previous = currentHead;
            currentHead = nextTohead;
        }

        return previous;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return
                    "   val = " + val +
                            " next = " + next;
        }
    }
}
