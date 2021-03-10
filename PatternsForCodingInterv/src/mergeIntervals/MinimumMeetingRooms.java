/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class MinimumMeetingRooms {

	/**
	 * Given a list of intervals representing the start and end time of N meetings
	 * find the minimum number of rooms required to hold all the meetings
	 * 
	 * Meetings: [[1,4],[2,5],[7,9]] output:2 since [1,4] & [2,5] overlap we need
	 * two rooms
	 * 
	 * Meetings: [[6,7],[2,4],[8,12]] output:1 none of the meetings overlap
	 * 
	 * Meetings: [[1,4],[2,3],[3,6]] output:2 since [1,4] overlaps with the other
	 * two we need two rooms
	 * 
	 * Meetings: [[4,5],[2,3],[2,4],[3,5]] output:2 we need one room for [2,3] &
	 * [3,5] and another room for [2,4] & [4,5]
	 */
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>() {
			{
				add(new Interval(4, 5));
				add(new Interval(2, 3));
				add(new Interval(2, 4));
				add(new Interval(3, 5));
			}
		};
		System.out.println("Minimum meeting rooms required : 2 got : " + findMinimumMeetingRooms(input));
		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 3));
				add(new Interval(3, 6));
			}
		};
		System.out.println("Minimum meeting rooms required : 2 got : " + findMinimumMeetingRooms(input));
		input = new ArrayList<Interval>() {
			{
				add(new Interval(6, 7));
				add(new Interval(2, 4));
				add(new Interval(8, 12));
			}
		};
		System.out.println("Minimum meeting rooms required : 1 got : " + findMinimumMeetingRooms(input));
		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 5));
				add(new Interval(7, 9));
			}
		};
		System.out.println("Minimum meeting rooms required : 2 got : " + findMinimumMeetingRooms(input));
	}
//satisfied all the above test cases
	public static int findMinimumMeetingRooms(List<Interval> meetings) {
		if (meetings == null || meetings.size() < 2)
			return meetings.size();
		Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
		int conflict = 1;
		Iterator<Interval> intervalItr = meetings.iterator();
		Interval interval = intervalItr.next();
		int end = interval.end;
		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start < end)
				conflict++;
			end = Math.min(end, interval.end);
		}
		return conflict;
	}
}
