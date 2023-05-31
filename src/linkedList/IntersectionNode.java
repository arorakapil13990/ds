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
        Node n1 = new Node(40);
        Node n2 = new Node(50);
        IntersectionNode l = new IntersectionNode();
        l.head1 = new Node(10);
        l.head1.next = new Node(20);
        l.head1.next.next = new Node(30);
        l.head1.next.next.next = n1;
        l.head1.next.next.next.next = n2;

        l.head2 = new Node(60);
        l.head2.next = n1;
        l.head2.next.next = n2;

        Node n = l.intersectPoint(l.head1,l.head2);
        if(n != null) {
            System.out.println(n.data);
        }else {
            System.out.println(n);
        }
    }

    static Node intersectPoint(Node head1, Node head2)
    {
        // Maintaining two pointers ptr1 and ptr2
        // at the head of A and B,
        Node ptr1 = head1;
        Node ptr2 = head2;

        // If any one of head is null i.e
        // no Intersection Point
        if (ptr1 == null || ptr2 == null) {
            return null;
        }

        // Traverse through the lists until they
        // reach Intersection node
        while (ptr1 != ptr2) {

            // If at any node ptr1 meets ptr2, then it is
            // intersection node.Return intersection node.

            if (ptr1 == ptr2) {
                return ptr1;
            }
        /* Once both of them go through reassigning,
        they will be equidistant from the collision point.*/

            // When ptr1 reaches the end of a list, then
            // reassign it to the head2.
            if (ptr1 == null) {
                ptr1 = head2;
            }else {
                ptr1 = ptr1.next;
            }
            // When ptr2 reaches the end of a list, then
            // redirect it to the head1.
            if (ptr2 == null) {
                ptr2 = head1;
            }else {
                ptr2 = ptr2.next;
            }
        }

        return ptr1;
    }
}
