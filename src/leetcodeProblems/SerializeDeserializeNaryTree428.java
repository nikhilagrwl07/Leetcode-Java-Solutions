/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeNaryTree428 {
    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.addChildren(three);
        one.addChildren(two);
        one.addChildren(four);

        three.addChildren(five);
        three.addChildren(six);

        Codec ob = new Codec();

        String serializedTree = ob.serialize(one);
        System.out.println(serializedTree);

        Node rootOfDeserializedTree = ob.deserialize(serializedTree);
        System.out.println(rootOfDeserializedTree.toString());

    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {

            if (root == null)
                return "";

            StringBuilder preOrderTraversal = new StringBuilder();
            preOrderDFSWithCountOfChildren(root, preOrderTraversal);

            return preOrderTraversal.substring(0, preOrderTraversal.length() - 1);
        }

        private void preOrderDFSWithCountOfChildren(Node root, StringBuilder preOrderTraversal) {

            if (root == null) {
                return;
            }

            preOrderTraversal.append(root.val);
            preOrderTraversal.append(",");
            preOrderTraversal.append(root.children.size());
            preOrderTraversal.append(",");

            for (Node child : root.children) {
                preOrderDFSWithCountOfChildren(child, preOrderTraversal);
            }


        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {

            if (data.isEmpty()) {
                return null;
            }

            List<String> preOrderTraversal = new LinkedList<String>(Arrays.asList(data.split(",")));
            return deserializeUtil(preOrderTraversal);
        }

        public Node deserializeUtil(List<String> preOrderTraversal) {
            if (preOrderTraversal == null || preOrderTraversal.isEmpty()) {
                return null;
            }

            int value = Integer.valueOf(preOrderTraversal.remove(0));
            Node root = new Node();
            root.val = value;
            int totalChildCount = Integer.valueOf(preOrderTraversal.remove(0));
            root.children = new ArrayList<>(totalChildCount);

            for (int c = 1; c <= totalChildCount; c++) {
                root.children.add(deserializeUtil(preOrderTraversal));
            }

            return root;
        }

    }


    static class Node {
        public int val;
        public List<Node> children = new LinkedList<>();

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        public void addChildren(Node children) {
            this.children.add(children);
        }

        @Override
        public String toString() {
            return val + " " + children + " ";
        }
    }
}



