Process Used (Plain English)
To solve the Least Recently Used (LRU) Cache problem:

Understanding Requirements: The LRU cache requires the use of a data structure with efficient get and put operations, both running in 
𝑂
(
1
)
O(1) time.
Choosing Data Structures:
Use a HashMap to store key-value pairs for 
𝑂
(
1
)
O(1) access.
Use a Doubly Linked List to maintain the order of usage, where the most recently used item is at the front, and the least recently used is at the back.
Implementation Steps:
Initialize the cache with a given capacity.
For get(key), retrieve the value if the key exists, move the node to the front of the linked list, and return the value.
For put(key, value), add the key-value pair. If the key already exists, update the value and move the node to the front. If the cache is full, evict the least recently used item before adding the new key-value pair.
Edge Cases:
Handle cache capacity of 0.
Handle updates to existing keys.
Handle retrieval of non-existent keys.
Pseudocode
Initialization:

Create a HashMap to store keys and their corresponding nodes.
Create a dummy head and tail for the doubly linked list.
Set the initial cache size to 0.
Get Operation:

Check if the key exists in the HashMap.
If it exists:
Move the corresponding node to the front of the linked list.
Return the value.
If it doesn't exist, return -1.
Put Operation:

Check if the key exists in the HashMap.
If it exists:
Update the value.
Move the corresponding node to the front of the linked list.
If it doesn't exist:
If the cache is at capacity:
Remove the least recently used node (node at the back).
Remove its key from the HashMap.
Add the new key-value pair to the HashMap and the linked list.
Increment the cache size.
Helper Functions:

Add a node to the front of the linked list.
Remove a node from the linked list.
Code Solution (Java)
java
Copy code
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
}
This implementation uses a HashMap for fast lookups and a Doubly Linked List for maintaining order, ensuring both get and put operations run in 
𝑂
(
1
)
O(1) time.






