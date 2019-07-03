package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKsortedLinkedList {
    public static void main(String[] args) {
        MergeKsortedLinkedList ob = new MergeKsortedLinkedList();
        ListNode[] nodes = ob.buildLinkedListArray();
        ListNode listNode = ob.mergeKLists(nodes);
        ob.printMergedLinkedList(listNode);

    }

    private ListNode[] buildLinkedListArray() {
        ListNode[] nodes = new ListNode[4];
        nodes[0] = new ListNode(10);
        nodes[1] = new ListNode(15);
        nodes[2] = new ListNode(5);
        nodes[3] = new ListNode(6, new ListNode(7, new ListNode(100)));

        return nodes;
    }

    private void printMergedLinkedList(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();

    }


    // Approach - Priority Queue
    // Time Complexity - O(N * logK)
    // Space Complexity - O(1)
    private ListNode mergeKLists(ListNode[] lists) {

        ListNode resultHead = null, result = null;

        Comparator<ListNode> cmp = (o1, o2) -> o1.val - o2.val;

        Queue<ListNode> q = new PriorityQueue<>(cmp);

        for (ListNode ln : lists) {

            if(ln!=null)
            {
                q.add(ln);
            }
        }

        if (q.isEmpty()){
            return null;
        }

        while (!q.isEmpty()) {

            ListNode removedNode = q.remove();
            if (result == null) {
                result = removedNode;
                resultHead = removedNode;
            } else {
                result.next = removedNode;
                result = result.next;
            }

            if(removedNode.next!=null){
                q.add(removedNode.next);
            }
        }
        return resultHead;
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
    }
}
