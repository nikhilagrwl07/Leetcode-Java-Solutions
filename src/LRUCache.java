

import java.util.HashMap;
import java.util.Map;


class MainDriver {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));       // returns 1
        cache.put(4, 10);
        System.out.println(cache.get(4));       // returns 1
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(3));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4
//        cache.put(4, 5);
//        System.out.println(cache.get(4));       // returns 5
    }

}

public class LRUCache {
    Map<Integer, Node> m;
    Node head;
    int totalCapacity;

    public LRUCache(int capacity) {
        m = new HashMap<>(capacity);
        head = null;
        totalCapacity = capacity;
    }

    public int get(int key) {
        if (!m.containsKey(key))
            return -1;

        Node node = m.get(key);

        // Head Node
        if (node.getLeft() == null) {
            return node.getValue();
        }

        // Last Node
        if (node.getRight() == null) {

            Node previous = node.getLeft();
            node.setLeft(null);
            node.setRight(head);
            head.setLeft(node);
            head = node;
            if (previous != null) {
                previous.setRight(null);
            }

            return node.getValue();
        }

        // Middle Node
        Node previous = node.getLeft();
        Node next = node.getRight();
        previous.setRight(next);
        next.setLeft(previous);

        node.setLeft(null);
        node.setRight(head);
        head.setLeft(node);
        head = node;
        return node.getValue();

    }

    public void put(int key, int value) {

        if (m.containsKey(key)) {
            Node node = m.get(key);
            node.setValue(value);

            if (node.getLeft() == null) {  // head node
                // do nothing -> already latest

            } else if (node.getRight() == null) // Last node
            {
                Node left = node.getLeft();
                left.setRight(null);
                node.setLeft(null);
                node.setRight(head);
                head.setLeft(node);
                head = node;
            } else            // middle node
            {
                Node previous = node.getLeft();
                Node next = node.getRight();
                previous.setRight(next);
                next.setLeft(previous);

                node.setLeft(null);
                node.setRight(head);
                head.setLeft(node);
                head = node;
            }
        } else // does not contain
        {
            if (m.size() == totalCapacity) { // capacity breached

                // Go to last node and remove it from map
                Node tmpHead = head;
                while (tmpHead.getRight() != null) {
                    tmpHead = tmpHead.getRight();
                }
                Node previous = tmpHead.getLeft();
                if (previous != null) {
                    previous.setRight(null);
                }
                else
                {
                    head = null;
                    m.clear();
                }

                Map.Entry<Integer, Node> me = null;
                for (Map.Entry<Integer, Node> n : m.entrySet()) {
                    if (n.getValue().getValue() == tmpHead.getValue()) {
                        me = n;
                        break;
                    }
                }
                if (me != null) {
                    m.remove(me.getKey());
                }


                if (head == null) {
                    head = new Node(value);
                } else {
                    Node newNode = new Node(value);
                    newNode.setLeft(null);
                    newNode.setRight(head);
                    head.setLeft(newNode);
                    head = newNode;
                }
                m.put(key, head);
            } else // capacity is not breached
            {

                if (head == null) {
                    head = new Node(value);
                } else {
                    Node newNode = new Node(value);
                    newNode.setLeft(null);
                    newNode.setRight(head);
                    head.setLeft(newNode);
                    head = newNode;
                }
                m.put(key, head);
            }
        }
    }
}

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}