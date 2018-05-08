package manipulator;

import java.util.List;

public interface Manipulator {

    void readGraph(String path);

    void readWeightedGraph(String path);

    int getVertexNumber(List<Integer> graph);

    int getEdgeNumber(List<Integer> graph);

    float getMeanEdge(List<Integer> graph);

    String graphRepresentation(List<Integer> graph, String type);

    String BFS(List<Integer> graph, List<Integer> vertex);

    String DFS(List<Integer> graph, List<Integer> vertex);

    String SCC(List<Integer> graph);

    String shortestPath(Integer vertex1, Integer vertex2);

    String MST(List<Integer> graph);
}
