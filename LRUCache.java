import java.util.*;

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        // Instantiate the LRUCache with a capacity of 2
        LRUCache cache = new LRUCache(2);
    
        // Perform operations and print the results
        System.out.println("null");  // LRUCache instantiation (no output expected)
        cache.put(1, 1);             // Cache is {1=1}
        System.out.println("null");  // put(1, 1)
        cache.put(2, 2);             // Cache is {1=1, 2=2}
        System.out.println("null");  // put(2, 2)
        System.out.println(cache.get(1)); // Returns 1, Cache is {2=2, 1=1}
        cache.put(3, 3);             // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println("null");  // put(3, 3)
        System.out.println(cache.get(2)); // Returns -1 (not found)
        cache.put(4, 4);             // Evicts key 1, Cache is {3=3, 4=4}
        System.out.println("null");  // put(4, 4)
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3, Cache is {4=4, 3=3}
        System.out.println(cache.get(4)); // Returns 4, Cache is {3=3, 4=4}
    }
}
