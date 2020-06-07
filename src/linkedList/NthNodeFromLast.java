package linkedList;

public class NthNodeFromLast {

    // length - n + 1 from beginning


    Node head;
    static int i = 0;

    public void insertNode(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }


    public int getLength(Node node) {
        int c = 0;
        while (node != null) {
            node = node.next;
            c++;
        }
        return c;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public int findNthNodeFromLast(Node node, int n) {

        int l = getLength(node);
        int pos = l - n + 1;

        while (pos - 1 > 0) {
            pos--;
            node = node.next;
        }
        return node.data;
    }


    public void findNthNodeFromLastUsingRecursion(Node node, int n) {

        if (node != null) {
            findNthNodeFromLastUsingRecursion(node.next, n);
            i++;
            if (i == n) {
                System.out.println(node.data);
            }
        }
        return;
    }

    public static void main(String[] args) {
        NthNodeFromLast l = new NthNodeFromLast();
        l.insertNode(1);
        l.insertNode(2);
        l.insertNode(3);
        l.insertNode(4);
        l.insertNode(5);

        //System.out.println(l.findNthNodeFromLast(l.head,2));
        l.findNthNodeFromLastUsingRecursion(l.head, 2);
    }
}
