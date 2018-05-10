package manipulator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

public class Graph {
	private Map<Integer, Set<Edge>> connections;
	
	public Graph() {
		this.connections = new HashMap<>();
	}
	
	/*
	public Graph(Map<Integer, Integer> connections) {
		this();
		for(Integer vertex : connections.keySet())

			this.includeRelation(vertex, connections.get(vertex));
	}
	*/
	
	public Map<Integer, Set<Edge>> getConnections() {
		return connections;
	}

	public void setConnections(Map<Integer, Set<Edge>> connections) {
		this.connections = connections;
	}

	/*
	public void includeRelation(Integer vertex1, Integer vertex2) {
		this.addConnection(vertex1, vertex2);
		this.addConnection(vertex2, vertex1);
	}
	*/
	
	public boolean contains(Integer vertex) {
		return this.connections.containsKey(vertex);
	}
	
	/*
	private void addConnection(Integer vertex1, Integer vertex2) {
		if(this.connections.containsKey(vertex1)) {
			this.connections.get(vertex1).add(vertex2);
		}else {
			this.connections.put(vertex1, new HashSet<>());
			this.connections.get(vertex1).add(vertex2);
		}
	}
	*/

	private void chekConnect(int node1, int node2, Double weight){
		if(!this.connections.containsKey(node1)){
			this.connections.put(node1,new HashSet<>());
		}
		if(!this.connections.containsKey(node2)){
			this.connections.put(node2,new HashSet<>());
		}

		Edge edge = new Edge(node1,node2,weight);
		this.connections.get(node1).add(edge);
		this.connections.get(node2).add(edge);
	}

	public void connect(String pair) {
		String[] nodes = pair.split(" ");
		int node1 = Integer.parseInt(nodes[0]);
		int node2 = Integer.parseInt(nodes[1]);

		chekConnect(node1, node2, 1.0);
	}

	public void connectWeighted(String triple) {
		String[] nodes = triple.split(" ");
		int node1 = Integer.parseInt(nodes[0]);
		int node2 = Integer.parseInt(nodes[1]);
		double weight = Double.parseDouble(nodes[2]);

		chekConnect(node1, node2, weight );
	}

	public static class Edge implements Comparable<Edge> {

		public double getWeight() {
			return weight;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		private double weight;
		private int start, end;

		Edge(int start, int end) {
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			this.start = start;
			this.end = end;
		}

		Edge(int start, int end, Double weight) {
			this(start, end);
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			return Objects.hash(weight, start, end);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Edge edge = (Edge) o;
			return weight == edge.weight &&
					start == edge.start &&
					end == edge.end;
		}

		@Override
		public int compareTo(Edge edge) {
			return Double.compare(this.weight, edge.getWeight());
		}
	}
}



