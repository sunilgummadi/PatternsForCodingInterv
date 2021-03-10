/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class InsertInterval {

	/**
	 * Given a list of non overlapping intervals sorted by their start time, insert
	 * a given interval at the correct position and merge all necessary intervals to
	 * produce a list that has only mutually exclusive intervals.
	 * 
	 * Input:[[1,3],[5,7],[8,12]] new Interval:[4,6] Output:[[1,3],[4,7],[8,12]]
	 * 
	 * Input:[[1,3],[5,7],[8,12]] new Interval:[4,10] Output:[[1,3],[4,12]]
	 * 
	 * Input:[[2,3],[5,7]] new Interval:[1,4] Output:[[1,4],[5,7]]
	 */
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.println(
				"Intervals after inserting new interval: Intervals: [[1,3],[5,7],[8,12]] new Interval:[4,6] Output:[[1,3],[4,7],[8,12]] got :");
		for (Interval interval : insert(input, new Interval(4, 6))) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.println(
				"Intervals after inserting new interval: Intervals: [[1,3],[5,7],[8,12]] new Interval:[4,10] Output:[[1,3],[4,12]] got :");
		for (Interval interval : insert(input, new Interval(4, 10))) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.println(
				"Intervals after inserting new interval: Intervals: [[2,3],[5,7]] new Interval:[1,4] Output:[[1,4],[5,7]] got :");
		for (Interval interval : insert(input, new Interval(1, 4))) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();

	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> mergedIntervals = new ArrayList<>();
		// int newStart = newInterval.start;
		// int newEnd = newInterval.end;
		int i;
		for (i = 0; i < intervals.size();) {
			if (intervals.get(i).start < newInterval.start)
				i++;
			else
				break;
		}
		intervals.add(i, newInterval);
		Iterator<Interval> intervalItr = intervals.iterator();
		Interval interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;
		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start <= end)
				end = Math.max(end, interval.end);
			else {
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		mergedIntervals.add(new Interval(start, end));
		return mergedIntervals;
	}
}
