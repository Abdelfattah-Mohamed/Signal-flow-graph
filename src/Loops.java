import java.util.LinkedList;

public class Loops {

	private LinkedList<LinkedList<Integer>> loops = new LinkedList<LinkedList<Integer>>();

	private void dfs(int from, int distance, boolean[][] graph, LinkedList<Integer> loop, boolean flag) {
		if (from == distance && flag) {
			this.loops.add((LinkedList<Integer>) loop.clone());
			loop.removeLast();
			flag = false;
			return;
		}
		flag = true;
		for (int i = distance; i < graph.length; i++) {
			if (graph[from][i] && this.contain(loop, i)) {
				loop.add(i);
				this.dfs(i, distance, graph, loop, flag);
			}

		}
		loop.removeLast();
		return;
	}

	private boolean contain(LinkedList<Integer> loop, int pivot) {
		for (int i = 1; i < loop.size(); i++) {
			if (pivot == loop.get(i)) {
				return false;
			}
		}
		return true;
	}

	public LinkedList<LinkedList<Integer>> getPaths(boolean[][] graph, int distance) {
		LinkedList<Integer> loop = new LinkedList<Integer>();
		if (distance > 0) {
			for (int i = 0; i < graph.length; i++) {
				loop.add(i);
				this.dfs(i, i, graph, loop, false);
			}
		}
		return this.loops;
	}
}
