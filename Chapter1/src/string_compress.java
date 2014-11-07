import java.util.Scanner;
public class string_compress {
	public static void main(String[] args){
		   System.out.println("Please enter a string");
	       Scanner input = new Scanner(System.in);
	       String str1 = input.nextLine();
	       System.out.println(string_compress(str1));
	   }

	private static String string_compress(String str) {
		char[] strArr = str.toCharArray();
		StringBuilder str1 = new StringBuilder();
		int i=0;
		int j=1;
		int count=1;
		boolean comp=false;
		while(i<str.length()){
			str1.append(strArr[i]);
			while(j<str.length()&&strArr[j]==strArr[i]){
				comp=true;
				j++;
				count++;
			}
			if(count>1||comp==true) str1.append(count);
			i=j;
			j++;
			count=1;
		}
		return str1.toString();
	}

}
