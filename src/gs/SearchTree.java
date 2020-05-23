package gs;

import tree.Node;

import java.util.List;

public class SearchTree {
    Node root;

    private Node put(int data, Node node) {

        if (node == null) {
            return new Node(data);
        } else if (data < node.data) {
            node.left = put(data, node.left);
        } else {
            node.right = put(data, node.right);
        }

        return node;
    }


    public boolean contains(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (node.data == key) {
            return true;
        }

        return contains(node.left, key) || contains(node.right, key);
    }


    private List<Integer> inorder(Node node, List<Integer> list) {

        if (node != null) {
            inorder(node.left, list);
            list.add(node.data);
            inorder(node.right, list);
        }
        return list;
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();

        tree.root = tree.put(3, tree.root);
        tree.put(1, tree.root);
        tree.put(2, tree.root);
        tree.put(5, tree.root);

        System.out.println(tree.contains(tree.root, 2));
        System.out.println(tree.contains(tree.root, 4));
        System.out.println(tree.contains(tree.root, 3));

    }
}
