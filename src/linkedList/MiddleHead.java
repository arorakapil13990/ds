package linkedList;

public class MiddleHead {
    Node head;


    public void makeMiddleHead(Node node) {

        Node slowNode = node;
        Node fastNode = node;
        Node prev = node;
        while (fastNode != null && fastNode.next != null) {
            prev = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        // slowNode is the middle node
        prev.next = slowNode.next;
        slowNode.next = head;
        head = slowNode;


    }


    public void addToTail(int data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        MiddleHead d = new MiddleHead();
        d.addToTail(1);
        d.addToTail(2);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(5);
        d.makeMiddleHead(d.head);
        d.print(d.head);

    }

}
