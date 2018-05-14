package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

	private List<Vertex<T>> nodes;

	public Graph() {
		this.nodes = new ArrayList<>();
	}

	public List<Vertex<T>> getNodes() {
		return nodes;
	}

	public void setNodes(List<Vertex<T>> nodes) {
		this.nodes = nodes;
	}

	public boolean contains(Vertex<T> vertex) {
		return this.nodes.contains(vertex);
	}

	public void connect(Vertex<T> vertex1, Vertex<T> vertex2) {
		Edge<T> edge = new Edge<T>(vertex2, vertex1);
		
		vertex1.getEdges().add(edge);
		vertex2.getEdges().add(edge);
		
		this.addVertex(vertex1);
		this.addVertex(vertex2);
	}

	public void connect(Vertex<T> vertex1, Vertex<T> vertex2, Float weight) {
		Edge<T> edge = new Edge<T>(vertex2, vertex1, weight);
			
		vertex1.getEdges().add(edge);
		vertex2.getEdges().add(edge);
		
		this.addVertex(vertex1);
		this.addVertex(vertex2);
	}
	
	
	public int numberVertex() {
		return this.nodes.size();
	}

	private void addVertex(Vertex<T> vertex) {
		if (! this.contains(vertex)) {
			this.nodes.add(vertex);
		}
	}
}