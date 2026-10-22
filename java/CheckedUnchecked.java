package checkunchecked;

class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }
    
    static class LowBalanceException extends MyException{
        public LowBalanceException(double baseAmount){
            super("Balance should not be less than " + baseAmount);
        }
        
        public LowBalanceException(){
            this(5000);
        }
    }
    
    static class InvalidAmountException extends MyException{
        public InvalidAmountException(){
            super("Invalid amount. Amount should be greater than 0.");
        }
    }
}

public class CheckedUnchecked{
    public static void fun1() throws MyException.LowBalanceException{
        throw new MyException.LowBalanceException();
    }
    
    public static void fun2(){
        try{
            fun1();
        }catch(MyException.LowBalanceException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void fun3(){
        fun2();
    }
    
    public static void main(String[] args){
        fun3();
    }
}