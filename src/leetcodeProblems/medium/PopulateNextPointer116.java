package leetcodeProblems.medium;

public class PopulateNextPointer116 {
    public static void main(String[] args) {

        PopulateNextPointer116 ob = new PopulateNextPointer116();

        Node six = new Node(6);
        Node seven = new Node(7);
        Node four = new Node(4);
        Node five = new Node(5);

        Node two = new Node(2, four, five);
        Node three = new Node(3, six, seven);

        Node one = new Node(1, two, three);

        Node root = ob.connect(one);
        System.out.println(root);


    }

    // Time Complexity - O(N) where N = total number of nodes
    // Space Complexity - O(1)
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node topMost = root;

        // across depth
        while (root.left != null) {

            // across same level
            Node rootTmp = root;
            while (rootTmp != null) {

                // connection 1
                rootTmp.left.next = rootTmp.right;

                // connection 2
                if (rootTmp.next != null)
                    rootTmp.right.next = rootTmp.next.left;

                rootTmp = rootTmp.next;
            }
            root = root.left;
        }
        return topMost;
    }


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    ;
}
