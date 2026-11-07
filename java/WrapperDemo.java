package wrapperdemo;

public class WrapperDemo{
    public static void main(String[] args){
        float a = 12.5f;
        Float b = 12.5f /0;
        
        System.out.println(b == Float.POSITIVE_INFINITY);
    }
}