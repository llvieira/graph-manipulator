package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	
	private T value;
    private List<Edge<T>> edges;

    public Vertex(T value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public Vertex(T value, List<Edge<T>> edges) {
        this.value = value;
        this.edges = edges;
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
}
