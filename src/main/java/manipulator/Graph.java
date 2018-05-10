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
		this.addVertex(vertex1);
		this.addVertex(vertex2);

		this.addEdge(vertex1, vertex2);
		this.addEdge(vertex2, vertex1);
	}

	public void connectWeighted(Vertex vertex1, Vertex vertex2, Float weight) {
		this.addVertex(vertex1);
		this.addVertex(vertex2);

		this.addWeightedEdge(vertex1, vertex2, weight);
		this.addWeightedEdge(vertex2, vertex1, weight);
	}

	private void addVertex(Vertex vertex) {
		if (! this.contains(vertex)) {
			this.nodes.add(vertex);
		}
	}

	private void addEdge(Vertex vertex1, Vertex vertex2) {
		Edge edge = new Edge(vertex2);
		this.nodes.get(nodes.indexOf(vertex1)).getEdges().add(edge);
	}

	private void addWeightedEdge(Vertex vertex1, Vertex vertex2, Float weight) {
		Edge edge = new Edge(vertex2, weight);
		this.nodes.get(nodes.indexOf(vertex1)).getEdges().add(edge);
	}
}
