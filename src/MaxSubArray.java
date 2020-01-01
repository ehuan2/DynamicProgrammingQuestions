import java.util.HashMap;
import java.util.Scanner;

public class MaxSubArray {

    static int[] array;
    static HashMap<String, Integer> map;
    public static int findMax(int i, int j){

        if(j <= i){
            return 0;
        }

        if(map.get(i + "|" + j) != null){
            return map.get(i + "|" + j);
        }

        map.put(i + "|" + j, Integer.max(Integer.max(findMax(i+1, j), findMax(i, j-1)), array[j]-array[i]));

        return map.get(i + "|" + j);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();


        array = new int[num+1];
        map = new HashMap<>();

        for (int i = 1; i <= num; i++) {
            array[i] = array[i-1] + scan.nextInt();
        }

        System.out.println(findMax(0, num));

    }

}
