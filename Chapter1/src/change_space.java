import java.util.Scanner;
public class change_space {
	public static void main(String[] args){
		   System.out.println("Please enter a string");
	       Scanner input = new Scanner(System.in);
	       String str1 = input.nextLine();
	       System.out.println(change_space(str1));
	   }
	public static String change_space(String str1){
		char[] str1Arr = str1.toCharArray();
		char[] strArr = new char[str1.length()*3];
		int i,j=0;
		for(i=0;i<str1.length();i++,j++){
			if(str1Arr[i]==' '){
				strArr[j]='%';
				strArr[j+1]='2';
				strArr[j+2]='0';
				j=j+2;
			}
			else strArr[j]=str1Arr[i];
		}
		//strArr[j]='\0';
		return new String(strArr);
	}

}
