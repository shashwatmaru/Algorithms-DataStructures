
/*
  @author Shashwat Maru
  ArmStrong Number in Java
  A number that is equal to sum of its cubes
  153 = (1*1*1)+(5*5*5)+(3*3*3) -------> TRUE
  371 = (3*3*3)+(7*7*7)+(1*1*1) -------> TRUE
  1000 -------> FALSE
  121 -------> FALSE
 */
public class ArmstrongNumber {

    public boolean isArmstrongNumber(int input){

        int num=input;
        int temp=0,sum=0;
        while(num>0){
            temp = num%10;
            sum = sum + (temp*temp*temp);
            num = num/10;
        }
        if(sum==input){
            return true;
        }
        return false;

    }

    public static void main(String[] args){
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        System.out.println("TESTCASE1: "+armstrongNumber.isArmstrongNumber(153));
        System.out.println("TESTCASE2: "+armstrongNumber.isArmstrongNumber(371));
        System.out.println("TESTCASE3: "+armstrongNumber.isArmstrongNumber(1000));
        System.out.println("TESTCASE4: "+armstrongNumber.isArmstrongNumber(121));
    }
}
