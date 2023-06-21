package tree;

import java.util.HashMap;

// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class WidthIncludeNull {

    int max_width = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public int getMaxWidth(Node node) {
        getWidth(node, 0, 0);
        return max_width;
    }

    public void getWidth(Node node, int depth, int position) {
        if (node == null) return;
        map.computeIfAbsent(depth, x -> position); // will store only the leftmost position
        max_width = Math.max(max_width, position - map.get(depth) + 1);
        getWidth(node.left, depth + 1, position * 2);
        getWidth(node.right, depth + 1, position * 2 + 1);
    }
}
