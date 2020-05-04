package sapient;

import java.util.HashMap;

class Node {
    int value;
    int key;
    Node left;
    Node right;
}

public class LRUCache {

    HashMap<Integer, Node> hashmap;
    Node start, end;
    int LRU_SIZE = 4;

    public LRUCache() {
        hashmap = new HashMap<Integer, Node>();
    }

    public int getEntry(int key) {
        if (hashmap.containsKey(key)) // Key Already Exist, just update the
        {
            Node entry = hashmap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void putEntry(int key, int value) {
        if (hashmap.containsKey(key)) // if key already exist, just update the value and move it to top
        {
            Node entry = hashmap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            Node newNode = new Node();
            newNode.left = null;
            newNode.right = null;
            newNode.value = value;
            newNode.key = key;
            if (hashmap.size() > LRU_SIZE) // We have reached maximum size so need to make room for new element.
            {
                hashmap.remove(end.key);
                removeNode(end);
                addAtTop(newNode);

            } else {
                addAtTop(newNode);
            }

            hashmap.put(key, newNode);
        }
    }

    public void addAtTop(Node node) {
        node.right = start;
        node.left = null;
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    public void removeNode(Node node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache();
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));

    }
}
