package manipulator;

import java.util.List;

public interface Manipulator {

    void readGraph(String path);

    void readWeightedGraph(String path);

    int getVertexNumber(Graph graph);

    int getEdgeNumber(Graph graph);

    float getMeanEdge(Graph graph);

    String graphRepresentation(Graph graph, String type);

    String BFS(Graph graph, List<Integer> vertex);

    String DFS(Graph graph, List<Integer> vertex);

    String SCC(Graph graph);

    String shortestPath(Integer vertex1, Integer vertex2);

    String MST(Graph graph);
}
