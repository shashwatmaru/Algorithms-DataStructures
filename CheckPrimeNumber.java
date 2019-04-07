public class CheckPrimeNumber {
    public static void main(String [] args){
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        int n =113;
        System.out.println("Is "+ n+" number is Prime: "+checkPrimeNumber.isPrimeNumber(n));
    }
    public boolean isPrimeNumber(int n){
        int i;
        for(i=2;i<=Math.floor(Math.sqrt(n));i++){
            if(n%i == 0) return false;
        }
        if(i == Math.floor(Math.sqrt(n)) +1) return  true;


        return false;
    }
}
