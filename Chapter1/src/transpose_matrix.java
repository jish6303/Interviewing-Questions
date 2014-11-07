import java.util.Scanner;
public class transpose_matrix {
	public static void main(String[] args){
		   System.out.println("Please enter the size of the 2D array");
	       Scanner input1, input2;
	       input1 = new Scanner(System.in);
	       int i,j;
	       int N = input1.nextInt();
	       int[][] Array= new int[N][N];
	       for(i=0;i<N;i++){
	    	   for(j=0;j<N;j++){
	    		   System.out.printf("Please input element[%d] of line %d\n", j,i+1);
	    		   input2 = new Scanner(System.in);
	    		   Array[i][j]=input2.nextInt();
	    	   }
	       }
	       System.out.println("The 2D array before transposition clockwise 90 degree is:");
	       for(i=0;i<N;i++){
	    	   for(j=0;j<N;j++){
	    		   System.out.printf("%d ", Array[i][j]);
	    	   }
	    	   System.out.printf("\n");
	       }
	       transpose90_array(Array, N);
	       System.out.println("The 2D array after transposition clockwise 90 degree is:");
	       for(i=0;i<N;i++){
	    	   for(j=0;j<N;j++){
	    		   System.out.printf("%d ", Array[i][j]);
	    	   }
	    	   System.out.printf("\n");
	       }
	   }

	private static void transpose90_array(int[][] matrix, int n) {
		int first,last,temp;
		for(int i=0;i<n/2;i++){
			first =i;
			last= n-i-1;
			for(int j= first;j<last;j++){
				temp=matrix[i][j];
				matrix[i][j]=matrix[last-j][i];
				matrix[last-j][i]=matrix[last-i][last-j];
				matrix[last-i][last-j]=matrix[j][last-i];
				matrix[j][last-i]=temp;
			}
		}
	}
}
