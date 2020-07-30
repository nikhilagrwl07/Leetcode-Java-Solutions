package mock.amazon.set1;

import java.util.*;

public class MostFrequentElementStack {
    public static void main(String[] args) {
        FreqStack ob = new FreqStack();
//        ob.push(5); //5,7,5,7,4,5
//        ob.push(7); //5,7,5,7,4,5
//        ob.push(5); //5,7,5,7,4,5
//        ob.push(7); //5,7,5,7,4,5
//        ob.push(4); //5,7,5,7,4,5
//        ob.push(5); //5,7,5,7,4,5
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());
//        System.out.println(ob.pop());


        ob.push(6);
        ob.push(8);
        ob.push(6);
        ob.push(6);
        ob.push(8);
        ob.push(9);
        System.out.println(ob.pop());
        ob.push(8);
        System.out.println(ob.pop());
        ob.push(9);
        System.out.println(ob.pop());

        ob.push(8);
        System.out.println(ob.pop());

        ob.push(8);
        System.out.println(ob.pop());


        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
    }
}

class FreqStack {
    Map<Integer, Node> m;
    Queue<Node> pq;
    int counter = 0;

    public FreqStack() {
        m = new HashMap<>();
        pq = new PriorityQueue<Node>((o1, o2) -> {
            int diff = o2.order.size() - o1.order.size(); // Highest freq element at top aka max Heap


            if (diff == 0) {
                int o2Size = o2.order.size() - 1;
                int o1Size = o1.order.size() - 1;

                return o2.order.get(o2Size) - o1.order.get(o1Size);
            }
            return diff;
        });
    }

    // Time Complexity - O(log N) - pq.add(node) will take O(LogN)

    public void push(int x) {
        counter++;

        if (m.get(x) != null) {
            Node node = m.get(x);
            pq.remove(node);
            node.addOrder(counter);

            m.put(x, node);
            pq.add(node);

        } else {
            Node n = new Node(x, counter);
            m.put(x, n);
            pq.add(n);
        }
    }

    // Time Complexity - O(log N) - pq.add(node) will take O(LogN)
    public int pop() {

        if (!pq.isEmpty()) {

            Node poppedNode = pq.remove();
            poppedNode.removeOrder();
            m.remove(poppedNode.val);

            if (poppedNode.order.size() > 0) {
                pq.add(poppedNode);
                m.put(poppedNode.val, poppedNode);
            }

            return poppedNode.val;
        }

        return -1;

    }

    static class Node {
        int val;
        List<Integer> order;

        public Node(int val, int position) {
            this.val = val;
            order = new LinkedList<>();
            order.add(position);
        }

        private void addOrder(int newPosition) {
            order.add(newPosition);
        }

        private void removeOrder() {

            order.remove(order.size() - 1);
        }
    }

}
