import java.util.Scanner;

public class GameDP {

    public static double findWays(double red, double green, boolean sTurn){

        if(green == 0){
            return (red == 0 || sTurn) ? 1.0 : 0.0;
        }

        double prob = 0;

        prob = (sTurn ? red/(red + green) : 0.0) + (green / (red + green)) * findWays(red, green - 1, !sTurn);

        return prob;

    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();

        for(int i = 0; i <= cases-1; i++){
            int red = scan.nextInt();
            int green = scan.nextInt();

            System.out.println(findWays(red, green, true));


        }

    }


}
