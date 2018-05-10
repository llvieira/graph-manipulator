package manipulator;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	private Set<Vertex> nodes;
	
	public Graph() {
		this.nodes = new HashSet<>();
	}
	
//	public Graph(Map<Vertex, Vertex> connections) {
//		this();
//		for(Vertex vertex : connections.keySet())
//			this.includeRelation(vertex, connections.get(vertex));
//	}
//
//	public Map<Vertex, Set<Vertex>> getEdges() {
//		return connections;
//	}
//
//	public void setEdges(Map<Vertex, Set<Vertex>> connections) {
//		this.connections = connections;
//	}
//
//	public void includeRelation(Vertex vertex1, Vertex vertex2) {
//		this.addConnection(vertex1, vertex2);
//		this.addConnection(vertex2, vertex1);
//	}
//
//	public boolean contains(Vertex vertex) {
//		return this.connections.containsKey(vertex);
//	}
//
//	private void addConnection(Vertex vertex1, Vertex vertex2) {
//		if(this.connections.containsKey(vertex1)) {
//			this.connections.get(vertex1).add(vertex2);
//		}else {
//			this.connections.put(vertex1, new HashSet<>());
//			this.connections.get(vertex1).add(vertex2);
//		}
//	}
}
