package linkedList;

/*
 *  1. Calculate length of both LL
 *  2. Calculate diff of length d =|l1-l2|
 *  3. Move d nodes in longer LL
 *  4. Then move by one step in both LL  till head1 = head2
 * */


public class IntersectionNode {

    Node head1, head2;


    public int getLength(Node node) {

        int l = 0;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }


    public Node findIntersection(Node n, Node m) {

        int l1 = getLength(n);
        int l2 = getLength(m);

        int d = Math.abs(l1 - l2);

        if (l1 > l2) {
            while (d > 0) {
                n = n.next;
                d--;
            }
        } else {
            while (d > 0) {
                m = m.next;
                d--;
            }
        }


        while (n != null || m != null) {

            if (n == m){
                return n;
            }
            n=n.next;
            m=m.next;

        }


        return null;
    }


    public static void main(String[] args) {
        Node n1 = new Node(15);
        Node n2 = new Node(30);
        IntersectionNode l = new IntersectionNode();
        l.head1 = new Node(3);
        l.head1.next = new Node(6);
        l.head1.next.next = new Node(9);
        l.head1.next.next.next = n1;
        l.head1.next.next.next.next = n2;

        l.head2 = new Node(10);
        l.head2.next = n1;
        l.head2.next.next = n2;

        Node n = l.findIntersection(l.head1,l.head2);
        System.out.println(n.data);
    }
}
