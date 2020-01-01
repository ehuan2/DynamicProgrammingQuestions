import java.util.Arrays;
import java.util.Scanner;

public class MinPartitionDP {

    static int[] partition;
    static int[] pos;
    static short[][]memoDP;

    public static int findPartition(int i, int sumOne){

        if(i == partition.length){
            return 0;
        }


        if(memoDP[i][sumOne] == 0) {
            int one = Math.abs(sumOne + findPartition(i + 1, sumOne + partition[i]));
            int two = Math.abs(sumOne - findPartition(i + 1, sumOne - partition[i]));
            memoDP[i][sumOne] = (short)Integer.min(memoDP[i+1][sumOne+partition[i]], memoDP[i+1][sumOne-partition[i]]);
        }

        pos[i] = memoDP[i+1][sumOne+partition[i]] < memoDP[i+1][sumOne-partition[i]] ? 1 : 2;

        return memoDP[i][sumOne];

    }


    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    partition = new int[num];
    for(int i = 0; i <= num-1; i++){
        partition[i] = scan.nextInt();
    }
    pos = new int[num];
    memoDP = new short[num+1][100];
        System.out.println(findPartition(0, 0));

        int[]subsetOne = new int[0];

        int[]subsetTwo = new int[0];

        for(int a = 0; a <= num-1; a++){
            System.out.print(pos[a] + " ");
            if(pos[a] == 1) {
                subsetOne = Arrays.copyOf(subsetOne, subsetOne.length+1);

                subsetOne[subsetOne.length-1] = partition[a];
            } else {
                subsetTwo = Arrays.copyOf(subsetTwo, subsetTwo.length+1);
                subsetTwo[subsetTwo.length-1] = partition[a];
            }
        }

        System.out.println();
        System.out.print("This is subset one : ");
        for(int w : subsetOne){
            System.out.print(w + " ");
        }
        System.out.println();
        System.out.print("This is subset two : ");

        for(int q : subsetTwo){
            System.out.print(q + " ");
        }

    }

}
