package linkedList;

public class DLLInsertion {

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

    public void insertAtLast(int data){
        DLLNode d = new DLLNode(null, null, data);

        DLLNode current = head;
        while (current.next != null){
            current=current.next;
        }
        current.next=d;
        d.prev=current;
    }

    public void insertAtFirst(int data) {
        DLLNode d = new DLLNode(head, null, data);
        head.prev = d;
        head = d;
    }

    public void printList(DLLNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLLInsertion d = new DLLInsertion();
        d.createList(1);
        d.createList(2);
        d.createList(3);
        d.createList(4);
        d.printList(d.head);
        d.insertAtFirst(0);
        d.printList(d.head);
        d.insertAtLast(5);
        d.printList(d.head);

    }
}
