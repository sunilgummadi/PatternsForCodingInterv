/**
 * 
 */
package cyclicSort;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindTheDuplicateNumberAct {

	/**
	 * We are given an unsorted array containing n+1 numbers taken from the range 1
	 * to n. The array has only one duplicate but it can be repeated multiple
	 * times.Find that duplicate number without using any extra space You are
	 * however allowed to modify the input array.
	 * 
	 * Input:[1,4,4,3,2] Output:4
	 * 
	 * Input:[2,1,3,3,5,4] Output: 3
	 * 
	 * Input: [2,4,1,4,4] Output: 4
	 */
	public static void main(String[] args) {
		System.out.println("Input:[1,4,4,3,2] Output:4 got : " + findNumber(new int[] { 1, 4, 4, 3, 2 }));
		System.out.println("Input:[2,1,3,3,5,4] Output: 3 got : " + findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
		System.out.println("Input: [2,4,1,4,4] Output: 4 got : " + findNumber(new int[] { 2, 4, 1, 4, 4 }));
	}

	public static int findNumber(int[] nums) {
		int i = 0;
		int j;
		int temp;
		// while swapping if we are swapping the same number them we found the duplicate
		// since there is only one duplicate number
		while (i < nums.length) {

			if (nums[i] != i + 1) {
				j = nums[i] - 1;
				if (nums[i] != nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				} else
					return nums[i];
			} else
				i++;
		}

		return -1;
	}
}
