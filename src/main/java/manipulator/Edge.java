package manipulator;

public class Edge<T> {

    private static final Float DEFAULT_WEIGHT = 1f;

    private Vertex<T> start;
    private Vertex<T> end;
    private Float weight;

    public Edge(Vertex<T> end, Vertex<T> start, Float weight) {
        this.end = end;
        this.start = start;

        if (weight == null) {
            this.weight = Edge.DEFAULT_WEIGHT;
        } else {
            this.weight = weight;
        }
    }

    public Edge(Vertex<T> end, Vertex<T> start) {
        this(end, start, null);
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public void setEnd(Vertex<T> end) {
        this.end = end;
    }
    
    public Vertex<T> getStart() {
        return start;
    }
    
    public void setStart(Vertex<T> start) {
        this.start = start;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
