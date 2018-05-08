package manipulator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphManipulator implements Manipulator {
	private Map<Integer, Set<Integer>> graph;
	
	public GraphManipulator() {
		this.graph = new HashMap<>();
	}

	public Map<Integer, Set<Integer>> getGraph() {
		return graph;
	}

	public void setGraph(Map<Integer, Set<Integer>> graph) {
		this.graph = graph;
	}

	@Override
	public void readGraph(String path) {
		try {
			Map<Integer, Integer> connections = Util.getValuesFromFile(path);
			
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
	
	private void includeRelation(Integer vertex1, Integer vertex2) {		
		if(this.graph.containsKey(vertex1)) {
			this.graph.get(vertex1).add(vertex2);
		}else {
			this.graph.put(vertex1, new HashSet<>());
			this.graph.get(vertex1).add(vertex2);
		}
	}

	@Override
	public String shortestPath(Integer vertex1, Integer vertex2) {
		return null;
	}

	@Override
	public int getVertexNumber(List<Integer> graph) {
		return 0;
	}

	@Override
	public int getEdgeNumber(List<Integer> graph) {
		return 0;
	}

	@Override
	public float getMeanEdge(List<Integer> graph) {
		return 0;
	}

	@Override
	public String graphRepresentation(List<Integer> graph, String type) {
		return null;
	}

	@Override
	public String BFS(List<Integer> graph, List<Integer> vertex) {
		return null;
	}

	@Override
	public String DFS(List<Integer> graph, List<Integer> vertex) {
		return null;
	}

	@Override
	public String SCC(List<Integer> graph) {
		return null;
	}

	@Override
	public String MST(List<Integer> graph) {
		return null;
	}
}
