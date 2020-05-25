package gs;


public class DequeueByLinkedList {

    DLLNode head, tail;


    class DLLNode {
        DLLNode next, prev;
        int data;

        public DLLNode(DLLNode next, DLLNode prev, int data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

    public void addFront(int data) {
        DLLNode n = new DLLNode(null, null, data);
        if (head == null) {
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
        }
        head = n;
    }


    public void addRear(int data) {
        DLLNode n = new DLLNode(null, null, data);
        if (head == null) {
            head = n;
        } else {
            DLLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
            n.prev = current;
        }
        tail = n;
    }

    public void deleteFront() {

        if (head != null) {
            DLLNode nextHead = head.next;
            head = null;
            nextHead.prev = null;
            head = nextHead;
        }
    }

    public void deleteRear() {

        if (tail != null) {
            DLLNode nextTail = tail.prev;
            tail = null;
            nextTail.next = null;
            tail = nextTail;
        }
    }


    public void createList(int data) {
        DLLNode n = new DLLNode(null, null, data);

        if (head == null) {
            head = n;
        } else {
            DLLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
            n.prev = current;
        }
        tail = n;
    }


    public void printList() {
        if (head != null) {
            DLLNode current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        DequeueByLinkedList dll = new DequeueByLinkedList();

        dll.createList(30);
        dll.createList(40);
        dll.createList(50);
        dll.createList(60);

        dll.printList();

        dll.addFront(20);
        System.out.println();
        dll.printList();
        dll.addRear(70);
        System.out.println();
        dll.printList();

        dll.deleteFront();
        System.out.println();
        dll.printList();
        dll.deleteRear();
        System.out.println();
        dll.printList();
    }
}
