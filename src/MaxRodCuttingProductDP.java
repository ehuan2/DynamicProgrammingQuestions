import java.util.Scanner;

public class MaxRodCuttingProductDP {

    // find subproblem
    // guess
    // relate subproblems/recurse
    // memoize

    // find original problem

static int[]memoDP;


public static int findMaxProduct(int length){
        if(length <= 1){
            return 1;
        }

        if(memoDP[length] != 0){
            return memoDP[length];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= length; i++){

            max = Integer.max(findMaxProduct(length - i) * i, max);

        }
        memoDP[length] = max;
        return memoDP[length];

    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        memoDP = new int[length+1];
        System.out.println(findMaxProduct(length));

    }



}
