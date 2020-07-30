package leetcodeProblems.medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree863 {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);


        three.left = five;
        three.right = one;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;
        one.left = zero;
        one.right = eight;

        AllNodesDistanceKInBinaryTree863 ob = new AllNodesDistanceKInBinaryTree863();
        List<Integer> result = ob.distanceK(three, five, 2);
        System.out.println(result);

    }

//    Time Complexity: O(N), where N is the number of nodes in the given tree.
//    Space Complexity: O(N)

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//
//        List<Integer> ans = new ArrayList<>();
//
//        distanceKUtil(root, target, K, ans);
//        return ans;
//
//    }
//
//    // returns vertex distance from currentNode to target (including both)
//    public int distanceKUtil(TreeNode currentNode, TreeNode target, int K,
//                             List<Integer> ans) {
//
//        if (currentNode == null) {
//            return -1;
//        }
//
//        if (currentNode.val == target.val) {
//            nodesAtKDistanceFromGivenNode(currentNode, 0, K, ans);
//            return 1;
//        }
//
//        int leftDistance = distanceKUtil(currentNode.left, target, K, ans);
//        int rightDistance = distanceKUtil(currentNode.right, target, K, ans);
//
//        // target is in left subtree with root as currentNode
//        if (leftDistance != -1) {
//
//            if (leftDistance == K) {
//                ans.add(currentNode.val);
//            }
//            nodesAtKDistanceFromGivenNode(currentNode.right, leftDistance + 1, K, ans);
//            return leftDistance + 1;
//        }
//
//        // target is in right subtree with root as currentNode
//        if (rightDistance != -1) {
//
//            if (rightDistance == K) {
//                ans.add(currentNode.val);
//            }
//            nodesAtKDistanceFromGivenNode(currentNode.left, rightDistance + 1, K, ans);
//            return rightDistance + 1;
//        }
//        return -1;
//
//    }
//
//
//    private void nodesAtKDistanceFromGivenNode(TreeNode node, int distanceTravelled, int K, List<Integer> ans) {
//
//        if (node == null || distanceTravelled < 0)
//            return;
//
//        if (distanceTravelled == K) {
//            ans.add(node.val);
//            return;
//        }
//
//        nodesAtKDistanceFromGivenNode(node.left, distanceTravelled + 1, K, ans);
//        nodesAtKDistanceFromGivenNode(node.right, distanceTravelled + 1, K, ans);
//    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result = new ArrayList<>();

        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        childToParent(root, childToParent, target);

        Set<TreeNode> isVisited = new HashSet<>();
        traverse(target, K, childToParent, result, isVisited);

        return result;
    }

    private void traverse(TreeNode currentNode, int k, Map<TreeNode, TreeNode> childToParent, List<Integer> result, Set<TreeNode> isVisited) {

        if (currentNode == null || isVisited.contains(currentNode))
            return;

        if (k == 0) {
            result.add(currentNode.val);
            return;
        }

        isVisited.add(currentNode);
        traverse(currentNode.left, k - 1, childToParent, result, isVisited);
        traverse(currentNode.right, k - 1, childToParent, result, isVisited);

        traverse(childToParent.get(currentNode), k - 1, childToParent, result, isVisited);
    }

    public void childToParent(TreeNode root, Map<TreeNode, TreeNode> childToParent, TreeNode target) {
        if (root == null || root == target)
            return;

        if (root.left != null)
            childToParent.put(root.left, root);

        if (root.right != null)
            childToParent.put(root.right, root);

        childToParent(root.left, childToParent, target);
        childToParent(root.right, childToParent, target);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
