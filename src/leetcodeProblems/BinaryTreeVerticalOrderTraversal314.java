package leetcodeProblems;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal314 {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode four = new TreeNode(4);
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode tweenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.setNeighbours(nine, eight);
        nine.setNeighbours(four, zero);
        eight.setNeighbours(one, seven);
        one.setNeighbours(five, two);

//        three.left=nine;
//        three.right=tweenty;
//        tweenty.left=fifteen;
//        tweenty.right=seven;

        BinaryTreeVerticalOrderTraversal314 ob = new BinaryTreeVerticalOrderTraversal314();
        List<List<Integer>> verticalOrder = ob.verticalOrder(three);
        System.out.println(verticalOrder);

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> m = new TreeMap<>();

        verticalOrderUtil(root, 0, m);

        return new LinkedList<>(m.values());
    }

    public void verticalOrderUtil(TreeNode root, int level, Map<Integer, LinkedList<Integer>> m) {
        if (root == null)
            return;

        LinkedList<Integer> list = m.getOrDefault(level, new LinkedList<Integer>());
        list.add(root.val);
        m.put(level, list);

        verticalOrderUtil(root.left, level - 1, m);
        verticalOrderUtil(root.right, level + 1, m);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setNeighbours(TreeNode l, TreeNode r){
            left = l;
            right = r;
        }
    }
}
