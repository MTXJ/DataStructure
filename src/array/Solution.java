package array;

import java.util.*;

public class Solution {
    public static int count=0;
    public static int maxArea(int[] height) {
        int max_area = 0;
        int temp = 0;
        int max_height = 0;
        int start = 0, end = height.length - 1;// 定义两个指针
        int width=0;
        while(start<end){
            width=end-start;
            max_height=height[start]>height[end]?height[start++]:height[end--];
            temp=max_height*width;
            max_area=temp>max_area?temp:max_area;
        }
        return max_area;
    }
    public static int lengthOfLongestSubstring() {
        LinkedList<Character> list=new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        return list.indexOf('c');
    }
    public static void test1(){
        List<fruit> l=new ArrayList<fruit>();
        fruit f=new fruit("p");
        l.add(f);
        if(l.contains(f)){
            System.out.println("按照引用来判断是否存在的！");
        }
    }
    public static List<List<Integer>> test2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> three_sum=new ArrayList<>();
        for(int a=0;a<nums.length;a++){
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b =nums.length - 1;
            int c = a + 1;
            while(b>c){
                if(nums[a]+nums[b]+nums[c]==0){
                    three_sum.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while(b>c&&nums[c]==nums[c+1])c++;
                    while(b>c&&nums[b]==nums[b-1])b--;
                    c++;
                    b--;
                }else if(nums[a]+nums[b]+nums[c]>0){
                    b--;
                }else if(nums[a]+nums[b]+nums[c]<0){
                    c++;
                }
            }
        }
        return three_sum;
    }
    public static  List<List<Integer>> test4(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int tem=0;
        for(int a=0;a<nums.length-3;a++){
            tem=target-nums[a];
            for(int b=a+1;b<nums.length-2;b++){
                if(nums[b]==nums[b+1]){
                    continue;
                }
                int c=b+1;
                int d=nums.length-1;
                while(c<d){
                    if(nums[b]+nums[c]+nums[d]>tem){
                        //  while(nums[d]==nums[d-1])d--;
                        d--;
                    }else if(nums[b]+nums[c]+nums[d]<tem){
                        //   while(nums[c]==nums[c+1])c++;
                        c++;
                    }else{
                        result.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        //  while(nums[d]==nums[d-1])d--;
                        //   while(nums[c]==nums[c+1])c++;
                        d--;
                        c++;
                    }
                }
            }
        }
        return result;
    }
    public static int test3(){
        int target=-100;
        int nums[]={1,1,1,0};
        int result=nums[1]+nums[0]+nums[2];
        int  Min=Math.abs(result-target);
        for(int a=0;a<nums.length-2;a++){
            int c=a+1;
            int b=nums.length-1;
            while(b>c){
                if(Math.abs(nums[a]+nums[b]+nums[c]-target)<Min){
                    Min=Math.abs(nums[a]+nums[b]+nums[c]-target);
                    result=nums[a]+nums[b]+nums[c];
                }
                b--;
                c++;
            }
        }
        return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        int mid1=0;
        int mid2=0;
        mid1=(length2+length2)/2-1;
        if((length1+length2)%2==0){
            mid2=(length2+length2)/2;
        }else{
            mid2=mid1;
        }
        int len=(length1+length2)/2+1;
        int[] nums=new int[len];
        int p1=0;int p2=0;
        for(int i=0;i<len;i++){
            if(nums1[p1]<nums2[p2]){
                nums[i]=nums1[p1];
                p1++;
            }else{
                nums[i]=nums2[p2];
                p2++;
            }
        }
        double res=((double)nums[mid1]+(double)nums[mid2])/2;
        return res;
    }
    public static int search(int[] nums, int target) {
        int right=0;
        int left=nums.length-1;
        int mid=0;
        if(left==right){
            return left;
        }
        while(left>=right){
            mid=(right+left)/2;
            if(nums[right]>target&&nums[right]<nums[mid]){
                right=mid+1;
            }else if((nums[right]<target&&nums[right]<nums[mid])||(nums[right]>target&&nums[right]>nums[mid])){
                if(nums[mid]<target){
                    right=mid+1;
                }else if(nums[mid]>target){
                    left=mid-1;
                }else{
                    return mid;
                }
            }else if(nums[right]<target&&nums[right]>nums[mid]){
                left=mid-1;
            }else if(nums[right]==target){
                return right;
            }else{
                return -1;
            }
        }
        return -1;
    }
    public static void getGroup(int arr[],int num){
        if(num==0){
            for(int i=0;i<10;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            count++;
            return;
        }
        for(int i=0;i<10;i++){
            if(arr[i]==1){
                continue;
            }else{
                arr[i]=1;
                getGroup(arr,num-1);
                arr[i]=0;
            }
        }
    }
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        return left;
    }
    public static boolean isValidSudoku(char[][] board) {
        Map<Character,Character> row=new HashMap<>();
        Map<Character,Character> col=new HashMap<>();
        for(int i=0;i<board.length;i++){
            row.clear();
            col.clear();
            for(int j=0;j<board[i].length;j++){
                if(row.containsKey(board[i][j])){
                    return false;
                }else if(board[i][j]!='.'){
                    row.put(board[i][j],'1');
                }
                if(col.containsKey(board[j][i])){
                    return false;
                }else if(board[j][i]!='.'){
                    col.put(board[j][i],'1');
                }
            }
        }
        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board.length;j=j+3){
                row.clear();
                for(int c=0;c<3;c++){
                    for(int d=0;d<3;d++){
                        if(row.containsKey(board[i+c][j+d])){
                            return false;
                        }else if(board[i+c][j+d]!='.'){
                            row.put(board[i+c][j+d],'1');
                        }
                    }
                }
            }
        }
        return true;
    }
        public static int maxProfit(int[] prices) {
            int l=0;int r=1;
            int maxprofit=0;
            while(r<prices.length){
                if(prices[r-1]<=prices[r]){
                    r++;
                }else{
                    maxprofit+=prices[r-1]-prices[l];
                    l=r;
                    r=l+1;
                }
            }
            return maxprofit;
        }
    public static void main(String[] argc){
        int[] prices={7,1,5,3,6,4};
        maxProfit(prices);
//        char[][] array={
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//             };
//        System.out.println(isValidSudoku(array));

//        int nums[]={6,8,10};
//        int target=11;
//        searchInsert(nums,target);
//      int height[]={1,1};
//      System.out.println(maxArea(height));
//        int nums[]={-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> three_sum=test2(nums);
//        int[] nums = new int[10];
//       getGroup(nums,2);
//       System.out.println(count);
    }
   static class fruit{
        String name;
        fruit(String name){
            this.name=name;
        }
    }
}
