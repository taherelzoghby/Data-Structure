package Graph;

public class Graph {

    private int e;//numbers of edges
    private Vertex[] vertList;
    private Edge edge;
    private int[][] adjMatrix;
    private int MaxNodes = 10;//max numbers of vertex
    private int nVert;//numbers of vertex

    public Graph() {
        this.adjMatrix = new int[MaxNodes][MaxNodes];
        this.vertList = new Vertex[MaxNodes];
        for (int i = 0; i < MaxNodes; i++) {
            for (int j = 0; j < MaxNodes; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
        this.e = 0;
        this.nVert = 0;
    }

    public void addVertex(char ch) {
        vertList[++nVert] = new Vertex(ch);
    }
    public int outDegree(int v){
        int n=0;
        for(int i=0;i<this.adjMatrix.length;i++){
            if(this.adjMatrix[v][i]==1){
                n++;
            }
        }
        return n;
    }
    public int inDegree(int v){
        int n=0;
        for(int i=0;i<this.adjMatrix[v].length;i++){
            if(this.adjMatrix[i][v]==1){
                n++;
            }
        }
        return n;
    }
    public void outGoingEdges(int v){
        for(int i=0;i<this.adjMatrix[v].length;i++){
            if(this.adjMatrix[v][i]==1){
                System.out.println(v+"---"+i);
            }
        }
    }

    public void inComingEdges(int v){
        for(int i=0;i<this.adjMatrix.length;i++){
            if(this.adjMatrix[i][v]==1){
                System.out.println(i+"---"+v);
            }
        }
    }
    public void addEdge(int i, int j) {
        this.adjMatrix[i][j] = 1;
        //this.adjMatrix[j][i] = 1;//because it is undirect graph 
        e++;
    }

    public void removeEdge(int i, int j) {
        this.adjMatrix[i][j] = 0;
        this.adjMatrix[j][i] = 0;//because it is undirect graph 
        e--;
    }

    public int maxOfVertex() {
        return this.MaxNodes;
    }

    public int numVertices() {
        return this.nVert;
    }

    public int numEdges() {
        return this.e;
    }

    public void getEdge(int u, int v) {
        if (this.adjMatrix[u][v] == 1 && this.adjMatrix[v][u] == 1) {
            System.out.println(u + "<-------->" + v);
        } else if (this.adjMatrix[u][v] == 1) {
            System.out.println(u + "-------->" + v);
        } else {
            System.out.println("not exist...!");
        }
    }

    public int[] endVertices(Edge e) {
        int[] arr = new int[2];
        if (this.adjMatrix[e.in][e.out] == 1 && this.adjMatrix[e.out][e.in] == 1) {
            arr[0] = e.in;
            arr[1] = e.out;
        }
        return arr;
    }
//    public void vertex(){
//        for(int i=0;i<vertList.length;i++){
//            System.out.print(vertList[i].label+" ");
//        }
//    }

    public void displayVertex(int v) {
        System.out.println(v + " : " + vertList[v].label);
    }

    public void display() {
        int j = 0;
        System.out.println("Adjacency matrix : ");
        for (int i = 0; i < adjMatrix.length; i++) {
            //System.out.print(i+" : ");
            for (j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Adjacency matrix : ").append("\n");
        str.append("Vertex : ").append(numVertices()).append(", Edges : ").append(numEdges()).append("\n");
        for (int i = 0; i < MaxNodes; i++) {
            str.append(i).append(" : ");
            for (int j : adjMatrix[i]) {
                str.append(j).append(" ");
            }
            str.append("\n");
        }
        return str.toString();

    }

}
