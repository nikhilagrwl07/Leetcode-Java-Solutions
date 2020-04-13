package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    public static void main(String[] args) {
        CloneGraph133 ob = new CloneGraph133();

        Node one = new Node(1);
//        Node two = new Node(2);
//        Node three = new Node(3);
//        Node four = new Node(4);
//        one.neighbors = Arrays.asList(two, four);
//        two.neighbors = Arrays.asList(one, three);
//        three.neighbors = Arrays.asList(two, four);
//        four.neighbors = Arrays.asList(one, three);

//        System.out.println(one);
        Node clonedNode = ob.cloneGraph(ob.cloneGraph(one));
        System.out.println(clonedNode.val);
//        System.out.println(clonedNode);
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        // creating map of old to new nodes
        Map<Integer, Node> oldToNew = new HashMap<>();
        dfs(node, oldToNew);
        return oldToNew.get(node.val);
    }

    private void dfs(Node node, Map<Integer, Node> oldToNew) {

        if (oldToNew.containsKey(node.val))
            return;

        Node newNode = new Node(node.val);
        oldToNew.put(node.val, newNode);

        for (Node nei : node.neighbors) {
            dfs(nei, oldToNew);
            // traverse old nodes to creating edges between new nodes
            newNode.neighbors.add(oldToNew.get(nei.val));
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return val + " " + neighbors + " ";
        }
    }
}
