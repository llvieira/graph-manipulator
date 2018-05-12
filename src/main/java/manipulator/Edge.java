package manipulator;

public class Edge {

    private static final Float DEFAULT_WEIGHT = 1f;

    private Vertex start;
    private Vertex end;
    private Float weight;

    public Edge(Vertex end, Vertex start, Float weight) {
        this.end = end;
        this.start = start;

        if (weight == null) {
            this.weight = Edge.DEFAULT_WEIGHT;
        } else {
            this.weight = weight;
        }
    }

    public Edge(Vertex end, Vertex start) {
        this(end, start, null);
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }
    
    public Vertex getStart() {
        return start;
    }
    
    public void setStart(Vertex start) {
        this.start = start;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
