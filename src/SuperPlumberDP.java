import java.util.Scanner;

public class SuperPlumberDP {
    static int[][] grid;
    static int[][] maxMemo;
    static boolean[][]flag;
    public static int findMax(int i, int j){

        if(j == grid[0].length-1 && i == grid.length-1){
            return grid[i][j];
        }

        int max = Integer.MIN_VALUE;

        if(j+1 <= grid[0].length-1) {
            if (maxMemo[i][j + 1] == 0 && grid[i][j + 1] != -1 && !flag[i][j+1]) {
                maxMemo[i][j + 1] = findMax(i, j + 1);
                flag[i][j+1] = true;
            }

            max = Integer.max(maxMemo[i][j+1], max);

        }
        if(i+1 <= grid.length-1) {
            if (maxMemo[i + 1][j] == 0 && grid[i + 1][j] != -1 && !flag[i+1][j]) {
                maxMemo[i + 1][j] = findMax(i + 1, j);
                flag[i+1][j] = true;
            }
            max = Integer.max(maxMemo[i+1][j], max);
        }

        if(i-1 >= 0) {
            if (maxMemo[i - 1][j] == 0 && grid[i - 1][j] != -1 && !flag[i-1][j]) {
                maxMemo[i - 1][j] = findMax(i - 1, j);


                flag[i - 1][j] = true;
            }

            max = Integer.max(maxMemo[i-1][j], max);
        }

        return max + (max == -1 ? 0 : grid[i][j]);

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int col = scan.nextInt();
        int row = scan.nextInt();

        while(col != 0 && row != 0) {

            grid = new int[col][row];

            for (int i = 0; i <= col - 1; i++) {

                String next = scan.next();

                for (int j = 0; j <= row - 1; j++) {
                    char eval = next.charAt(j);

                    grid[i][j] = eval == '.' ? 0 : eval == '*' ? -1 : (int) eval; // 0 for the ., num for the actual thing, -1 for *

                }

            }

            maxMemo = new int[col][row];
            flag = new boolean[col][row];

            System.out.println(findMax(col-1, 0));

            col = scan.nextInt();
            row = scan.nextInt();

        }


    }
}
