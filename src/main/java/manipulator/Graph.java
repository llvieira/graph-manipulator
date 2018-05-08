package manipulator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private Map<Integer, Set<Integer>> connections;
	
	public Graph() {
		this.connections = new HashMap<>();
	}
	
	public Graph(Map<Integer, Integer> connections) {
		this();
		for(Integer vertex : connections.keySet())
			this.includeRelation(vertex, connections.get(vertex));
	}
	
	public Map<Integer, Set<Integer>> getConnections() {
		return connections;
	}

	public void setConnections(Map<Integer, Set<Integer>> connections) {
		this.connections = connections;
	}

	public void includeRelation(Integer vertex1, Integer vertex2) {
		this.addConnection(vertex1, vertex2);
		this.addConnection(vertex2, vertex1);
	}
	
	public boolean contains(Integer vertex) {
		return this.connections.containsKey(vertex);
	}
	
	private void addConnection(Integer vertex1, Integer vertex2) {		
		if(this.connections.containsKey(vertex1)) {
			this.connections.get(vertex1).add(vertex2);
		}else {
			this.connections.put(vertex1, new HashSet<>());
			this.connections.get(vertex1).add(vertex2);
		}
	}
}
