import java.util.Scanner;

public class TourismDP {
    static int max = 0;
    static int[] weight;
    static int[][] memo;
    public static int findBestWay(int i, int days){
        if(days <= 0) {
            return 0;
        }
        int out = 0;

        int mod = days % max;

        int min = mod == 0 ? max : mod;

        if(memo[i][days] == 0) {

            for (int j = min; j <= max && (i + j) <= weight.length; j++) {
                memo[i + j][days - j] = findBestWay(i + j, days - j) + findMax(i, i + j - 1);

                out = Integer.max(memo[i + j][days - j], out);
            }

            memo[i][days] = out;
        }

        return memo[i][days];
    }

    public static int findMax(int begin, int end){
        int max = Integer.MIN_VALUE;
        for(int i = begin; i <= end; i++){
            max = Integer.max(weight[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        max = scan.nextInt();
        weight = new int[num];
        for(int i = 0; i <= num-1; i++){
            weight[i] = scan.nextInt();
        }


        memo = new int[num+1][num+1];
        System.out.println(findBestWay(0, num));

    }


}
