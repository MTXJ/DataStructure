package array;

public class xisuDemo {
    public static int[][] cover(int[][] array){
        int row=array.length;
        int col=array[0].length;
        int count=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]!=0){
                    count ++;
                }
            }
        }
        int[][] coverArray=new int[count+1][3];
        coverArray[0][0]=row;
        coverArray[0][1]=col;
        coverArray[0][2]=count;
        count=1;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]!=0) {
                    coverArray[count][0] = i;
                    coverArray[count][1] = j;
                    coverArray[count][2] = array[i][j];
                    count++;
                }
            }
        }
        return coverArray;
    }
    public static int[][] recover(int[][] array){
        int[][] recoverArray=new int[array[0][0]][array[0][1]];
        for(int i=1;i<array[0][2]+1;i++){
            recoverArray[array[i][0]][array[i][1]]=array[i][2];
        }

        return recoverArray;
    }
    public static void display(int[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int array[][]=new int[10][10];
        array[1][4]=5;
        array[7][6]=8;
        int array1[][]=cover(array);
        int array2[][]=recover(array1);
        display(array2);

    }
}
