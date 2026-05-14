
class LRUCache {
    private int cap;
    Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<Integer, Integer>(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.cap;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
