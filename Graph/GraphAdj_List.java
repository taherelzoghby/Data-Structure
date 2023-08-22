package Graph;

import java.util.LinkedList;

public class GraphAdj_List {

    LinkedList<Integer>[] adj;
    private int nVertex;//number of vertex
    private int e;//number of edges

    public GraphAdj_List(int nodes) {
        this.nVertex = nodes;
        this.adj = new LinkedList[nodes];
        this.e = 0;
        for (int i = 0; i < nVertex; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public int n_of_vertex() {
        return this.nVertex;
    }

    public int n_of_edges() {
        return this.e;
    }

    public void vertices() {
        for (int i = 0; i < this.adj.length; i++) {
            System.out.print(adj[i] + " ");
        }
    }

    public void edges() {
    }

    public void getEdge(Vertex u, Vertex v) {

    }

    public void outGoingEdges() {

    }

    public void inComingEdges() {

    }

    public void outDegree(Vertex v) {

    }

    public void inDegree(Vertex v) {

    }

    public void addVertex(int u, int v) {

    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        e++;
    }

    public void deleteVertex(int u, int v) {
    }

    public void deleteEdge(int u, int v) {
        this.adj[u].remove(v);
        this.adj[v].remove(u);
        e--;
    }

//    public void addVertex() {
//        adj[++nVertex] =new LinkedList<>() ;
//    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Adjacency matrix : ").append("\n");
        str.append("Vertex : ").append(n_of_vertex()).append(", Edges : ").append(n_of_edges()).append("\n");
        for (int i = 0; i < this.adj.length; i++) {
            str.append(i).append(" # ");
            for (int j : adj[i]) {
                str.append(j).append(" -> ");
            }
            str.append("\n");
        }
        return str.toString();

    }

}
