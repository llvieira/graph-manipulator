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
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}    
}
