/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
class Intervals {
	int start;
	int end;

	public Intervals(int start, int end) {
		this.start = start;
		this.end = end;
	}

};

class MergeIntervalsAct {

	/**
	 * Given a list of intervals merge all the overlapping intervals to produce a
	 * list that has only mutually exclusive intervals.
	 * 
	 * Intervals: [[1,4],[2,5],[7,9]] Output:[[1,5],[7,9]]
	 * 
	 * Intervals: [[6,7],[2,4],[5,9]] Output:[[2,4],[5,9]]
	 * 
	 * Intervals: [[1,4],[2,6],[3,5]] Output:[[1,6]]
	 */
	public static void main(String[] args) {
		List<Intervals> input = new ArrayList<Intervals>();
		input.add(new Intervals(1, 4));
		input.add(new Intervals(2, 5));
		input.add(new Intervals(7, 9));
		System.out.println("Merged intervals: Intervals: [[1,4],[2,5],[7,9]] Output:[[1,5],[7,9]] got :");
		for (Intervals interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Intervals>();
		input.add(new Intervals(6, 7));
		input.add(new Intervals(2, 4));
		input.add(new Intervals(5, 9));
		System.out.println("Merged intervals: Intervals: [[6,7],[2,4],[5,9]] Output:[[2,4],[5,9]] got :");
		for (Intervals interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Intervals>();
		input.add(new Intervals(1, 4));
		input.add(new Intervals(2, 6));
		input.add(new Intervals(3, 5));
		System.out.println("Merged intervals: Intervals: [[1,4],[2,6],[3,5]] Output:[[1,6]] got :");
		for (Intervals interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
	}

	public static List<Intervals> merge(List<Intervals> intervals) {
		if (intervals.size() < 2)
			return intervals;
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		List<Intervals> mergedIntervals = new LinkedList<Intervals>();
		Iterator<Intervals> intervalItr = intervals.iterator();
		Intervals interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;
		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start <= end)
				end = Math.max(end, interval.end);
			else {
				mergedIntervals.add(new Intervals(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		mergedIntervals.add(new Intervals(start, end));
		return mergedIntervals;
	}

}
