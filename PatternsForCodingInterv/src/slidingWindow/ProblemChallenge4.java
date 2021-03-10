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
public class ProblemChallenge4 {

	/**
	 * Given a string and a list of words, find all the starting indices of
	 * substring in the given string that are a concatenation of all the given words
	 * exactly once without any overlapping of words It is given that all words are
	 * of the same length. string="catfoxcat" words=["cat","fox"] output:[0,3]
	 * string="catcatfoxfox" words=["cat","fox"] output:[3]
	 */
	public static void main(String[] args) {
		System.out.println("string=\"catfoxcat\" words=[\"cat\",\"fox\"] output:[0,3] got : "
				+ findWordConcatenation("catfoxcat", new String[] { "cat", "fox" }));
		System.out.println("string=\"catcatfoxfox\" words=[\"cat\",\"fox\"] output:[3] got : "
				+ findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" }));
	}
//passed one test case only
	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> resultIndices = new ArrayList<Integer>();
		String pattern = "";
		for (int i = 0; i < words.length; i++) {
			pattern += words[i];
		}
		HashMap<Character, Integer> patternFreq = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++)
			patternFreq.put(pattern.charAt(i), patternFreq.getOrDefault(pattern.charAt(i), 0) + 1);
		int startIndex = 0;
		int endIndex;
		char leftChar;
		char rightChar;
		int matched = 0;
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			if (patternFreq.containsKey(rightChar)) {
				patternFreq.put(rightChar, patternFreq.get(rightChar) - 1);
				if (patternFreq.get(rightChar) == 0)
					matched++;
				
			}
			if (endIndex-startIndex +1 > pattern.length()) {
				leftChar = str.charAt(startIndex++);
				if (patternFreq.containsKey(leftChar)) {
					//System.out.println(patternFreq);
					if (patternFreq.get(leftChar) == 0)
						matched--;
					patternFreq.put(leftChar, patternFreq.get(leftChar) + 1);
				}
			}
			if (matched == patternFreq.size()) {
				resultIndices.add(startIndex);
			}
			
		}
		return resultIndices;
	}
}
