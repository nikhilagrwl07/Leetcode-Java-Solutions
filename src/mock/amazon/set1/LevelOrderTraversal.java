package mock.amazon.set1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal ob = new LevelOrderTraversal();

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<TreeNode> tmp = new ArrayList<>();
        while (!q.isEmpty()) {

            TreeNode node = q.remove();

            if (node == null) {
                List<Integer> t = new LinkedList<>();

                while (!tmp.isEmpty()) {
                    t.add(tmp.remove(0).val);
                }
                result.add(t);
                q.add(null);

                if(q.peek()==null)
                    break;
            } else {

                tmp.add(node);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return result;
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
