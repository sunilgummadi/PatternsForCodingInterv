/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class StringPermutationsByChangingCaseAct {

	/**
	 * Given a string find all of its permutations preserving the character sequence
	 * but changing case.
	 * 
	 * Input:"ad52" Output:"ad52","Ad52","aD52","AD52"
	 * 
	 * Input:"ab7c" Output:"ab7c","Ab7c","aB7c","AB7c","ab7C","Ab7C","aB7C","AB7C"
	 */
	public static void main(String[] args) {
		System.out.println("String permutations are : " + findLetterCaseStringPermutations("ad52"));
		System.out.println("String permutations are : " + findLetterCaseStringPermutations("ab7z"));
	}

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<String>();
		if (str == null)
			return permutations;
		permutations.add(str);
		// process every character of the string one by one
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				// we will take all existing permutations and change the letter case
				// appropriately
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] chr = permutations.get(j).toCharArray();
					// if the current character is in upper case change it to lower case or vice
					// versa
					if (Character.isUpperCase(chr[i]))
						chr[i] = Character.toLowerCase(chr[i]);
					else
						chr[i] = Character.toUpperCase(chr[i]);
					permutations.add(String.valueOf(chr));
				}
			}
		}
		return permutations;
	}
}
