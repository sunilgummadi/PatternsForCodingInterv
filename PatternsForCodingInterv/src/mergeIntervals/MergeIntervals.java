/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

};

class MergeIntervals {

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
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.println("Merged intervals: Intervals: [[1,4],[2,5],[7,9]] Output:[[1,5],[7,9]] got :");
		for (Interval interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.println("Merged intervals: Intervals: [[6,7],[2,4],[5,9]] Output:[[2,4],[5,9]] got :");
		for (Interval interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		System.out.println("Merged intervals: Intervals: [[1,4],[2,6],[3,5]] Output:[[1,6]] got :");
		for (Interval interval : merge(input)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
	}

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals = new LinkedList<Interval>();
		int left = 0;
		int len = intervals.size();
		int right = len - 1;
		Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
		while (left <= right) {
			if (intervals.get(left).end < intervals.get(right).start)
				right--;
			else {
				int min = Math.min(intervals.get(left).start, intervals.get(right).start);
				int max = Math.max(intervals.get(left).end, intervals.get(right).end);
				mergedIntervals.add(new Interval(min, max));
				left = right + 1;
				right = len - 1;
			}

		}
		return mergedIntervals;
	}

}
