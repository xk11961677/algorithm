package com.alg.struct;

import java.util.LinkedList;

/**
 * 图数据结构(使用 [邻接表] 方式存储)
 *
 * @author
 */
public class Graph {

    /**
     * 定点个数vertex
     */
    private int v;


    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边 edge（无向图则需要添加两次）
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getV() {
        return v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }


}
