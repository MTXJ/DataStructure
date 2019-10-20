package knapsack;

public class Main {
    public static final int N=6;
    public static final int M=21;
    public static int[][] knapsack(int w[],int v[]){
        int[][] B=new int[N][M];
        int K,C;
        for(K=1;K<N;K++){
            for(C=1;C<M;C++){
                if (C < w[K]) {
                    B[K][C]=B[K-1][C];
                }else{
                    int v1=B[K-1][C-w[K]]+v[K];
                  //  B[K][C]=v1;
                    int v2=B[K-1][C];
                    if(v1>v2){
                        B[K][C]=v1;
                    }else{
                        B[K][C]=v2;
                    }
                }
            }
        }
        return B;
    }
    public static void main(String[] args){
         int w[]={0,19,1,4,5,9};
         int v[]={0,3,4,5,-6,10};
         int[][] B=knapsack(w,v);
         for(int i=0;i<N;i++){
             for(int j=0;j<M;j++){
                 System.out.print(B[i][j]+" ");
             }
             System.out.println();
         }
    }
}
