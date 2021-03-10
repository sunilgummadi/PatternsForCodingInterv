package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class LongestSubStringWithKdistrinctChars {

	/**
	 * Given a string find the length of the longest substring in it with no more
	 * than K distinct characters string = "araaci" , k = 2 and output : 4(araa)
	 * string = "araaci", k = 1 and output : 2(aa) string = "cbbebi", k = 3 and
	 * output : 5 (cbbeb,bbebi)
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
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			lastChar = str.charAt(endIndex);
			if (map.containsKey(lastChar))
				map.put(lastChar, map.get(lastChar) + 1);
			else
				map.put(lastChar, 1);
			while (map.size() > k) {
				firstChar = str.charAt(startIndex);
				if (map.get(firstChar) == 1)
					map.remove(firstChar);
				else
					map.put(firstChar, map.get(firstChar) - 1);

				startIndex++;
			}
			if (map.size() == k && maxLength < (endIndex - startIndex + 1)) {
				maxLength = (endIndex - startIndex + 1);
			}
		}
		return maxLength;
	}
}
