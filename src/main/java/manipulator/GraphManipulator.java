package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphManipulator implements Manipulator {

	@Override
	public Graph readGraph(String path) {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			Graph graph = new Graph();

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.trim().split(" ");

				if (values.length > 1) {
					Vertex vertex1 = new Vertex(Integer.valueOf(values[0]));
					Vertex vertex2 = new Vertex(Integer.valueOf(values[1]));

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
		DFSUtil(vertex);

		for (Vertex otherVertices : graph.getNodes()) {
			if (! otherVertices.isVisited()) {
				DFSUtil(otherVertices);
			}
		}

		clearVisitedProperty(graph);
		return "";
	}

	private void DFSUtil(Vertex vertex) {
		vertex.setVisited(true);

		for (Edge edge : vertex.getEdges()) {
			Vertex adjacent = getAdjacent(vertex, edge);
			if (! adjacent.isVisited()) {

				System.out.print(vertex.getValue() + " - " + adjacent.getValue());
				System.out.println();

				DFSUtil(adjacent);
			}
		}
	}

	private Vertex getAdjacent(Vertex vertex, Edge edge) {
		if (edge.getEnd().equals(vertex)) {
			return edge.getStart();
		}

		return edge.getEnd();
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

	private void clearVisitedProperty(Graph graph) {
		for (Vertex vertex : graph.getNodes()) {
			vertex.setVisited(false);
		}
	}

	public static void main(String[] args) {
		GraphManipulator gm = new GraphManipulator();

		Graph graph = new Graph();

		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		graph.connect(v1, v2);
		graph.connect(v1, v3);
		graph.connect(v1, v4);
		graph.connect(v3, v5);

//		graph.connect(v1, v3);
//		graph.connect(v3, v5);
//		graph.connect(v1, v4);
//		graph.connect(v4, v2);

		gm.DFS(graph, v1);
	}
}
