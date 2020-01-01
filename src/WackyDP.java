import java.util.Scanner;

public class WackyDP {

    static int[][] holdMemo;

    public static int findWays(int days, boolean yesterday){

        if(days == 0){
            return 1;
        }

        if(!yesterday && holdMemo[days-1][1] == 0) {
            holdMemo[days-1][1] = findWays(days - 1, true);
        }

        if(holdMemo[days-1][0] == 0) {
            holdMemo[days - 1][0] = findWays(days - 1, false);
        }

        return holdMemo[days-1][0] + (!yesterday ? holdMemo[days-1][1] : 0) ;

    }


    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for(int i = 0; i <= num-1; i++) {
            int days = scan.nextInt();

            holdMemo = new int[days][2]; // first one is if yesterday is false, second if true

            System.out.println(findWays(days, false));
        }
    }


}
