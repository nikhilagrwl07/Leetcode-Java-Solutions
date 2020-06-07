package leetcodeProblems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeNArrayBinaryTree428 {
    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.children = Arrays.asList(three, two, four);
        three.children = Arrays.asList(five, six);

        SerializeDeserializeNArrayBinaryTree428 ob = new SerializeDeserializeNArrayBinaryTree428();
        String serializedTree = ob.serialize(one);
        System.out.println(serializedTree);

        Node deserializeTree = ob.deserialize(serializedTree);
        System.out.println(deserializeTree);
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();

        if (root == null)
            return sb.toString();

        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(Node root, StringBuilder sb) {

        sb.append(root.val);
        sb.append(',');
        if (root.children == null) {
            sb.append(0);
        } else {
            sb.append(root.children.size());
        }

        sb.append(',');

        if (root.children != null) {
            for (Node child : root.children) {
                serializeUtil(child, sb);
            }
        }

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        String[] split = data.split(",");
        return deserializeUtil(split, new int[]{0});
    }

    private Node deserializeUtil(String[] sb, int[] index) {
        if (sb.length == 0 || index[0] >= sb.length)
            return null;

        String currentStr = sb[index[0]];
        Node root = new Node(Integer.parseInt(currentStr));
        index[0] = index[0] + 1;
        int countOfChildren = Integer.parseInt(sb[index[0]]);
        index[0] = index[0] + 1;

        root.children = new ArrayList<>(countOfChildren);
        for (int i = 1; i <= countOfChildren; i++) {
            root.children.add(deserializeUtil(sb, index));
        }
        return root;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return val + ", " + children;
        }
    }
}
