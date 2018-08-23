class LRUCache {
    HashMap<Integer, DLinkedNode> map;
    DLinkedNode tail;
    DLinkedNode head;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        if(tail == map.get(key)) return tail.val;
        DLinkedNode node = map.get(key);
        node.remove();
        tail.add(node);
        tail = tail.next;
        return tail.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            if(tail == map.get(key)) {
                tail.val = value;
                return;
            }
            map.get(key).remove();
        }
        tail.add(new DLinkedNode(value, key));
        map.put(key, tail.next);
        tail = tail.next;
        if(map.size() > capacity) {
            DLinkedNode tmp = head.next;
            map.remove(tmp.key);
            head.remove();
            head = tmp;
        }
    }
}

class DLinkedNode {
    int key;
    int val;
    DLinkedNode pre;
    DLinkedNode next;
    
    DLinkedNode() {
        pre = null;
        next = null;
    }
    
    DLinkedNode(int val, int key) {
        this.key = key;
        this.val = val;
    }
    
    public void remove() {
        if(pre != null) {
            pre.next = next;
        }
        if(next != null) {
            next.pre = pre;
        }
        pre = null;
        next = null;
    }
    public void add(DLinkedNode node) {
        if(node != null) {
            next = node;
            node.pre = this;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
