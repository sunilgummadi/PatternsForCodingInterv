/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class ProblemChallenge3 {

	/**
	 * Smallest window containing Substring:- Given a string and a pattern find the
	 * smallest substring in the given string which has all the characters of the
	 * given pattern string="aabdec" pattern="abc" output="abdec" string="abdbca"
	 * pattern="abc" output="bca" string="adcad" pattern="abc" output=""
	 */
	public static void main(String[] args) {
		System.out
				.println(" string=\"aabdec\" pattern=\"abc\" output=\"abdec\" got : " + findSubstring("aabdec", "abc"));
		System.out.println(" string=\"abdbca\" pattern=\"abc\" output=\"bca\" got : " + findSubstring("abdbca", "abc"));
		System.out.println(" string=\"adcad\" pattern=\"abc\" output=\"\" got : " + findSubstring("adcad", "abc"));
	}
//i have seen the solution
	public static String findSubstring(String str, String pattern) {
		int startIndex = 0;
		int endIndex;
		char rightChar;
		char leftChar;
		HashMap<Character, Integer> patternFreq = new HashMap<>();
		int matched = 0;
		int k = pattern.length();
		int minLength = str.length() + 1;
		int charStartIndex = 0;
		for (int i = 0; i < k; i++) {
			patternFreq.put(pattern.charAt(i), patternFreq.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			if (patternFreq.containsKey(rightChar)) {
				patternFreq.put(rightChar, patternFreq.get(rightChar) - 1);
				if (patternFreq.get(rightChar) == 0)
					matched++;
			}

			while (matched == patternFreq.size()) {
				if (minLength > endIndex - startIndex + 1) {
					minLength = endIndex - startIndex + 1;
					charStartIndex = startIndex;
				}

				leftChar = str.charAt(startIndex++);
				if (patternFreq.containsKey(leftChar)) {
					if (patternFreq.get(leftChar) == 0)
						matched--;
					patternFreq.put(leftChar, patternFreq.get(leftChar) + 1);
				}
			}

		}
		return minLength > str.length() ? "" : str.substring(charStartIndex, charStartIndex + minLength);
	}
}
