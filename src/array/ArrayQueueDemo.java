package array;

public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue queue=new ArrayQueue(2);
        queue.push(2);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        queue.push(5);
        System.out.println(queue.pop());


     //   queue.display();
    }
}
class ArrayQueue{
    private int MaxSize;
    private int front;
    private int rear;
    private int[] array;
    public ArrayQueue(int maxsize){
        this.array=new int[maxsize+1];
        this.MaxSize=maxsize+1;
        this.front=1;
        this.rear=0;
    }
    public boolean isFull(){
        if(front%MaxSize==rear%MaxSize){
            return true;
        }else{
            return false;
        }
    }
    public boolean isEmpty(){
        int a=front%MaxSize;
        int b=rear%MaxSize;
        if(this.MaxSize==1&&Math.abs(front%MaxSize-rear%MaxSize)==0){
            return true;
        }
        if(Math.abs(front%MaxSize-rear%MaxSize)==1){
            return true;
        }else{
            return false;
        }
    }
    public void push(int num){
          if(isFull()){
              System.out.println("man");
          }else{
              array[front%MaxSize]=num;
              front++;
          }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("kong");
            return 0;
        }else{
            rear++;
            return array[rear%MaxSize];
        }
    }
    public void display(){
        int i=front%MaxSize;
        for(;i<rear%MaxSize;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
