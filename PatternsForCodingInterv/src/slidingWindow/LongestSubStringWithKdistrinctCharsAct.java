/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class LongestSubStringWithKdistrinctCharsAct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("string = \"araaci\" , k = 2 expected 4 got :" + LongestSubstringDistinct("araaci", 2));
		System.out.println("string = \"araaci\" , k = 1 expected 2 got :" + LongestSubstringDistinct("araaci", 1));
		System.out.println("string = \"cbbebi\" , k = 3 expected 5 got :" + LongestSubstringDistinct("cbbebi", 3));

	}

	public static int LongestSubstringDistinct(String str, int k) {
		int maxLength = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int startIndex = 0;
		int endIndex;
		char firstChar;
		char lastChar;
		// inserting char from the begining of the string until we have K distinct
		// characters in the hashmap
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			if (str == null || str.length() == 0 || str.length() < k)
				throw new IllegalArgumentException();
			lastChar = str.charAt(endIndex);
			map.put(lastChar, map.getOrDefault(lastChar, 0) + 1);
			// shrink the sliding window until we are left with k distinct characters in the
			// frequency map
			while (map.size() > k) {
				firstChar = str.charAt(startIndex);
				if (map.get(firstChar) == 1) {
					map.remove(firstChar);
				} else
					map.put(firstChar, map.get(firstChar) - 1);
				startIndex++;// shrinking the window
			}
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}

		return maxLength;
	}
}
