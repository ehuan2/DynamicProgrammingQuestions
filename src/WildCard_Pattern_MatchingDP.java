import java.util.HashMap;
import java.util.Scanner;

public class WildCard_Pattern_MatchingDP {

    // subproblem
    // guess
    // relate subproblems
    // memoize
    // return orig. problem

    static String input = "";
    static String pattern = "";

    static HashMap<String, Boolean> map;

    public static boolean isMatch(int i, int j){
        // subproblem would be if the suffixes match - if the suffixes match and the first characters match
        // then they match
        // guess if the * becomes the next character or not

        if(map.get(i + "|" + j) != null){
            return map.get(i + "|" + j);
        }

        if(i == input.length() || j == pattern.length()){
            return i == input.length() && j == pattern.length();
        }


        if(pattern.charAt(j) == '?'){
            return isMatch(i+1, j+1);
        }

        if(pattern.charAt(j) == '*'){
            return isMatch(i+1, j+1) || isMatch(i + 1, j) || isMatch(i, j+1);
        }

        return pattern.charAt(j) == input.charAt(i) && isMatch(i + 1, j + 1);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
        pattern = scan.next();
        System.out.println(isMatch(0,0));
    }

}
