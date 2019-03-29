import java.util.ArrayList;
import java.util.List;

public class AddOneToIntArray {
        public int[] plusOne(int[] digits) {
            int j = digits.length-1;
            boolean flag=true;

            while(flag && j>=0){
                if(digits[j]==9){
                    digits[j]=0;
                    flag=true;
                }
                else{
                    digits[j] += 1;
                    flag=false;
                }
                j--;
            }
            if(j== -1 && flag){
                int[] newDigit = new int[digits.length+1];
                newDigit[0]=1;
                for(int k=0;k<digits.length;k++){
                    newDigit[k+1]= digits[k];
                }
                return newDigit;
            }

            return digits;
        }

        public static void main(String[] args){
            int[] input = {1,2,9};
            int[] input1 = {0,2,0};
            int[] input2 = {9,9,9};
            AddOneToIntArray addOne = new AddOneToIntArray();
            int[] output =  addOne.plusOne(input);
            for (int i : output) {
                System.out.print(" "+i);
            }
            System.out.println();
            int[] output1 =  addOne.plusOne(input1);
            for (int i : output1) {
                System.out.print(" "+i);
            }
            System.out.println();

            int[] output2 =  addOne.plusOne(input2);
            for (int i : output2) {
                System.out.print(" "+i);
            }


        }
}
