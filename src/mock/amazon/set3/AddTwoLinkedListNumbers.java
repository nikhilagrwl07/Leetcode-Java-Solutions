package mock.amazon.set3;

public class AddTwoLinkedListNumbers {
    public static void main(String[] args) {

        ListNode two = new ListNode(2);
        ListNode sixFirst = new ListNode(6);
        ListNode three = new ListNode(3);
        two.next = sixFirst;
        sixFirst.next = three;


        ListNode five = new ListNode(5);
        ListNode sixSecond = new ListNode(6);
        ListNode nine = new ListNode(9);

        five.next = sixSecond;
        sixSecond.next = nine;


        AddTwoLinkedListNumbers ob = new AddTwoLinkedListNumbers();
        ListNode addTwoNumbers = ob.addTwoNumbers(two, five);
        System.out.println(addTwoNumbers.toString());

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode head = null;

        int remainder = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remainder;

            if (sum >= 10) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }

            if (result == null) {
                result = new ListNode(sum);
                head = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {

            if (remainder == 0) {
                result.next = l1;
                break;
            } else {

                int sum = l1.val + remainder;

                if (sum >= 10) {
                    remainder = 1;
                    sum = sum % 10;
                } else {
                    remainder = 0;
                }

                result.next = new ListNode(sum);
                result = result.next;
            }

            l1 = l1.next;
        }

        while (l2 != null) {

            if (remainder == 0) {
                result.next = l2;
                break;
            } else {

                int sum = l2.val + remainder;

                if (sum >= 10) {
                    remainder = 1;
                    sum = sum % 10;
                } else {
                    remainder = 0;
                }

                result.next = new ListNode(sum);
                result = result.next;
            }

            l2 = l2.next;
        }

        if (remainder > 0) {
            result.next = new ListNode(remainder);
        }


        return head;
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
