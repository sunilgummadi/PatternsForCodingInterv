/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class EmployeeFreeTime {

	/**
	 * For 'K' employees we are given a list of intervals representing the working
	 * hours of each employee. Our goal is to find out if there is a free interval
	 * that is common to all employees. You can assume that each list of employee
	 * working hours is sorted on the start time.
	 * 
	 * Input: [[[1,3],[5,6]],[[2,3],[6,8]]] Output: [3,5] the employees are free
	 * between [3,5]
	 * 
	 * Input: [[[1,3],[9,12]],[[2,4]],[[6,8]]] Output:[4,6],[8,9] employees are free
	 * between [4,6] & [8,9]
	 * 
	 * Input: [[[1,3],[2,4]],[[3,5],[7,9]]] Output: [5,7] employees are free between
	 * [5,7]
	 */
	public static void main(String[] args) {
		List<List<Interval>> input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
		System.out.println("Free Intervals : [[[1,3],[5,6]],[[2,3],[6,8]]] Output: [3,5] got:");
		for (Interval interval : findEmployeeFreeTime(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
		System.out.println("Free Intervals : [[[1,3],[9,12]],[[2,4]],[[6,8]]] Output:[4,6],[8,9] got:");
		for (Interval interval : findEmployeeFreeTime(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
		System.out.println("Free Intervals : [[[1,3],[2,4]],[[3,5],[7,9]]] Output: [5,7] got:");
		for (Interval interval : findEmployeeFreeTime(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

	}

	public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<>();
		List<Interval> sortedSechedule = new ArrayList<>();
		for (int i = 0; i < schedule.size(); i++) {
			for (int j = 0; j < schedule.get(i).size(); j++) {
				sortedSechedule.add(schedule.get(i).get(j));
			}
		}
		Collections.sort(sortedSechedule, (a, b) -> Integer.compare(a.start, b.start));
		Iterator<Interval> intervalItr = sortedSechedule.iterator();
		Interval interval = intervalItr.next();
		int end = interval.end;
		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				result.add(new Interval(end, interval.start));
				end = interval.end;
			}
		}
		return result;
	}

}
