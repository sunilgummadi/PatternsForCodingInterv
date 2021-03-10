/**
 * 
 */
package mergeIntervals;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class ConflictingAppointmentsAct {

	/**
	 * Given an array of intervals representing N appointments find out if a person
	 * can attend all the appointments.
	 * 
	 * Appointments: [[1,4],[2,5],[7,9]] Output: false ([1,4] & [2,5]) overlap so
	 * person cannot attend both of them.
	 * 
	 * Appointments: [[6,7],[2,4],[8,12]] Output: true none of them overlap so
	 * person can attend.
	 * 
	 * Appointments: [[4,5],[2,3],[3,6]] Output: false ([4,5] & [3,6]) overlap so
	 * person cannot attend both of them.
	 */
	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		System.out.println("Can attend all the appointments : false got :" + canAttendAppointments(intervals));
		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		System.out.println("Can attend all the appointments : true got :" + canAttendAppointments(intervals1));
		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		System.out.println("Can attend all the appointments : false got :" + canAttendAppointments(intervals2));

	}

	public static boolean canAttendAppointments(Interval[] intervals) {
		if (intervals == null || intervals.length < 2)
			return true;
		// sorting the intervals by start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				// note that comparison above is < not <= while merging we needed <= comparison
				// as we will be merging the two intervals having condition intervals[i].start =
				// intervals[i - 1].end but such intervals don't represent conflicting
				// appointments as one starts right after other
				return false;
			}
		}
		return true;
	}
}
