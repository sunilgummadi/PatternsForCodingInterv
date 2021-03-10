/**
 * 
 */
package twoHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author gummadisunil.kumar
 *
 */
public class SlidingWindowMedianAct {

	/**
	 * Given an array of numbers and a number k find the median of all the k sized
	 * sub arrays of the array.
	 */
	public static void main(String[] args) {
		System.out.println("Sliding window medians are: [1.5,0.5,1.0,4.0] got :"
				+ Arrays.toString(findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2)));
		System.out.println("Sliding window medians are: [1.0,2.0,3.0] got : "
				+ Arrays.toString(findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3)));
	}

	private static PriorityQueue<Integer> maxHeap;
	private static PriorityQueue<Integer> minHeap;

	public static double[] findSlidingWindowMedian(int[] nums, int k) {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
				maxHeap.offer(nums[i]);
			else
				minHeap.offer(nums[i]);
			reshape();
			if (i - k + 1 >= 0) {
				if (maxHeap.size() == minHeap.size())
					result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
				else
					result[i - k + 1] = maxHeap.peek();
				if (maxHeap.peek() >= nums[i - k + 1])
					maxHeap.remove(nums[i - k + 1]);
				else
					minHeap.remove(nums[i - k + 1]);
				reshape();
			}
		}
		return result;
	}

	public static void reshape() {
		if (maxHeap.size() > minHeap.size() + 1)
			minHeap.offer(maxHeap.poll());
		else if (minHeap.size() > maxHeap.size())
			maxHeap.offer(minHeap.poll());
	}
}
