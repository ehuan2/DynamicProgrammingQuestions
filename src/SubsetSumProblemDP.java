import java.util.Scanner;

public class SubsetSumProblemDP {

    static int[] array;
    static int[][]memo;
    public static boolean findSum(int i, int sum){

        if(sum == 0){
            return true;
        }

        if(i == array.length){
            return false;
        }




        return findSum(i+1, sum-array[i]) || findSum(i+1, sum);


    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);


        int num = scan.nextInt();
        int sum = scan.nextInt();
        array = new int[num];

        for(int i = 0; i <= num-1; i++){
            array[i] = scan.nextInt();
        }

        System.out.println(findSum(0, sum));

    }



}
