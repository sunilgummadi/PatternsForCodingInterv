/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class NoRepeatSubStringAct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("string = \"aabccbb\" expected 3 got :" + findLength("aabccbb"));
		System.out.println("string = \"abbbb\" expected 2 got :" + findLength("abbbb"));
		System.out.println("string = \"abccde\" expected 3 got :" + findLength("abccde"));
		System.out.println("string = \"abdccdeabcdefgh\" expected 8 got :" + findLength("abdccdeabcdefgh"));
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
				// here we are getting the next index of right index before inserting into map
				// which can be understood by seeing the last example
				startIndex = charFreq.get(rightChar) + 1;
			}
			charFreq.put(rightChar, endIndex);
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}
		return maxLength;
	}
}
