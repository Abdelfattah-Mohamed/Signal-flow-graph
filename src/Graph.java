import java.util.LinkedList;

public class Graph {

	private boolean[][] graph;
	private int[][] gain;

	public Graph(int nV) {
		this.graph = new boolean[nV][nV];
		this.gain = new int[nV][nV];
	}

	public boolean[][] getGraph() {
		return this.graph;
	}

	public void addEdge(int f, int t, int gain) {
		if (gain != 0) {
			this.graph[f][t] = true;
			this.gain[f][t] = gain;
		}
	}

	public void printPaths() {
		Paths path = new Paths();
		LinkedList<LinkedList<Integer>> list = path.getPaths(this.graph, this.graph.length);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.println();
		}
	}

	public void printloops() {
		Loops path = new Loops();
		LinkedList<LinkedList<Integer>> list = path.getPaths(this.graph, this.graph.length);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.println();
		}
		
	}
}
