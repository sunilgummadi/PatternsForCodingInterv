/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class ProblemChallenge1Act {

	/**
	 * Permutations in a String :- Given a string and a pattern, find out if the
	 * string contains any permutation of the pattern If a string has n distinct
	 * characters, it will have n! permutations. string="oidbcaf", pattern="abc"
	 * output : true string="odicf", pattern="dc" output: false string="bcdxabcdy"
	 * pattern="bcdyabcdx" output: true string="aaacb" pattern="abc" output: true
	 */
	public static void main(String[] args) {
		System.out
				.println("string=\"oidbcaf\", pattern=\"abc\" output : true got :" + findPermutation("oidbcaf", "abc"));
		System.out.println("string=\"odicf\", pattern=\"dc\" output : false got :" + findPermutation("odicf", "dc"));
		System.out.println("string=\"bcdxabcdy\", pattern=\"bcdyabcdx\" output : true got :"
				+ findPermutation("bcdxabcdy", "bcdyabcdx"));
		System.out.println("string=\"aaacb\", pattern=\"abc\" output : true got :" + findPermutation("aaacb", "abc"));
		System.out
				.println("string=\"aaaccb\", pattern=\"abc\" output : false got :" + findPermutation("aaaccb", "abc"));

	}

	public static boolean findPermutation(String str, String pattern) {
		int k = pattern.length();
		if (str == null || str.length() < pattern.length()) {
			throw new IllegalArgumentException();
		}
		char rightChar;
		char leftChar;
		int endIndex;
		int startIndex = 0;
		int matched = 0;
		// HashMap<Character, Integer> charFreq = new HashMap<>();
		HashMap<Character, Integer> patternFreq = new HashMap<>();
		for (int i = 0; i < k; i++) {
			patternFreq.put(pattern.charAt(i), patternFreq.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			if (patternFreq.containsKey(rightChar)) {
				// decrement the frequency at the matched character
				patternFreq.put(rightChar, patternFreq.get(rightChar) - 1);
				if (patternFreq.get(rightChar) == 0)// character is completely matched
					matched++;
			}

			if (matched == patternFreq.size())
				return true;
			if (endIndex >= k - 1) {
				leftChar = str.charAt(startIndex);
				if (patternFreq.containsKey(leftChar)) {
					if (patternFreq.get(leftChar) == 0)
						matched--;
					// put the character back for matching
					patternFreq.put(leftChar, patternFreq.get(leftChar) + 1);

				}
				startIndex++;
			}

		}
		return false;
	}
}
