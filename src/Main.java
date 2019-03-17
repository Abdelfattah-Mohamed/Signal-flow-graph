
public class Main {

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 6;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 5, 5);
		graph.addEdge(1, 0, 1);
		graph.addEdge(1, 2, 4);
		graph.addEdge(2, 1, 6);
		graph.addEdge(2, 3, 6);
		graph.addEdge(3, 2, 2);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 5, 2);
		graph.addEdge(5, 3, 2);
		graph.addEdge(5, 4, 2);
		graph.addEdge(5, 5, 2);
		
		graph.setLoops_and_Pathes();
		
		graph.printPaths();
		graph.printloops();
	}

}
