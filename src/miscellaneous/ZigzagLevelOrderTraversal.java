package miscellaneous;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class ZigzagLevelOrderTraversal {
    public static void main(String[] args) {

        ZigzagLevelOrderTraversal ob = new ZigzagLevelOrderTraversal();
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

        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();

        if (root == null) {
            return zigzagLevelOrder;
        }
        if ((root.left == null && root.right == null)) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            zigzagLevelOrder.add(list);
            return zigzagLevelOrder;
        }

        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;

        q.add(root);
        q.add(null);

        List<Integer> l1 = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {

            TreeNode t = q.remove();

            if (t != null) {
                if (leftToRight) {
                    l1.add(t.val);
                } else {
                    s.add(t.val);
                }
            }


            if (t == null) {

                if (leftToRight) {
                    zigzagLevelOrder.add(l1);
                    l1 = new ArrayList<>();
                } else {
                    List<Integer> lTmp = new ArrayList<>();
                    while (!s.isEmpty()){
                        lTmp.add(s.pop());
                    }
                    zigzagLevelOrder.add(lTmp);
                    s = new Stack<>();
                }

                if (q.peek() == null) {
                    break;
                }

                q.add(null);
                leftToRight = !leftToRight;
                continue;
            }

            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }


        }
        return zigzagLevelOrder;
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
