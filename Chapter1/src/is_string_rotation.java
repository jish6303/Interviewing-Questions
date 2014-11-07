import java.util.Scanner;
public class is_string_rotation {
	public static void main(String[] args){
		   System.out.println("Please enter a string");
	       Scanner input = new Scanner(System.in);
	       String str1 = input.nextLine();
	       System.out.println("Please enter the second string");
	       String str2 = input.nextLine();
	       System.out.println(is_rotation(str1, str2));
	   }

	public static boolean is_rotation(String str1, String str2) {
		if(first_rotates_second(str1,str2)||first_rotates_second(str2,str1)) return true;
		else return false;
	}

	public static boolean first_rotates_second(String str1, String str2) {
		if(str1.length()!=str2.length()) return false;
		else{
			for(int i=0;i<str2.length();i++)
			{
				String str2_1=str2.substring(0,i+1);
				String str2_2=str2.substring(i+1,str2.length());
				String newstr2=str2_2+str2_1;
				if(newstr2.equals(str1)) return true;
			}
			return false;
		}
	}

}
