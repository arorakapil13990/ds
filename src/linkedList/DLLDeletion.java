package linkedList;

public class DLLDeletion {

    DLLNode head;

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
    }


    public void deleteHead() {
        head = head.next;
        head.prev = null;
    }


    public void deleteAtPosition(int pos) {
        if (pos == 1) {
            deleteHead();
            return;
        }
        DLLNode current = head;
        while (pos - 1 > 0 && current.next != null) {
            pos--;
            current = current.next;
        }

        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    public void printList(DLLNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLLDeletion d = new DLLDeletion();
        d.createList(1);
        d.createList(2);
        d.createList(3);
        d.createList(4);
        d.printList(d.head);

        d.deleteAtPosition(4);
        d.printList(d.head);
    }
}
