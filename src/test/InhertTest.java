package test;

public class InhertTest  {
    public static void main(String[] args){

    }
}
interface implementtion{
    void method1();
    void method2();
}
class test1 implements implementtion{

    @Override
    public void method1() {
        System.out.println("test1:"+"method1");
    }

    @Override
    public void method2() {
        System.out.println("test1:"+"method2");
    }
}
class test2 implements implementtion{

    @Override
    public void method1() {
        System.out.println("test2:"+"method1");
    }

    @Override
    public void method2() {
        System.out.println("test2:"+"method2");
    }
}
