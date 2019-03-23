import java.util.ArrayList;

public class Loops {

	private ArrayList<ArrayList<Integer>> loops = new ArrayList<ArrayList<Integer>>();

	private void dfs(int from, int distance, boolean[][] graph, ArrayList<Integer> loop, boolean flag) {
		if (from == distance && flag) {
			this.loops.add((ArrayList<Integer>) loop.clone());
			loop.remove(loop.size() - 1);
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
		loop.remove(loop.size() - 1);
		return;
	}

	private boolean contain(ArrayList<Integer> loop, int pivot) {
		for (int i = 1; i < loop.size(); i++) {
			if (pivot == loop.get(i)) {
				return false;
			}
		}
		return true;
	}

	public void madeLoops(boolean[][] graph, int distance) {
		ArrayList<Integer> loop = new ArrayList<Integer>();
		if (distance > 0) {
			for (int i = 0; i < graph.length; i++) {
				loop.add(i);
				this.dfs(i, i, graph, loop, false);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> getLoops() {
		return this.loops;
	}
}
