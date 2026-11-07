public class GreetingTest{
    public static void main(String[] args){
        print(null);
    }
    
    public static void print(String str){
        System.out.println("String method called");
    }
    
    public static void print(Object str){
        System.out.println("Object method called");
    }
}