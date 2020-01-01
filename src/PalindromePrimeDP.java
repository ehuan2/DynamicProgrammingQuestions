import java.util.Scanner;

public class PalindromePrimeDP {

    public static int findLength(String a){
        return 0;
    }

    public static boolean isPalindrome(String a){

        for(int i = 0; i <= (a.length())/2-1; i++){
            if(a.charAt(i) != a.charAt(a.length()-1-i)){
                return false;
            }

        }
        return true;
    }

    public static boolean isPrime(int a){

        for(int i = 2; i <= Math.sqrt(a); i++){
            if(a % 2 == 0){
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for(int i = 0; i <= num-1; i++){
            String next = scan.next();
            int prime = findLength(next);
            System.out.println(isPrime(prime) ? "PRIME" : "NOT PRIME");

        }


    }


}
