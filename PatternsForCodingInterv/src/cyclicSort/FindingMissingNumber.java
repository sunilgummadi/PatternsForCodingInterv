/**
 * 
 */
package cyclicSort;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindingMissingNumber {

	/**
	 * We are given an array containing n distinct numbers taken from the range 0 to
	 * n. Since the array has only n numbers out of the total n+1 numbers find the
	 * missing number.
	 * 
	 * Input: [4,0,3,1] Output: 2
	 * 
	 * Input: [8,3,5,2,4,6,0,1] Output: 7
	 */
	public static void main(String[] args) {
		System.out.println("Input: [4,0,3,1] Output: 2 got :" + findMissingNumber(new int[] { 4, 0, 3, 1 }));
		System.out.println(
				"Input: [8,3,5,2,4,6,0,1] Output: 7 got :" + findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	}

	public static int findMissingNumber(int[] nums) {
		int sum = 0;
		int len = nums.length - 1;
		int max = 0;
		int reqSum = (len * (len + 1)) / 2;
		for (int i = 0; i <= len; i++) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}
		sum -= max;
		return reqSum - sum;
	}
}
