package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
//        TreeNode oneleft = new TreeNode(1);
//        one.left=oneleft;

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
//
        three.setNeighbours(four, five);
        four.setNeighbours(one, two);

        TreeNode fourS = new TreeNode(4);
        TreeNode oneS = new TreeNode(1);
        TreeNode twoS = new TreeNode(2);
//        TreeNode zeroS = new TreeNode(0);
        fourS.setNeighbours(oneS, twoS);
//        twoS.left = zeroS;

        SubtreeOfAnotherTree572 ob = new SubtreeOfAnotherTree572();
        boolean isSubTree = ob.isSubtree(three, fourS);
        System.out.println(isSubTree);

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> rootofTInS = new ArrayList<>();

        findRootofTInS(s, t, rootofTInS);

        for (TreeNode tn : rootofTInS) {
            if(isSubtreeUtil(tn, t)){
                return true;
            }
        }
        return false;
    }

    public boolean isSubtreeUtil(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (s.val != t.val) {
            return false;
        }

        return isSubtreeUtil(s.left, t.left) && isSubtreeUtil(s.right, t.right);
    }

    public void findRootofTInS(TreeNode s, TreeNode t, List<TreeNode> ans) {

        if (s == null || t == null) {
            return;
        }

        if (s.val == t.val) {
            ans.add(s);
        }

        findRootofTInS(s.left, t, ans);
        findRootofTInS(s.right, t, ans);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setNeighbours(TreeNode l, TreeNode r) {
            this.left = l;
            this.right = r;
        }
    }

}
