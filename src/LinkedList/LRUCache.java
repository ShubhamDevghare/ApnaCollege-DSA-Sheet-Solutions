package LinkedList;

import java.util.HashMap;
/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:
---------
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


i.e
To implement an LRU (Least Recently Used) Cache in O(1) time for both get and put, we combine:

HashMap → O(1) access to nodes by key
Doubly Linked List → O(1) insert/remove to track usage order
🔹 Core Idea
------------
The most recently used (MRU) node is placed at the head
The least recently used (LRU) node is placed at the tail
On get → move node to head
On put → insert/update at head
If capacity exceeded → remove tail node
 */
class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail to avoid edge checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
/*
🔹 Core Operations
✅ get(key)
------------
If key not in map → return -1
Move node to front (mark as most recently used)
Return value
Time Complexity → O(1)

✅ put(key, value)
-------------------
==Case 1: Key exists
Update value
Move node to front
==Case 2: Key does not exist
If capacity full:
      Remove node before tail (LRU)
      Remove from map
Insert new node at front
Add to map
Time Complexity → O(1)

🔹 Why Doubly Linked List?

Because we need:
Remove node from middle in O(1)
Add node at head in O(1)
Singly linked list cannot remove a node in O(1) without tracking previous pointer.

🔹 Space Complexity
HashMap → O(capacity)
Doubly Linked List → O(capacity)
Total Space → O(capacity)

🔹 Interview Summary Answer (Short Version)

Use a HashMap for O(1) access and a Doubly Linked List to maintain usage order.
On get and put, move the node to the head.
If capacity is exceeded, remove the tail node (least recently used).
Both operations run in O(1) time.
 */