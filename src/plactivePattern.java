import java.util.regex.*;

public class plactivePattern {

	public static void main(String[] args) {
		String str1 = "a.*";
		Pattern p = Pattern.compile(str1);
		Matcher m = p.matcher("fagava");
		System.out.println(m.matches());
		
		String str2 = "appleorangemelon";
		System.out.println(str2.contains("orange"));
		int index = str2.indexOf("orange");
		System.out.println(index);
		String substr = str2.substring(index, index+6);
        System.out.println(substr);
	}

}
