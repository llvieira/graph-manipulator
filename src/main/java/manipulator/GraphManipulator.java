package manipulator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GraphManipulator implements Manipulator {
	private Graph graph;
	
	public GraphManipulator() {
		this.graph = new Graph();
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	@Override
	public void readGraph(String path) {
			Util util = new Util();
			Scanner scanner = util.getValuesFromFile(path);
			Graph graph = new Graph();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
				graph.connect(line);
		}
		this.graph = graph;

	}

	@Override
	public void readWeightedGraph(String path) {
		Util util = new Util();
		Scanner scanner = util.getValuesFromFile(path);
		Graph graph = new Graph();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			graph.connectWeighted(line);
		}

		this.graph = graph;

	}

	@Override
	public String shortestPath(Integer vertex1, Integer vertex2) {
		return null;
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
	public String BFS(Graph graph, List<Integer> vertex) {
		return null;
	}

	@Override
	public String DFS(Graph graph, List<Integer> vertex) {
		return null;
	}

	@Override
	public String SCC(Graph graph) {
		return null;
	}

	@Override
	public String MST(Graph graph) {
		return null;
	}
}
