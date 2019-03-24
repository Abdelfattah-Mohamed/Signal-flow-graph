
public class Main {

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 8;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(4, 5, 2);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 7, 1);
		graph.addEdge(4, 7, 4);
		graph.addEdge(5, 2, -1);
		graph.addEdge(7, 1, -1);
		graph.addEdge(7, 4, -2);

		graph.setLoops_and_Pathes();

		graph.printPaths();
		graph.printloops();
		graph.printNonTouchedLoops();	
	}
}
