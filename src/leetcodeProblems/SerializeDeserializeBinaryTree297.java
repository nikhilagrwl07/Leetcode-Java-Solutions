package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBinaryTree297 {
    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);


        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;
        four.left = six;
        four.right = seven;

        SerializeDeserializeBinaryTree297 ob = new SerializeDeserializeBinaryTree297();
        String serializedTree = ob.serialize(one);
        System.out.println(serializedTree);

        TreeNode deserializeTree = ob.deserialize(serializedTree);
        System.out.println(deserializeTree);
    }


    // Applying preorder traversal which is one of the DFS strategy
    private String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preorderDFS(root, sb);
        String result = sb.toString();
        return result.substring(0, result.length() - 1);

    }

    private void preorderDFS(TreeNode currentNode, StringBuilder sb) {

        if (currentNode == null) {
            sb.append("null");
            sb.append(",");
            return;
        }

        sb.append(currentNode.val);
        sb.append(",");

        preorderDFS(currentNode.left, sb);
        preorderDFS(currentNode.right, sb);
    }

    // Without maintaining external index, i.e., completely stateless
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }


        List<String> list = Arrays.asList(data.split(","));
        List<String> split = new LinkedList<>(list);

        return constructTree(split);
    }

    public TreeNode constructTree(List<String> data) {

        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);

        root.left = constructTree(data);
        root.right = constructTree(data);

        return root;
    }



    // Wrong approach to maintain index outside the function
//    private static int currentIndex = 0;
//    private static void serialize(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            list.add(-1);
//            return;
//        }
//
//        list.add(root.getValue());
//        serialize(root.getLeft(), list);
//        serialize(root.getRight(), list);
//    }
//
//    private static TreeNode deserialize(List<Integer> list) {
//        if (list.isEmpty() || currentIndex >= list.size() || list.get(currentIndex) == -1) {
//            currentIndex++;
//            return null;
//        }
//
//        TreeNode root = new TreeNode(list.get(currentIndex));
//
//        currentIndex++;
//
//        root.setLeft(deserialize(list));
//        root.setRight(deserialize(list));
//
//        return root;
//    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getValue() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return val + " , " + left + " , " + right;
        }
    }
}
