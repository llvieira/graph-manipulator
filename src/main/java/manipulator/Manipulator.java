package manipulator;

public interface Manipulator {

    Graph<Integer> readGraph(String path);

    Graph<String> readWeightedGraph(String path);

    int getVertexNumber(Graph<Integer> graph);

    int getEdgeNumber(Graph<Integer> graph);

    float getMeanEdge(Graph<Integer> graph);

    String graphRepresentation(Graph<Integer> graph, String type);

    String BFS(Graph<Integer> graph, Vertex<Integer> vertex);

    String DFS(Graph<Integer> graph, Vertex<Integer> vertex);

    String shortestPath(Vertex<Integer> vertex1, Vertex<Integer> vertex2);

    String MST(Graph<Integer> graph);

    boolean connected(Graph<Integer> graph);
}
