/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class LongestSubstringWithSameLettersAfterReplacement {

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
//it doesn't worked so stopped working on it and saw the solution
	public static int findLength(String str, int k) {
		if (str == null || str.length() == 0 || str.length() < k)
			throw new IllegalArgumentException();
		int maxLength = 0;
		HashMap<Character, Integer> charFreq = new HashMap<>();
		char rightChar;
		char leftChar;
		int endIndex;
		int sum =0;
		int max;
		int startIndex = 0;
		int temp;
		boolean check;
		for (endIndex = 0; endIndex < str.length(); endIndex++) {
			rightChar = str.charAt(endIndex);
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
			max=0;
			System.out.println(charFreq.values());
			for(int i:charFreq.values()) {
				if (max<i)
					max = i;
				sum += i;
			}
			System.out.println(max);
			temp = sum - k;
			check = false;
			for(int j = 0;j<=endIndex;j++) {
				if (temp==charFreq.get(str.charAt(j)))
					check = true;
			}
				if (check) {
					maxLength = Math.max(maxLength, endIndex - startIndex + 1);
				}
							
			if(sum-k==1) {
				leftChar = str.charAt(startIndex);
				System.out.println(charFreq);
				if (charFreq.get(leftChar) == 1)
					charFreq.remove(leftChar);
				else
					charFreq.put(leftChar, charFreq.get(leftChar) - 1);
				startIndex++;
			
			}
			
		}
		return maxLength;
	}
}
