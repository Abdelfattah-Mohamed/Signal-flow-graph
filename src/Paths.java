import java.util.LinkedList;

public class Paths {

	private LinkedList<LinkedList<Integer>> paths = new LinkedList<LinkedList<Integer>>();

	private void dfs(int from, int distance, boolean[][] graph, LinkedList<Integer> path) {
		if (from == distance) {
			this.paths.add((LinkedList<Integer>) path.clone());
			path.removeLast();
			return;
		}
		for (int i = from + 1; i < graph.length; i++) {
			if (graph[from][i]) {
				path.add(i);
				this.dfs(i, distance, graph, path);
			}

		}
		path.removeLast();
		return;
	}

	public LinkedList<LinkedList<Integer>> getPaths(boolean[][] graph, int distance) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		if (distance > 0) {
			path.add(0);
			this.dfs(0, distance-1, graph, path);
		}
		return this.paths;
	}

}
