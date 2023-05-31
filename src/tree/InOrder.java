package tree;

import java.util.Stack;
// https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
public class InOrder {
    Node root;

    public static void inorderIterative(Node root) {
        // create an empty stack
        Stack<Node> stack = new Stack();

        // start from root node (set current node to root node)
        Node curr = root;

        // if current node is null and stack is also empty, we're done
        while (!stack.empty() || curr != null) {
            // if current node is not null, push it to the stack (defer it)
            // and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // else if current node is null, we pop an element from stack,
                // print it and finally set current node to its right child
                curr = stack.pop();
                System.out.print(curr.data + " ");

                curr = curr.right;
            }
        }
    }

        public static void main (String[]args){
            InOrder p = new InOrder();
            p.root = new Node(1);
            p.root.left = new Node(2);
            p.root.right = new Node(3);
            p.root.left.left = new Node(4);
            p.root.left.right = new Node(5);
            p.root.right.left = new Node(6);
            p.root.right.right = new Node(7);
            inorderIterative(p.root);
        }
    }
