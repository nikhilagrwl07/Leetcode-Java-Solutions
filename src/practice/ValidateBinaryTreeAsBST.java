package practice;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinaryTreeAsBST {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4, three, six);
        TreeNode two = new TreeNode(2, one, four);
        TreeNode tmp = new TreeNode(-2147483648);

        ValidateBinaryTreeAsBST ob = new ValidateBinaryTreeAsBST();
        boolean validBSTIterative = ob.isValidBSTUsingInOrderTraversal(tmp);
        System.out.println(validBSTIterative);

    }

    // O(N) time
    // O(N) space
    public boolean isValidBSTUsingInOrderTraversal(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        Integer inOrderPredecessor = null;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (inOrderPredecessor != null && inOrderPredecessor >= root.val)
                return false;

            inOrderPredecessor = root.val;
            root = root.right;
        }
        return true;
    }

    // O(N) time
    // O(N) space
    public boolean isValidBSTIterative(TreeNode root) {

        if (root == null)
            return true;

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> lower = new LinkedList<>();
        LinkedList<Integer> higher = new LinkedList<>();

        // populating data
        stack.add(root);
        lower.add(null);
        higher.add(null);

        while (!stack.isEmpty()) {
            TreeNode current = stack.poll();
            updateStack(stack, lower, higher, current);

            Integer low = lower.poll();
            Integer high = higher.poll();
            if (low != null && current.val <= low) {
                return false;
            }
            if (high != null && current.val >= high) {
                return false;
            }
        }
        return true;
    }

    private void updateStack(LinkedList<TreeNode> stack, LinkedList<Integer> lower,
                             LinkedList<Integer> higher, TreeNode current) {

        if (current.left != null) {
            stack.add(current.left);
            lower.add(lower.peek());
            higher.add(current.val);
        }

        if (current.right != null) {
            stack.add(current.right);
            lower.add(current.val);
            higher.add(higher.peek());
        }
    }


    //             5
//                / \
//                1   6
//                / \
//                0   2
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, null, null);
    }


    //    f(5, n, n)
//      f(1, n, 5)
//      f(0, n, 1)
//      f(2, 1, 5)
//      f(6, 5, n)
    // O(N) Time
    // O(N) space
    public boolean isValidBSTUtil(TreeNode root, Integer low, Integer high) {

        if (root == null)
            return true;

        if (low != null && low >= root.val)
            return false;

        if (high != null && high <= root.val)
            return false;

        return isValidBSTUtil(root.left, low, root.val)
                &&
                isValidBSTUtil(root.right, root.val, high);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
