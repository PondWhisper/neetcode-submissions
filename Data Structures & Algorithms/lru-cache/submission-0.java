
class LRUCache {
    private Map<Integer, Node> map;
    private int cap;
    private Node left;
    private Node right;


    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        map = new HashMap<>();
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node) {
        node.prev = right.prev;
        node.next = right;
        right.prev.next = node;
        right.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node res = map.get(key);
            remove(res);
            insert(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node curr = new Node(key, value);
        map.put(key, curr);
        insert(curr);

        if (map.size() > cap) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }


    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
