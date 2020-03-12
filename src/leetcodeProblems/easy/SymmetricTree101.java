package leetcodeProblems.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {
    public static void main(String[] args) {


        TreeNode threefirst = new TreeNode(3);
        TreeNode threeSecond = new TreeNode(3);

        TreeNode fourFirst = new TreeNode(4);
        TreeNode fourSecond = new TreeNode(4);

        TreeNode twofirst = new TreeNode(2, fourFirst, null);
        TreeNode twosecond = new TreeNode(2, fourSecond, null);

        TreeNode one = new TreeNode(1, twofirst, twosecond);

        SymmetricTree101 ob = new SymmetricTree101();

        boolean isSymmetric = ob.isSymmetricRecursive(one);
        System.out.println(isSymmetric);

    }

    public boolean isSymmetricRecursive(TreeNode root) {
       return isSymmetricRecursive(root, root);
    }

    public boolean isSymmetricRecursive(TreeNode r1, TreeNode r2) {
        if(r1==null && r2 ==null)
            return true;

        if(r1==null || r2 ==null)
            return false;

        if(r1.val!= r2.val)
            return false;

        return isSymmetricRecursive(r1.left, r2.right) &&
                isSymmetricRecursive(r1.right, r2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if(t1.val != t2.val)
                return false;

            q.offer(t1.left);
            q.offer(t2.right);

            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(dummy);


        while (!q.isEmpty()) {
            TreeNode polledNode = q.poll();

            if (polledNode.val == dummy.val) {

                if (q.isEmpty())
                    break;

                q.offer(polledNode);

                List<TreeNode> list = extractNodesfromQueue(q, dummy);

                if (!checkPalindrome(list))
                    return false;

            } else {
                if (polledNode.left != dummy) {
                    q.offer(polledNode.left);
                }

                if (polledNode.right != dummy) {
                    q.offer(polledNode.right);
                }
            }

        }

        return true;
    }

    private List<TreeNode> extractNodesfromQueue(Queue<TreeNode> q, TreeNode dummy) {

        List<TreeNode> l = new ArrayList<>();

        while (q.peek() != dummy) {

            TreeNode polledNode = q.poll();

            if (polledNode == null) {
                l.add(polledNode);
                continue;
            }

            if (polledNode.left != dummy) {
                q.offer(polledNode.left);
            }

            if (polledNode.right != dummy) {
                q.offer(polledNode.right);
            }

            l.add(polledNode);
        }
        return l;
    }

    private boolean checkPalindrome(List<TreeNode> list) {

        if (list.size() % 2 != 0) {
            return false;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {

            if (list.get(i) == null && list.get(j) == null) {
                i++;
                j--;
                continue;
            }
            if (list.get(i) == null || list.get(j) == null)
                return false;

            if (list.get(i).val != list.get(j).val)
                return false;

            i++;
            j--;
        }
        return true;
    }
}

class TreeNode {
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
