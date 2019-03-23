import java.util.ArrayList;

public class Graph {

	private boolean[][] graph;
	private int[][] gain;
	private Paths path = new Paths();
	private Loops loop = new Loops();
	private Non_Touched_loops ntl = new Non_Touched_loops();

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

	public void setLoops_and_Pathes() {

		path.madePathes(this.graph, this.graph.length);
		loop.madeLoops(this.graph, this.graph.length);
		ntl.madeNonTouchedLoops(loop.getLoops());
	}

	public void printPaths() {
		ArrayList<ArrayList<Integer>> list = path.getPaths();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.println();
		}
	}

	public void printloops() {
		ArrayList<ArrayList<Integer>> list = loop.getLoops();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.println();
		}

	}
}
