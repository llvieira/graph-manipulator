package manipulator;

public class Edge {

    private static final Float DEFAULT_WEIGHT = 1f;

    // we already now its start point since each vertex has a list of edges.
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
}
