/**
 * 
 */
package twoHeaps;

import java.util.PriorityQueue;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindMedianOfNumberStream {

	/**
	 * Design a class to calculate the median of a number stream. The class should
	 * have the following two methods:
	 * 
	 * 1.insertNum(int num): stores the number in the class.
	 * 
	 * 2.findMedian(): returns the median of all numbers inserted in the class.
	 * 
	 * If the count of numbers inserted in the class is even, the median will be the
	 * average of the middle two numbers.
	 * 
	 * insertNum(3),insetNum(1),findMedian()->output:2,insert(5),findMedian()->output:3
	 */
	public static void main(String[] args) {
		insertNum(3);
		insertNum(1);
		System.out.println("The median is : 2 got :" + findMedian());
		insertNum(5);
		System.out.println("The median is : 3 got :" + findMedian());
		insertNum(4);
		System.out.println("The median is : 3.5 got :" + findMedian());
	}

	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

	// public FindMedianOfNumberStream() {
	// maxHeap = new PriorityQueue<>((a, b) -> b - a);
	// minHeap = new PriorityQueue<>((a, b) -> a - b);
	// }

	public static void insertNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.offer(num);
		else
			minHeap.offer(num);
		//either both the heaps will have equal number of elements or max heap will have one
		//more element than the min heap
		if (maxHeap.size() > minHeap.size() + 1)
			minHeap.offer(maxHeap.poll());
		else if (minHeap.size() > maxHeap.size())
			maxHeap.offer(minHeap.poll());
	}

	public static double findMedian() {
		if (maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		else {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
			
	}
}
