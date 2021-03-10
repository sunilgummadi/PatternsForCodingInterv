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
// class ParenthesesString {
// String str;
// int openCount;
// int closeCount;
//
// public ParenthesesString(String str, int openCount, int closeCount) {
// this.str = str;
// this.openCount = openCount;
// this.closeCount = closeCount;
// }
// }

public class BalancedParenthesisRecursion {

	/**
	 * For a given number N write a function to generate all combination of N pairs
	 * of balanced parentheses.
	 * 
	 * N=2 Output:(()),()()
	 * 
	 * N=3 Output: ((())),(()()),(())(),()(()),()()()
	 */
	public static void main(String[] args) {
		System.out.println("All combinations of balanced parentheses are: " + generateValidParentheses(2));
		System.out.println("All combinations of balanced parentheses are: " + generateValidParentheses(3));
	}
	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		generateParenthesesRecursion(result, new ParenthesesString("", 0, 0), num);
		return result;
	}

	public static void generateParenthesesRecursion(List<String> result, ParenthesesString ps, int num) {

		if (ps.openCount == num && ps.closeCount == num) {
			result.add(ps.str);
		} else {
			if (ps.openCount < num) {
				generateParenthesesRecursion(result,
						new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount), num);
			}
			if (ps.closeCount < ps.openCount) {
				generateParenthesesRecursion(result,
						new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1), num);
			}

		}
	}
}
