/**
 * 
 */
package twoHeaps;

import java.util.PriorityQueue;

/**
 * @author gummadisunil.kumar
 *
 */
public class MaximizeCapital {

	/**
	 * Given a set of investment projects with their respective profits, we need to
	 * find the most profitable projects. We are given an initial capital and are
	 * allowed to invest only in a fixed number of projects. Our goal is to choose
	 * projects that give us the maximum profit. Write a function that returns the
	 * maximum total capital after selecting the most profitable projects.
	 * 
	 * We can start an investment project only when we have the required capital.
	 * Once a project is selected we can assume that its profit has become our
	 * capital.
	 * 
	 * Ex-1:
	 * 
	 * Input: Project Capitals =[0,1,2], Project profits=[1,2,3], initial capital =1
	 * Number of projects = 2; output:6
	 * 
	 * Explanation:
	 * 
	 * 1.With initial capital of 1 we will start the second project which will give
	 * us profit of 2. Once we selected our first project our total capital will
	 * become 3(profit+initial capital)
	 * 
	 * 2.With 3 capital we will select the third project which will give us 3
	 * profit.
	 * 
	 * After completion of the two projects, our total capital will be 6 (1+2+3)
	 */
	public static void main(String[] args) {
		System.out.println(
				"Maximum capital : 6 got : " + findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1));
		System.out.println("Maximum capital : 8 got :"
				+ findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0));
	}

	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		int n = capital.length;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i2] - capital[i1]);
		for (int i = 0; i < n; i++) {
			minHeap.offer(i);
		}
		int capitalProfit = initialCapital;
		for (int i = 0; i < numberOfProjects; i++) {
			//find all projects that can be selected within the available capital and insert them in a max heap
			while (!minHeap.isEmpty() && capital[minHeap.peek()] <= capitalProfit)
				maxHeap.offer(minHeap.poll());

			// terminate if we are not able to find any project that can be completed within
			// the available capital
			if (maxHeap.isEmpty())
				break;
			capitalProfit += profits[maxHeap.poll()];
		}
		return capitalProfit;
	}

}
