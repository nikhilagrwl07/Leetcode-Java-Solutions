/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */

package leetcodeProblems;

public class ConvertSortedArrayToBST108 {
    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};

        ConvertSortedArrayToBST108 ob = new ConvertSortedArrayToBST108();
        TreeNode root = ob.sortedArrayToBST(a);

        ob.inOrderTraversal(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTUtil(int[] nums, int low, int high) {

        if (low < 0 || high > nums.length - 1 || low > high)
            return null;

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTUtil(nums, low, mid - 1);
        root.right = sortedArrayToBSTUtil(nums, mid + 1, high);
        return root;
    }


    public void inOrderTraversal(TreeNode root){

        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
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
