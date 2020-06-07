package leetcodeProblems.hard;

public class SerializeDeserializeBinaryTree297 {
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree297 ob = new SerializeDeserializeBinaryTree297();
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


//        String serializedTree = ob.serialize(one);
//        System.out.println(serializedTree);
//        TreeNode deserializeTree = ob.deserialize(serializedTree);
//        System.out.println(deserializeTree);


        TreeNode one1 = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        one1.left = null;
        one1.right = two1;
        String serializedTree = ob.serialize(one1);
        System.out.println(serializedTree);
        TreeNode deserializeTree = ob.deserialize(serializedTree);
        System.out.println(deserializeTree);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('N');
            sb.append(',');
            return;
        }

        sb.append(root.val);
        sb.append(',');
        serializeUtil(root.left, sb);

        serializeUtil(root.right, sb);
        ;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        String[] split = data.split(",");
        return deserializeUtil(split, new int[]{0});
    }

    private TreeNode deserializeUtil(String[] sb, int[] index) {
        if (sb.length == 0)
            return null;

        String currentStr = sb[index[0]];
        index[0] = index[0] + 1;

        if (currentStr.equals("N"))
        {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(currentStr));
        root.left = deserializeUtil(sb, index);
        root.right = deserializeUtil(sb, index);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " , " + left + right;
        }
    }
}
