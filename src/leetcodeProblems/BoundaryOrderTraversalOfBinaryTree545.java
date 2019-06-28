package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOrderTraversalOfBinaryTree545 {
    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;
        three.left = six;

        BoundaryOrderTraversalOfBinaryTree545 ob = new BoundaryOrderTraversalOfBinaryTree545();

        List<Integer> traversal = ob.boundaryOfBinaryTree(one);

        System.out.println(traversal);
    }


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        result.add(root.val);

        // left view --> parent then child except leaf nodes
        leftView(root.left, result);

        // leaf nodes
        bottomView(root.left, result);
        bottomView(root.right, result);


        // right view --> child then parent except leaf nodes
        rightView(root.right, result);

        return result;
    }

    private void leftView(TreeNode root, List<Integer> result) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        result.add(root.val);

        if (root.left != null) {
            leftView(root.left, result);
        } else {
            leftView(root.right, result);
        }
    }

    private void rightView(TreeNode root, List<Integer> result) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            rightView(root.right, result);
        } else {
            rightView(root.left, result);
        }

        result.add(root.val);
    }

    private void bottomView(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            result.add(root.val);
        }

        bottomView(root.left, result);
        bottomView(root.right, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
