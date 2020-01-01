import java.util.Scanner;

public class BankNotesDP {

    static int[]denom;
    static int[]count;
    static int[][][] memoNotes;

    public static int findMinNotes(int pos, int i, int sum){

        if(sum <= 0 || pos >= count.length){
            return 0;
        }

        if(memoNotes[pos][i][sum] == 0){
            if(i+1 > count[pos]){
                i = 0;
                pos++;
                if(pos >= count.length){
                    return 10000;
                }
            }

            memoNotes[pos][i][sum] = Integer.min(findMinNotes(pos, i+1, sum), findMinNotes(pos, i+1, sum-denom[pos])+1);

        }

        return memoNotes[pos][i][sum];

    }

    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        denom = new int[num];
        count = new int[num];

        for(int i = 0; i <= num-1; i++){


            denom[i] = scan.nextInt();


        }

        int max = 0;
        for(int j = 0; j <= num-1; j++){
            count[j] = scan.nextInt();
            max = Integer.max(count[j], max);
        }

        int sum = scan.nextInt();
        memoNotes = new int[num+1][max+1][sum+1];
        System.out.println (findMinNotes(0, 0, sum));

    }


}
