import java.util.HashMap;
import java.util.Scanner;

public class NumNoConsecutiveOnesDP {
    static HashMap<Integer, HashMap<Boolean, Integer>> map = new HashMap<>();
    public static int findNum(int i, boolean prev){




        if(i == 0){
            return 1;
        }

        if(map.containsKey(i)){

            if(!map.get(i).containsKey(prev)){
               // map.get(i).put(prev, findNum(i, oneBefore));
            }

        }
        int oneBefore = findNum(i-1, false);
        int zeroBefore = findNum(i - 1, true);

        return oneBefore + (prev ? 0 : zeroBefore);


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();


        System.out.println(findNum(num, false));

    }


}
