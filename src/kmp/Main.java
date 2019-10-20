package kmp;

public class Main {
    public static int[] lcs(char[] partten){
        int len=0;
        int j=1;
        int[] lcs=new int[partten.length];
        while(j<partten.length){
            if(partten[len]==partten[j]){//匹配
                len++;//公共前后缀长+1
                lcs[j]=len;//记录该位置得公共前后缀
                j++;//下一个数
            }else{
                if(len>0){
                    len=lcs[len-1];
                }else{
                    lcs[j]=len;
                    j++;
                }
            }
        }
        return lcs;
    }
    public static int kmp(char[] array,char[] partten,int[] lcs){
//        int head=0,j=0,i=0;
//        while(head<=array.length-partten.length){
//            if(j==partten.length){//匹配成功，返回头部
//                return head;
//            }
//            if(array[head+i]==partten[j]){
//                i++;//记录第一个数组每次前进得距离
//                j++;
//            }else{
//                if(j==0){//两个数组得第一个都匹配不上，第一个数组自动更新匹配位置
//                    head++;
//                }else{
//                    head=head+i;//加上自己每次前进得距离，更新头部
//                    i=0;//清0，准备记录下一次
//                    j=lcs[j-1];//准备第二个数组得匹配位置
//                }
//            }
//        }
        int m=0,n=0;
        while(array.length-1-m>=partten.length-1-n){
            if(n>=partten.length){
                return m-partten.length;
            }
            if(array[m]==partten[n]){
                m++;
                n++;
            }else{
                if(n>0){
                    n=lcs[n-1];
                }else{
                    m++;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        char test[]={'a','a','b','a','a','b','a','a','a'};
          char partten[]={'a','b','c','a','b','c','a','g','g'};
          char array[]={'p','p','a','b','c','a','b','c','a','a','a','b','c','a','a','b','c','a','b','c','a','g'};
          int[] lcs=lcs(partten);
//          for(int i=0;i<lcs.length;i++){
//              System.out.print(lcs[i]+" ");
//          }
        System.out.println(kmp(array,partten,lcs));
    }
}
