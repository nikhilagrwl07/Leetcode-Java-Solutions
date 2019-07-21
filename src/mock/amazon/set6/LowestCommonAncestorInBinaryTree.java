/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set6;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorInBinaryTree {

    public static void main(String[] args) {
        // Didn't wrote driver program as I was confident about path based solution for LCA in BT
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;


        List<TreeNode> path = new ArrayList<>();
        int index = 0;

        int topIndexOfP = lowestCommonAncestor(root, p, path, index);

        List<TreeNode> path2 = new ArrayList<>();
        index = 0;
        int topIndexOfQ = lowestCommonAncestor(root, q, path2, index);

        index = 0;
        TreeNode previous = root;

        while (index <= topIndexOfP && index <= topIndexOfQ) {
            if (path.get(index).val == path2.get(index).val) {
                previous = path.get(index);
            } else {
                return previous;
            }
            index++;
        }

        return previous;
    }

    public Integer lowestCommonAncestor(TreeNode root, TreeNode t, List<TreeNode> path, int index) {

        if (root == null) {
            return -1;
        }

        path.add(index, root);

        if (root.val == t.val) {
            return index;
        }

        int leftIndex = lowestCommonAncestor(root.left, t, path, index + 1);
        if (leftIndex != -1) {
            return leftIndex;
        }
        return lowestCommonAncestor(root.right, t, path, index + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
