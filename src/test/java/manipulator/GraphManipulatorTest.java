package manipulator;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphManipulatorTest {

	private final String GRAPH_SAMPLE_PATH = "src/test/java/manipulator/samples/graph-sample.txt";

	private GraphManipulator graphManipulator;
	private Set<?>[] connections;
	
	@Before
	public void setUp() {
		this.graphManipulator = new GraphManipulator();
		this.connections = this.mountConnections();
	}

	@Test
	public void testReadGraph() {
		Graph graph = graphManipulator.readGraph(GRAPH_SAMPLE_PATH);
		
		for (int i = 0; i < connections.length; i++) {
			Assert.assertEquals(graph.getConnections().get(new Vertex(i + 1)), connections[i]);
		}
	}
	
	private Set<?>[] mountConnections() {
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		Set<Vertex> connectionsFor1 = new HashSet<>();
		connectionsFor1.add(vertex2);
		
		Set<Vertex> connectionsFor2 = new HashSet<>();
		connectionsFor2.add(vertex1);
		connectionsFor2.add(vertex3);
		
		Set<Vertex> connectionsFor3 = new HashSet<>();
		connectionsFor3.add(vertex2);
		connectionsFor3.add(vertex4);
		
		Set<Vertex> connectionsFor4 = new HashSet<>();
		connectionsFor4.add(vertex3);
		connectionsFor4.add(vertex5);
		
		Set<Vertex> connectionsFor5 = new HashSet<>();
		connectionsFor5.add(vertex4);
		
		Set<?>[] listOfConnections = new HashSet<?>[5];
		listOfConnections[0] = connectionsFor1;
		listOfConnections[1] = connectionsFor2;
		listOfConnections[2] = connectionsFor3;
		listOfConnections[3] = connectionsFor4;
		listOfConnections[4] = connectionsFor5;
		
		return listOfConnections;
	}
}
