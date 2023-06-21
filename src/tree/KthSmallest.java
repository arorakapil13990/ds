package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class KthSmallest {
    public int kthSmallest(Node root, int k) {

        List<Integer> allList = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            Node node = list.remove(0);
            allList.add(node.data);
            if(node.left != null) {
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
        }
        Collections.sort(allList);
        if(k> allList.size()){
            return 0;
        }
        System.out.print(allList);
        return allList.get(k-1);

    }

    public int kth(Node root, int k) {
        int p =k;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        //st.push(root);
        List<Integer> lt = new ArrayList<>();
        while(!st.empty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                curr = st.pop();
                k--;
                lt.add(curr.data);
                if(k == 0){
                    break;
                }
                curr =curr.right;

            }
        }
        return lt.get(p-1);
    }
}
