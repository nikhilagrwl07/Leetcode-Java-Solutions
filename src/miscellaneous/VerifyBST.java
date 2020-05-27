package miscellaneous;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }


    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class VerifyBST {
    public static void main(String[] args) {
        VerifyBST ob = new VerifyBST();
//         5
//        / \
//       1   7
//          / \
//         6   8
        Node eight = new Node(8);
        Node four = new Node(4);
        Node seven = new Node(7, four, eight);
        Node one = new Node(1);
        Node five = new Node(5, one, seven);

        boolean verifyBSTResult = ob.verifyBST(five);
        System.out.println(verifyBSTResult);

    }

    public boolean verifyBST(Node root) {

        Integer min = null;
        Integer max = null;
        return verifyValidBstUtil(root, min, max);
    }

    // conquer
    private boolean verifyValidBstUtil(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.value < min)
            return false;

        if (max != null && root.value > max)
            return false;

        // conquer
        return verifyValidBstUtil(root.left, min, root.value - 1)
                &&
                verifyValidBstUtil(root.right, root.value + 1, max);
    }
}
