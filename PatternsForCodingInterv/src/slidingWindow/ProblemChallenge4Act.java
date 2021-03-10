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
public class ProblemChallenge4Act {

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

	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> resultIndices = new ArrayList<Integer>();

		HashMap<String, Integer> wordFreq = new HashMap<>();
		int nextWordIndex;
		for (String st : words)
			wordFreq.put(st, wordFreq.getOrDefault(st, 0) + 1);
		int wordCount = words.length;
		int wordLength = words[0].length();
		String word;
		HashMap<String, Integer> wordSeen;
		for (int i = 0; i <= str.length() - wordCount * wordLength; i++) {
			wordSeen = new HashMap<>();
			for (int j = 0; j < wordCount; j++) {
				nextWordIndex = i + j * wordLength;
				// getting the next word from the string
				word = str.substring(nextWordIndex, nextWordIndex + wordLength);
				// break if we don't need this word
				if (!wordFreq.containsKey(word))
					break;
				wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);
				// no need to process further if the word has higher frequency than required
				if (wordSeen.get(word) > wordFreq.getOrDefault(word, 0))
					break;
				if (j + 1 == wordCount)
					resultIndices.add(i);
			}
		}

		return resultIndices;
	}
}
