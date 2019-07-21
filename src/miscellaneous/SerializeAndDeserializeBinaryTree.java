/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.setNeighbours(two, three);
        three.setNeighbours(null, five);
        Codec ob = new Codec();
        String serialize = ob.serialize(one);
        System.out.println(serialize);

        TreeNode root = ob.deserialize(serialize);
        ob.inOrderTraversal(root);

    }
}

class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder preOrderTraversal = new StringBuilder();
        preOrderDFS(root, preOrderTraversal);
        return preOrderTraversal.substring(0, preOrderTraversal.length()-1);
    }


    public void preOrderDFS(TreeNode root, StringBuilder preOrderTraversal) {
        if (root == null) {
            preOrderTraversal.append("NULL");
            preOrderTraversal.append(",");
            return;
        }
        preOrderTraversal.append(root.val);
        preOrderTraversal.append(",");

        preOrderDFS(root.left, preOrderTraversal);
        preOrderDFS(root.right, preOrderTraversal);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty())
            return null;

        String[] split = data.split(",");
        LinkedList list = new LinkedList(Arrays.asList(split));

        return deserializeUtil(list);
    }

    public TreeNode deserializeUtil(List<String> data) {

        if (data.isEmpty()) {
            return null;
        }
        String value = data.get(0);
        data.remove(0);

        if (value.equals("NULL")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(value));
            root.left = deserializeUtil(data);
            root.right = deserializeUtil(data);
            return root;
        }
    }

    public void inOrderTraversal(TreeNode root) {

        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
    }

}

class TreeNode {
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
