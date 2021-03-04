package linkedList;

public class DeleteEveryKthNode {
    Node head;

    static Node freeList(Node node) {
        while (node != null) {
            Node next = node.next;
            node = next;
        }
        return node;
    }

    private void delete(Node node, int k) {

        int count = 1;
        Node prev = null;

        if (k == 1) {
            head = null;  // freeList(head);
            return;
        }
        while (node != null) {
            if (count == k) {
                prev.next = node.next;
                count = 0;
                //node = node.next; // prev.next
            }
            count++;
            prev = node;
            node = node.next;

        }

    }


    private void deleteNode(Node node, int k) {
        int count = 1;
        Node pre = null;

        while (node != null) {
            if (count == k) {
                pre.next = node.next;
                count = 0;
            }
            pre = node;
            node = node.next;
            count++;
        }

    }

    public void deleteEveryKthNode(Node node, int k) {

        int count = 1;
        Node pre = null;
        while (node != null) {

            if (count == k) {
                pre.next = node.next;
                node = node.next;
                count = 0;
            } else {
                pre = node;
                node = node.next;

            }
            count++;

        }

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
        DeleteEveryKthNode d = new DeleteEveryKthNode();
        d.addToTail(1);
        d.addToTail(2);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(5);
        d.addToTail(6);
        d.addToTail(7);
        d.addToTail(8);
        d.deleteNew(d.head, 5);
        d.print(d.head);
    }

    private void deleteNew(Node node, int k) {
        int c = 1;
        Node prev = node;
        while (node != null) {
            if (c < k) {
                prev = node;
                node = node.next;
                c++;
            } else {
                prev.next = node.next;
                node = node.next;
                c = 1;
            }
        }
    }

}
