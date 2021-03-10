/**
 * 
 */
package cyclicSort;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindingMissingNumberAct {

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
		int i = 0;
		int len = nums.length;
		int temp;
		int j;
		while (i < len) {
			if (nums[i] < len && nums[i] != nums[nums[i]]) {
				j = nums[i];
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else
				i++;
		}
		for (i = 0; i < len; i++) {
			if (nums[i] != i)
				return i;
		}
		return len;
	}

}
