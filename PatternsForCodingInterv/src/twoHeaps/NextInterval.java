/**
 * 
 */
package twoHeaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gummadisunil.kumar
 *
 */
class Interval {
	int start = 0;
	int end = 0;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class NextInterval {

	/**
	 * Given an array of intervals find the next interval of each interval. In a
	 * list of intervals for an interval i its next interval j will have the
	 * smallest start greater than or equal to the end of i.
	 * 
	 * Write a function to return an array containing indices of the next interval
	 * of each input interval. If there is no next interval of a given interval,
	 * return -1. It is given that none of the intervals have the same start point.
	 * 
	 * Input: Intervals [[2,3],[3,4],[5,6]] Output: [1,2-1]
	 * 
	 * Explanation: The next interval of [2,3] is [3,4] having index 1. Similarly
	 * the next interval of [3,4] is [5,6] having index 2. There is no next interval
	 * for [5,6] hence we have -1
	 */
	public static void main(String[] args) {
		Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
		System.out.println("Next interval indices are : [1,2-1] got :" + Arrays.toString(findNextInterval(intervals)));
		intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
		System.out
				.println("Next interval indices are: [2,-1,-1] got : " + Arrays.toString(findNextInterval(intervals)));
	}

	public static int[] findNextInterval(Interval[] intervals) {
		int n = intervals.length;
		int[] result = new int[n];
		// heap for finding the maximum start
		PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n,
				(i1, i2) -> intervals[i2].start - intervals[i1].start);
		// heap for finding the minimum start
		PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
		for (int i = 0; i < n; i++) {
			maxStartHeap.offer(i);
			maxEndHeap.offer(i);
		}
		// go through all the intervals to find each interval's next interval
		for (int i = 0; i < n; i++) {
			int topEnd = maxEndHeap.poll();
			result[topEnd] = -1;// default to -1
			if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
				int topStart = maxStartHeap.poll();
				// find the interval that has the closest start
				while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
					topStart = maxStartHeap.poll();
				}
				result[topEnd] = topStart;
				maxStartHeap.offer(topStart);
			}
		}
		return result;

	}

}
