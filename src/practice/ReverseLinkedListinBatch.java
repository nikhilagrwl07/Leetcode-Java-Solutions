package practice;

public class ReverseLinkedListinBatch {
    public static void main(String[] args) {
        ReverseLinkedListinBatch ob = new ReverseLinkedListinBatch();
//        ListNode five = new ListNode(5, null);
//        ListNode four = new ListNode(4, five);
//        ListNode three = new ListNode(3, four);
//        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, null);

        System.out.println(one);
        System.out.println(ob.swapPairs(one));

    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmpHead = new ListNode(-1, null);
        ListNode tmpHead2 = head;
        ListNode reversedHead = null;

        while (tmpHead2 != null) {
            tmpHead2 = reverse(tmpHead2);

            if (reversedHead == null) {
                reversedHead = tmpHead2;
            }

            tmpHead.next = tmpHead2;

            if(tmpHead2.next != null)
                tmpHead2 = tmpHead2.next.next;
            else
                tmpHead2=null;

            tmpHead = tmpHead.next.next;

        }
        return reversedHead;

    }


    // 1-->2-->3-->4-->5
    // 2-->1-->3-->4-->5
    // 2-->1-->4-->3-->5

    //1-->2
    private ListNode reverse(ListNode head) {

        ListNode currentHead = head;
        ListNode next = currentHead.next;

        if (currentHead.next != null) {
            currentHead.next = currentHead.next.next;
            next.next = head;
        }
        else{
            return currentHead;
        }

        return next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " " + next;
        }
    }
}
