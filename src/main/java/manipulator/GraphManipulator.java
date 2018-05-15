package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
					Vertex<Integer> vertex1 = new Vertex<>(Integer.valueOf(values[0]));
					Vertex<Integer> vertex2 = new Vertex<>(Integer.valueOf(values[1]));

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
		Set<Edge<Integer>> edgesGraph = new HashSet<>();
		
		for (Vertex<Integer> vertex: graph.getNodes()) {
			edgesGraph.addAll(vertex.getEdges());
		}
		
		return edgesGraph.size();
	}

	@Override
	public float getMeanEdge(Graph<Integer> graph) {
		float sumDegree = 0;
		float meanEdge = 0;
		
		for (Vertex<Integer> vertex: graph.getNodes()) {
			sumDegree += vertex.degree();
		}
		
		if(graph.getNodes().size() > 0) {
			meanEdge = (sumDegree/graph.getNodes().size());
		}
		
		return meanEdge;
	}

	@Override
	public String graphRepresentation(Graph<Integer> graph, String type) {
		return null;
	}

	@Override
	public String BFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		String stringBfsOut = "";
		
		if(graph.getNodes().size() > 0) {
			Map<Integer, Integer[]> bfsOutput = BFS(vertex);
					
			stringBfsOut = formatSearchOutput(bfsOutput);
			
			return stringBfsOut;
		}
		
		return stringBfsOut;
	}

	// Shortest path using BFS, it doesn't work for weighted graph
	@Override
	public String shortestPath(Vertex<Integer> vertex1, Vertex<Integer> vertex2) {
		List<Integer> path = new ArrayList<>();
		path.add(vertex2.getValue());

		Map<Integer, Integer[]> bfsOutput = BFS(vertex1);

		Integer dad = bfsOutput.get(vertex2.getValue())[1];

		while (! dad.equals(vertex1.getValue())) {
			path.add(dad);
			dad = bfsOutput.get(dad)[1];
		}

		path.add(vertex1.getValue());

		String result = "";

		for (int i = path.size() - 1; i >= 0; i--) {
			result += path.get(i) + " ";
		}

		return result;
	}

	@Override
	public String MST(Graph<Integer> graph) {
		return null;
	}

	@Override
	public boolean connected(Graph<Integer> graph) {
		if(graph.getNodes().size() > 0) {
			Vertex<Integer> firstVertex = graph.getNodes().get(0);
			Map<Integer, Integer[]> bfsOut = BFS(firstVertex);
			
			for (Vertex<Integer> vertex: graph.getNodes()) {
				if (!bfsOut.containsKey(vertex.getValue())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public Map<Integer, Integer[]> BFS(Vertex<Integer> vertex) {
		Map<Integer, Integer[]> bfsOutput = new HashMap<>();
		Queue<Vertex<Integer>> queue = new LinkedList<>();
	
		Integer[] initialLevel = {0, null};
		bfsOutput.put(vertex.getValue(), initialLevel);
		queue.add(vertex);
	
		BFS(queue, bfsOutput);
		
		return bfsOutput;
	}
	
	private void BFS(Queue<Vertex<Integer>> queue, Map<Integer, Integer[]> bfsOutput) {
		if (!queue.isEmpty()) {
			Vertex<Integer> visited = queue.poll();
			Integer levelVisited = bfsOutput.get(visited.getValue())[0];
			Integer[] levelNeighbors = {++levelVisited, visited.getValue()};

			for (Vertex<Integer> neighbor: visited.neighbors()) {
				if(!bfsOutput.containsKey(neighbor.getValue())) {
					bfsOutput.put(neighbor.getValue(), levelNeighbors);
					queue.add(neighbor);
				}
			}

			BFS(queue, bfsOutput);
		}
	}

	@Override
	public String DFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		String stringDfsOut = "";

		if (graph.getNodes().size() > 0) {
			Map<Integer, Integer[]> dfsOutput = new HashMap<>();

			Integer[] initialLevel = {0, null};
			dfsOutput.put(vertex.getValue(), initialLevel);

			DFS(vertex, dfsOutput);

			stringDfsOut = formatSearchOutput(dfsOutput);
		}

		return stringDfsOut;
	}

	private void DFS(Vertex<Integer> vertex, Map<Integer, Integer[]> dfsOutput) {
		Integer levelVisited = dfsOutput.get(vertex.getValue())[0];
		Integer[] levelNeighbors = {++levelVisited, vertex.getValue()};

		for (Vertex<Integer> neighbor: vertex.neighbors()) {
			if(! dfsOutput.containsKey(neighbor.getValue())) {
				dfsOutput.put(neighbor.getValue(), levelNeighbors);
				DFS(neighbor, dfsOutput);
			}
		}
	}

	private String formatSearchOutput(Map<Integer, Integer[]> output) {
		String string = "";

		List<Integer> orderedVertex = new ArrayList<>(output.keySet());
		Collections.sort(orderedVertex);

		for (int i = 0; i < orderedVertex.size(); i++) {
			Integer value = orderedVertex.get(i);
			Integer levelVertex = output.get(value)[0];
			String parentVertex = (output.get(value)[1] == null) ?
					"-":String.valueOf(output.get(value)[1]);

			if (i == orderedVertex.size() - 1) {
				string += value + " - " + levelVertex + " "+ parentVertex;
			} else {
				string += value + " - " + levelVertex + " "+ parentVertex + "\n";
			}
		}

		return string;
	}
}
