import java.util.Scanner;

/*
* EUCLID ALGORITHM
*
* */
public class EuclidAlgo {
    public static void main(String agrs[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter both the number for which GCD needs to be find.");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int gcd = findGCD(firstNumber,secondNumber);
        System.out.println("GCD for"+firstNumber+" and "+secondNumber+" is: "+gcd);
    }
    public static int findGCD(int a, int b){
        int temp=0;
        if(a!=0 && b!=0 & a>b){
               temp = a%b;
               if(temp==0){
                   return b;
               }
               else{
                   while(temp!=0){
                       a=b;
                       b=temp;
                       temp = a%b;
                   }
                   return b;
               }
        }
        else{
            System.err.println("Kindly enter both the number properly");
            return -1;
        }
    }
}
