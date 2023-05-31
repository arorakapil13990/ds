package linkedList;

public class SortedIntersect {

    Node head, head1;


    private Node findSortedIntersect(Node n, Node m) {
        Node res = null;
        Node head_new = null;

        while (n != null && m != null) {
            if (n.data == m.data) {
                if (res == null) {
                    res = new Node(n.data);
                    head_new=res;
                } else {
                    res.next = new Node(n.data);
                    res=res.next;
                }
            }
            if (n.data < m.data) {
                n = n.next;
            } else if(m.data < n.data){
                m = m.next;
            }else {
                n = n.next;
                m = m.next;
            }
        }

        return head_new;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SortedIntersect s = new SortedIntersect();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);


        s.head1 = new Node(2);
        s.head1.next = new Node(4);
        s.head1.next.next = new Node(6);
        s.head1.next.next.next = new Node(8);
        Node n = s.findSortedIntersect(s.head, s.head1);
        s.printList(n);

    }


}
