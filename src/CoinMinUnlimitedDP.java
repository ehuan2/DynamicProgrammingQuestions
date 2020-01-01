import java.util.HashMap;
import java.util.Scanner;

public class CoinMinUnlimitedDP {

    // subproblem
    // guess

    // relate subproblems, find recursion
    // memoize or tabulate
    // find original problem
    static int[] coinDenom; static HashMap<Integer, Integer>memoDP;
    public static int findMin(int sum){

        if(sum == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;















        if(memoDP.get(sum) != null){
            return memoDP.get(sum);
        }

        for(int i = 0; i <= coinDenom.length-1; i++){
            if((sum-coinDenom[i]) >= 0){
                min = Integer.min(findMin(sum-coinDenom[i]) + 1, min);
            }
        }

        memoDP.put(sum, min);
        return min;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(); int sum = scan.nextInt();

        coinDenom = new int[num];



        memoDP = new HashMap<>();

        for(int i = 0; i <= num-1; i++){
            coinDenom[i] = scan.nextInt();
        }

        System.out.println(findMin(sum));

    }

}
