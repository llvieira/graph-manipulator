package manipulator;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	
	// Switch to generic type
    private T value;
    private List<Edge> edges;

    public Vertex(T value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    public Vertex(T value, List<Edge> edges) {
        this.value = value;
        this.edges = edges;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
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
