package linkedList;

public class DLLNode {
    public DLLNode next, prev;
    public int data;

    public DLLNode(int data) {
        this.data = data;
    }

    public DLLNode(DLLNode next, DLLNode prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
}
