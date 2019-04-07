import java.util.Stack;

public class CreateHeapUsingTwoStacks {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static boolean qisEmpty(){
        return stack1.empty() && stack2.empty();
    }

    public static int qsize(){
        return stack1.size() + stack2.size();
    }

    public static void enqueue(int n){
        stack1.push(n);
    }
    public static int dequeue(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        enqueue(1);
        enqueue(2);
        System.out.println("Size:"+qsize());
        System.out.println("Is Empty: "+qisEmpty());
        System.out.println("Element:"+dequeue());
        System.out.println("Element:"+dequeue());
        System.out.println("Size:"+qsize());
        System.out.println("Is Empty: "+qisEmpty());
        enqueue(3);
        enqueue(4);
        System.out.println("Size:"+qsize());
        System.out.println("Is Empty: "+qisEmpty());
        System.out.println("Element:"+dequeue());
        System.out.println("Element:"+dequeue());
        System.out.println("Size:"+qsize());
        System.out.println("Is Empty: "+qisEmpty());



    }
}
