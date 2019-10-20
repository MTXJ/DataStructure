package offer;

public class Main4 {
    public static int[] merage(int[] arrA,int[] arrB){
        if(arrA == null || arrA.length <= 0 || arrB == null || arrB.length <= 0){
            return null;
        }
        int[] newArr=new int[arrA.length+arrB.length];
        int pA=0;
        int pB=0;
        int pN=0;
        while(pA < arrA.length && pB < arrB.length){
            if (arrA[pA] > arrB[pB]){
                newArr[pN]=arrB[pB];
                pN++;
                pB++;
            }else{
                newArr[pN]=arrA[pA];
                pN++;
                pA++;
            }
        }
        while(pA<arrA.length){
            newArr[pN++]=arrA[pA++];
        }
        while(pB<arrB.length){
            newArr[pN++]=arrB[pB++];
        }
        return newArr;
    }
    public static void main(String args[]){
       // int[] arrA={1,3,5,7,9};
        int[] arrA={1,1,1,100,100,100,100,100,100};
        int[] arrB={2,4,6,8,10};
        int[] newarr=merage(arrA,arrB);
        if(newarr!=null){
            for(int i=0;i<newarr.length;i++){
                System.out.println(newarr[i]);
            }
        }else{
            System.out.println("null");
        }

    }
}
