/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

        CopyListWithRandomPointer ob = new CopyListWithRandomPointer();
        Node head = ob.buildLinkedList();
        ob.printList(head);

        Node newHead = ob.copyRandomList(head);
        ob.printList(newHead);

    }

    private void printList(Node head){
        Node tHead = head;

        while (tHead!=null){
            System.out.println(tHead.val);
            tHead = tHead.next;
        }
    }

    private Node buildLinkedList (){

        Node four = new Node(4,null, null);
        Node three = new Node(3,four, four);
        Node two = new Node(2, three, four);
        Node head = new Node(1, two, three);
        return head;
    }


    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Map<Node, Node> m = new HashMap<>();

        Node tHead = null;
        Node tGiven = head;
        while (head != null) {

            Node copied = new Node(head.val, null, null);
            if (tHead == null) {
                tHead = copied;
            }

            m.put(head, copied);
            head = head.next;
        }

        while (tGiven != null) {
            Node node = m.get(tGiven);
            node.next = m.get(tGiven.next);
            node.random = m.get(tGiven.random);
            tGiven = tGiven.next;
        }
        return tHead;

    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}

