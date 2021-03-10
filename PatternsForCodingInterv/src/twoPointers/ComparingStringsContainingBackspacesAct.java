/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class ComparingStringsContainingBackspacesAct {

	/**
	 * Given two strings containing backspaces ('identified by the character #')
	 * check if the two strings are equal.
	 * 
	 * String1 = "xy#z", String2 = "xzz#" output: true
	 * 
	 * String1 = "ay#z", String2 ="xyz#" output: false
	 * 
	 * String1 = "xp#",String2 = "xyz##" output:true
	 * 
	 * String1 = "xywrrmp",String2 = "xywrrmu#p" output:true
	 */
	public static void main(String[] args) {
		System.out.println("String1 = \"xy#z\", String2 = \"xzz#\" output: true got : " + compare("xy#z", "xzz#"));
		System.out.println("String1 = \"ay#z\", String2 =\"xyz#\" output: false got : " + compare("ay#z", "xyz#"));
		System.out.println("String1 = \"xp#\",String2 = \"xyz##\" output:true got : " + compare("xp#", "xyz##"));
		System.out.println(
				"String1 = \"xywrrmp\",String2 = \"xywrrmu#p\" output:true got : " + compare("xywrrmp", "xywrrmu#p"));
	}

	public static boolean compare(String str1, String str2) {
		int str1Pointer = str1.length() - 1;
		int str2Pointer = str2.length() - 1;
		while (str1Pointer >= 0 || str2Pointer >= 0) {
			int i1 = findNextChar(str1, str1Pointer);
			int i2 = findNextChar(str2, str2Pointer);
			if (i1 < 0 && i2 < 0)
				return true;
			if (i1 < 0 || i2 < 0)
				return false;
			if (str1.charAt(i1) != str2.charAt(i2))
				return false;
			str1Pointer = i1 - 1;
			str2Pointer = i2 - 1;
		}
		return true;
	}

	public static int findNextChar(String str, int index) {
		int backSpaceCounter = 0;
		while (index >= 0) {
			if (str.charAt(index) == '#')
				backSpaceCounter++;
			else if (backSpaceCounter > 0)
				backSpaceCounter--;
			else
				break;
			index--;
		}
		return index;
	}

}
