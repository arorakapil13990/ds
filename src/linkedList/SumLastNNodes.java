package linkedList;

public class SumLastNNodes {
    Node head;
    static int n = 2, sum = 0;


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SumLastNNodes s = new SumLastNNodes();
        s.head = new Node(10);
        s.head.next = new Node(15);
        s.head.next.next = new Node(12);
        s.head.next.next.next = new Node(13);
        s.head.next.next.next.next = new Node(20);
        s.head.next.next.next.next.next = new Node(14);
        System.out.println(s.sum(s.head));

    }

    private int sum(Node node) {

        if (node == null) {
            return 0;
        }
        sum(node.next);
        if (n > 0) {
            sum = sum + node.data;
            n--;
        }
        return sum;
    }
}
