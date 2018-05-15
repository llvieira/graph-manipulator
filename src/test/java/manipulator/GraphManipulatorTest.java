package manipulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GraphManipulatorTest {

	private final String GRAPH_SAMPLE_PATH = "src/test/java/manipulator/samples/graph-sample.txt";
	private final String GRAPH_SAMPLE_WITH_WEIGHT_PATH = "src/test/java/manipulator/samples/graph-sample-with-weight.txt";

	private GraphManipulator graphManipulator;
	
	@Before
	public void setUp() {
		this.graphManipulator = new GraphManipulator();
	}

	@Test
	public void testReadGraph() {
		Graph<Integer> graph = graphManipulator.readGraph(GRAPH_SAMPLE_PATH);

		List<Vertex<Integer>> realNodes = graph.getNodes();
		List<Vertex<Integer>> mockNodes = mockGraph().getNodes();

		for (int i = 0; i < realNodes.size(); i++) {
			Assert.assertEquals(realNodes.get(i), mockNodes.get(i));

			List<Edge<Integer>> realEdges = realNodes.get(i).getEdges();
			List<Edge<Integer>> mockEdges = mockNodes.get(i).getEdges();

			for (int j = 0; j < realEdges.size(); j++) {
				Assert.assertEquals(realEdges.get(j).getEnd(), mockEdges.get(j).getEnd());
				Assert.assertEquals(realEdges.get(j).getWeight(), mockEdges.get(j).getWeight());
			}
		}
	}
	
	@Test
	public void testReadWeightedGraph() {
		Graph<Integer> graph = graphManipulator.readWeightedGraph(GRAPH_SAMPLE_WITH_WEIGHT_PATH);

		List<Vertex<Integer>> realNodes = graph.getNodes();
		List<Vertex<Integer>> mockNodes = mockGraphWithWeight().getNodes();

		for (int i = 0; i < realNodes.size(); i++) {
			Assert.assertEquals(realNodes.get(i), mockNodes.get(i));

			List<Edge<Integer>> realEdges = realNodes.get(i).getEdges();
			List<Edge<Integer>> mockEdges = mockNodes.get(i).getEdges();

			for (int j = 0; j < realEdges.size(); j++) {
				Assert.assertEquals(realEdges.get(j).getEnd(), mockEdges.get(j).getEnd());
				Assert.assertEquals(realEdges.get(j).getWeight(), mockEdges.get(j).getWeight());
			}
		}	
	}
	
	@Test
	public void getVertexNumber() {
		Graph<Integer> graphOne = mockGraph();
		int expectedNumberVertex;
		int numberAddedVertex;
		
		expectedNumberVertex = this.graphManipulator.getVertexNumber(graphOne);
		numberAddedVertex = 5;
		
		Assert.assertEquals(expectedNumberVertex, numberAddedVertex);
	}
	
	@Test
	public void testGetEdgeNumber() {
		Graph<Integer> graphOne = mockGraph();
		int expectedNumberEdges;
		int numberAddedEdges;
		
		expectedNumberEdges = this.graphManipulator.getEdgeNumber(graphOne);
		numberAddedEdges = 4;
		
		Assert.assertEquals(expectedNumberEdges, numberAddedEdges);
	}
	
	@Test
	public void testGetMeanEdge() {
		Graph<Integer> graphOne = mockGraph();
		float expectedMeanEdge;
		float numberMeanEdge;
		float delta = 0;
		
		expectedMeanEdge = this.graphManipulator.getMeanEdge(graphOne);
		numberMeanEdge =  1.6f;
		
		Assert.assertEquals(expectedMeanEdge, numberMeanEdge, delta);
	}
	
	@Test
	public void testBFS() {
		Graph<Integer> graph = mockGraphFigureOne();
		Vertex<Integer> firstVertex = graph.getNodes().get(0);
		
		String realBFS = this.graphManipulator.BFS(graph, firstVertex);
		String expectedBFS =  "1 - 0 -\n" + 
							  "2 - 1 1\n" + 
							  "3 - 2 5\n" + 
							  "4 - 2 5\n" + 
							  "5 - 1 1";
		
		Assert.assertEquals(expectedBFS, realBFS);
	}

	@Test
	public void testDFS() {
		Graph<Integer> graphOne = mockGraphFigureOne();
		Vertex<Integer> firstVertex = graphOne.getNodes().get(0);

		String realDFS = this.graphManipulator.DFS(graphOne, firstVertex);
		String expectedDFS =  "1 - 0 -\n" +
				"2 - 1 1\n" +
				"3 - 3 5\n" +
				"4 - 3 5\n" +
				"5 - 2 2";

		Assert.assertEquals(expectedDFS, realDFS);
	}

	@Test
	public void testShortestPath() {
		Graph<Integer> graphOne = mockGraphFigureOne();
		Vertex<Integer> firstVertex = graphOne.getNodes().get(0);
		Vertex<Integer> thirdVertex = graphOne.getNodes().get(3);

		String result = this.graphManipulator.shortestPath(firstVertex, thirdVertex);
		String expectedResult = "1 5 3 ";

		Assert.assertEquals(result, expectedResult);
	}

	@Test
	public void testConnected() {
		Graph<Integer> graph = mockGraphDisconnected();
		boolean expected = false;
		boolean real = this.graphManipulator.connected(graph);
		
		Assert.assertEquals(expected, real);
	}
	
	private Graph<Integer> mockGraph() {
		Graph<Integer> graph = new Graph<Integer>();
		
		Vertex<Integer> vertex1 = new Vertex<Integer>(1);
		Vertex<Integer> vertex2 = new Vertex<Integer>(2);
		Vertex<Integer> vertex3 = new Vertex<Integer>(3);
		Vertex<Integer> vertex4 = new Vertex<Integer>(4);
		Vertex<Integer> vertex5 = new Vertex<Integer>(5);
		
		graph.addVertex(vertex1);
		graph.addVertex(vertex2);
		graph.addVertex(vertex3);
		graph.addVertex(vertex4);
		graph.addVertex(vertex5);

		graph.connect(vertex1, vertex2);
		graph.connect(vertex2, vertex3);
		graph.connect(vertex3, vertex4);
		graph.connect(vertex4, vertex5);

		return graph;
	}
	
	private Graph<Integer> mockGraphWithWeight() {
		Graph<Integer> graph = new Graph<Integer>();
		
		Vertex<Integer> vertex1 = new Vertex<Integer>(1);
		Vertex<Integer> vertex2 = new Vertex<Integer>(2);
		Vertex<Integer> vertex3 = new Vertex<Integer>(3);
		Vertex<Integer> vertex4 = new Vertex<Integer>(4);
		Vertex<Integer> vertex5 = new Vertex<Integer>(5);
		
		graph.addVertex(vertex1);
		graph.addVertex(vertex2);
		graph.addVertex(vertex3);
		graph.addVertex(vertex4);
		graph.addVertex(vertex5);

		graph.connect(vertex1, vertex2, 0.1f);
		graph.connect(vertex2, vertex5, 0.2f);
		graph.connect(vertex5, vertex3, 5f);
		graph.connect(vertex3, vertex4, -9.5f);
		graph.connect(vertex4, vertex5, 2.3f);
		graph.connect(vertex1, vertex5, 1f);

		return graph;
	}
	
	private Graph<Integer> mockGraphFigureOne() {
		Graph<Integer> graph = new Graph<Integer>();

		Vertex<Integer> vertex1 = new Vertex<>(1);
		Vertex<Integer> vertex2 = new Vertex<>(2);
		Vertex<Integer> vertex3 = new Vertex<>(3);
		Vertex<Integer> vertex4 = new Vertex<>(4);
		Vertex<Integer> vertex5 = new Vertex<>(5);
		
		graph.addVertex(vertex1);
		graph.addVertex(vertex2);
		graph.addVertex(vertex3);
		graph.addVertex(vertex4);
		graph.addVertex(vertex5);

		graph.connect(vertex1, vertex2);
		graph.connect(vertex1, vertex5);
		graph.connect(vertex2, vertex5);
		graph.connect(vertex5, vertex3);
		graph.connect(vertex4, vertex5);

		return graph;
	}
	
	private Graph<Integer> mockGraphDisconnected() {
		Graph<Integer> graph = new Graph<Integer>();

		Vertex<Integer> vertex1 = new Vertex<>(1);
		Vertex<Integer> vertex2 = new Vertex<>(2);
		Vertex<Integer> vertex3 = new Vertex<>(3);
		Vertex<Integer> vertex4 = new Vertex<>(4);
		Vertex<Integer> vertex5 = new Vertex<>(5);
		
		graph.addVertex(vertex1);
		graph.addVertex(vertex2);
		graph.addVertex(vertex3);
		graph.addVertex(vertex4);
		graph.addVertex(vertex5);

		graph.connect(vertex1, vertex2);
		graph.connect(vertex3, vertex4);

		return graph;
	}
}
