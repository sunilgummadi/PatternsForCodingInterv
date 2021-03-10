/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class RemoveDuplicates {

	/**
	 * Given an array of sorted numbers remove all duplicates from it. You should
	 * not use any extra space after removed the duplicates in place return the
	 * length of the sub array that has no duplicates in it. input:[2,3,3,3,6,9,9]
	 * output:4 [2,3,6,9] input:[2,2,2,11] output: 2 [2,11]
	 */
	public static void main(String[] args) {
		System.out
				.println("input:[2,3,3,3,6,9,9] output:4 [2,3,6,9] got : " + remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
		System.out.println("input:[2,2,2,11] output:2 [2,11] got : " + remove(new int[] { 2, 2, 2, 11 }));
		System.out.println("input:[2,2,2,2] output:1 [2] got : " + remove(new int[] { 2, 2, 2, 2 }));
	}

	public static int remove(int[] arr) {

		int start = 0;
		int count = 0;
		for (int end = 1; end < arr.length; end++) {
			if (arr[start] != arr[end])
				count++;
			start++;
		}
		return count + 1;
	}
}
