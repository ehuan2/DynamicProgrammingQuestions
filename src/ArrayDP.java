import java.util.Scanner;

public class ArrayDP {

    public static int sumOfArray(int[]a, int[]b, int start, int end){
        int sum = 0; boolean go = false;
        for(int i = start-1; i <= end-1; i++){
            sum += !go ? a[i] : b[i];
            go = !go;
        }
        return sum;
    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int numTests = scan.nextInt();

        int [] a = new int[size];
        int[] b = new int[size];

        for(int i = 0; i <= size - 1; i++){
            a[i] = scan.nextInt();
        }

        for(int i = 0; i <= size-1; i++){
            b[i] = scan.nextInt();
        }

        for(int i = 0; i <= numTests - 1; i++){

            int first = scan.nextInt();
            int start = scan.nextInt();
            int end = scan.nextInt();


            System.out.println(sumOfArray(first == 1 ? a : b, first == 1 ? b : a, start, end));


        }


    }


}
