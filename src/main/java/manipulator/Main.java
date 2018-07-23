package manipulator;

public class Main {

	public static void main(String[] args) {
		GraphManipulator graphManipulator = new GraphManipulator();
		String path = "src/test/java/manipulator/samples/graph-sample-with-weight.txt";
		
		graphManipulator.readWeightedGraph(path);
		
		
	}
}