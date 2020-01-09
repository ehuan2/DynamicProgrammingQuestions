import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BridgeCrossingDP {

    // subproblem - a suffix of subproblems [i:]
    // guess - what the groups are going to be, how far you get in the line
    // relate subproblems min(of each guess)
    // memoize
    // return orig. problem

    static String[] personToTime;
    static int maxM;
    static int[] time;
    static int num;
    static HashMap<Integer, Integer> mapFlag = new HashMap<>();

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int findMinPersonToTime(int i) { // has to be a suffix

        if(mapFlag.containsKey(i)){
            return mapFlag.get(i);
        }


        int min = Integer.MAX_VALUE;
        int pos = 0;

        for (int j = 1; j <= maxM; j++) {
            if (i + j > num) {
                break;
            }
            int next = findMinPersonToTime(i + j) + findMaxInArray(i, i + j);
            if (next < min) {
                min = next;
                pos = j;
            }

        }

       map.put(i, i+pos);

        mapFlag.put(i, min == Integer.MAX_VALUE ? 0 : min);
        return mapFlag.get(i); }

    public static void goRecur(int i){
        if(i > personToTime.length-1)
            return;
        for (int j = map.get(i)-i; j > 0; j--) {
            System.out.print(personToTime[map.get(i)-j] + " ");
        }
        System.out.println();
        goRecur(map.get(i));
    }

    public static int findMaxInArray(int i, int j) {
        int max = time[i];
        for (int k = i; k < j; k++) {
            max = Integer.max(max, time[k]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        maxM = scan.nextInt();
        num = scan.nextInt();
        personToTime = new String[num];
        time = new int[num];

        for (int i = 0; i < num; i++) {
            personToTime[i] = scan.next();
            time[i] = scan.nextInt();
        }

        System.out.println(findMinPersonToTime(0));
        int count = 0;
        goRecur(0);

    }


}
