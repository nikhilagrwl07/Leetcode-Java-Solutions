package leetcodeProblems.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreOrder105 {
    public static void main(String[] args) {
        ConstructBTFromInorderAndPreOrder105 ob = new ConstructBTFromInorderAndPreOrder105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = ob.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeUtil(preorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeUtil(int[] preOrder, int preOrderIndex, int from, int to, Map<Integer, Integer> inorder) {
        if (from < 0 || to > preOrder.length - 1 || preOrderIndex < 0 || preOrderIndex >= preOrder.length)
            return null;


        int value = preOrder[preOrderIndex];
        TreeNode root = new TreeNode(value);
        Integer inOrderIndex = searchInOrder(inorder, from, to, value);

        if (inOrderIndex == null)
            return null;

        int length = inOrderIndex - from + 1;

        root.left = buildTreeUtil(preOrder, preOrderIndex + 1, from, inOrderIndex - 1, inorder);
        root.right = buildTreeUtil(preOrder, preOrderIndex + length, inOrderIndex + 1, to, inorder);

        return root;
    }

    private Integer searchInOrder(Map<Integer, Integer> inorder, int from, int to, int value) {
        if (from > to || inorder.get(value) == null)
            return null;

        return inorder.get(value);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left + " " + val + " " + right;
    }
}
