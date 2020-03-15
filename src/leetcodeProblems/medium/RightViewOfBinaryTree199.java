package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree199 {
    public static void main(String[] args) {

        RightViewOfBinaryTree199 ob = new RightViewOfBinaryTree199();

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.right = five;
//        three.right = four;

        List<Integer> result = ob.rightSideView(one);
        System.out.println(result);

    }

    // DFS approach
//    public List<Integer> rightSideView(TreeNode root) {
//        if (root == null)
//            return new ArrayList<>();
//
//        List<Integer> result = new ArrayList<>();
//        TreeMap<Integer, TreeNode> depthToNodeMap = new TreeMap<>();
//
//        Stack<Integer> depthStack = new Stack<>();
//        Stack<TreeNode> nodeStack = new Stack<>();
//        depthStack.push(0);
//        nodeStack.push(root);
//
//        while (!nodeStack.isEmpty()) {
//            TreeNode poppedNode = nodeStack.pop();
//            Integer depth = depthStack.pop();
//
//            if (!depthToNodeMap.containsKey(depth)) {
//                depthToNodeMap.put(depth, poppedNode);
//            }
//
//            if (poppedNode.left != null) {
//                depthStack.push(depth + 1);
//                nodeStack.push(poppedNode.left);
//            }
//            if(poppedNode.right!=null){
//                depthStack.push(depth + 1);
//                nodeStack.push(poppedNode.right);
//            }
//        }
//
//        for(TreeNode node : depthToNodeMap.values()){
//            result.add(node.val);
//        }
//        return result;
//    }

    // BFS
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();

                if (currentNode.left != null)
                    q.offer(currentNode.left);

                if (currentNode.right != null)
                    q.offer(currentNode.right);

                if (i == size - 1)
                    result.add(currentNode.val);
            }
        }
        return result;
    }


    private static class TreeNode {
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
}
