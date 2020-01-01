import java.util.HashMap;
import java.util.Scanner;

public class ProbabilityIslandDP {

    // subproblem
    // guess
    // relate subproblems
    // memoize
    // return orig. problem
    static int size;
    static HashMap<String, Double> map;

    public static double findProbability(int i, int j, int n) {


        if (i > size - 1 || j > size - 1 || i < 0 || j < 0) {
            return 0;
        }


        if (n == 0) {
            return 1;
        }



        if(map.get(i + "|" + j + "|" + n) != null){
            return map.get(i + "|" + j + "|" + n);
        }

        double probs = 0;

        int[] moveHort = new int[]{1, -1, 0, 0};
        int[] moveVert = new int[]{0, 0, -1, 1};


        for (int k = 0; k < 4; k++) {

            probs += findProbability(i + moveHort[k], j + moveVert[k], n - 1) * (1.0 / 4.0);

        }



        map.put(i + "|" + j + "|" + n, probs);


        return probs;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        int steps = scan.nextInt();

        int startX = scan.nextInt();
        int startY = scan.nextInt();

        map = new HashMap<>();

        System.out.println(findProbability(startX, startY, steps));

    }

}
