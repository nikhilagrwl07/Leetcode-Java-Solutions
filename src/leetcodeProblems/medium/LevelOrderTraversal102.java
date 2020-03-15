package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal102 {
    public static void main(String[] args) {

        LevelOrderTraversal102 ob = new LevelOrderTraversal102();

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.right = five;
        three.right = four;

        List<List<Integer>> result = ob.levelOrder(one);
        System.out.println(result);
    }

    // BFS approach
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> listAtLevel = new ArrayList<>();
        while (!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left!=null)
                    q.offer(node.left);

                if(node.right!=null)
                    q.offer(node.right);

                listAtLevel.add(node.val);
            }

            result.add(new ArrayList<>(listAtLevel));
            listAtLevel.clear();
        }

        return result;
    }


    // DFS approach
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null)
//            return new ArrayList<>();
//
//        TreeMap<Integer, List<Integer>> depthToNodeMap = new TreeMap<>();
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
//            depthToNodeMap.computeIfAbsent(depth,integer ->  new LinkedList<>()).add(poppedNode.val);
//
//            if(poppedNode.right!=null){
//                depthStack.push(depth + 1);
//                nodeStack.push(poppedNode.right);
//            }
//
//            if (poppedNode.left != null) {
//                depthStack.push(depth + 1);
//                nodeStack.push(poppedNode.left);
//            }
//
//        }
//
//        return new ArrayList<>(depthToNodeMap.values());
//    }

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
