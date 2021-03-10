/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class ComparingStringsContainingBackspaces {

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

		String newStr1 = remove(str1);
		String newStr2 = remove(str2);
		return newStr1.equals(newStr2);

	}
	
	public static String remove(String str1) {
		int left = 0;
		int firstIndex = str1.indexOf('#');
		int lastIndex = 0;
		int len = str1.length();
		String newStr1;
		if (firstIndex > -1)
			lastIndex = str1.lastIndexOf('#');
		firstIndex = firstIndex == -1 ? 0 : firstIndex;
		lastIndex = lastIndex == 0 ? str1.length() - 1 : lastIndex;

		if (firstIndex == lastIndex)
			newStr1 = str1.substring(left, firstIndex - 1) + str1.substring(firstIndex + 1);
		else if (firstIndex == 0)
			newStr1 = str1.substring(left, lastIndex + 1);
		else
			newStr1 = str1.substring(left, len - 2 * (lastIndex - firstIndex + 1));
		//System.out.println(newStr1);
		return newStr1;
	}
}
