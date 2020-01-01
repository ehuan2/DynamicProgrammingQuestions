import java.util.Scanner;

public class MaxValueExpressionDP { // following is a DP that evaluates the max value of an expression, where a[s] - a[j] + a[k] - a[l], where s > j > k > l
    static int[]array;
    static int[][]memo;
    static int[]hold = new int[4];
    public static int findMax(int count, int i){ // essentially a DP that takes in prefixes

        if(count == -1 || i == -1){
            return 0;
        }

        if(memo[count][i] == 0) {
            int max = Integer.MIN_VALUE;
            for (int j = count; j <= i - 1; j++) {
                max = Integer.max(findMax(count - 1, j) + array[j]*(count % 2 == 1 ? 1 : -1), max);
            }
            memo[count][i] = max;
            hold[count] = max;
        }

        return memo[count][i];

    }

    public static void main(String[] args) {
        // note to self, use Arrays.fill(with integer or something else value)
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt(); // num >= 4
        array = new int[num];
        for(int i = 0; i <= num-1; i++){
            array[i] = scan.nextInt();
        }
        memo = new int[4][num+1];
        System.out.println(findMax(3, num));

        for(int a : hold){
            System.out.println("The number is " + a);
        }

    }


}
