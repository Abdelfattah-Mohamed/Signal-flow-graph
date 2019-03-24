import java.util.ArrayList;

public class Graph {

	private boolean[][] graph;
	private int[][] gain;
	private Paths path = new Paths();
	private Loops loop = new Loops();
	private Non_Touched_loops ntl = new Non_Touched_loops();
	private Calc_Delta delta = new Calc_Delta();
	private Calc_Deltas deltas = new Calc_Deltas();

	public Graph(int nV) {
		this.graph = new boolean[nV][nV];
		this.gain = new int[nV][nV];
	}

	public boolean[][] getGraph() {
		return this.graph;
	}

	public int[][] get_gain() {
		return this.gain;
	}

	public void addEdge(int f, int t, int gain) {
		if (gain != 0) {
			this.graph[f][t] = true;
			this.gain[f][t] = gain;
		}
	}

	public void setLoops_and_Pathes() {

		this.path.madePathes(this.graph, this.graph.length, this.gain);
		this.loop.madeLoops(this.graph, this.graph.length, this.gain);
		this.ntl.madeNonTouchedLoops(loop.getLoops(), loop.get_loops_gain());
		this.delta.setDelta(ntl.getLoopsGain());
		this.deltas.setDeltas(this.path, this.ntl);
	}

	public void printPaths() {
		ArrayList<ArrayList<Integer>> list = path.getPaths();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.print(path.get_paths_gain().get(i));
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
	}

	public void printloops() {
		ArrayList<ArrayList<Integer>> list = loop.getLoops();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "=>");
			}
			System.out.print(loop.get_loops_gain().get(i));
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
	}

	public void printNonTouchedLoops() {
		ArrayList<ArrayList<ArrayList<Integer>>> nt = ntl.getNonTouched();
		for (int i = 0; i < nt.size(); i++) {
			for (int j = 0; j < nt.get(i).size(); j++) {
				for (int k = 0; k < nt.get(i).get(j).size(); k++) {
					System.out.print(nt.get(i).get(j).get(k) + "=>");
				}
				System.out.print(ntl.getLoopsGain().get(i).get(j));
				System.out.println();
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		System.out.println(this.delta.getDelta());
		System.out.println(this.deltas.getDeltas());
	}

}
