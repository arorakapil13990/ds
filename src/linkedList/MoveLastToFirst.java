package linkedList;

public class MoveLastToFirst {
    Node head;


    private void moveToFront() {
        Node node = head;
        Node pre = null;
        while(node.next != null){
            pre=node;
            node=node.next;
        }
        pre.next=null;
        node.next=head;
        head=node;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        MoveLastToFirst s = new MoveLastToFirst();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);
        s.moveToFront();
        s.printList(s.head);

    }


}
