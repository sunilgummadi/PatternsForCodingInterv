/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gummadisunil.kumar
 *
 */
public class StringPermutationsByChangingCase {

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
		char[] chr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < chr.length; i++) {
			if (chr[i] - 'a' >= 0 && chr[i] - 'a' < 26) {
				map.put(chr[i], i);
			}
		}
		permutations.add(str);
		for (int i : map.values()) {
			int n = permutations.size();
			for (int j = 0; j < n; j++) {
				chr = permutations.get(j).toCharArray();
				chr[i] = (char) (chr[i] - 32);
				permutations.add(new String(chr));
			}
		}
		return permutations;
	}
}
