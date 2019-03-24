import java.util.ArrayList;

public class Loops {

	private ArrayList<ArrayList<Integer>> loops = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> loops_gain = new ArrayList<Integer>();

	private void dfs(int from, int distance, boolean[][] graph, ArrayList<Integer> loop, boolean flag, int[][] gain) {
		if (from == distance && flag) {
			this.loops.add((ArrayList<Integer>) loop.clone());
			this.set_gain(loop, gain);
			loop.remove(loop.size() - 1);
			flag = false;
			return;
		}
		flag = true;
		for (int i = distance; i < graph.length; i++) {
			if (graph[from][i] && this.contain(loop, i)) {
				loop.add(i);
				this.dfs(i, distance, graph, loop, flag, gain);
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

	public void madeLoops(boolean[][] graph, int distance, int[][] gain) {
		ArrayList<Integer> loop = new ArrayList<Integer>();
		if (distance > 0) {
			for (int i = 0; i < graph.length; i++) {
				loop.add(i);
				this.dfs(i, i, graph, loop, false, gain);
			}
		}
	}

	private void set_gain(ArrayList<Integer> loop, int[][] gain) {
		int totGain = 1;
		for (int i = 0; i < loop.size() - 1; i++) {
			totGain *= gain[loop.get(i)][loop.get(i + 1)];
		}
		this.loops_gain.add(totGain);
	}

	public ArrayList<ArrayList<Integer>> getLoops() {
		return this.loops;
	}

	public ArrayList<Integer> get_loops_gain() {
		return this.loops_gain;
	}
}
