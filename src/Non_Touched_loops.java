import java.util.ArrayList;

public class Non_Touched_loops {

	private ArrayList<ArrayList<ArrayList<Integer>>> nt = new ArrayList<ArrayList<ArrayList<Integer>>>();
	private ArrayList<ArrayList<ArrayList<Integer>>> ntIndexes = new ArrayList<ArrayList<ArrayList<Integer>>>();
	private ArrayList<ArrayList<Integer>> all_loops_gain = new ArrayList<ArrayList<Integer>>();

	public void madeNonTouchedLoops(ArrayList<ArrayList<Integer>> loops, ArrayList<Integer> loopsGain) {
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> tempIndex = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempGains = new ArrayList<Integer>();
		this.nt.add(loops);
		this.loopsName(loops.size());
		this.all_loops_gain.add(loopsGain);
		for (int k = 0; k < nt.size(); k++) {
			for (int i = 0; i < nt.get(k).size(); i++) {
				ArrayList<Integer> first = nt.get(k).get(i);
				ArrayList<Integer> indexFirst = ntIndexes.get(k).get(i);
				for (int j = this.get_j(first); j < nt.get(0).size(); j++) {
					ArrayList<Integer> last = nt.get(0).get(j);
					ArrayList<Integer> indexLast = ntIndexes.get(0).get(j);
					if (!first.get(0).equals(last.get(0))) {
						if (this.nonTouched(first, last)) {
							temp.add(this.add(first, last));
							tempIndex.add(this.add(indexFirst, indexLast));
							tempGains.add(all_loops_gain.get(k).get(i) * all_loops_gain.get(0).get(j));
						}
					}
				}
			}
			if (!temp.isEmpty()) {
				this.nt.add((ArrayList<ArrayList<Integer>>) temp.clone());
				this.ntIndexes.add((ArrayList<ArrayList<Integer>>) tempIndex.clone());
				this.all_loops_gain.add((ArrayList<Integer>) tempGains.clone());
				temp.clear();
				tempIndex.clear();
				tempGains.clear();
			} else {
				break;
			}
		}
	}

	private void loopsName(int n) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> tempB = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			temp.add(i);
			tempB.add((ArrayList<Integer>) temp.clone());
			temp.clear();
		}
		this.ntIndexes.add((ArrayList<ArrayList<Integer>>) tempB.clone());
	}

	private int get_j(ArrayList<Integer> first) {
		int i = 0;
		for (i = 0; i < nt.get(0).size(); i++) {
			if (nt.get(0).get(i).get(0) > first.get(0)) {
				return i;
			}
		}
		return i;
	}

	private ArrayList<Integer> add(ArrayList<Integer> first, ArrayList<Integer> last) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < first.size(); i++) {
			list.add(first.get(i));
		}
		for (int i = 0; i < last.size(); i++) {
			list.add(last.get(i));
		}
		return list;

	}

	private boolean nonTouched(ArrayList<Integer> first, ArrayList<Integer> last) {
		for (int i = 0; i < first.size(); i++) {
			int x = first.get(i);
			for (int j = 0; j < last.size(); j++) {
				int y = last.get(j);
				if (x == y) {
					return false;
				}
			}
		}
		return true;
	}

	public ArrayList<ArrayList<ArrayList<Integer>>> getNonTouched() {
		return this.nt;
	}

	public ArrayList<ArrayList<Integer>> getLoopsGain() {
		return this.all_loops_gain;
	}

}
