import java.util.Scanner;

public class PartitionProblemDP {
    static int[]all;
    public static boolean findPartition(int i, int sum){

        if(sum == 0){
            return true;
        }

        if(i == all.length){
            return false;
        }

        return findPartition(i+1, sum-all[i]) || findPartition(i+1, sum);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int total = 0;
        all = new int[num];
        for(int i = 0; i <= num-1; i++){

            all[i] = scan.nextInt();
            total += all[i];

        }


            System.out.println(total % 2 == 1 ? "there is no possible partition" :
                    findPartition(0, total/2) ? "there is a possible partition" : "there is no possible partition");



    }

}
