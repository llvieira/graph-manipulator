package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T value;
    private List<Edge<T>> edges;
    private Boolean coveraged;

    public Vertex(T value) {
        this.value = value;
        this.edges = new ArrayList<>();
        this.setCoveraged(false);
    }

    public Vertex(T value, List<Edge<T>> edges) {
        this.value = value;
        this.edges = edges;
        this.setCoveraged(false);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }
    
    public int degree() {
    	return this.edges.size();
    }
    
    public List<Vertex<T>> neighbors() {
    	List<Vertex<T>> neighbors = new ArrayList<>();
    	
    	for (Edge<T> edge: this.edges) {
    		if (this.equals(edge.getStart())) {
    			neighbors.add(edge.getEnd());
    		} else {
    			neighbors.add(edge.getStart());
    		}
    	}
    	
    	return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return value != null ? value.equals(vertex.value) : vertex.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

	public Boolean getCoveraged() {
		return coveraged;
	}

	public void setCoveraged(Boolean coveraged) {
		this.coveraged = coveraged;
	}
}