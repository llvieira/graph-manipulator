package manipulator;

import java.net.URL;

public class Main {
	public static void main(String[] args) {
		GraphManipulator graph = new GraphManipulator();
		
		URL path = Main.class.getResource("samples/test.txt");
		graph.readGraph(path.getPath());
	}
}
