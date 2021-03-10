/**
 * 
 */
package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class ProblemChallenge2 {

	/**
	 * String Anagrams :- Given a string and a pattern, find all anagrams of the
	 * pattern in the given string. Write a function to return a list of starting
	 * indices of the anagrams of the pattern in the given string. string="ppqp",
	 * pattern="pq" output:[1,2] string="abbcabc", pattern="abc" output:[2,3,4]
	 * 
	 */
	public static void main(String[] args) {

		System.out.println("string=\"ppqp\", pattern=\"pq\" output:[1,2] got : " + findStringAnagrams("ppqp", "pq"));
		System.out.println(
				"string=\"abbcabc\", pattern=\"abc\" output:[2,3,4] got : " + findStringAnagrams("abbcabc", "abc"));
	}

	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> resultIndices = new ArrayList<Integer>();
		int startIndex = 0;
		int k = pattern.length();
		HashMap<Character, Integer> patternFreq = new HashMap<>();
		int endIndex;
		int matched = 0;
		char rightChar;
		char leftChar;
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
			if (matched == patternFreq.size())
				resultIndices.add(startIndex);
			if (endIndex >= k - 1) {
				leftChar = str.charAt(startIndex++);
				if (patternFreq.containsKey(leftChar)) {

					if (patternFreq.get(leftChar) == 0)
						matched--;
					patternFreq.put(leftChar, patternFreq.get(leftChar) + 1);
				}

			}
		}
		return resultIndices;
	}
}
