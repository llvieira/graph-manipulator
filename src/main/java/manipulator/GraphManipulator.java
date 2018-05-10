package manipulator;

import java.io.FileNotFoundException;

public class GraphManipulator implements Manipulator {

	@Override
	public Graph readGraph(String path) {
		try {
			return new Graph(Util.getValuesFromFile(path));
			
		} catch (FileNotFoundException e) {
			System.out.println("File" + path + " does not exists.");
			return null;
		}
	}

	@Override
	public void readWeightedGraph(String path) {

	}

	@Override
	public int getVertexNumber(Graph graph) {
		return 0;
	}

	@Override
	public int getEdgeNumber(Graph graph) {
		return 0;
	}

	@Override
	public float getMeanEdge(Graph graph) {
		return 0;
	}

	@Override
	public String graphRepresentation(Graph graph, String type) {
		return null;
	}

	@Override
	public String BFS(Graph graph, Vertex vertex) {
		return null;
	}

	@Override
	public String DFS(Graph graph, Vertex vertex) {
		return null;
	}

	@Override
	public String SCC(Graph graph) {
		return null;
	}

	@Override
	public String shortestPath(Vertex vertex1, Vertex vertex2) {
		return null;
	}

	@Override
	public String MST(Graph graph) {
		return null;
	}
}
