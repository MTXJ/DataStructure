package offer;

public class Main6 extends Exception{
//    static class RCode{
//        private String msg="";
//        private Object data=null;
//        RCode(Object data){
//            this.data=data;
//            this.msg="成功";
//        }
//        RCode(String msg){
//            this.data=null;
//            this.msg=msg;
//        }
//        public static RCode success(Object data){
//            return new RCode(data);
//        }
//        public static RCode error(String msg){
//            return new RCode(msg);
//        }
//    }
    static class Node{
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getL_node() {
            return l_node;
        }

        public void setL_node(Node l_node) {
            this.l_node = l_node;
        }

        public Node getR_node() {
            return r_node;
        }

        public void setR_node(Node r_node) {
            this.r_node = r_node;
        }

        private int value;
        private Node l_node;
        private Node r_node;
        Node(int value){
            this.value=value;
            l_node=null;
            r_node=null;
        }
    }
    public static int[] preorder={1,2,4,7,3,5,6,8};
    public static int[] inorder={4,7,2,1,5,3,8,6};
    public static Node createBtree(int startpre,int endpre,int startin,int endin) {
        //判断传入的数字是否为空
        if(endpre < 0 || endin < 0){
            return null;
        }
        //从前序中找出头节点  初始化头节点
        Node root=new Node(preorder[startpre]);

        //判断是否只有一个数，且该数是否复合遍历规则
        if(startpre == endpre){
            if(startin == endin && preorder[startpre] == inorder[startin]){
                return root;
            }else{
                return null;
            }
        }

        //从中序遍历中找出头节点的位置，分别找出左右子树的长度
        int rootinorder=startin;
        while(rootinorder <= endin && inorder[rootinorder] != root.getValue()){
            rootinorder++;
        }
        if(rootinorder > endin){
            return null;
        }
        int leftLength=rootinorder-startin;
        int rightLength=endin-rootinorder;
        //构建左子树
        if(leftLength > 0){
            root.setL_node(createBtree(startpre+1,startpre+leftLength,startin,startin+leftLength-1));
        }
        //构建右子树
        if(rightLength > 0){
            root.setR_node(createBtree(startpre+leftLength+1,endpre,rootinorder+1,endin));
        }

        return root;
    }
    public static void main(String args[]){
       createBtree(0,preorder.length-1,0,inorder.length-1);

    }

}
