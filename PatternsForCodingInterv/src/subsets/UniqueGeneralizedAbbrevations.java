/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class UniqueGeneralizedAbbrevations {

	/**
	 * Given a word write a function to generate all of its unique generalized
	 * abbreviations.
	 * 
	 * Generalized abbreviation of a word can be generated by replacing each
	 * substring of the word by the count of characters in the substring. Take the
	 * example of "ab" which has four substrings: "","a","b" and "ab". After
	 * replacing these substrings in the actual word by the content of characters we
	 * get all the generalized abbreviations: "ab","1b","a1", and "2".
	 * 
	 * Input: "BAT" Output: "BAT","BA1","B1T","B2","1AT","1A1","2T","3"
	 */
	public static void main(String[] args) {
		System.out.println("Generalized abbreviation are: " + generateGeneralizedAbbreviation("BAT"));
		System.out.println("Generalized abbreviation are: " + generateGeneralizedAbbreviation("code"));
	}

	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		List<String> list = new LinkedList<String>();
		result.add(word);
		int len = word.length();
		for (int i = 0; i < len; i++) {
			int n = result.size();
			for (int j = 0; j < n; j++) {
				char[] chr = result.get(j).toCharArray();
				if (i > 0 && Character.isDigit(chr[i - 1])) {
					chr[i] = (char) ((int) chr[i - 1] + 1);
					chr[i - 1] = 0;
				} else
					chr[i] = '1';
				String str = "";
				for (int k = 0; k < len; k++)
					if (chr[k] != 0)
						str += chr[k];
				list.add(str);
				result.add(String.valueOf(chr));
			}
		}
		return list;
	}
}
