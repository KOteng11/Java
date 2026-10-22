public class SeqTest
{
    public static void main(String[] args){
        int n = 5;
        
        System.out.println(sum(n));
    }
    
    public static int sum(int n){
        if (n == 0){
            return 5;
        }
        return sum(n-1) + sum(n-1)+2;
    }
}