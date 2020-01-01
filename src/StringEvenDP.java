import java.util.Scanner;

public class StringEvenDP {

    public static int[] findWays(String a){
        int [] hold = new int[a.length()];
        hold[a.length()-1] = ((int)(a.charAt(a.length()-1)) + 1) % 2;
        for(int i = a.length()-2; i >= 0; i--){
            hold[i] = hold[i+1] + ((int)(a.charAt(i)) + 1) % 2;
        }
        return hold;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.next();


        int [] ex = findWays(s);
        for(int a : ex){
            System.out.print(a + " ");
        }

    }


}
