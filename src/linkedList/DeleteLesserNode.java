package linkedList;

/*
 * 10->20->30->40->50->60->NULL should be changed to 60->NULL
 * The list 60->50->40->30->20->10->NULL should not be changed
 * 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL
 * */

public class DeleteLesserNode {

    Node head;


    void reverseList()
    {
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void delLesserNodes()
    {
        /* 1.Reverse the linked list */
        reverseList(); // 60 50 40 30 20 10

        /* 2) In the reversed list, delete nodes which
           have a node with greater value node on left
           side. Note that head node is never deleted
           because it is the leftmost node.*/

        deleteNew();  // or deleteNew();

        /* 3) Reverse the linked list again to retain
           the original order */
        reverseList();
    }

    void delete()
    {
        Node current = head;

        Node maxnode = head;
        Node temp;

        while (current != null && current.next != null) {
            /* If current is smaller than max, then delete
               current */
            if (current.next.data < maxnode.data) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }

            /* If current is greater than max, then update
               max and move current */
            else {
                current = current.next;
                maxnode = current;
            }
        }
    }


    // https://www.youtube.com/watch?v=RJhZ1Ld-rwA
/*
    12 99 8 39 5

    reverse 5 39 8 99 12
    delete  5 39 99 12   1s delete
    delete  5 39 99      2nd delete
    reverse 99 39 5      ans

    */
    void deleteNew(){

        int max  = head.data;
        Node current = head;

        while(current.next != null){

            if(current.next.data>max){
                max=current.next.data;
                current=current.next;
            }else{
                current.next=current.next.next;
            }

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
        DeleteLesserNode m = new DeleteLesserNode();
        m.head = new Node(12);
        m.head.next = new Node(99);
        m.head.next.next = new Node(8);
        m.head.next.next.next = new Node(39);
        m.head.next.next.next.next = new Node(5);
        //m.head.next.next.next.next.next = new Node(60);

        /*m.head = new Node(200);
        m.head.next = new Node(100);
        m.head.next.next = new Node(300);
        m.head.next.next.next = new Node(150);
        m.head.next.next.next.next = new Node(5);
        m.head.next.next.next.next.next = new Node(500);
        m.head.next.next.next.next.next.next = new Node(80);
        m.head.next.next.next.next.next.next.next = new Node(10);*/

        m.delLesserNodes();
        m.printList(m.head);
    }


}
