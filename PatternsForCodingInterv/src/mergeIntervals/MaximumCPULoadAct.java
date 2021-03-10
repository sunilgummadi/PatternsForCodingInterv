/**
 * 
 */
package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author gummadisunil.kumar
 *
 */

//class Job {
//	int start;
//	int end;
//	int cpuLoad;
//
//	public Job(int start, int end, int cpuLoad) {
//		this.start = start;
//		this.end = end;
//		this.cpuLoad = cpuLoad;
//	}
//}

public class MaximumCPULoadAct {

	/**
	 * We are given a list of jobs. Each job has a start time an End time and a CPU
	 * load when it is running. Our goal is to find the maximum CPU load at any time
	 * if all the jobs are running on the same machine.
	 * 
	 * Jobs:[[1,4,3],[2,5,4],[7,9,6]] output: 7 since [1,4,3] & [2,5,4] overlap
	 * their max cpu load 3+4=7
	 * 
	 * Jobs:[[6,7,10],[2,4,11],[8,12,15]] output: 15 none of the jobs overlap so
	 * maximum load is 15
	 * 
	 * Jobs:[[1,4,2],[2,4,1],[3,6,5]] output: 8 max cpu load will be 8 as all jobs
	 * overlap
	 */
	public static void main(String[] args) {
		List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
		System.out.println("Maximum CPU load at any  time:[[1,4,3],[2,5,4],[7,9,6]]  7 got : " + findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
		System.out.println(
				"Maximum CPU load at any  time:[[6,7,10],[2,4,11],[8,12,15]] 15 got : " + findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
		System.out.println("Maximum CPU load at any  time:[[1,4,2],[2,4,1],[3,6,5]] 8 got : " + findMaxCPULoad(input));

	}

	public static int findMaxCPULoad(List<Job> jobs) {
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

		PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
		int maxLoad = 0;
		int currentLoad = 0;
		for (Job job : jobs) {
			while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
				currentLoad -= minHeap.poll().cpuLoad;
			currentLoad += job.cpuLoad;
			minHeap.offer(job);
			maxLoad = Math.max(maxLoad, currentLoad);
		}
		return maxLoad;
	}
}
