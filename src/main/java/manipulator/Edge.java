package manipulator;

public class Edge {

    private static final Float DEFAULT_WEIGHT = 1f;

    // we already now its start point since Vertex has a list the list of edges.
    private Vertex end;
    private Float weight;

    public Edge(Vertex end, Float weight) {
        this.end = end;

        if (weight == null) {
            this.weight = Edge.DEFAULT_WEIGHT;
        } else {
            this.weight = weight;
        }
    }

    public Edge(Vertex end) {
        this(end, null);
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (end != null ? !end.equals(edge.end) : edge.end != null) return false;
        return weight != null ? weight.equals(edge.weight) : edge.weight == null;
    }

    @Override
    public int hashCode() {
        int result = end != null ? end.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "end=" + end +
                ", weight=" + weight +
                '}';
    }
}
