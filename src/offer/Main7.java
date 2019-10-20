package offer;

import java.util.Stack;

public class Main7 {
    static class stack2queue<T>{
        private Stack<T> stack1=new Stack<>();
        private Stack<T> stack2=new Stack<>();
        public void add(T data){
            stack1.add(data);
        }
        public T pop(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    T data=stack1.pop();
                    stack2.add(data);
                }
                if(stack2.isEmpty()){
                    System.out.println("队列为空！！！");
                    return null;
                }
            }
            return stack2.pop();
        }
    }
    public static void main(String[] args){
        stack2queue<Integer> queue=new stack2queue<>();
        queue.add(5);
        queue.add(4);


        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
