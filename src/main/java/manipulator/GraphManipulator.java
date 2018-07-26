package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphManipulator implements Manipulator {

	private static final String BREAK_LINE = System.getProperty("line.separator");
	@Override
	public Graph<Integer> readGraph(String path) {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			Graph<Integer> graph = new Graph<Integer>();
			String firstLine = scanner.nextLine();
			Integer numberVertex = Integer.valueOf(firstLine);
			
			for (int i = 1; i <= numberVertex; i++) {
				Vertex<Integer> vertex = new Vertex<Integer>(i);
				graph.addVertex(vertex);
			}
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.trim().split(" ");

				Vertex<Integer> vertex1 = new Vertex<>(Integer.valueOf(values[0]));
				Vertex<Integer> vertex2 = new Vertex<>(Integer.valueOf(values[1]));

				graph.connect(vertex1, vertex2);
			}

			scanner.close();
			
			graph.setWeight(false);

			return graph;
		} catch (FileNotFoundException e) {
			System.out.println("File" + path + " does not exists.");
			return null;
		}
	}

	@Override
	public Graph<String> readWeightedGraph(String path) {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);

			Graph<String> graph = new Graph<>();
			String firstLine = scanner.nextLine();
			Integer numberVertex = Integer.valueOf(firstLine);
			
			for (int i = 1; i <= numberVertex; i++) {
				Vertex<String> vertex = new Vertex<String>(String.valueOf(i));
				graph.addVertex(vertex);
			}
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.trim().split(",");
				
				Vertex<String> vertex1 = new Vertex<>(values[0]);
				Vertex<String> vertex2 = new Vertex<>(values[1]);
				float weight = Float.valueOf(values[2]);

				graph.connect(vertex1, vertex2, weight);
			}

			scanner.close();
			
			graph.setWeight(true);
			
			return graph;
		} catch (FileNotFoundException e) {
			System.out.println("File" + path + " does not exists.");
			return null;
		}
	}

	@Override
	public int getVertexNumber(Graph<Integer> graph) {
		return graph.numberVertex();
	}

	@Override
	public int getEdgeNumber(Graph<Integer> graph) {
		Set<Edge<Integer>> edgesGraph = new HashSet<>();
		
		for (Vertex<Integer> vertex: graph.getNodes()) {
			edgesGraph.addAll(vertex.getEdges());
		}
		
		return edgesGraph.size();
	}

	@Override
	public float getMeanEdge(Graph<Integer> graph) {
		float sumDegree = 0;
		float meanEdge = 0;
		
		for (Vertex<Integer> vertex: graph.getNodes()) {
			sumDegree += vertex.degree();
		}
		
		if(graph.getNodes().size() > 0) {
			meanEdge = (sumDegree/graph.getNodes().size());
		}
		
		return meanEdge;
	}

	@Override
    public String graphRepresentation(Graph<Integer> graph, String type) {
		if(graph.getWeight()) {
	        if(type.equals("AM")){
	            return graphRepresentationWeightAM(graph);
	        }else if(type.equals("AL")){
	            return graphRepresentationWeightAL(graph);
	        }
		}else {
			if(type.equals("AM")){
	            return graphRepresentationAM(graph);
	        }else if(type.equals("AL")){
	            return graphRepresentationAL(graph);
	        }
		}
       
        return null;
    }
	
