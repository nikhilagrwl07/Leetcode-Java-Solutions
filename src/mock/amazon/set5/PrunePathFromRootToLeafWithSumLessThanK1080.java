package mock.amazon.set5;


public class PrunePathFromRootToLeafWithSumLessThanK1080 {

    public static void main(String[] args) {
        PrunePathFromRootToLeafWithSumLessThanK1080 ob = new PrunePathFromRootToLeafWithSumLessThanK1080();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode four1 = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);
        TreeNode seven = new TreeNode(7);
        TreeNode fourteen = new TreeNode(14);
        TreeNode eleven = new TreeNode(11);


//        TreeNode negative99 = new TreeNode(-99);
//        TreeNode negative991 = new TreeNode(-99);
//        TreeNode negative992 = new TreeNode(-99);
//        TreeNode negative993 = new TreeNode(-99);
//        TreeNode negative994 = new TreeNode(-99);
//
//
//        one.setNeighbours(two, three);
//        two.setNeighbours(four, negative99);
//        four.setNeighbours(eight, nine);
//        negative99.setNeighbours(negative991, negative992);
//        three.setNeighbours(negative993, seven);
//        negative993.setNeighbours(twelve, thirteen);
//        seven.setNeighbours(negative994, fourteen);


//        TreeNode negativeThree = new TreeNode(-3);
//        TreeNode negativeFive = new TreeNode(-5);
//
//        one.setNeighbours(two, negativeThree);
//        two.setNeighbours(negativeFive, null);
//        negativeThree.setNeighbours(four, null);


        TreeNode five = new TreeNode(5);
        TreeNode five1 = new TreeNode(5);
        TreeNode seventeen = new TreeNode(17);

        five.setNeighbours(four, eight);
        four.setNeighbours(eleven, null);
        eleven.setNeighbours(seven, one);
        eight.setNeighbours(seventeen, four1);
        four1.setNeighbours(five1, three);


        ob.sufficientSubset(five, 22);
        System.out.println(one);


    }

    // Time Complexity - O(N) where N is number of nodes in given tree
    // Space Complexity - O(h) where h is height of given tree (in worst case tree would be skewed hence h becomes N)
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if(root == null)
            return null;

        if(root.left==null && root.right==null) {  // leaf node

            if(root.val < limit)
                return null;
            else
                return root;
        }

        root.left = sufficientSubset(root.left, limit-root.val);
        root.right = sufficientSubset(root.right, limit-root.val);

        if(root.left==null && root.right==null)
            return null;
        else
            return root;
    }


    static class TreeNode {
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
