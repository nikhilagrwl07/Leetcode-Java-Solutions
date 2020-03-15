package mock.amazon.set1;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal ob = new LevelOrderTraversal();

    }


    // DFS approach
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, List<Integer>> depthToNodeMap = new TreeMap<>();

        Stack<Integer> depthStack = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        depthStack.push(0);
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode poppedNode = nodeStack.pop();
            Integer depth = depthStack.pop();

            depthToNodeMap.computeIfAbsent(depth, integer -> new LinkedList<>()).add(poppedNode.val);

            if (poppedNode.right != null) {
                depthStack.push(depth + 1);
                nodeStack.push(poppedNode.right);
            }

            if (poppedNode.left != null) {
                depthStack.push(depth + 1);
                nodeStack.push(poppedNode.left);
            }

        }

        return new ArrayList<>(depthToNodeMap.values());
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
