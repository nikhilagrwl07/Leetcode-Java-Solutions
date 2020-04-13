package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    public static void main(String[] args) {
        PathSum113 ob = new PathSum113();
//          5
//         / \
//        4   8
//       /   / \
//       11  13  4
//      /  \    / \
//     7    2  5   1
//        TreeNode seven = new TreeNode(7);
//        TreeNode two = new TreeNode(2);
//        TreeNode eleven = new TreeNode(11, seven, two);
//        TreeNode fourLeft = new TreeNode(4, eleven, null);
//
//
//        TreeNode fiveDown = new TreeNode(5);
//        TreeNode one = new TreeNode(1);
//        TreeNode fourRight = new TreeNode(4, fiveDown, one);
//        TreeNode thirteen = new TreeNode(13);
//        TreeNode eight = new TreeNode(8, thirteen, fourRight);
//
//        TreeNode fiveUp = new TreeNode(5, fourLeft, eight);
//        List<List<Integer>> paths = ob.pathSum(fiveUp, 22);


        TreeNode negativeThree = new TreeNode(-3);
        TreeNode negativeTwo = new TreeNode(-2, null, negativeThree);
        List<List<Integer>> paths = ob.pathSum(negativeTwo, -5);
        System.out.println(paths);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> path = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        int[] currentSum = new int[1];
        dfs(root, sum, currentSum, currentPath, path);
        return path;
    }

    // For complete binary tree with N/2 leaf nodes, im worst case
    // each leaf node would taken O(N) to create list to be copied
    private boolean dfs(TreeNode root, int target, int[] currentSum,
                        List<Integer> currentPath, List<List<Integer>> result) {

        if (root == null)
            return false;

        if (currentSum[0] + root.val != target && isLeaf(root))
            return false;

        currentSum[0] += root.val;
        currentPath.add(root.val);

        // qualify for adding in result
        if (currentSum[0] == target && isLeaf(root)) {
            result.add(new ArrayList<>(currentPath)); // O(N) time taken
        }

        boolean left = dfs(root.left, target, currentSum, currentPath, result);

        if (left) {
            currentPath.remove(currentPath.size() - 1);
            currentSum[0] -= root.left.val;
        }

        boolean right = dfs(root.right, target, currentSum, currentPath, result);
        if (right) {
            currentPath.remove(currentPath.size() - 1);
            currentSum[0] -= root.right.val;
        }
        return true;
    }

    public boolean isLeaf(TreeNode r) {
        if (r == null)
            return false;

        if (r.left != null || r.right != null)
            return false;

        return true;
    }

    static class TreeNode {
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
