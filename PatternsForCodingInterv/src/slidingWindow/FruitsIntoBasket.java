/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class FruitsIntoBasket {

	/**
	 * Given an array of characters where each character represents a fruit tree you
	 * are given two baskets and your goal is to put maximum number of fruits in
	 * each basket. The only restriction is that each basket can have only one type
	 * of fruit. You can start with any tree but you can't skip a tree once you have
	 * started. You will pick a fruit from each tree until you cannot, you will stop
	 * when you have to pick from a third fruit type. string = ['A','B','C','A','C']
	 * Output 3 (['C','A','C']) string = ['A','B','C','B','B','C'] Output 5
	 * (['B','C','B','B','C'])
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("string = ['A','B','C','A','C'] , expected 3 got : "
				+ findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("string = ['A','B','C','B','B','C'] , expected 5 got : "
				+ findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

	}

	public static int findLength(char[] arr) {
		if (arr.length == 0 || arr.length < 2)
			throw new IllegalArgumentException();
		int maxLength = 0;
		char leftChar;
		char rightChar;
		int startIndex = 0;
		int endIndex;
		HashMap<Character, Integer> charFreq = new HashMap<>();
		for (endIndex = 0; endIndex < arr.length; endIndex++) {
			rightChar = arr[endIndex];
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
			while (charFreq.size() > 2) {
				
				leftChar = arr[startIndex++];
				if (charFreq.get(leftChar) == 1)
					charFreq.remove(leftChar);
				else
					charFreq.put(leftChar, charFreq.get(leftChar) - 1);
				
			}
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}
		return maxLength;
	}
}
