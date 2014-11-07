import java.util.Scanner;
public class unique_chars {
	public static void main(String[] args){
		   System.out.println("Please enter a string");
	       Scanner input = new Scanner(System.in);
	       String str1 = input.nextLine();
	       System.out.println(ContainsUniqueChars(str1));
	   }
	private static boolean ContainsUniqueChars(String word) {
		int[] myIntArray = new int[128];
		for(int i=0;i<word.length();i++){
			if(myIntArray[word.charAt(i)]!=0) return false;
			myIntArray[word.charAt(i)]=1;
		}
		return true;
	}

}
