package manipulator;

public interface Manipulator {

    Graph readGraph(String path);

    void readWeightedGraph(String path);

    int getVertexNumber(Graph graph);

    int getEdgeNumber(Graph graph);

    float getMeanEdge(Graph graph);

    String graphRepresentation(Graph graph, String type);

    String BFS(Graph graph, Vertex vertex);

    String DFS(Graph graph, Vertex vertex);

    String SCC(Graph graph);

    String shortestPath(Vertex vertex1, Vertex vertex2);

    String MST(Graph graph);
}
