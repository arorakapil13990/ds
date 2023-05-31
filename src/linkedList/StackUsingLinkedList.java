package linkedList;

public class StackUsingLinkedList {
    Node head;

    public void push(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return;
        }

        n.next = head;
        head = n;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        Node n = head;
        head = head.next;
        return n.data;
    }

    public Integer peek() {
        return head.data;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("--------");
    }


    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);

        s.display();
        s.push(4);
        s.display();
        s.pop();
        s.display();
        s.peek();
        s.display();

    }
}
