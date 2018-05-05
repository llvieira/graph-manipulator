package manipulator;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
	private List<Vertex> connections;
	private Integer value;
	
	public Vertex(Integer value) {
		this.value = value;
		this.connections = new LinkedList<>();
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public List<Vertex> getConnections() {
		return connections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vertex))
			return false;
		Vertex other = (Vertex) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}
