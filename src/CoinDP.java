import java.util.ArrayList;
import java.util.Scanner;

public class CoinDP {

    public static int getMinCoin(ArrayList<Integer> ar, int sum){
        if(sum == 0){
            return 0;
        }

        if(sum < 0){
            return -1;
        }

        ArrayList<Integer> change = new ArrayList<>();
        change.addAll(ar);
        int min = Integer.MAX_VALUE;
        for(int i : ar){
            change.remove(Integer.valueOf(i));
            int next = getMinCoin(ar, sum-i);
            min = next == -1 ? min : Integer.min(min, getMinCoin(ar, sum-i));
            change.add(Integer.valueOf(i));
        }

        return min == Integer.MAX_VALUE ? -1 : min+1;
    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        ArrayList<Integer> ar = new ArrayList<>();











        for(int i = 0; i <= num-1; i++){
            ar.add(scan.nextInt());
        }








        int get = getMinCoin(ar, scan.nextInt());
        System.out.println(get == -1? "No way to do so" : get);

    }
}
