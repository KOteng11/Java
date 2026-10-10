package staticpractice;

class Test{
    static{
        System.out.println("Block 1");
    }

    static{
        System.out.println("Block 2");
    }
}

public class StaticPractice{
    
    public static void main(String[] args){
        Test t1 = new Test();
        System.out.println("Main");
    }
    
}