package manipulator;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphManipulatorTest {
	private GraphManipulator graph;
	private final String GRAPH_SAMPLE_PATH = "samples/graph-sample.txt";
	private Set<?>[] connections;
	
	@Before
	public void setUp() {
		this.graph = new GraphManipulator();
		this.connections = this.mountConnections();
	}

	@Test
	public void testReadGraph() {
		URL path = GraphManipulatorTest.class.getResource(GRAPH_SAMPLE_PATH);
		graph.readGraph(path.getPath());
		
		for (int i = 0; i < connections.length; i++) {
			Assert.assertEquals(this.graph.getGraph().getConnections().get(i+1), connections[i]);
		}
	}
	
	private Set<?>[] mountConnections() {
		Set<Integer> connectionsFor1 = new HashSet<>();
		connectionsFor1.add(2);
		
		Set<Integer> connectionsFor2 = new HashSet<>();
		connectionsFor2.add(1);
		connectionsFor2.add(3);
		
		Set<Integer> connectionsFor3 = new HashSet<>();
		connectionsFor3.add(2);
		connectionsFor3.add(4);
		
		Set<Integer> connectionsFor4 = new HashSet<>();
		connectionsFor4.add(3);
		connectionsFor4.add(5);
		
		Set<Integer> connectionsFor5 = new HashSet<>();
		connectionsFor5.add(4);
		
		Set<?>[] listOfConnections = new HashSet<?>[5];
		listOfConnections[0] = connectionsFor1;
		listOfConnections[1] = connectionsFor2;
		listOfConnections[2] = connectionsFor3;
		listOfConnections[3] = connectionsFor4;
		listOfConnections[4] = connectionsFor5;
		
		return listOfConnections;
	}
}
