import java.util.ArrayList;

public class Non_Touched_loops {

	private ArrayList<ArrayList<ArrayList<Integer>>> nt = new ArrayList<ArrayList<ArrayList<Integer>>>();

	public void madeNonTouchedLoops(ArrayList<ArrayList<Integer>> loops) {
		for (int i = 0; i < loops.size(); i++) {
			ArrayList<Integer> first = loops.get(i);
			for (int j = i + 1; j < loops.size(); j++) {
				ArrayList<Integer> last = loops.get(j);
				if (!first.get(0).equals(last.get(0))) {
					if (nonTouched(first, last)) {
						
					}
				}
			}

		}

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

}
