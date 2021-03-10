/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class IntervalsIntersectionAct {

	/**
	 * Given two lists of intervals find the intersection of these two lists. Each
	 * list consists of disjoint intervals sorted on their start time.
	 * 
	 * arr1=[[1,3],[5,6],[7,9]], arr2=[[2,3],[5,7]] Output: [2,3],[5,6],[7,7]
	 * 
	 * arr1=[[1,3],[5,7],[9,12]], arr2=[[5,10]] Output: [5,7],[9,10]
	 */
	public static void main(String[] args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		Interval[] result = merge(input1, input2);
		System.out.println(
				"Intervals Intersection : arr1=[[1,3],[5,6],[7,9]], arr2=[[2,3],[5,7]] Output: [2,3],[5,6],[7,7] got :");
		for (Interval interval : result) {
			System.out.print("[" + interval.start + "," + interval.end + "]");
		}
		System.out.println();
		input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
		input2 = new Interval[] { new Interval(5, 10) };
		result = merge(input1, input2);
		System.out.println(
				"Intervals Intersection : arr1=[[1,3],[5,7],[9,12]], arr2=[[5,10]] Output: [5,7],[9,10] got: ");
		for (Interval interval : result) {
			System.out.print("[" + interval.start + "," + interval.end + "]");
		}
		System.out.println();
	}

	// brute force approach O(N*M)
	public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
		List<Interval> intervalsIntersection = new ArrayList<Interval>();
		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end
					|| arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end) {
				intervalsIntersection
						.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));

			}
			if (arr1[i].end < arr2[j].end)
				i++;
			else
				j++;
		}
		return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
	}
}
