import java.util.Scanner;

public class NumKeyPadDialDP {

    static int[][]keyPad;

    public static int findNum(int i, int j, int dig){
        if(i > keyPad.length-1 || j > keyPad[0].length-1 || i < 0 || j < 0){ return 0;}









        if(keyPad[i][j] == -1 ||dig < 1){ return 0; }



    int[]moveHoriz = new int[]{0,0,0,1,-1};

        int[]moveVert = new int[]{0,1,-1,0,0};

        int count = 0;
        for (int k = 0; k < moveVert.length; k++) {

            count += findNum(i + moveVert[k], j + moveHoriz[k], dig-1) + 1;

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        keyPad = new int[][]{ {1,2,3}, {4,5,6}, {7,8,9}, {-1, 0, -1}};
        int dig = scan.nextInt();


        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                sum += findNum(i, j, dig);
            }
        }


        System.out.println(sum);

    }

}