private String graphRepresentationAM(Graph<Integer> graph){
        
    	int numberVertex = graph.numberVertex();
        List<Vertex<Integer>> nodes = graph.getNodes(); 
        Map<Vertex<Integer>, Set<Vertex>> mapAdjacents = new HashMap<Vertex<Integer>, Set<Vertex>>();
       
        for(Vertex node: nodes){
            ArrayList<Edge> edges = (ArrayList) node.getEdges();
            Set<Vertex> adjacents = new HashSet<Vertex>();
            for(Edge edge : edges) {
            	if(!edge.getEnd().equals(node)) {
            		adjacents.add(edge.getEnd());
            	}else {
            		adjacents.add(edge.getStart());
            	}
            }
            mapAdjacents.put(node, adjacents);
        }
        
        
        
        String resp = " ";
       
        for(int i=1;i<=numberVertex;i++) {
        	resp += " " + i;
        }
        
        resp += BREAK_LINE;
        
        
        for(Vertex verts : mapAdjacents.keySet()) {
        	resp += verts.getValue();
        	for(int i = 0;i<numberVertex;i++) {
        		if(mapAdjacents.get(verts).contains(nodes.get(i))) {
        			resp +=" "+1;
        		}else {
        			resp +=" "+0	;
        		}
        	}
        	resp+=BREAK_LINE;
        }
        
        return resp;
       
       
    }
 
    private String graphRepresentationWeightAL(Graph<Integer> graph){
    	
    	int numberVertex = graph.numberVertex();
        List<Vertex<Integer>> nodes = graph.getNodes(); 
     
        String resp = "";
        
        for(Vertex verts : nodes) {
        	resp += verts.getValue() +" -";
        	ArrayList<Edge> edges = (ArrayList<Edge>) verts.getEdges();
        	for(Edge edge : edges) {
        		if(!edge.getEnd().equals(verts)) {
        			resp +=" "+edge.getEnd().getValue()+"("+edge.getWeight()+")";
        		}else {
        			resp +=" "+edge.getStart().getValue()+"("+edge.getWeight()+")";
        		}
        	}
        	resp+=BREAK_LINE;
        }
       
       
        return resp;
    }
   
    private String graphRepresentationWeightAM(Graph<Integer> graph){
        
    	int numberVertex = graph.numberVertex();
        List<Vertex<Integer>> nodes = graph.getNodes(); 
        Map<Vertex<Integer>, Map<Vertex,Edge>> mapAdjacents = new HashMap<Vertex<Integer>, Map<Vertex,Edge>>();
        
        for(Vertex node: nodes){
            ArrayList<Edge> edges = (ArrayList) node.getEdges();
            Map<Vertex,Edge> adjacents = new HashMap<Vertex,Edge>();
            for(Edge edge : edges) {
            	if(!edge.getEnd().equals(node)) {
            		adjacents.put(edge.getEnd(),edge);
            	}else {
            		adjacents.put(edge.getStart(),edge);
            	}
            }
            mapAdjacents.put(node, adjacents);
        }
        
        String resp = " ";
       
        for(int i=1;i<=numberVertex;i++) {
        	resp += " " + i;
        }
        
        resp += BREAK_LINE;
        
        
        for(Vertex vert : mapAdjacents.keySet()) {
        	resp += vert.getValue();
        	for(int i = 0;i<numberVertex;i++) {
        		if(mapAdjacents.get(vert).containsKey(nodes.get(i))) {
        			resp +=" "+mapAdjacents.get(vert).get(nodes.get(i)).getWeight();
        		}else {
        			resp +=" "+0;
        		}
        	}
        	resp+=BREAK_LINE;
        }
        
        
        return resp;
       
       
    }
 
    private String graphRepresentationAL(Graph<Integer> graph){
    	
    	int numberVertex = graph.numberVertex();
        List<Vertex<Integer>> nodes = graph.getNodes(); 
        Map<Vertex<Integer>, Set<Vertex>> mapAdjacents = new HashMap<Vertex<Integer>, Set<Vertex>>();
       
        for(Vertex node: nodes){
            ArrayList<Edge> edges = (ArrayList) node.getEdges();
            Set<Vertex> adjacents = new HashSet<Vertex>();
            for(Edge edge : edges) {
            	if(!edge.getEnd().equals(node)) {
            		adjacents.add(edge.getEnd());
            	}else {
            		adjacents.add(edge.getStart());
            	}
            }
            mapAdjacents.put(node, adjacents);
        }
        
        
        String resp = "";
        
        for(Vertex verts : mapAdjacents.keySet()) {
        	resp += verts.getValue() +" -";
        	for(Vertex adjVerts : mapAdjacents.get(verts)) {
        		resp +=" "+adjVerts.getValue();
        	}
        	resp+=BREAK_LINE;
        }
       
       
        return resp;
    }

	@Override
	public String BFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		String stringBfsOut = "";
		
		if(graph.getNodes().size() > 0) {
			Map<Integer, Integer[]> bfsOutput = BFS(vertex);
					
			stringBfsOut = formatSearchOutput(bfsOutput);
			
			return stringBfsOut;
		}
		
		return stringBfsOut;
	}

	// Shortest path using BFS, it doesn't work for weighted graph
	@Override
	public String shortestPath(Vertex<Integer> vertex1, Vertex<Integer> vertex2) {
		List<Integer> path = new ArrayList<>();
		path.add(vertex2.getValue());

		Map<Integer, Integer[]> bfsOutput = BFS(vertex1);

		Integer dad = bfsOutput.get(vertex2.getValue())[1];

		while (! dad.equals(vertex1.getValue())) {
			path.add(dad);
			dad = bfsOutput.get(dad)[1];
		}

		path.add(vertex1.getValue());

		String result = "";

		for (int i = path.size() - 1; i >= 0; i--) {
			result += path.get(i) + " ";
		}

		return result;
	}

	@Override
	public String MST(Graph<Integer> graph) {
		Graph<Integer> mst = new Graph<>();
		int root_index = 0;
		
		Vertex<Integer> initial = graph.getNodes().get(root_index);
		List<Edge<Integer>> edges = initial.getEdges();
		graph.addVertex(initial);
		
		
		while(mst.getNodes().size() <= graph.getNodes().size()) {
			Edge<Integer> connection = null;
			do {
				connection = min(edges);
				if (mst.contains(connection.getEnd())) {
					edges.remove(connection);
				}
				
			} while (mst.contains(connection.getEnd()));
			mst.connect(connection.getStart(), connection.getEnd());
			edges.addAll(connection.getEnd().getEdges());
			edges.remove(connection);
		}
		
		String output = "";
		for (int i = 0; i < mst.getNodes().size(); i++) {
			for (Edge<Integer> edge : mst.getNodes().get(i).getEdges()) {
				output += "Parent: " + edge.getStart().getValue() +
				  " Level: " + i + System.lineSeparator();
			}
		}
		return output;
		
	}
	
	public Edge<Integer> min(List<Edge<Integer>> edges) {
		Edge<Integer> nextSteap = edges.get(0);
		
		for (Edge<Integer> edge : edges) {
			if (nextSteap.getWeight() > edge.getWeight())
				nextSteap = edge;
		}
		return nextSteap;
	}

	@Override
	public boolean connected(Graph<Integer> graph) {
		if(graph.getNodes().size() > 0) {
			Vertex<Integer> firstVertex = graph.getNodes().get(0);
			Map<Integer, Integer[]> bfsOut = BFS(firstVertex);
			
			for (Vertex<Integer> vertex: graph.getNodes()) {
				if (!bfsOut.containsKey(vertex.getValue())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public Map<Integer, Integer[]> BFS(Vertex<Integer> vertex) {
		Map<Integer, Integer[]> bfsOutput = new HashMap<>();
		Queue<Vertex<Integer>> queue = new LinkedList<>();
	
		Integer[] initialLevel = {0, null};
		bfsOutput.put(vertex.getValue(), initialLevel);
		queue.add(vertex);
	
		BFS(queue, bfsOutput);
		
		return bfsOutput;
	}
	
	private void BFS(Queue<Vertex<Integer>> queue, Map<Integer, Integer[]> bfsOutput) {
		if (!queue.isEmpty()) {
			Vertex<Integer> visited = queue.poll();
			Integer levelVisited = bfsOutput.get(visited.getValue())[0];
			Integer[] levelNeighbors = {++levelVisited, visited.getValue()};

			for (Vertex<Integer> neighbor: visited.neighbors()) {
				if(!bfsOutput.containsKey(neighbor.getValue())) {
					bfsOutput.put(neighbor.getValue(), levelNeighbors);
					queue.add(neighbor);
				}
			}

			BFS(queue, bfsOutput);
		}
	}

	@Override
	public String DFS(Graph<Integer> graph, Vertex<Integer> vertex) {
		String stringDfsOut = "";

		if (graph.getNodes().size() > 0) {
			Map<Integer, Integer[]> dfsOutput = new HashMap<>();

			Integer[] initialLevel = {0, null};
			dfsOutput.put(vertex.getValue(), initialLevel);

			DFS(vertex, dfsOutput);

			stringDfsOut = formatSearchOutput(dfsOutput);
		}

		return stringDfsOut;
	}

	private void DFS(Vertex<Integer> vertex, Map<Integer, Integer[]> dfsOutput) {
		Integer levelVisited = dfsOutput.get(vertex.getValue())[0];
		Integer[] levelNeighbors = {++levelVisited, vertex.getValue()};

		for (Vertex<Integer> neighbor: vertex.neighbors()) {
			if(! dfsOutput.containsKey(neighbor.getValue())) {
				dfsOutput.put(neighbor.getValue(), levelNeighbors);
				DFS(neighbor, dfsOutput);
			}
		}
	}

	private String formatSearchOutput(Map<Integer, Integer[]> output) {
		String string = "";

		List<Integer> orderedVertex = new ArrayList<>(output.keySet());
		Collections.sort(orderedVertex);

		for (int i = 0; i < orderedVertex.size(); i++) {
			Integer value = orderedVertex.get(i);
			Integer levelVertex = output.get(value)[0];
			String parentVertex = (output.get(value)[1] == null) ?
					"-":String.valueOf(output.get(value)[1]);

			if (i == orderedVertex.size() - 1) {
				string += value + " - " + levelVertex + " "+ parentVertex;
			} else {
				string += value + " - " + levelVertex + " "+ parentVertex + "\n";
			}
		}

		return string;
	}
}
