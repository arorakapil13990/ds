package linkedList;

public class SwapTwoNode {

    Node head;


    public void swapNode(int x, int y) {
        Node node = head;

        Node preX = null;
        Node preY = null;
        Node nextX = null;
        Node nextY = null;

        boolean isXFound = false;
        boolean isYFound = false;
        while (node.next != null) {

            if (!isXFound && node.data == x) {
                isXFound = true;
                nextX=node.next;
            }

            if (!isYFound && node.data == y) {
                isYFound = true;
                nextY=node.next;
            }
            if (!isXFound)
                preX = node;
            if (!isYFound)
                preY = node;
            node = node.next;
        }

        if (!isXFound) {
            if (node.data == x) {
                isXFound = true;
            }
        }

        if (!isYFound) {
            if (node.data == y) {
                isYFound = true;
            }
        }
        node = head;


       /* if(preX != null && preY != null){

            Node temp = preX.next;
            preX.next = preY.next;
            preY.next = temp;
            temp = preX.next.next;
            preX.next.next = preY.next.next;
            preY.next.next = temp;
        }*/

       if(preX!=null && preY != null){
           Node temp = preX.next;

           preX.next=preY.next;
           preY.next=temp;
           preX.next.next=nextX;
           preY.next.next=nextY;

       }

    }


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        SwapTwoNode s = new SwapTwoNode();
        s.head = new Node(10);
        s.head.next = new Node(15);
        s.head.next.next = new Node(12);
        s.head.next.next.next = new Node(13);
        s.head.next.next.next.next = new Node(20);
        s.head.next.next.next.next.next = new Node(14);
        s.swapNode(12, 20);
        s.printList(s.head);

    }
}
