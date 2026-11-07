import java.math.BigInteger;

public class Test
{
    public static void main(String[] args){
        BigInteger[] table = new BigInteger[10];
        BigInteger[] old = table;
        
        System.out.println(table == old);
    }
}