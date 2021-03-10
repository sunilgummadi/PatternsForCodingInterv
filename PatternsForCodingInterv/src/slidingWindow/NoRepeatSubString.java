/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class NoRepeatSubString {

	/**
	 * Given a string, find the length of the longest substring which has no
	 * repeating characters string = "aabccbb" output : 3(abc) string = "abbbb"
	 * output : 2(ab) string = "abccde" output : 3(abc,cde)
	 */
	public static void main(String[] args) {
		System.out.println("string = \"aabccbb\" expected 3 got :" + findLength("aabccbb"));
		System.out.println("string = \"abbbb\" expected 2 got :" + findLength("abbbb"));
		System.out.println("string = \"abccde\" expected 3 got :" + findLength("abccde"));
		//this logic failed for the input abdccdeabcdefgh expected was 8 but getting 4
	}

	public static int findLength(String str) {
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException();
		int maxLength = 0;
		int startIndex = 0;
		int endIndex;
		char rightChar;
		HashMap<Character, Integer> charFreq = new HashMap<>();
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			if (charFreq.containsKey(rightChar)) {
				if (charFreq.get(rightChar) == 1)
					startIndex = endIndex;
			} else
				charFreq.put(rightChar, 1);

			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}
		return maxLength;
	}

}
