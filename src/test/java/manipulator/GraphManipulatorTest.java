package manipulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GraphManipulatorTest {

	private final String GRAPH_SAMPLE_PATH = "src/test/java/manipulator/samples/graph-sample.txt";

	private GraphManipulator graphManipulator;

	@Before
	public void setUp() {
		this.graphManipulator = new GraphManipulator();
	}

	@Test
	public void testReadGraph() {
		Graph graph = graphManipulator.readGraph(GRAPH_SAMPLE_PATH);

		List<Vertex> realNodes = graph.getNodes();
		List<Vertex> mockNodes = mockGraph().getNodes();

		for (int i = 0; i < realNodes.size(); i++) {
			Assert.assertEquals(realNodes.get(i), mockNodes.get(i));

			List<Edge> realEdges = realNodes.get(i).getEdges();
			List<Edge> mockEdges = mockNodes.get(i).getEdges();

			for (int j = 0; j < realEdges.size(); j++) {
				Assert.assertEquals(realEdges.get(j).getEnd(), mockEdges.get(j).getEnd());
				Assert.assertEquals(realEdges.get(j).getWeight(), mockEdges.get(j).getWeight());
			}
		}
	}
	
	private Graph mockGraph() {
		Graph graph = new Graph();

		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		graph.connect(vertex1, vertex2);
		graph.connect(vertex2, vertex3);
		graph.connect(vertex3, vertex4);
		graph.connect(vertex4, vertex5);

		return graph;
	}
}
