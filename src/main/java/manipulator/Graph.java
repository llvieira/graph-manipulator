package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

	private List<Vertex<T>> nodes;
	private Boolean weight;
	
	
	public Boolean getWeight() {
		return weight;
	}

	public void setWeight(Boolean weight) {
		this.weight = weight;
	}

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

	public boolean connect(Vertex<T> vertex1, Vertex<T> vertex2) {
		int indexVertex1 = this.nodes.indexOf(vertex1);
		int indexVertex2 = this.nodes.indexOf(vertex2);
		
		if (indexVertex1 != -1 && indexVertex2 != -1) {
			Vertex<T> vertexOne = this.nodes.get(indexVertex1);
			Vertex<T> vertexTwo = this.nodes.get(indexVertex2);
			
			Edge<T> edge = new Edge<T>(vertex2, vertex1);
			
			vertexOne.getEdges().add(edge);
			vertexTwo.getEdges().add(edge);
			
			return true;
		}
				
		return false;
	}

	public boolean connect(Vertex<T> vertex1, Vertex<T> vertex2, Float weight) {
		int indexVertex1 = this.nodes.indexOf(vertex1);
		int indexVertex2 = this.nodes.indexOf(vertex2);
		
		if (indexVertex1 != -1 && indexVertex2 != -1) {
			Vertex<T> vertexOne = this.nodes.get(indexVertex1);
			Vertex<T> vertexTwo = this.nodes.get(indexVertex2);
			
			Edge<T> edge = new Edge<T>(vertex2, vertex1, weight);
			
			vertexOne.getEdges().add(edge);
			vertexTwo.getEdges().add(edge);
			
			return true;
		}
		
		return false;
	}
	
	public boolean addVertex(Vertex<T> vertex) {
		if (! this.contains(vertex)) {
			this.nodes.add(vertex);
			return true;
		}
		
		return false;
	}
	
	public int numberVertex() {
		return this.nodes.size();
	}
}