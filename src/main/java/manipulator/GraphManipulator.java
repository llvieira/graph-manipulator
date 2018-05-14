package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphManipulator implements Manipulator {

	@Override
	public Graph<Integer> readGraph(String path) {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			Graph<Integer> graph = new Graph<Integer>();

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.trim().split(" ");

				if (values.length > 1) {
					Vertex<Integer> vertex1 = new Vertex<Integer>(Integer.valueOf(values[0]));
					Vertex<Integer> vertex2 = new Vertex<Integer>(Integer.valueOf(values[1]));

					graph.connect(vertex1, vertex2);
				}
			}

			scanner.close();

			return graph;
		} catch (FileNotFoundException e) {
			System.out.println("File" + path + " does not exists.");
			return null;
		}
	}

	@Override
	public void readWeightedGraph(String path) {

	}

	@Override
	public int getVertexNumber(Graph<Integer> graph) {
		return graph.numberVertex();
	}

	@Override
	public int getEdgeNumber(Graph<Integer> graph) {
		return 0;
	}

	@Override
	public float getMeanEdge(Graph<Integer> graph) {
		return 0;
	}

	@Override
	public String graphRepresentation(Graph<Integer> graph, String type) {
		return null;
	}

	@Override
	public String BFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		return null;
	}

	@Override
	public String DFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		return null;
	}

	@Override
	public String SCC(Graph<Integer> graph) {
		return null;
	}

	@Override
	public String shortestPath(Vertex<Integer> vertex1, Vertex<Integer> vertex2) {
		return null;
	}

	@Override
	public String MST(Graph<Integer> graph) {
		return null;
	}
}
