package offer;

public class Main3 {
    public static boolean hasNum(int[][] numbers,int rows,int cols,int target){
        if(numbers != null && rows > 0 && cols > 0){
            int row =0;
            int col=cols-1;
            while(row < rows && col > 0){
                if(target == numbers[row][col]){
                    return true;
                }else if(target > numbers[row][col]){
                    row++;
                }else{
                    col--;
                }
            }
        }
        return false;
    }
}
