import java.util.Scanner;

public class SaddlePoint {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of rows and columns");
        int m= sc.nextInt();
        int n= sc.nextInt();
        int arr[][]= new int[m][n];
        System.out.println("Enter Values for Array");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        if(!printSaddlePoint(arr,m,n)){
            System.out.println(" Saddle Point Not found");
        }

    }

    private static boolean printSaddlePoint(int[][] arr,int rows,int col) {
        for(int i=0;i<rows;i++){
            int minRow=arr[i][0],colInd=0;
            for(int j=1;j<col;j++){
                if(minRow>arr[i][j]){
                    minRow=arr[i][j];
                    colInd=j;
                }
            }
           int k;
            for(k=0;k<rows;k++){
                if(minRow<arr[k][colInd]){
                    break;
                }
                if(k==rows-1){
                    System.out.println("Saddle Point:"+minRow);
                    return true;
                }
            }
        }
           return false;
       }
}
