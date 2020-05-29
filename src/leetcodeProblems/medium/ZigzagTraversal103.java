package leetcodeProblems.medium;
import java.util.*;

public class ZigzagTraversal103 {
    public static void main(String[] args) {

        ZigzagTraversal103 ob = new ZigzagTraversal103();
        TreeNode treeNode = ob.buildTree();

        List<List<Integer>> lists = ob.zigzagLevelOrder(treeNode);
        System.out.println(lists);

    }

    private TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode tweenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = tweenty;
        tweenty.left = fifteen;
        tweenty.right = seven;

        return root;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flip = false;
        LinkedList<Integer> levelNode = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) {

            TreeNode poll = q.poll();
//            System.out.println(poll);

            if (poll == null) {
                if (flip) {
                    List<Integer> tmp = new ArrayList<>();
                    while (!stack.isEmpty()){
                        tmp.add(stack.pop());
                    }
                    result.add(tmp);
                    stack.clear();
                } else {
                    result.add(new ArrayList<>(levelNode));
                    levelNode.clear();
                }
                flip = !flip;

                if (q.peek() == null)
                    break;

                q.add(null);
            } else {
                if (flip) {
                    stack.push(poll.val);
                } else {
                    levelNode.add(poll.val);
                }


                if (poll.left != null)
                    q.offer(poll.left);

                if (poll.right != null)
                    q.offer(poll.right);
            }
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
