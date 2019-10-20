package heapsort;

import java.util.Random;

class until{
    public static void show(int[] arr,String name){
        int count=0;
        for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
                count++;
            if(count==8){
                count=0;
                System.out.println();
            }

        }
    }
}
//class insertSort implements Runnable{
//    public void insert(int[] arr){
//        int tem[]=new int[arr.length];
//        int j=0;
//        for(int i=0;i<arr.length;i++){
//            j=0;
//            while(j<i){
//                if(arr[])
//            }
//        }
//    }
//    @Override
//    public void run() {
//
//    }
//}
class bubbing implements Runnable{
    private int[] tree;
    bubbing(int[] tree){
        this.tree=tree;
    }
    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<tree.length;i++){
            for(int j=0;j<tree.length-i-1;j++){
                if(tree[j]>tree[j+1]){
                    int tem=tree[j+1];
                    tree[j+1]=tree[j];
                    tree[j]=tem;
                }
            }
        }
        long time=System.currentTimeMillis()-startTime;
        System.out.println("冒泡："+time+"ms");
 //       until.show(tree,"冒泡");
    }
}
class chose_sort implements Runnable{
    private int[] tree;
    chose_sort(int[] tree){
        this.tree=tree;
    }
    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<tree.length;i++){
            for(int j=i+1;j<tree.length;j++){
                if(tree[i]>tree[j]){
                    int tem=tree[i];
                    tree[i]=tree[j];
                    tree[j]=tem;
                }
            }
        }
        long time=System.currentTimeMillis()-startTime;
        System.out.println("选择："+time+"ms");
 //       until.show(tree,"选择");
    }
}
class heap implements Runnable{
    private int[] tree;
    heap(int[] tree){
        this.tree=tree;
    }
    public  void swap(int[] tree,int a,int b){
        int temp=tree[a];
        tree[a]=tree[b];
        tree[b]=temp;
    }
    public  void heapify(int[] tree,int n,int j){
        if(n>=j){
            return;
        }
        int c1=n*2+1;
        int c2=n*2+2;
        int max=n;
        if(c1<j&&tree[max]<tree[c1]){
            max=c1;
        }
        if(c2<j&&tree[max]<tree[c2]){
            max=c2;
        }
        if(max!=n){
            swap(tree,n,max);
            heapify(tree,max,j);
        }

    }
    public  void build_heapify(int[] tree){
        int n=(tree.length-2)/2;
        for(int i=n;i>=0;i--){
            heapify(tree,i,tree.length);
        }
    }
    public void heapify_sort(int[] tree){
        build_heapify(tree);
        for(int i=tree.length-1;i>0;i--){
            swap(tree,0,i);
            heapify(tree,0,i-1);
        }
    }

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        heapify_sort(this.tree);
        long time=System.currentTimeMillis()-startTime;

        System.out.println("分堆："+time+"ms");
 //       until.show(tree,"分堆");
    }
}
class MergeClass implements Runnable{
    private int[] tree;
    MergeClass(int[] tree){
        this.tree=tree;
    }
    public void merge(int[] arr,int l,int m,int r){
        int size1=m-l;
        int size2=r-m+1;
        int[] tem1=new int[size1];
        int[] tem2=new int[size2];
        for(int i=0;i<size1;i++){
            tem1[i]=arr[l+i];
        }
        for(int i=0;i<size2;i++){
            tem2[i]=arr[m+i];
        }
        int s1=0,s2=0,i=l;
        while(s1<size1&&s2<size2){
            if(tem1[s1]<tem2[s2]){
                arr[i]=tem1[s1];
                s1++;
            }else{
                arr[i]=tem2[s2];
                s2++;
            }
            i++;
        }

        while(s1<size1){
            arr[i++]=tem1[s1++];
        }
        while(s2<size2){
            arr[i++]=tem2[s2++];
        }
    }
    public void merge_sort(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int m=l+(r-l+1)/2;
        merge_sort(arr,l,m-1);
        merge_sort(arr,m,r);
        merge(arr,l,m,r);
    }
    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        merge_sort(tree,0,tree.length-1);
        long time=System.currentTimeMillis()-startTime;
        System.out.println("归并："+time+"ms");
 //       until.show(tree,"归并");
    }
}
class QuickClass implements Runnable{
    private int[] tree;
    QuickClass(int[] tree){
        this.tree=tree;
    }
    public void quick(int[] arr,int l,int r){
        if(r<=l){
            return;
        }
        int left=l;
        int right=r;
        int tem=arr[left];

        while(right>left){
            while(right>left&&tem<arr[right]){
                right--;
            }
            if(right>left){
                arr[left]=arr[right];
                left++;
            }

            while(right>left&&tem>arr[left]){
                left++;
            }
            if(right>left){
                arr[right]=arr[left];
                right--;
            }
        }

        arr[left]=tem;
        quick(arr,l,left-1);
        quick(arr,left+1,r);

    }
    @Override
    public void run() {
        int r=tree.length-1;
        long startTime=System.currentTimeMillis();
        quick(tree,0,r);
        long Time=System.currentTimeMillis()-startTime;
        System.out.println("快排："+Time+"ms");
 //       until.show(tree,"快排");
    }
}
public class Main{

    public static void main(String[] args){
        int[] arr={10,2,7,8,4,3,1,5,10,1};
        Random r = new Random();
        final int N=800000;
        int tree[]=new int[N];
        int tree1[]=new int[N];
        int tree2[]=new int[N];
        int tree3[]=new int[N];
        int tree4[]=new int[N];
        for(int i=0;i<tree.length;i++){
            int tem=r.nextInt(100000);
            tree[i]=tem;
            tree1[i]=tem;
            tree2[i]=tem;
            tree3[i]=tem;
            tree4[i]=tem;
        }
       Thread t1=new Thread(new chose_sort(tree2));
        t1.start();
        Thread t2=new Thread(new bubbing(tree1));
        t2.start();
        Thread t3=new Thread(new heap(tree));
        t3.start();
        Thread t4=new Thread(new MergeClass(tree3));
        t4.start();
        Thread t5=new Thread(new QuickClass(tree4));
        t5.start();

    }


}
