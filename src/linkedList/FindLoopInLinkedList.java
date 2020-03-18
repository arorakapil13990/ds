package linkedList;

public class FindLoopInLinkedList {

    Node head;


    public Node detectLoop(Node node) {
        Node n = node;
        Node m = node;

        while (n != null && m != null && m.next != null) {
            n = n.next;
            m = m.next.next;

            if (n == m) {
                return n;
            }
        }


        return null;
    }


    public Node findStartNodeOfLoop(Node p , Node head){

        Node q = head;
        while(p != q){
            p=p.next;
            q=q.next;
        }
        return p;
    }


    public static void main(String[] args) {
        FindLoopInLinkedList f = new FindLoopInLinkedList();
        Node n = new Node(2);
        f.head = new Node(1);
        f.head.next = new Node(3);
        f.head.next.next = n;
        f.head.next.next.next = new Node(4);
        f.head.next.next.next.next = new Node(5);
        f.head.next.next.next.next.next = new Node(6);
        f.head.next.next.next.next.next.next = new Node(6);
        f.head.next.next.next.next.next.next.next = n;

        Node k = f.detectLoop(f.head);
        if(k == null){
            System.out.println("No loop exist");
        }else {
            System.out.println(k.data);
            System.out.println(f.findStartNodeOfLoop(k,f.head).data);
        }

    }
}
