package manipulator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		GraphManipulator graphManipulator = new GraphManipulator();
		String path = "src/test/java/manipulator/samples/graph-sample-with-weight.txt";

		Graph<String> graph = graphManipulator.readWeightedGraph(path);
		
		Vertex<String> tomCruize =  graph.getNodes().stream()
				.filter(node -> node.getValue().equals("Tom Cruise"))
				.findFirst().get();
		
		List<Vertex<String>> otherActors = graph.getNodes().stream()
					.filter(node -> !node.getValue().equals("Tom Cruise"))
					.collect(Collectors.toList());
		
	}
	
	public static void shortestPath(List<Vertex<String>> otherActors, Vertex<String> target) {
		Map<String, Integer> distances = new HashMap<>();
		for (Vertex<String> vertex : otherActors) {
			Queue<Vertex<String>> queue = new LinkedList<>();
			
			for(Edge<String> e : vertex.getEdges()) {
				queue.add(e.getEnd()); // Need fix, should have the initial vertex.
			}
			
			Queue<Vertex<String>> aux = new LinkedList<>();
			int level = 1;
			
			while(queue.size() > 0) {
				for (Vertex<String> v : queue) {
					if (v.equals(target)) {
						distances.put(v.getValue(), level);
						break;
					}
					for(Edge<String> e2: v.getEdges()) {
						aux.add(e2.getEnd());
					}
				}
				queue = aux;
				aux = new LinkedList<>();
				level++;
			}
		}
	}
}