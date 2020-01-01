import java.util.HashMap;
import java.util.Scanner;

public class CoinTotalDenomDP {

    // subproblem
    // guess
    // relate subproblems/recurse
    // memoize
    // find original problem

    static int[]coinDenom;
    static HashMap<Integer, HashMap<Integer, Integer>> map;
    public static int findWays(int sum, int j){
        if(sum == 0){
            return 1;
        }

        if(map.get(sum) != null){
            if(map.get(sum).get(j) != null) {
                return map.get(sum).get(j);
            }
        }

        int count = 0;
        for (int i = j; i < coinDenom.length; i++) {

            if((sum-coinDenom[i]) >= 0){
                count += findWays(sum - coinDenom[i], i);
            }

        }
        if(map.get(sum) == null){
            map.put(sum, new HashMap<>());
        }






        map.get(sum).put(j, count);
        return count;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);




        int num = scan.nextInt();
        int sum = scan.nextInt();




        coinDenom = new int[num];

        for (int i = 0; i < num; i++) {
            coinDenom[i] = scan.nextInt();
        }

        map = new HashMap<>();

        System.out.println(findWays(sum, 0));

    }

}
