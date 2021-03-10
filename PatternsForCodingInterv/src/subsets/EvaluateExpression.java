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
public class EvaluateExpression {

	/**
	 * Given an expression containing digits and operations(+,-,*), find all
	 * possible ways in which the expression can be evaluated by grouping the
	 * numbers and operators using parentheses.
	 * 
	 * Input: "1+2*3" Output:7,9 Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
	 * 
	 * Input:"2*3-4-5" Output: 8,-12,7,-7,-3 Explanation: 2*(3-(4-5))=>8, 2*(3-4-5)
	 * =>-12,2*3-(4-5)=>7, 2*(3-4)-5=>-7,(2*3)-4-5=>-3
	 */
	public static void main(String[] args) {
		System.out.println("Expression evaluations: " + diffWaysToEvaluateExpression("1+2*3"));
		System.out.println("Expression evaluations: " + diffWaysToEvaluateExpression("2*3-4-5"));
	}

	public static List<Integer> diffWaysToEvaluateExpression(String input) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		if (map.containsKey(input))
			return map.get(input);
		List<Integer> result = new ArrayList<>();
		if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
			result.add(Integer.parseInt(input));
		} else {
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (!Character.isDigit(ch)) {
					List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
					List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
					for (Integer val1 : left) {
						for (Integer val2 : right) {
							if (ch == '+')
								result.add(val1 + val2);
							else if (ch == '-')
								result.add(val1 - val2);
							else if (ch == '*')
								result.add(val1 * val2);
						}
					}
				}
			}
		}
		map.put(input, result);
		return result;
	}
}
