package com.alg.other;

import com.alg.other.struct.Graph;

import java.util.LinkedList;

/**
 * BFS 广度优先搜索 (图的最短路径)
 *
 * @author
 */
public class BreadthFirstSearch {

    private Graph graph;

    /**
     * visited 存储哪个顶点已经访问过  visited[0]=true 顶点0被访问过
     * prev    s->t prev[t]=s 顶点t从s访问过来  如:prev[1]=0; 1顶点 访问路径是从 0顶点访问过来
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[graph.getV()];
        visited[s] = true;

        int[] prev = new int[graph.getV()];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }


        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (queue.size() != 0) {
            Integer w = queue.poll();
            LinkedList<Integer> vertex = graph.getAdj()[w];
            for (int i = 0; i < vertex.size(); i++) {
                Integer v = vertex.get(i);
                if (!visited[v]) {
                    prev[v] = w;
                    if (v == t) {
                        //print all vertex
                        print(s, v, prev);
                        return;
                    }
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }


    private void print(int s, int t, int[] prev) {
        if (prev[t] != -1 && s != t) {
            print(s, prev[t], prev);
        }
        System.out.print(t + " ");
    }


    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.buildGraph(8);
        bfs.bfs(0, 7);
    }

    /**
     * 0───1───2
     * │   │   │
     * 3───4───5
     * *   │   │
     * ****6───7
     *
     * @param vertex
     */
    public void buildGraph(int vertex) {
        graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
    }
}
