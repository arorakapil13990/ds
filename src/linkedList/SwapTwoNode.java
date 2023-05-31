package linkedList;

public class SwapTwoNode {

    Node head;


    public void swapNode(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y)
            return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

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
        //s.swapNode(12, 20);
        s.swap(12, 20);
        s.printList(s.head);

    }

    private void swap(int x, int y) {
        if (x == y)
            return;
        Node currX = head, preX = null;
        while (currX != null && currX.data != x) {
            preX = currX;
            currX = currX.next;
        }

        Node currY = head, preY = null;
        while (currY != null && currY.data != y) {
            preY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null)
            return;

        if(preX != null)
            preX.next=currY;
        else
            head=currY;

        if(preY != null)
            preY.next=currX;
        else
            head=currX;

        Node temp = currX.next;
        currX.next=currY.next;
        currY.next = temp;

    }
}
