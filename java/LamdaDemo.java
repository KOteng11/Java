package lamdademo;

@FunctionalInterface
interface MyLamda{
    public void display(String str);
}



public class LamdaDemo{
    public static void main(String[] args){
        MyLamda ml = LamdaDemo::reverse;
        ml.display("Hello");
    }
    
    public static void reverse(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb);
    }
}