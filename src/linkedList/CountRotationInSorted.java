package linkedList;

public class CountRotationInSorted {
    Node head;

    private void countRotation(Node node) {
        int count = 0;
        int min = node.data;

        while (node != null) {
            if (min > node.data) {
                break;
            }
            count++;
            node = node.next;
        }
        System.out.println(count);
    }

    private void rotation(Node node) {
        int count = 1;
        while (node != null && node.next != null) {
            if (node.data > node.next.data) {
                break;
            } else {
                node = node.next;
                count++;
            }
        }
        System.out.println(count);
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
        CountRotationInSorted d = new CountRotationInSorted();
        d.addToTail(15);
        d.addToTail(18);
        d.addToTail(5);
        d.addToTail(8);
        d.addToTail(11);
        d.addToTail(12);
        d.countRotation(d.head);
        d.rotation(d.head);
        d.count(d.head);
    }

    private void count(Node node) {
        int c = 1;
        while (node != null && node.next != null && node.data < node.next.data) {
            node=node.next;
            c++;
        }
        System.out.println(c);
    }

}
