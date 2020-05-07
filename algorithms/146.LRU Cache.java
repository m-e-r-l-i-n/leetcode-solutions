class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int n;
    public LRUCache(int capacity) {
        cache=new LinkedHashMap<>();
        n=capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) 
        {
            int x=cache.get(key);
            cache.remove(key);
            cache.put(key,x);
            return x;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) cache.remove(key);
        else if(cache.size()==n) 
        {
            int first=cache.keySet().iterator().next();
            cache.remove(first);
        }
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
