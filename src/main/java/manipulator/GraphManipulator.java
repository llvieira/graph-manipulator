package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
		
			Map<Integer, Integer[]> bfsOut = new HashMap<>();
			Queue<Vertex<Integer>> queue = new LinkedList<>();
		
			Integer[] initialLevel = {0, null};
			bfsOut.put(vertex.getValue(), initialLevel);
			queue.add(vertex);
		
			BFS(queue, bfsOut);
			
			stringBfsOut = formatBfsOut(bfsOut);
			
			return stringBfsOut;
		}
		
		return stringBfsOut;
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
	
	private void BFS(Queue<Vertex<Integer>> queue, Map<Integer, Integer[]> bfsOut) {
		if (!queue.isEmpty()) {
			Vertex<Integer> visited = queue.poll();
			Integer levelVisited = bfsOut.get(visited.getValue())[0];
			Integer[] levelNeighbors = {++levelVisited, visited.getValue()};
						
			for (Vertex<Integer> neighbor: visited.neighbors()) {
				if(!bfsOut.containsKey(neighbor.getValue())) {
					bfsOut.put(neighbor.getValue(), levelNeighbors);
					queue.add(neighbor);
				}
			}
			
			BFS(queue, bfsOut);
		}
	}
	
	private String formatBfsOut(Map<Integer, Integer[]> bfsOut) {
		String string = "";
		
		List<Integer> orderedVertex = new ArrayList<>(bfsOut.keySet());
		Collections.sort(orderedVertex);
		
		for (int i = 0; i < orderedVertex.size(); i++) {
			Integer value = orderedVertex.get(i);
			Integer levelVertex = bfsOut.get(value)[0];
			String parentVertex = (bfsOut.get(value)[1] == null) ? 
					"-":String.valueOf(bfsOut.get(value)[1]);
			
			if (i == orderedVertex.size() - 1) {
				string += value + " - " + levelVertex + " "+ parentVertex;
			} else {
				string += value + " - " + levelVertex + " "+ parentVertex + "\n";
			}
		}
		
		return string;
	}
}
