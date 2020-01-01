import java.util.Scanner;

public class RodCuttingDP {

    // define subproblem
    // guess
    // define recursion and relate subproblems
    // memoize
    // find original problem

    static int[] rodLength;
    static int[] weight;
    public static int findMax(int i, int length){

        if(length <= 0){
            return 0;
        }


        int max = 0;


        for(int j = i; j <= rodLength.length-1; j++){

            if(length - rodLength[j] < 0){
                continue;
            }

            max = Integer.max(findMax(j, length-rodLength[j]) + weight[j], max);

        }

        return max;

    }


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int length = scan.nextInt();
        rodLength = new int[num];

        weight = new int[num];



        for(int i = 0; i <= num-1; i++){
            rodLength[i] = scan.nextInt();
        }

        for(int j = 0; j <= num-1; j++){
             weight[j] = scan.nextInt();
        }



        System.out.println(findMax(0, length));

    }

}
