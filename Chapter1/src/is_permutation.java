import java.util.Scanner;
public class is_permutation {
	public static void main(String[] args){
		   System.out.println("Please enter a string");
	       Scanner input = new Scanner(System.in);
	       String str1 = input.nextLine();
	       System.out.println("Please enter the second string");
	       String str2 = input.nextLine();
	       System.out.println(is_permutation(str1, str2));
	   }
	private static boolean is_permutation(String str1, String str2) {
		if(str1.length()!=str2.length()) return false;
		else if(str1.equals(str2)) return true;
		else{
			int[] Array1 = new int[256];
			int[] Array2 = new int[256];
			int i,j,k;
			char c1, c2;
			for(i=0;i<str1.length();i++)
			{
				c1=str1.charAt(i);
				c2=str2.charAt(i);
				j=(int) c1;
				k=(int) c2;
				Array1[j]++;
				Array2[k]++;
			}
			for(i=0;i<256;i++)
				if(Array1[i]!=Array2[i]) return false;
			return true;
		}
	}

}
