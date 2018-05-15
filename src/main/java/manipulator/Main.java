package manipulator;

public class Main {

	public static void main(String[] args) {
		GraphManipulator graphManipulator = new GraphManipulator();

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

		System.out.println(graphManipulator.BFS(graph, vertex1));
	}
}