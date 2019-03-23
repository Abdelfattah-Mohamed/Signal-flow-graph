import java.util.ArrayList;

public class Paths {

	private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	private void dfs(int from, int distance, boolean[][] graph, ArrayList<Integer> path) {
		if (from == distance) {
			this.paths.add((ArrayList<Integer>) path.clone());
			path.remove(path.size() - 1);
			return;
		}
		for (int i = from + 1; i < graph.length; i++) {
			if (graph[from][i]) {
				path.add(i);
				this.dfs(i, distance, graph, path);
			}

		}
		path.remove(path.size() - 1);
		return;
	}

	public void madePathes(boolean[][] graph, int distance) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (distance > 0) {
			path.add(0);
			this.dfs(0, distance - 1, graph, path);
		}

	}

	public ArrayList<ArrayList<Integer>> getPaths() {
		return this.paths;
	}

}
