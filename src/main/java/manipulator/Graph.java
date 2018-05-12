package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Vertex> nodes;

	public Graph() {
		this.nodes = new ArrayList<>();
	}

	public List<Vertex> getNodes() {
		return nodes;
	}

	public void setNodes(List<Vertex> nodes) {
		this.nodes = nodes;
	}

	public boolean contains(Vertex vertex) {
		return this.nodes.contains(vertex);
	}

	public void connect(Vertex vertex1, Vertex vertex2) {
		Edge edge = new Edge(vertex2, vertex1);
		
		vertex1.getEdges().add(edge);
		vertex2.getEdges().add(edge);
		
		this.addVertex(vertex1);
		this.addVertex(vertex2);
	}

	public void connect(Vertex vertex1, Vertex vertex2, Float weight) {
		Edge edge = new Edge(vertex2, vertex1, weight);
			
		vertex1.getEdges().add(edge);
		vertex2.getEdges().add(edge);
		
		this.addVertex(vertex1);
		this.addVertex(vertex2);
	}

	private void addVertex(Vertex vertex) {
		if (! this.contains(vertex)) {
			this.nodes.add(vertex);
		}
	}
}
