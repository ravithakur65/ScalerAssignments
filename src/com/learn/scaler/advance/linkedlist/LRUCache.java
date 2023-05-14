import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
Expected Output
Enter your input as per the following guideline:
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with. 
Then numOperation operations follow. 
Each operation is either : 
 * G  : This corresponds to a function call get()
 * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.  
 */

public class LRUCache {
    
    
     // Define the Node class for the doubly linked list.
     private class Node {
        int key, value;
        Node next, prev;

        // Constructor for creating a new Node object.
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    Node head; // head Node
    Node tail; // tail Node
    int cap; // maximum capacity of the cache
    HashMap<Integer, Node> hm; // HashMap to store key-value pairs

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(5, 12);
        System.out.println(cache.get(5)); // returns 12
        System.out.println(cache.get(1)); // returns 10
        System.out.println(cache.get(10)); // returns -1
        cache.set(6, 14); // this pushes out key = 5 as LRU is full.
        System.out.println(cache.get(5)); // returns -1
    }
    // Constructor for creating a new LRU cache with a given capacity.
    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = new Node(-1, -1); // initialize head node
        tail = new Node(-1, -1); // initialize tail node
        head.next = tail; // link head to tail
        tail.prev = head; // link tail to head
        cap = capacity; // set maximum capacity
    }

    // Method to get the value associated with a key from the cache.
    public int get(int key) {
        if (hm.containsKey(key)) { // if key exists in HashMap
            Node temp = hm.get(key); // get corresponding Node object
            delete(temp); // remove Node from current position in list
            insert(temp); // insert Node at head of list (most recently used)
            return temp.value; // return value associated with key
        }
        return -1; // return -1 if key not found
    }

    // Method to set the value associated with a key in the cache.
    public void set(int key, int value) {
        Node cur = new Node(key, value); // create new Node object with key-value pair
        if (hm.containsKey(key)) { // if key already exists in HashMap
            Node temp = hm.get(key); // get corresponding Node object
            delete(temp); // remove Node from current position in list
            insert(cur); // insert new Node at head of list (most recently used)
        } else { // if key does not exist in HashMap
            if (hm.size() == cap) { // if cache is at maximum capacity
                delete(tail.prev); // remove least recently used Node from list (tail.prev)
            }
            insert(cur); // insert new Node at head of list (most recently used)
        }
    }

    // Helper method to remove a Node from its current position in the list.
    private void delete(Node temp) {
        Node l = temp.prev;
        Node r = temp.next;
        l.next = r;
        r.prev = l;
        temp.next = null;
        temp.prev = null;
        hm.remove(temp.key); // remove key-value pair from HashMap
    }

    // Helper method to insert a Node at the head of the list (most recently used).
    private void insert(Node temp) {
        Node cur = head.next;
        temp.next = cur;
        temp.prev = head;
        head.next = temp;
        cur.prev = temp;
        hm.put(temp.key, temp); // add key-value pair to HashMap
    }
}
