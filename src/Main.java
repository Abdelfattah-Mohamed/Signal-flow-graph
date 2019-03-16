
public class Main {

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 4, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 4, 4);
		graph.addEdge(2, 3, 6);
		graph.addEdge(3, 4, 6);
		graph.addEdge(4, 0, 2);

		graph.printPaths();
	}

}
