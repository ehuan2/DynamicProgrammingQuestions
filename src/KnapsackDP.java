import java.util.Arrays;
import java.util.Scanner;

public class KnapsackDP {



    public static int findKnap(int cap, int obj, int [] value, int[]weight, boolean[]used){

        if(cap == 0){
            return 0;
        }

        int out = Integer.MIN_VALUE;

        for(int i = 0; i <= obj-1; i++){

            if(!used[i] && cap-weight[i] >= 0) {
                boolean[] recurse = Arrays.copyOf(used, used.length);
                recurse[i] = true;
                out = Integer.max(findKnap(cap - weight[i], obj, value, weight, recurse) + value[i], out);
            }

        }
        return out;

    }

    static int[][] memo;
    public static int betterFindKnap(int cap, int i, int[]values, int[]weight){
        if(i+1 > values.length){
            return 0;
        }
        int out = 0;
        if(memo[cap][i] == 0){
            int eval = cap-weight[i];
            memo[cap][i] = Integer.max(betterFindKnap(cap, i+1, values, weight), eval >= 0 ?
                    betterFindKnap(cap-weight[i],  i+1, values, weight)   +   values[i]  : 0);
        }
        return memo[cap][i];
    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);
        int cap = scan.nextInt();
        int obj = scan.nextInt();
        int[]values = new int[obj];
        int[]weight = new int[obj];

        for(int i = 0; i <= obj-1; i++){
            values[i] = scan.nextInt();
            weight[i] = scan.nextInt();
        }

        boolean [] flag = new boolean[obj];

        memo = new int[cap+1][obj+1];

        System.out.println(betterFindKnap(cap, 0, values, weight));

    }


}
