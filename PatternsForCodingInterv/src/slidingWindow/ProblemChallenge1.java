/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class ProblemChallenge1 {

	/**
	 * Permutations in a String :- Given a string and a pattern, find out if the
	 * string contains any permutation of the pattern If a string has n distinct
	 * characters, it will have n! permutations. 
	 * string="oidbcaf", pattern="abc" output : true 
	 * string="odicf", pattern="dc" output: false 
	 * string="bcdxabcdy" pattern="bcdyabcdx" output: true 
	 * string="aaacb" pattern="abc" output: true
	 */
	public static void main(String[] args) {
		System.out
				.println("string=\"oidbcaf\", pattern=\"abc\" output : true got :" + findPermutation("oidbcaf", "abc"));
		System.out.println("string=\"odicf\", pattern=\"dc\" output : false got :" + findPermutation("odicf", "dc"));
		System.out.println("string=\"bcdxabcdy\", pattern=\"bcdyabcdx\" output : true got :"
				+ findPermutation("bcdxabcdy", "bcdyabcdx"));
		System.out.println("string=\"aaacb\", pattern=\"abc\" output : true got :" + findPermutation("aaacb", "abc"));
		System.out.println("string=\"aaaccb\", pattern=\"abc\" output : false got :" + findPermutation("aaaccb", "abc"));

	}

	public static boolean findPermutation(String str, String pattern) {
		int k = pattern.length();
		if (str == null || str.length() < k) {
			throw new IllegalArgumentException();
		}
		char rightChar;
		char leftChar;
		int endIndex;
		int startIndex = 0;
		// char patternArray[]=pattern.toCharArray();
		// Arrays.sort(patternArray);
		// pattern = new String(patternArray);
		HashMap<Character, Integer> charFreq = new HashMap<>();
		HashMap<Character, Integer> patternFreq = new HashMap<>();
		for (int i = 0; i < k; i++) {
			patternFreq.put(pattern.charAt(i), patternFreq.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
			//System.out.println(charFreq);
			if (endIndex - startIndex + 1 > k) {
				leftChar = str.charAt(startIndex);
				if (charFreq.get(leftChar) == 1)
					charFreq.remove(leftChar);
				else
					charFreq.put(leftChar, charFreq.get(leftChar) - 1);
				startIndex++;
			}
			if (endIndex - startIndex + 1 == k) {
//				System.out.println(charFreq);
//				System.out.println(patternFreq);
//				if (charFreq.size() != patternFreq.size())
//					return false;
//				System.out.println(charFreq);
//				System.out.println(patternFreq.values());
				//if (charFreq.keySet().equals(patternFreq.keySet()) && new ArrayList<>(charFreq.values()).equals(new ArrayList<>(patternFreq.values())))
				if(charFreq.equals(patternFreq))
					return true;
			}
			
		}
		return false;
	}
}
