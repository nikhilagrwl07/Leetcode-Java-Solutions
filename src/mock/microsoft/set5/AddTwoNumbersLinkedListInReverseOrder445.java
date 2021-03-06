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
        System.out.println(t1.toString());
        System.out.println(t10.toString());
//        ListNode reverseLinkedList = ob.reverseLinkedList(t1);
//        ob.print(reverseLinkedList);


        ListNode summedHead = ob.addTwoNumbers(t1, t10);
        System.out.println(summedHead.toString());
    }

    public ListNode addTwoNumbers(ListNode h1, ListNode h2)  {
        if (h1 == null)
            return h2;

        if (h2 == null)
            return h1;

        ListNode resultHead = null;
        ListNode headToReturn = null;
        int remainder = 0;
        int currentVal;
        int valueToPass =0;

        while (h1 != null && h2 != null) {
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
        }

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

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " " + next + " ";
        }
    }
}
