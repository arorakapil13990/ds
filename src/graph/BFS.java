package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int v;
    private LinkedList<Integer> adj[];


    public BFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void breadthFirstSearch(int s) {

        boolean visited[] = new boolean[v];
        LinkedList<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);
        while (q.size() != 0) {
            int temp = q.poll();

            System.out.print(temp + " ");

            Iterator<Integer> itr = adj[temp].listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }

            }

        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.breadthFirstSearch(2);

    }
}
