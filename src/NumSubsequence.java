import java.util.HashMap;
import java.util.Scanner;

public class NumSubsequence {


    static String find;
    static String string;
    static HashMap<String, Integer> memoMap;

    public static int findNum(int i, String s) {


        if (s.equals(find)) {
            return 1;
        }


        if (i > string.length() - 1) {
            return 0;
        }

        if(memoMap.get(i + s) != null){
            return memoMap.get(i+s);
        }

        memoMap.put(i + s, findNum(i + 1, s + string.charAt(i)) + findNum(i + 1, s));
        return memoMap.get(i+s);

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        string = scan.next();
        find = scan.next();
        memoMap = new HashMap<>();
        System.out.println(findNum(0, ""));

    }

}
