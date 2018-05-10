package manipulator;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private Integer value;
    private Set<Edge> connections;

    public Node(Integer value) {
        this.value = value;
        this.connections = new HashSet<>();
    }

    public Node(Integer value, Set<Edge> connections) {
        this.value = value;
        this.connections = connections;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Set<Edge> getConnections() {
        return connections;
    }

    public void setConnections(Set<Edge> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (value != null ? !value.equals(node.value) : node.value != null) return false;
        return connections != null ? connections.equals(node.connections) : node.connections == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        return result;
    }
}
