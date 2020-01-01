import java.util.HashMap;
import java.util.Scanner;

public class solutionToLinearEquation {

    // subproblem
    // guess
    // relate subproblems (recurse)
    // memoize
    // find original problem

    static int[] coefficients;
    static HashMap<String, Integer> map;



    public static int findNum(int i, int sum){
        if(sum == 0){ return 1;};
        if(i > coefficients.length-1){
            return sum == 0 ? 1 : 0;
        }






        if(map.get(i + "|" + sum) != null){
            return map.get(i + "|" + sum);
        }

        int count = 0;
        for (int j = 0; j <= (sum / coefficients[i]); j++) {

            count += findNum(i+1, sum - j*coefficients[i]);

        }

        map.put(i + "|" + sum, count);
        return count;

    }

    public static void main(String[] args) {





        Scanner scan = new Scanner(System.in);


        int num = scan.nextInt();
        int sum = scan.nextInt();

        coefficients = new int[num];
        map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            coefficients[i] = scan.nextInt();
        }


        System.out.println(findNum(0, sum));

    }

}
