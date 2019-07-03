package leetcodeProblems;

public class ConvertSortedSinglyLinkedListToBST109 {
    public static void main(String[] args) {

        ListNode minus10 = new ListNode(-10);
        ListNode minus3 = new ListNode(-3);
        ListNode zero = new ListNode(0);
        ListNode five = new ListNode(5);
//        ListNode nine = new ListNode(9);

        minus10.next = minus3;
        minus3.next = zero;
        zero.next = five;
//        five.next = nine;

        ConvertSortedSinglyLinkedListToBST109 ob = new ConvertSortedSinglyLinkedListToBST109();
        TreeNode root = ob.sortedListToBST(minus10);

        ob.inOrderTraversal(root);
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;

        ListNode middleNode = findMiddleNode(head);

        TreeNode root = new TreeNode(middleNode.val);

        ListNode tmp = middleNode.next;

        middleNode.next=null;

        // base case - when there is only one element
        if(head == middleNode){
            return root;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(tmp);
        return root;
    }

    public ListNode findMiddleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode slower = head;
        ListNode faster = head;

        while (faster != null && faster.next != null) {
            previous = slower;
            slower = slower.next;
            faster = faster.next.next;
        }

        if (previous != null) {
            previous.next = null;
        }

        return slower;
    }


    public void inOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
