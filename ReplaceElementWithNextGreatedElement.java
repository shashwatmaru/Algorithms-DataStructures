public class ReplaceElementWithNextGreatedElement {
    public static void main(String [] args){
        ReplaceElementWithNextGreatedElement replaceElementWithNextGreatedElement = new ReplaceElementWithNextGreatedElement();
        int [] input = {1,3,20,4,5,6,11,4,6,1,2,8,0};
        input = replaceElementWithNextGreatedElement.replaceWithNextGreaterElement(input);
        for(int i: input){
            System.out.print(i+" ");
        }

    }
    public int[] replaceWithNextGreaterElement(int[] input){
        int max=Integer.MIN_VALUE;
//        System.out.print(input[input.length-1]+" ");
        for(int i=input.length-2;i>=0;i--){
            if(max< input[i]){
                max = input[i];
            }
            else{
                input[i]=max;
            }
      //      System.out.print(input[i]+" ");
        }



        return input;
    }
}
