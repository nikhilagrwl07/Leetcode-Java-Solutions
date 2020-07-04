package leetcodeProblems.medium;

import java.util.HashMap;

class LRUCacheMainDriver146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4


//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));       // returns 2
//        cache.put(1, 1);
//        cache.put(4, 1);     // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
    }

    static class LRUCache {

        private int capacity;
        private HashMap<Integer, LRUNode> map; // HashMap to support O(1) get.
        private LRUNode anchor; // Root of DLL

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<Integer, LRUNode>();

            this.anchor = new LRUNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
            this.anchor.left = this.anchor;
            this.anchor.right = this.anchor;
        }

        public int get(int key) {
            LRUNode node = this.map.get(key);
            if (node != null) {
                moveToTop(node);
                return node.value;
            } else {
                return -1; // Check the requirement. Normally it returns null.
            }
        }

        public void put(int key, int value) {
            LRUNode node = this.map.get(key);
            if (node != null) {
                moveToTop(node);
                node.value = value;
            } else {
                LRUNode newNode;
                if (this.map.size() >= this.capacity) {
                    // Unlink from ddl and reuse the object.
//                System.out.println(" anchor.left.key :: " + anchor.left.key);
                    newNode = remove(this.anchor.left.key);
                    newNode.key = key;
                    newNode.value = value;
                } else {
                    newNode = new LRUNode(key, value);
                }
                linkAsTop(newNode);
                this.map.put(key, newNode);
            }
        }

        private LRUNode remove(int key) {
// Remove a key/value node from cache.
            LRUNode node = this.map.get(key);
            this.map.remove(key);

// Unlink and remove from dll.
            LRUNode left = node.left;
            LRUNode right = node.right;
            left.right = right;
            right.left = left;
            return node;
        }

        private void linkAsTop(LRUNode node) {
            // Link node to anchor'right in dll.
            LRUNode anchor = this.anchor;
            LRUNode anchor_right = anchor.right;

            node.left = anchor;
            node.right = anchor_right;
            anchor_right.left = node;
            anchor.right = node;
        }

        private void moveToTop(LRUNode node) {
            // Unlink node from its current position.
            LRUNode left = node.left;
            LRUNode right = node.right;
            left.right = right;
            right.left = left;
            linkAsTop(node);
        }

        public String toString() {
            String ret = "";
            LRUNode node;
            for (int key : this.map.keySet()) {
                node = this.map.get(key);
                ret += "<" + key + ", " + node.value + ">\n";
            }
            return ret;
        }

        public void printDLL() {
            LRUNode cursor = this.anchor;
            while (cursor.right != this.anchor) {
                System.out.print(cursor.right + " ");
                cursor = cursor.right;
            }
            System.out.println();
        }

        public void clear() {
            this.map.clear();
            this.anchor.left = this.anchor;
            this.anchor.right = this.anchor;
        }
    }

    static class LRUNode {

        public LRUNode left;
        public LRUNode right;
        public int key;
        public int value;

        public LRUNode(int key, int value) {
            this.left = null;
            this.right = null;
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "<" + this.key + ", " + this.value + ">";
        }
    }
}


