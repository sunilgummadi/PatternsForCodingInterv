/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gummadisunil.kumar
 *
 */
class ParenthesesString {
	String str;
	int openCount;
	int closeCount;

	public ParenthesesString(String str, int openCount, int closeCount) {
		this.str = str;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}
}

public class BalancedParenthesis {

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
		Queue<ParenthesesString> queue = new LinkedList<>();
		queue.add(new ParenthesesString("", 0, 0));
		while (!queue.isEmpty()) {
			ParenthesesString ps = queue.poll();
			if (ps.openCount == num && ps.closeCount == num)
				result.add(ps.str);
			else {
				if (ps.openCount < num)
					queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
				if (ps.openCount > ps.closeCount)
					queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
			}
		}
		return result;
	}
}
