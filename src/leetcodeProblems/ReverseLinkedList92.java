
package leetcodeProblems;

public class ReverseLinkedList92 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ReverseLinkedList92 ob = new ReverseLinkedList92();
        System.out.println(one);
        ListNode reverseList = ob.reverseBetween(one, 1, 1);
        System.out.println(reverseList);

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode previousNode = head;
        ListNode postNode = head;
        int length = n - m + 1;
        int mOriginal = m;
        int nOriginal = n;

        m--;
        // find m-1 node
        while ((m - 1) > 0 && previousNode != null) {
            previousNode = previousNode.next;
            m--;
        }

        if (mOriginal == 1) {
            previousNode = null;
        }

        // find n+1 node
        while (n > 0 && postNode != null) {
            postNode = postNode.next;
            n--;
        }

        // reverse m to n
        ListNode previousNext;
        if (previousNode == null) {
            previousNext = head;
        } else {
            previousNext = previousNode.next;
        }

        ListNode reverseHead = reverseList(previousNext, length);


        // m-1.next = revered head
        if (previousNode == null) {
            previousNode = reverseHead;
            head = previousNode;
        } else {
            previousNode.next = reverseHead;
        }


        //reversed LL's tail. next = n+1
        ListNode tmp = reverseHead;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = postNode;

        return head;
    }


    public ListNode reverseList(ListNode head, int length) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        while (length > 0) {
            ListNode tmp = head.next;
            head.next = previous;
            previous = head;
            head = tmp;
            length--;
        }
        return previous;
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
