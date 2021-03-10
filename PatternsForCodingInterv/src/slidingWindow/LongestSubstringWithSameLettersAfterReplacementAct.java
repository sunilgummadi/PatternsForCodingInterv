/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class LongestSubstringWithSameLettersAfterReplacementAct {

	/**
	 * Given a string lower case letters only, if you are allowed to replace no more
	 * than k letters with any letter, find the length of the longest substring
	 * having the same letters after replacement. string="aabccbb", k=2 output
	 * :5(bbbbb) string ="abbcb", k=1 output :4(bbbb) string="abccde", k=1 output
	 * :3(ccc)
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("string = \"aabccbb\" , k = 2 expected 5 got :" + findLength("aabccbb", 2));
		System.out.println("string = \"abbcb\" , k = 1 expected 4 got :" + findLength("abbcb", 1));
		System.out.println("string = \"abccde \" , k = 1 expected 3 got :" + findLength("abccde", 1));

	}

	// it doesn't worked
	public static int findLength(String str, int k) {
		if (str == null || str.length() == 0 || str.length() < k)
			throw new IllegalArgumentException();
		int maxLength = 0;
		HashMap<Character, Integer> charFreq = new HashMap<>();
		char rightChar;
		char leftChar;
		int endIndex;
		int startIndex = 0;
		int maxCharLength = 0;
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
			// creating global level max instead of window size max because we need max
			// substring length this can be achieved by max char length of whole string
			maxCharLength = Math.max(maxCharLength, charFreq.get(rightChar));
			if (endIndex - startIndex + 1 - maxCharLength > k) {
				leftChar = str.charAt(startIndex);
				charFreq.put(leftChar, charFreq.get(leftChar) - 1);
				startIndex++;
			}
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}
		return maxLength;
	}
}
