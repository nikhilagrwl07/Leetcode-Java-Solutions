/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set5;

public class AddTwoNumbersLinkedListInReverseOrder445 {

    public static void main(String[] args) {

        ListNode t1 = new ListNode(7);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(4);
        ListNode t4 = new ListNode(3);
//        ListNode tExtra = new ListNode(1);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
//        t3.next = tExtra;


        ListNode t10 = new ListNode(5);
        ListNode t11 = new ListNode(6);
        ListNode t12 = new ListNode(4);

        t10.next = t11;
        t11.next = t12;

        AddTwoNumbersLinkedListInReverseOrder445 ob = new AddTwoNumbersLinkedListInReverseOrder445();
        ob.print(t1);
        ob.print(t10);
//        ListNode reverseLinkedList = ob.reverseLinkedList(t1);
//        ob.print(reverseLinkedList);


        ListNode summedHead = ob.addTwoNumbers(t1, t10);
        ob.print(summedHead);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode head1 = reverseLinkedList(l1), head2 = reverseLinkedList(l2);

        ListNode result = null;
        ListNode resultHead = null;
        int remainder = 0;
        while (head1 != null && head2 != null) {

            int value = head1.val + head2.val + remainder;
            if (value / 10 >= 1) { // more than 10

                result = insert(result, value % 10);

                if (resultHead == null) {
                    resultHead = result;
                }

                remainder = value / 10;

            } else {

                result = insert(result, value);
                remainder = 0;

                if (resultHead == null) {
                    resultHead = result;
                }

            }

            head1 = head1.next;
            head2 = head2.next;
        }


        if (head1 == null) {
            insertAtlast(result, head2, remainder);
        } else {
            insertAtlast(result, head1, remainder);
        }

        return reverseLinkedList(resultHead);
//        return resultHead;
    }

    private void insertAtlast(ListNode head, ListNode remaining, int remainder) {

        if (remainder == 0) {
            head.next = remaining;
            return;
        }


        if (remaining != null) {
            head.next = remaining;

            ListNode previous = remaining;

            while (remaining != null) {
                int total = remaining.val + remainder;

                if (total >= 10) {
                    remaining.val = total % 10;
                    remainder = total / 10;
                } else {
                    remaining.val = total;
                    remainder = 0;
                }
                previous = remaining;
                remaining = remaining.next;
            }

            if (remainder > 0) {
                previous.next = new ListNode(remainder);
            }

        } else {
            head.next = new ListNode(remainder);
        }

    }


    private ListNode insert(ListNode result, int i) {

        if (result == null) {
            result = new ListNode(i);
            return result;
        } else {
            ListNode listNode = new ListNode(i);
            result.next = listNode;
            return listNode;
        }
    }


    private ListNode reverseLinkedList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;

        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;


    }

    private void print(ListNode head) {

        ListNode h = head;
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
