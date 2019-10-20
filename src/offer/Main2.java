package offer;

public class Main2 {
    private Main2(){}
    private static volatile Main2 singleton=null;
    public static Main2 getSingleTon(){
        if(singleton==null){
           synchronized(Main2.class){
               if(singleton==null){
                   singleton=new Main2();
               }
           }
        }
        return singleton;
    }


}
