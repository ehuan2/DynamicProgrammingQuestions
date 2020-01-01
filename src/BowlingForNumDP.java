import java.util.Scanner;

public class BowlingForNumDP {

    static int[] holdMemo;
    static boolean[] pinsThere;

    public static int findMax(int[]pins, int numPins, int numBowl, int width){

        if(numBowl == 0){
            return 0;
        }

        if(pins.length > 2) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= pins.length-2; i++){

               // max = Integer.max()
            }
        }

        else {
            // return Integerpins[0];
        }
        return 0;
    }


    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for(int i = 0; i <= num-1; i++){
            int numPins = scan.nextInt();
            int numBowl = scan.nextInt();
            int width = scan.nextInt();

            int[] pins = new int[numPins];
            holdMemo = new int[numPins];
            pinsThere = new boolean[numPins];
            pins[0] = scan.nextInt();
            pinsThere[0] = true;
            for(int x = 1; x <= pins.length-1; x++){

                pins[x] += scan.nextInt();
                pinsThere[x] = true;

            }

            System.out.println(findMax(pins, numPins, numBowl, width));

        }

    }


}
