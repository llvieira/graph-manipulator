package manipulator;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

    private Integer value;
    private Set<Edge> edges;

    public Vertex(Integer value) {
        this.value = value;
        this.edges = new HashSet<>();
    }

    public Vertex(Integer value, Set<Edge> edges) {
        this.value = value;
        this.edges = edges;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (value != null ? !value.equals(vertex.value) : vertex.value != null) return false;
        return edges != null ? edges.equals(vertex.edges) : vertex.edges == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (edges != null ? edges.hashCode() : 0);
        return result;
    }
}
