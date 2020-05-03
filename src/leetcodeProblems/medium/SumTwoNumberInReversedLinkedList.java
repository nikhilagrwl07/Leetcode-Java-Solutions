package leetcodeProblems.medium;

public class SumTwoNumberInReversedLinkedList {
    public static void main(String[] args) {
        SumTwoNumberInReversedLinkedList ob = new SumTwoNumberInReversedLinkedList();
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8

        ListNode three = new ListNode(3, null);
        ListNode fourFirst = new ListNode(4, three);
        ListNode two = new ListNode(2, fourFirst);


        ListNode fourSecond = new ListNode(4, null);
        ListNode six = new ListNode(6, fourSecond);
        ListNode five = new ListNode(5, six);

        ListNode result = ob.addTwoNumbers(two, five);

        System.out.println(result.toString());

    }

    // DFS approach Left --> Right --> Left
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        if (h1 == null && h2 == null) {
            return null;
        }

        if (h1 == null)
            return h2;

        if (h2 == null)
            return h1;

        ListNode currentNode = addTwoNumbers(h1.next, h2.next);


        ListNode resultHead = null;
        ListNode headToReturn = null;
        int remainder = 0;
        int currentVal;
        int valueToPass = 0;

        int sum = h1.val + h2.val;
        currentVal = sum + remainder;
        valueToPass = currentVal % 10;

        remainder = currentVal / 10;


        // first ListNode
        if (resultHead == null) {
            resultHead = new ListNode(valueToPass, null);
            headToReturn = resultHead;
        } else {
            resultHead.next = new ListNode(valueToPass, null);
            resultHead = resultHead.next;
        }
        h1 = h1.next;
        h2 = h2.next;


        if (h1 == null) {
            while (h2 != null) {
                currentVal = h2.val + remainder;
                valueToPass = currentVal % 10;
                remainder = currentVal / 10;

                resultHead.next = new ListNode(valueToPass, null);
                resultHead = resultHead.next;
                h2 = h2.next;
            }
        } else if (h2 == null) {
            while (h1 != null) {
                currentVal = h1.val + remainder;
                valueToPass = currentVal % 10;
                remainder = currentVal / 10;

                resultHead.next = new ListNode(valueToPass, null);
                resultHead = resultHead.next;
                h1 = h1.next;
            }
        }

        if (remainder > 0) {
            resultHead.next = new ListNode(remainder, null);
        }

        return headToReturn;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " " + next + " ";
        }
    }
}
