/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class InsertIntervalAct {

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
		if (intervals == null || intervals.size() == 0)
			return Arrays.asList(newInterval);
		List<Interval> mergedIntervals = new ArrayList<>();
		int i = 0;
		int size = intervals.size();
		while (i < size && intervals.get(i).end < newInterval.start)
			mergedIntervals.add(intervals.get(i++));
		while (i < size && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i++).end, newInterval.end);
		}
		mergedIntervals.add(newInterval);
		while (i < size)
			mergedIntervals.add(intervals.get(i++));
		return mergedIntervals;
	}
}
