import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxMatrixRouteDP {

    static int[][] matrix;
    static LinkedList<Integer[]> list = new LinkedList<>();













    static HashMap<String, Integer> memoMap;

    public static int findMaxPath(int m, int n){
        if(m > matrix.length-1 || n > matrix[0].length-1 || m < 0 || n < 0){
            return 0;
        }
        if (matrix[m][n] == -1) {
            return 0;
        }

        if(memoMap.get(m + "|" + n) != null){
            return memoMap.get(m+"|"+n);
        }

        int[]moveX = new int []{0, (m % 2) == 1 ? -1 : 1};
        int[]moveY = new int []{1,0};

        int moveDown = findMaxPath(m + moveY[0], n + moveX[0]) + matrix[m][n];
        int moveSide = findMaxPath(m + moveY[1], n+moveX[1]) + matrix[m][n];
        memoMap.put(m + "|" + n, Integer.max(moveDown, moveSide));
        return memoMap.get(m + "|" + n);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        matrix = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        memoMap = new HashMap<>();
        System.out.println(findMaxPath(0,0));
    }


}
