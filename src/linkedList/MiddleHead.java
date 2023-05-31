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
        d.middle(d.head);
        d.print(d.head);
    }

    private void middle(Node node) {
        Node slow = node, fast = node, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = slow.next;
        slow.next = head;
        head = slow;

    }
}
