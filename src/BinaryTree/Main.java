package BinaryTree;

public class Main {

    public static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.l_node);
            preorder(root.r_node);
        }
    }
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.l_node);
            System.out.print(root.data+" ");
            inorder(root.r_node);
        }
    }
    public static void postorder(Node root){
        if(root!=null){
            postorder(root.l_node);
            postorder(root.r_node);
            System.out.print(root.data+" ");
        }
    }
    public static Node getBTree(int num,Node root){
        Node head=root;
       if(root==null){
           head=new Node(num);
           return head;
       }
       while(root!=null){
           if(num<root.data){
               if(root.l_node!=null){
                   root=root.l_node;
               }else{
                   root.l_node=new Node(num);
                   return head;
               }

           }else{
               if(root.r_node!=null){
                   root=root.r_node;
               }else{
                   root.r_node=new Node(num);
                   return head;
               }

           }
       }
        return null;
    }
    public static int getMin(Node root){
        if(root==null){
            return 100;
        }else{
            int min=root.data;
            int v1=getMin(root.l_node);
            int v2=getMin(root.r_node);
            min=min<v1?min:v1;
            return min<v2?min:v2;
        }

    }
    public static int getMax(Node root){
        if(root==null){
            return -1;
        }else{
            int max=root.data;
            int v1=getMax(root.l_node);
            int v2=getMax(root.r_node);
            max=max>v1?max:v1;
            return max>v2?max:v2;
        }

    }
    public static int getPiles(Node root){
        if(root==null){
            return 0;
        }else{
            int p1=getPiles(root.l_node);
            int p2=getPiles(root.r_node);
            int Piles=p1>p2?p1:p2;
            return Piles+1;
        }

    }
    public static void main(String[] args){
        Node root=new Node(6);
        root.l_node=new Node(3);
        root.r_node=new Node(10);
        root.l_node.l_node=new Node(7);
        root.l_node.l_node.l_node=new Node(22);
        root.l_node.r_node=new Node(1);
        root.r_node.r_node=new Node(9);
        System.out.println(getPiles(root));;
//        System.out.print("前：");
//        preorder(root);
//        System.out.print("中：");
//        inorder(root);
//        System.out.print("后：");
//        postorder(root);
//        Node root=null;
//        int[] nums={6,4,9,3,5,7,10};
//        for(int i=0;i<nums.length;i++){
//            root=getBTree(nums[i],root);
//        }
//        System.out.print("中：");
//        inorder(root);
    }
}
