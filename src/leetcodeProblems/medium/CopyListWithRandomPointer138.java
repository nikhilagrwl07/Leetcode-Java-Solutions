package leetcodeProblems.medium;

public class CopyListWithRandomPointer138 {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.next = two;
        one.random = three;

        two.next = three;
        two.random = one;

        three.next = null;
        three.random = one;

        printList(one);

        CopyListWithRandomPointer138 ob = new CopyListWithRandomPointer138();
        Node headOfCopiedList = ob.copyRandomList(one);

        printList(headOfCopiedList);

    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node headOfOld = head;
        Node headOfNew;

        // creating next only
        while (headOfOld != null) {
            headOfNew = new Node(headOfOld.val);

            Node nextOfOld = headOfOld.next;
            headOfOld.next = headOfNew;
            headOfNew.next = nextOfOld;

            headOfOld = headOfOld.next.next;
        }

        // creating random pointer
        headOfOld = head;
        while (headOfOld != null) {
            if (headOfOld.random != null) {
                headOfOld.next.random = headOfOld.random.next;
            }
            headOfOld = headOfOld.next.next;
        }

        // separating copied with original list
        headOfOld = head;
        headOfNew = null;
        Node headOfNewFirst = null;

        while (headOfOld != null) {

            if (headOfNew == null) {
                headOfNew = headOfOld.next;
                headOfNewFirst = headOfNew;
            } else {
                headOfNew.next = headOfOld.next;
                headOfNew = headOfNew.next;
            }
            headOfOld.next = headOfOld.next.next;
            headOfOld = headOfOld.next;
        }
        return headOfNewFirst;
    }


    // Time Complexity - O(N)
    // Space Complexity - O(N)
//    public Node copyRandomList(Node head) {
//        if (head == null)
//            return null;
//
//        Map<Node, Node> oldToNewNode = new HashMap<>();
//
//        Node headOfOld = head;
//        Node headOfNew;
//        while (headOfOld != null) {
//            headOfNew = new Node(headOfOld.val);
//            oldToNewNode.put(headOfOld, headOfNew);
//            headOfOld = headOfOld.next;
//        }
//
//        for (Map.Entry<Node, Node> e : oldToNewNode.entrySet()) {
//            Node oldNode = e.getKey();
//            Node newNode = e.getValue();
//
//            newNode.next = oldToNewNode.get(oldNode.next);
//            newNode.random = oldToNewNode.get(oldNode.random);
//
//        }
//        return oldToNewNode.get(head);
//    }


    private static void printList(Node headOfCopiedList) {

        Node tmp = headOfCopiedList;
        while (tmp != null) {
            System.out.print(tmp + " --> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);

        }
    }
}
