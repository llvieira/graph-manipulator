package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GraphManipulator implements Manipulator {
	private Map<Integer, Set<Integer>> graph;
	
	public GraphManipulator() {
		this.graph = new HashMap<>();
	}

	@Override
	public void readGraph(String path) {
		try {
			Map<Integer, Integer> connections = this.getValuesFromFile(path);
			
			for(Integer vertex : connections.keySet()) {
				this.includeRelation(vertex, connections.get(vertex));
				this.includeRelation(connections.get(vertex), vertex);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File" + path + " does not exists.");
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

	private Map<Integer, Integer> getValuesFromFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scanner = new Scanner(file);

		Map<Integer, Integer> mapOfConnections = new HashMap<>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] values = line.trim().split(" ");

			if (values.length > 1) {
				mapOfConnections.put(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
			} else {
				mapOfConnections.put(Integer.valueOf(values[0]), null);
			}
		}

		scanner.close();

		return mapOfConnections;
	}
	
	private void includeRelation(Integer vertex1, Integer vertex2) {
		if (vertex1 == null || vertex2 == null)
			return;
		
		if(this.graph.containsKey(vertex1)) {
			this.graph.get(vertex1).add(vertex2);
		}else {
			this.graph.put(vertex1, new HashSet<>());
			this.graph.get(vertex1).add(vertex2);
		}
	}
}
