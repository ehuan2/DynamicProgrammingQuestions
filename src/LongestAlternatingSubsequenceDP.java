import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class LongestAlternatingSubsequenceDP {
    static int[] allNum;
    static HashMap<String, Integer> map; static LinkedList<Integer> list;
    public static int findLongestAltSubsqnc(int i, int num, boolean inc) {

        if(i >= allNum.length){
            return 0;
        }
        if(map.get(i + "" +  inc + "" + num) != null){
            return map.get(i + "" + inc + "" + num);
        }
        if((inc && allNum[i] >= num) || (!inc && allNum[i] <= num)) {
            map.put(i + "" + inc + "" + num, findLongestAltSubsqnc(i+1, num, inc));
            return map.get(i + "" + inc + "" + num);
        }

        int adding = findLongestAltSubsqnc(i+1, allNum[i], !inc) + 1;

        int skip = findLongestAltSubsqnc(i+1, num, inc);

        if(adding > skip){

            if(list.size() < 5) {
                list.add(allNum[i]);
            }
        }
        map.put(i + "" + inc + "" + num, Integer.max(adding, skip));
        return map.get(i+""+inc+""+num);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        allNum = new int[num];
        for (int i = 0; i < num; i++) {
            allNum[i] = scan.nextInt();
        }
        map = new HashMap<>(); list = new LinkedList<>();
        System.out.println(Integer.max(findLongestAltSubsqnc(0, 0, false), findLongestAltSubsqnc(0, 0, true)));
        for(int a : list){
            System.out.print(a + " ");
        }
    }
}
